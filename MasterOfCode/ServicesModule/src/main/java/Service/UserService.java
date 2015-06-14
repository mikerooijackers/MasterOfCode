/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domein.MOCUser;
import Domein.Role;
import Domein.Team;
import java.util.List;
import javax.ejb.Stateless;
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
     * @return
     */
    public MOCUser Register(String email, String fullname, String password, Role privilege, String activationCode) {
//        em.getTransaction().begin();
        MOCUser user = new MOCUser();
        user.setEmail(email);
        user.setFullName(fullname);
        user.setPrivilege(privilege);
        user.setPrivilege(Role.spectator);
        user.setActivationCode(activationCode);
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
}
