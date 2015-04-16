/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.reply;

import java.util.ArrayList;
import java.util.List;
import mocjms.messages.main.OperationDrivenMessage;

/**
 *
 * @author JordiK
 */
public class RunGroupTestReplyMessage implements OperationDrivenMessage {
    
    private List<String> commandOutput;
    
    public RunGroupTestReplyMessage() {
        this.commandOutput = new ArrayList<>();
    }
    
    public RunGroupTestReplyMessage(List<String> output) {
        this.commandOutput = output;
    }

    /**
     * @return the commandOutput
     */
    public List<String> getCommandOutput() {
        return commandOutput;
    }

    /**
     * @param commandOutput the commandOutput to set
     */
    public void setCommandOutput(List<String> commandOutput) {
        this.commandOutput = commandOutput;
    }

    @Override
    public void doWork() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
