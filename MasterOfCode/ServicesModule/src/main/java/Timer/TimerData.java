/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timer;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author mikerooijackers
 */
public class TimerData implements Serializable {

    private Long hintId;
    private String hint;
    private TimerType timerType;

    /**
     * Constructor
     * @param hintId
     * @param hint
     * @param timerType
     */
    public TimerData(Long hintId, String hint, TimerType timerType) {
        this(timerType);
        this.hint = hint;
        this.hintId = hintId;
    }
    
    public TimerData(TimerType timerType) {
        this.timerType = timerType;
    }

    /**
     *
     * @return
     */
    public String getHint() {
        return hint;
    }

    /**
     *
     * @return
     */
    public TimerType getTimerType() {
        return timerType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.hintId);
        hash = 83 * hash + Objects.hashCode(this.timerType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TimerData other = (TimerData) obj;
        if (!Objects.equals(this.hintId, other.hintId)) {
            return false;
        }
        if (this.timerType != other.timerType) {
            return false;
        }
        return true;
    }
}
