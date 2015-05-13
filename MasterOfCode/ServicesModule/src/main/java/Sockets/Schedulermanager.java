/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import Domein.Competition;
import Domein.Hint;
import java.util.List;
import java.util.Map;
import javax.ejb.Timer;

/**
 *
 * @author mikerooijackers
 */
public class Schedulermanager {
    private Timer roundTimer;
    private Timer competitionStartTimer;
    private Competition currentCompetition;
    private int currentRoundNr;
    private Map<Hint, Timer> hints;
    
    public void StartRoundTimer(List<Hint> hints) {
        
    }
    
    public void PauseRoundTimer() {
        
    }
    
    public void ResumeRoundTimer() {
        
    }
    
    private void OnRoundTimerFinished() {
        
    }
    
    public void PublishHint(Hint hint) {
        
    }
}
