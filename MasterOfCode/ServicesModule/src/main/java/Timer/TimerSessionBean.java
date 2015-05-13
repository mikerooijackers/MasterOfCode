/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timer;

import javax.annotation.Resource;
import javax.ejb.TimerService;

/**
 *
 * @author mikerooijackers
 */
public class TimerSessionBean {
    @Resource
    TimerService timerService;
    
    public void CreateTimer(long duration) {
        timerService.createTimer(duration, null);
    }
    
    public void AddTimer() {
        timerService.getTimers().add(null);
    }
    
    public void RemoveTimer() {
        timerService.getTimers().remove(null);
    }
}
