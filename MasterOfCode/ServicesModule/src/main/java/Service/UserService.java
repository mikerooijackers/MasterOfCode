/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domein.MOCUser;
import Domein.Team;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mikerooijackers
 */
public class UserService {
    private EntityManager em;
    
    public MOCUser Login(String username, String password) {
        return null;
    }
    
    public MOCUser register(String username, String password, String fullname, String phoneNumber, String organization) {
        return null;
        
    }
    
    public Team getTeamOfUser(long userID) {
        return null;
        
    }
    
    public boolean checkActivationCode(long userID, String code) {
        return false;
        
    }
    
    public void createTeam(String name, long initiatorID, long competitionID) {
        
    }
    
    public List<MOCUser> getMembersOfTeam(long teamID) {
        return null;
        
    }
    
    public void addMemberToTeam(long teamID, long memberID) {
        
    }
    
    public void editTeam (long teamID, String name, boolean willParticipate) {
        
    }
    
    public MOCUser findUser(long userID) {
        return null;
        
    }
    
    public MOCUser findUser(String username) {
        return null;
        
    }
    
    public Team findTeam(long teamID) {
        return null;
        
    }
}
