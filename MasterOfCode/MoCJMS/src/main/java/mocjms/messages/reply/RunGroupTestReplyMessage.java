/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.reply;

import java.util.ArrayList;
import java.util.List;
import mocjms.messages.main.CompetitionBasedOperationDrivenReplyMessage;

/**
 * @deprecated Use GroupTestReplyMessage instead.
 * @author JordiK
 */
public class RunGroupTestReplyMessage extends CompetitionBasedOperationDrivenReplyMessage {
    
    private List<String> commandOutput;
    
    /**
     *
     */
    public RunGroupTestReplyMessage() {
        this.commandOutput = new ArrayList<>();
    }
    
    /**
     *
     * @param output
     */
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
}
