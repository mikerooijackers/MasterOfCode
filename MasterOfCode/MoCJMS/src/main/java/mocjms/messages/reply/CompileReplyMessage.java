/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.reply;

import mocjms.messages.main.CompetitionBaseMessage;
import mocjms.messages.main.OperationDrivenMessage;

/**
 *
 * @author Gebruiker
 */
public class CompileReplyMessage extends CompetitionBaseMessage implements OperationDrivenMessage {

    private String result;

    public CompileReplyMessage(String result) {
        this.result = result;
    }

    public CompileReplyMessage(String result, Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.result = result;
    }

    public CompileReplyMessage() {
    }

    public CompileReplyMessage(Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    @Override
    public void doWork() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
