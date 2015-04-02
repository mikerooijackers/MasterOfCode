/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

import java.util.Arrays;
import java.util.logging.*;
import org.testng.annotations.Test;

/**
 *
 * @author mikerooijackers
 */
public abstract class AbstractTest {
    protected static final Logger LOG = Logger.getLogger(AbstractTest.class.getName());
    
    protected void logTestDetails() {
        final Test testAnnotation = this.getClass().getAnnotation(Test.class);
        final String name = testAnnotation.testName().isEmpty() ? this.getClass().getSimpleName() : testAnnotation.testName();
        LOG.log(
            Level.INFO, 
            "running test\n\tname: \t\t{0}\n\tdescription: \t{1}\n\tclass: \t\t{2}\n\tgroups: \t{3}", 
            new Object[]{name, testAnnotation.description(),getClass().getName(),Arrays.asList(testAnnotation.groups())}
        );
    }
    
    /**
     * Implement and document {@code this}' one and only test method.
     */
    public abstract void doTest();
}
