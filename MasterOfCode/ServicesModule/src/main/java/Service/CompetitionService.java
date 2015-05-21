/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domein.*;
import java.util.*;
import javax.persistence.EntityManager;

/**
 *
 * @author mikerooijackers
 */
public class CompetitionService {
    private EntityManager em;
    
    public void CreateCompetition(String name, Calendar startTime) {
        
    }
    
    public void UpdateCompetition(long competitionID, String name, Calendar startTime, Status status) {
        
    }
    
    public List<Team> GetTeamFromCompetition(long competitionID) {
        return null;
        
    }
    
    public void AddRoundToCompetition(long competitionID, String assignmentPath, int duration, int roundNr) {
        
    }
    
    public void EditRound(long roundID, int roundNr, int duration, String assignmentPath) {
        
    }
    
    public void RemoveRound(long roundID) {
        
    }
    
    public Competition FindCompetition(long competitionID) {
        return null;
        
    }
    
    public Round FindRound(long roundID) {
        return null;
        
    }
}
