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

    /**
     * Constructor
     * @param data
     * @param timerType
     */
    public TimerData(String data, TimerType timerType) {
        this.data = data;
        this.timerType = timerType;
    }

    /**
     *
     * @return
     */
    public String getData() {
        return data;
    }

    /**
     *
     * @return
     */
    public TimerType getTimerType() {
        return timerType;
    }
}
