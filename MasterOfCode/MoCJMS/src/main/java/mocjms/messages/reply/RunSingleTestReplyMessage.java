/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.reply;

import mocjms.messages.main.CompetitionBasedOperationDrivenReplyMessage;

/**
 * @deprecated Use UserTestReplyMessage instead.
 * @author JordiK
 */
public class RunSingleTestReplyMessage extends CompetitionBasedOperationDrivenReplyMessage {
    
    private String output;
    
    public RunSingleTestReplyMessage() {
        
    }
    
    public RunSingleTestReplyMessage(String output) {
        this.output = output;
    }

    /**
     * @return the output
     */
    public String getOutput() {
        return output;
    }

    /**
     * @param output the output to set
     */
    public void setOutput(String output) {
        this.output = output;
    }
}
