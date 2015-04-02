/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archetype;

import framework.*;
import org.junit.Assert;
import org.testng.annotations.*;

/**
 *
 * @author mikerooijackers
 */

@Test(
    testName = "SystemTest",
    groups={GroupsTest.SYSTEM}, 
    priority = 1,
    description = "Enter a description for this test"
)
public class SystemTest extends AbstractTest {
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

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
