/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import service.ClientService;

/**
 *
 * @author May
 */
public class ClientServiceTest {
    
    ClientService service;
    
    public ClientServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        service = new ClientService();
    }
    
    @After
    public void tearDown() {
    }

    // TODO: add test when there's a proper file (project) to compile.

    /*
    * Test to show that compilation fails if the path is null
    */
     @Test
     public void testRequestCompileFail() {
         boolean compileResult = service.requestCompile(null);
         Assert.assertEquals(false, compileResult);
     }
}
