/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import java.util.List;
import mocjms.messages.main.CompetitionBaseMessage;
import mocjms.messages.main.OperationDrivenMessage;

/**
 *
 * @author JordiK
 */
public class RunGroupTestRequestMessage extends CompetitionBaseMessage implements OperationDrivenMessage {
    
    private List<String> group;
    private String directory;
    
    public RunGroupTestRequestMessage() {
        
    }

    public RunGroupTestRequestMessage(List<String> group, String directory) {
        this.group = group;
        this.directory = directory;
    }
    
    /**
     * @return the group
     */
    public List<String> getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(List<String> group) {
        this.group = group;
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
    public void doWork() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
