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
    
    @PersistenceContext(unitName = "masterofcodedb")
    private EntityManager em;
    
    /**
     * Create a competition
     * @param name
     * @param startTime
     */
    public void CreateCompetition(String name, Calendar startTime) {
        Competition competition = new Competition();
        competition.setName(name);
        competition.setStartTime(startTime);
        competition.setStatus(Status.waiting);
        em.persist(competition);
        em.flush();
    }
    
    /**
     * update a competition
     * @param competitionID
     * @param name
     * @param startTime
     * @param status
     */
    public void UpdateCompetition(long competitionID, String name, Calendar startTime, Status status) {
        Competition competition = em.find(Competition.class, competitionID);
        competition.setName(name);
        competition.setStartTime(startTime);
        competition.setStatus(status);
        em.persist(competition);
        em.flush();
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
    public void AddRoundToCompetition(long competitionID, String assignmentPath, Calendar duration, int roundNr) {
        Round round = new Round();
        Assignment assignment = new Assignment();
        Competition competition = em.find(Competition.class, competitionID);
        competition.setStartTime(duration);
        assignment.setPath(assignmentPath);
        round.setRoundNr(roundNr);
        round.setAssignment(assignment);
        em.persist(competition);
        em.persist(round);
        em.persist(assignment);
        em.flush();        
    }
    
    /**
     * edit a round
     * @param roundID
     * @param roundNr
     * @param duration
     * @param assignmentPath
     */
    public void EditRound(long roundID, int roundNr, int duration, String assignmentPath) {
        em.getTransaction().begin();
        Round round = em.find(Round.class, roundID);
        round.setRoundNr(roundNr);
        round.setDurationInSeconds(duration);
        Assignment assignment = new Assignment();
        assignment.setPath(assignmentPath);
        round.setAssignment(assignment);
        em.persist(round);
        em.persist(assignment);
        em.getTransaction().commit();
        em.close();
    }
    
    /**
     * remove a round
     * @param roundID
     */
    public void RemoveRound(long roundID) {
        Round round = em.find(Round.class, roundID);
        em.getTransaction().begin();
        em.remove(round);
        em.getTransaction().commit();
        em.close();
    }
    
    /**
     * find a competition
     * @param competitionID
     * @return
     */
    public Competition FindCompetition(long competitionID) {
        Competition competition = em.find(Competition.class, competitionID);
        return competition;
        
    }
    
    /**
     * find a round
     * @param roundID
     * @return
     */
    public Round FindRound(long roundID) {
        Round round = em.find(Round.class, roundID);
        return round;
    }

    /**
     *
     * @return
     */
    public List<Competition> GetCompetitionsData() {
        List<Competition> ListCompetitionData;
        ListCompetitionData = em.createNamedQuery("GetCompetitionsData").getResultList();
        if (ListCompetitionData.isEmpty()) {
            System.out.println("No competitions found.");
        }
        else {
            for (Competition competition : ListCompetitionData) {
                System.out.print("CompetitionID= " + competition.getId()
                    + ", name=" + competition.getName()
                    + ", starttime= " + competition.getStartTime()
                    + ", Status" + competition.getStatus());
            }
        }
        return ListCompetitionData;
    }
}
