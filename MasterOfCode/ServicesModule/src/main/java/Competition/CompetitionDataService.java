/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Competition;

import Domein.Team;
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
    private Competition currentCompetition;
    private Round currentRound;
    
    private long BackupRemainingRoundTime;

    public Round getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(Round currentRound) {
        this.currentRound = currentRound;
    }

    public Competition getCurrentCompetition() {
        return currentCompetition;
    }

    public void setCurrentCompetition(Competition currentCompetition) {
        this.currentCompetition = currentCompetition;
    }
    
    /**
     * start coundown of timer Competition
     */
    public void StartCompetitionCounDownTimer() {
        
    }    
    
    /**
     * start round timer
     */
    public void StartRoundTimer() {
        
    }
    
    /**
     * pause round timer
     */
    public void PauseRoundTimer() {
        
    }
    
    /**
     * cancel round timer
     */
    public void CancelRoundTimer() {
        
    }
    
    /**
     * Cancel all timers
     */
    public void CancelAllTimers() {
        
    }
    
    /**
     * resuem round timer
     */
    public void ResumeRoundTimer() {
        
    }
    
    /**
     * set metadata of a round
     * @param roundMetaData
     */
    public void setRoundMetaData(RoundMetaData roundMetaData) {
        this.roundMetaData = roundMetaData;
    }

    public RoundMetaData getRoundMetaData() {
        return roundMetaData;
    }
    
    /**
     * modify timer of a round
     * @param deltaIntervalDuration
     */
    public void ModifyTimeRoundTimer(long deltaIntervalDuration) {
        
    }
    
    /**
     * update score of a team
     * @param teamID
     * @param score
     */
    public void UpdateTeamScore(String teamID, long score) {
        
    }
    
    /**
     * get all teams 
     * @return
     */
    public List<Team> GetTeams() {
        return null;
        
    }
}
