/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Competition;

import Domein.*;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author mikerooijackers
 */
@Singleton
public class CompetitionDataService {
    private List<Team> teams;
    private RoundMetaData roundMetaData;
    private long BackupRemainingRoundTime;
    
    public void StartCompetitionCounDownTimer() {
        
    }    
    
    public void StartRoundTimer() {
        
    }
    
    public void PauseRoundTimer() {
        
    }
    
    public void CancelRoundTimer() {
        
    }
    
    public void CancelAllTimers() {
        
    }
    
    public void ResumeRoundTimer() {
        
    }
    
    public void SetRoundMetaData(RoundMetaData roundMetaData) {
        
    }
    
    public void ModifyTimeRoundTimer(long deltaIntervalDuration) {
        
    }
    
    public void UpdateTeamScore(String teamID, long score) {
        
    }
    
    public List<Team> GetTeams() {
        return null;
        
    }
}
