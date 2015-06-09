/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Domein.AnnotationData;
import com.mycompany.workspacemanagementmoduleb.WorkspaceService;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
    
    @org.testng.annotations.Test
    public void testReadAnnotationData() {
        WorkspaceService service = new WorkspaceService();
        String path = "C:\\assignments";
        List<AnnotationData> readAssignmentMetaData = service.readAssignmentMetaData(path, 1L);
        Assert.assertTrue(true);
    }
    
    @org.testng.annotations.Test
    public void testTest() {
        WorkspaceService service = new WorkspaceService();
        String runSingleTest = service.runSingleTest("UserTest,AmbivilantTest", 0L, 0L, 0L);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
