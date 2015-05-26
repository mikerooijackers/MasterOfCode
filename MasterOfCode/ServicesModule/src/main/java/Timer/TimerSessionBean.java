/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timer;

import javax.annotation.Resource;
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
    TimerService timerService;
    
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
        TimerType timerType = timerData.getTimerType();
        switch (timerType) {
            case CompetitionCountDownTimer:
                //TO DO
                break;
            case HintTimer:
                //TO DO
                String Hint = timerData.getData();
                break;
            case RoundTimer:
                //TO DO
                break;
        }
    }
    
}
