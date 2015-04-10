/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archetype;

import framework.*;
import java.util.logging.Logger;
import org.junit.Assert;
import org.testng.annotations.*;

/**
 *
 * @author mikerooijackers
 */
@Test(
    testName = "UserTest",
    groups={GroupsTest.USER}, 
    priority = 0,
    description = "Enter a description for this test"
)
public class UserTest extends AbstractTest {
    private static final Logger LOG = Logger.getLogger(UserTest.class.getName());

    @BeforeClass
    public static void setUpClass() throws Exception {
    
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    private Object TestGroups;

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    
    }

    @Override
    public void doTest() {
        logTestDetails();
        Assert.assertTrue(true);
    }
}
