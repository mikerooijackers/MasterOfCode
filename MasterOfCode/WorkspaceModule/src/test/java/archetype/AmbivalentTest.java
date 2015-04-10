/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archetype;

import framework.*;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author mikerooijackers
 */
@Test(
    testName = "AmbivalentTest",
    groups={GroupsTest.USER,GroupsTest.SYSTEM}, 
    priority = 0,
    description = "Enter a description for this test"
)
public class AmbivalentTest extends AbstractTest {

    @Override
    public void doTest() {
        logTestDetails();
        Assert.assertTrue(true);
    }
    
}
