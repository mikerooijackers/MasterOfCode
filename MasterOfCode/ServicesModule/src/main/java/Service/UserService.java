/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domein.MOCUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
     * @param username
     * @param password
     * @return
     */
    public MOCUser Login(String username, String password) {
        return null;
    }

    public void test() {
        MOCUser user = new MOCUser();
        user.setId(1);
        em.persist(user);
        em.flush();
        MOCUser find = em.find(MOCUser.class, 1);
        System.out.println(find.getId());
    }

    public MOCUser Register() {
        return null;
    }
    
    public List<MOCUser> GetAllUsers() {
        List<MOCUser> listUsers = em.createQuery("SELECT m.* FROM MOCUSER m").getResultList();
        if (listUsers.isEmpty()) {
            System.out.println("No persons found.");
        }
        else {
            for (MOCUser user : listUsers) {
                System.out.print("UserID= " + user.getId()
                    //+ ", Username" + user.getUsername() 
                    + ", Email=" + user.getEmail() 
                    + ", Password=" + user.getPassword()
                    + ", Fullname= " + user.getFullName()
                    + ", Privilege= " + user.getPrivilege()
                    + ", TeamID= " + user.getTeam());
            }
        }
        return listUsers;
        
    }
}
