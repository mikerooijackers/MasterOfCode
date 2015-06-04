/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domein.*;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mikerooijackers
 */
@Stateless
public class CompetitionService {
    
//    @PersistenceContext(unitName = "masterofcodedb")
    private EntityManager em;
    
    /**
     * Create a competition
     * @param name
     * @param startTime
     */
    public void CreateCompetition(String name, Calendar startTime) {
        
    }
    
    /**
     * update a competition
     * @param competitionID
     * @param name
     * @param startTime
     * @param status
     */
    public void UpdateCompetition(long competitionID, String name, Calendar startTime, Status status) {
        
    }
    
    /**
     * get all teams from a competition
     * @param competitionID
     * @return
     */
    public List<Team> GetTeamFromCompetition(long competitionID) {
        return null;
        
    }
    
    /**
     * add a roun to a competition
     * @param competitionID
     * @param assignmentPath
     * @param duration
     * @param roundNr
     */
    public void AddRoundToCompetition(long competitionID, String assignmentPath, int duration, int roundNr) {
        
    }
    
    /**
     * edit a round
     * @param roundID
     * @param roundNr
     * @param duration
     * @param assignmentPath
     */
    public void EditRound(long roundID, int roundNr, int duration, String assignmentPath) {
        
    }
    
    /**
     * remove a round
     * @param roundID
     */
    public void RemoveRound(long roundID) {
        
    }
    
    /**
     * find a competition
     * @param competitionID
     * @return
     */
    public Competition FindCompetition(long competitionID) {
        return null;
        
    }
    
    /**
     * find a round
     * @param roundID
     * @return
     */
    public Round FindRound(long roundID) {
        return null;
        
    }
}
