/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import mocjms.messages.main.OperationDrivenReplyMessage;
import mocjms.messages.main.OperationDrivenRequestMessage;


/**
 * @deprecated Use UserTestRequestMessage instead.
 * @author JordiK
 */
public class RunSingleTestRequestMessage extends OperationDrivenRequestMessage {
    
    private String testName;
    private String directory;
    
    public RunSingleTestRequestMessage() {
        
    }
    
    public RunSingleTestRequestMessage(String testName, String directory) {
        this.testName = testName;
        this.directory = directory;
    }

    /**
     * @return the testName
     */
    public String getTestName() {
        return testName;
    }

    /**
     * @param testName the testName to set
     */
    public void setTestName(String testName) {
        this.testName = testName;
    }

    /**
     * @return the directory
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * @param directory the directory to set
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    @Override
    public OperationDrivenReplyMessage generateReplyMessage() {
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
