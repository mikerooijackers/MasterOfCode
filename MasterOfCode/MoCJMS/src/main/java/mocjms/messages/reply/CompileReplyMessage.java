/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.reply;

import mocjms.messages.main.CompetitionBasedOperationDrivenReplyMessage;

/**
 *
 * @author Gebruiker
 */
public class CompileReplyMessage extends CompetitionBasedOperationDrivenReplyMessage {

    private String result;

    public CompileReplyMessage(String result, Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.result = result;
    }

    public CompileReplyMessage() {
        
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }    
}
