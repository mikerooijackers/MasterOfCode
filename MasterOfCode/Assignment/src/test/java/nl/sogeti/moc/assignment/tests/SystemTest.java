/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.sogeti.moc.assignment.tests;

import junit.framework.Assert;
import nl.sogeti.moc.assignment.framework.AbstractTest;
import nl.sogeti.moc.assignment.framework.TestGroups;
import org.testng.annotations.Test;

/**
 *
 * @author JordiK
 */

@Test (
        testName = "SystemsTest",
        groups = {TestGroups.SYSTEM},
        priority = 0,
        description = "Enter test description here"
)
public class SystemTest extends AbstractTest {

    @Override
    public void doTest() {
        logTestDetails();
        Assert.assertTrue(true);
    }
    
}
