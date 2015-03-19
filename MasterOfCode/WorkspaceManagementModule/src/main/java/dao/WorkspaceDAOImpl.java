/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Domein.Team;
import Domein.MOCUser;
import java.io.File;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author Gebruiker
 */
public class WorkspaceDAOImpl implements WorkspaceDAO {

    //@PersistenceContext
    private EntityManager em;
    
    //@PersistenceUnit(unitName = "MasterOfCodeDB")
    //private EntityManagerFactory factory;

    public WorkspaceDAOImpl() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MasterOfCodeDB");
        em = factory.createEntityManager();
        
    }    
    
    @Override
    public void createWorkspace(Team team) {
        // TODO
        String path = "C:\\workspaces\\" + team.getId();
        new File(path).mkdir();
        team.setWorkspacePath(path);
        
        em.merge(team);
    }

    @Override
    public Team addTeam(Team team) {
        em.getTransaction().begin();
        em.persist(team);
        em.getTransaction().commit();
        return team;
    }

    @Override
    public MOCUser addUser(MOCUser user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }
    
    
}
