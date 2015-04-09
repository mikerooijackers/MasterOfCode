/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.sogeti.moc.assignment.tests;

import nl.sogeti.moc.assignment.framework.AbstractTest;
import nl.sogeti.moc.assignment.framework.TestGroups;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author JordiK
 */
@Test(
        testName = "AmbivilantTest",
        groups = {TestGroups.SYSTEM, TestGroups.USER},
        priority = 0,
        description = "Enter test description here"
)
public class AmbivilantTest extends AbstractTest {

    @Override
    public void doTest() {
        logTestDetails();
        Assert.assertTrue(true);
    }
    
}
