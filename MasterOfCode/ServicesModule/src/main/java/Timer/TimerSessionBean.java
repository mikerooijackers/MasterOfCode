/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timer;

import Service.CommunicationBean;
import Sockets.Messages.Client.Reply.HintReplyMessage;
import java.util.Collection;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import mocjms.messages.request.ExtractAssignmentToWorkspacesRequestMessage;

/**
 *
 * @author mikerooijackers
 */
@Singleton
public class TimerSessionBean {
    @Resource
    private TimerService timerService;
    
    @EJB
    private CommunicationBean communicationBean;
    
    private TimerData pausedOrFreezedTimer;
    private long leftDurationOfTimer;
    
    /**
     *
     * @param durationInSeconds
     * @param timerData
     */
    public void CreateTimer(long durationInSeconds, TimerData timerData) {
        System.out.println("[[INFO]] Started a timer: " + timerData.getTimerType() + " with duration: " + durationInSeconds);
        timerService.createTimer(durationInSeconds * 1000L, timerData);
    }
    
    /**
     *
     * @param timer
     */
    @Timeout
    public void TimerExpired(Timer timer) {
        TimerData timerData = (TimerData) timer.getInfo();
        this.handleTimerExpired(timerData);
    }
    
    private void handleTimerExpired(TimerData timerData) {
        TimerType timerType = timerData.getTimerType();
        
        System.out.println("[[INFO]] A timer stopped: " + timerType);
        switch (timerType) {
            case CompetitionCountDownTimer:
                communicationBean.startNextRoundOfCompetition();
                //communicationBean.sendMessageToWorkspaceManegementBean(new ExtractAssignmentToWorkspacesRequestMessage());
                break;
            case HintTimer:
                String hint = timerData.getHint();
                System.out.println("[[INFO]] A hint timer stopped with hint: " + hint);
                //communicationBean.sendMessageToAllCompetitors(new HintReplyMessage(hint));
                break;
            case RoundTimer:
                //TO DO
                break;
        }
    }
    
    private Timer getTimer(TimerData timerData) {
        Collection<Timer> timers = timerService.getTimers();
        Timer retValue = null;
        
        for (Timer timer : timers) {
            TimerData timerDataOfTimer = (TimerData) timer.getInfo();
            
            if (timerDataOfTimer.equals(timerData)) {
                retValue = timer;
            }
        }
        
        return retValue;
    }
    
    public void pauseOrFreezeTimer(TimerData timerData) {
        Timer timer = this.getTimer(timerData);
        this.leftDurationOfTimer = timer.getTimeRemaining();
        this.pausedOrFreezedTimer = timerData;
        timer.cancel();
    }
    
    public void resumeTimer() {
        if (this.leftDurationOfTimer > -1L && this.pausedOrFreezedTimer != null) {
            this.CreateTimer(this.leftDurationOfTimer, this.pausedOrFreezedTimer);
            this.leftDurationOfTimer = -1L;
            this.pausedOrFreezedTimer = null;
        }
    }
    
    public void modifyTimerDuration(long newDuration, TimerData timerData) {
        Timer timer = this.getTimer(timerData);
        timer.cancel();
        this.CreateTimer(newDuration, timerData);
    }
    
    public void stopTimer(TimerData timerData) {
        Timer timer = this.getTimer(timerData);
        timer.cancel();
        this.handleTimerExpired(timerData);
    }
}
