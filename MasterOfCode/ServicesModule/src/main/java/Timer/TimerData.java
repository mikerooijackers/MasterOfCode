/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timer;

import java.io.Serializable;

/**
 *
 * @author mikerooijackers
 */
public class TimerData implements Serializable {

    private String data;
    private TimerType timerType;

    public TimerData(String data, TimerType timerType) {
        this.data = data;
        this.timerType = timerType;
    }

    public String getData() {
        return data;
    }

    public TimerType getTimerType() {
        return timerType;
    }
}
