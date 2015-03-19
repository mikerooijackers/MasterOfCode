/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Domein.Competition;
import Domein.Team;
import Domein.MOCUser;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import services.WorkspaceService;

/**
 *
 * @author Gebruiker
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addTeam() {
        WorkspaceService service = new WorkspaceService();
        //MOCUser user = new MOCUser();
        //MOCUser retUser = service.addUser(user);
        
        
        //Team team = new Team();
        //Team retTeam = service.addTeam(team);
        Team team = service.findTeam();
        service.createWorkspace(team);
        
        //assertTrue(retTeam.getId() != 0);
        //em.persist(team);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
