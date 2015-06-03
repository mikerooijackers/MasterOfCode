/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domein.MOCUser;
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

    public String Register() {
        MOCUser user = new MOCUser();
        user.setUsername("username");
        user.setEmail("email");
        user.setPassword("password");
        em.persist(user);
        return "geregistreerd";
    }
}
