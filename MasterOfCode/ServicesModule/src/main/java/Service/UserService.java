/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Competition.CompetitionDataService;
import Domein.Competition;
import Domein.MOCUser;
import Domein.Role;
import Domein.Round;
import Domein.RoundScore;
import Domein.Team;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mikerooijackers
 */
@Stateless
public class UserService {

    @PersistenceContext(unitName = "masterofcodedb")
    private EntityManager em;

    /**
     * login of a user
     *
     * @param username
     * @param password
     * @return
     */
    public MOCUser Login(String username, String password) {
        MOCUser user = new MOCUser();
        try {
            user = (MOCUser) em.createNamedQuery("LoginUser").setParameter("email", username).setParameter("password", password).getSingleResult();
        } catch (NoResultException ex) {
            user = new MOCUser();
        }
        if (user == null) {
            System.out.println("No person found.");
        } else {
            System.out.print("UserID= " + user.getId()
                    + ", Email=" + user.getEmail()
                    + ", Fullname= " + user.getFullName());
        }
        return user;
    }

    /**
     *
     * @param email
     * @param fullname
     * @param activationCode
     * @param privilege
     * @param password
     * @param company
     * @param telephone
     * @return
     */
    public MOCUser Register(String email, String fullname, String password, Role privilege, String activationCode, String company, String telephone) {
//        em.getTransaction().begin();
        MOCUser user = new MOCUser();
        user.setEmail(email);
        user.setFullName(fullname);
        user.setPrivilege(Role.TEAMMEMBER);
        user.setPassword(password);
        user.setActivationCode(activationCode);
        user.setCompany(company);
        user.setTelephoneNumber(telephone);
        em.persist(user);
//        em.getTransaction().commit();
//        em.close();
        return user;
    }

    /**
     *
     * @return
     */
    public List<MOCUser> GetAllUsers() {
        List<MOCUser> listUsers;
        listUsers = em.createNamedQuery("AllUsers").getResultList();
        if (listUsers.isEmpty()) {
            System.out.println("No persons found.");
        } else {
            for (MOCUser user : listUsers) {
                System.out.print("UserID= " + user.getId()
                        + ", Email=" + user.getEmail()
                        + ", Fullname= " + user.getFullName());
            }
        }
        return listUsers;
    }

    /**
     *
     * @return
     */
    public List<Team> GetAllTeams() {
        List<Team> listTeams;
        listTeams = em.createNamedQuery("AllTeams").getResultList();
        if (listTeams.isEmpty()) {
            System.out.println("No persons found.");
        } else {
            for (Team team : listTeams) {
                System.out.print("UserID= " + team.getId()
                        + ", Email=" + team.getTeamName()
                        + ", Fullname= " + team.getServerName());
            }
        }
        return listTeams;
    }

    /**
     *
     * @param userId
     * @param teamId
     * @return
     */
    public MOCUser AddToTeam(long userId, long teamId) {
        MOCUser user = em.find(MOCUser.class, userId);
        Team team = em.find(Team.class, teamId);
        user.setTeam(team);
        //team.addMember(user);
        em.persist(user);
        em.flush();
        em.close();
        return user;
    }

    /**
     *
     * @param activationCode
     * @param userId
     * @return
     */
    public String SetActivationCode(String activationCode, long userId) {
        MOCUser user = em.find(MOCUser.class, userId);
        if (user.getActivationCode() == null) {
            System.out.println("account already activated");
            return "account already activated";
        } else if (user.getActivationCode().equals(activationCode)) {
            user.setActivationCode(null);
            System.out.println("account activated");
            return "account activated";
        } else {
            System.out.println("incorrect activation code");
            return "incorrect activation code";
        }
    }

    /**
     *
     * @param id
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public String changePassword(int id, String oldPassword, String newPassword) {
        MOCUser user = em.find(MOCUser.class, id);
        if (!user.getPassword().equals(oldPassword)) {
            return "Old password incorrect.";
        }
        user.setPassword(newPassword);
        em.merge(user);
        return "Password changed successfully.";
    }

    /**
     *
     * @param teamName
     * @param initiator
     * @param members
     * @return
     */
    public Team createTeam(String teamName, String initiator, List<String> members) {
        Team team = new Team(teamName);
        List<MOCUser> MOCMembers = new ArrayList<>();
        
        MOCUser mocInitiator = (MOCUser) em.createNamedQuery("FindUserByEmail").setParameter("email", initiator).getSingleResult();
        
        team.setInitiator(mocInitiator);
//        team.setCompetition(em.find(Competition.class, competitionDataService.getCurrentCompetition().getCompetitionId()));
        
        em.persist(team);
        
        mocInitiator.setTeam(team);
        mocInitiator.setPrivilege(Role.INITIATOR);
        em.merge(mocInitiator);
        
        for (String username : members) {
            MOCUser user = null;
            try {
                user = (MOCUser) em.createNamedQuery("FindUserByEmail").setParameter("email", username).getSingleResult();
                if (user.getTeam() == null) {
                    user.setTeam(team);
                    em.merge(user);
                }
            } catch (NoResultException ex) {
                System.out.println("TeamMember " + username + " ");
            }
        }
        return team;
    }
    
    public List<MOCUser> getTeamMembers(Team team) {
        List<MOCUser> members = em.createNamedQuery("GetTeamMembers").setParameter("team", team).getResultList();
        return members;
    }
    
    public Team getTeam(Long teamId) {
        Team team = em.find(Team.class, teamId);
        return team;
    }
}
