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
     * @param duration
     * @param timerData
     */
    public void CreateTimer(long duration, TimerData timerData) {
        timerService.createTimer(duration, timerData);
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
        switch (timerType) {
            case CompetitionCountDownTimer:
                communicationBean.startNextRoundOfCompetition();
                //communicationBean.sendMessageToWorkspaceManegementBean(new ExtractAssignmentToWorkspacesRequestMessage());
                break;
            case HintTimer:
                String hint = timerData.getHint();
                communicationBean.sendMessageToAllCompetitors(new HintReplyMessage(hint));
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
    
    /**
     *
     * @param timerData
     */
    public void pauseOrFreezeTimer(TimerData timerData) {
        Timer timer = this.getTimer(timerData);
        this.leftDurationOfTimer = timer.getTimeRemaining();
        this.pausedOrFreezedTimer = timerData;
        timer.cancel();
    }
    
    /**
     *
     */
    public void resumeTimer() {
        if (this.leftDurationOfTimer > -1L && this.pausedOrFreezedTimer != null) {
            this.CreateTimer(this.leftDurationOfTimer, this.pausedOrFreezedTimer);
            this.leftDurationOfTimer = -1L;
            this.pausedOrFreezedTimer = null;
        }
    }
    
    /**
     *
     * @param newDuration
     * @param timerData
     */
    public void modifyTimerDuration(long newDuration, TimerData timerData) {
        Timer timer = this.getTimer(timerData);
        timer.cancel();
        this.CreateTimer(newDuration, timerData);
    }
    
    /**
     *
     * @param timerData
     */
    public void stopTimer(TimerData timerData) {
        Timer timer = this.getTimer(timerData);
        timer.cancel();
        this.handleTimerExpired(timerData);
    }
}
