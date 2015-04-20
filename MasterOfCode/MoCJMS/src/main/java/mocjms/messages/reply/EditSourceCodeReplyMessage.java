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
public class EditSourceCodeReplyMessage extends CompetitionBaseMessage implements OperationDrivenMessage {

    private boolean isSuccessful;

    public EditSourceCodeReplyMessage(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public EditSourceCodeReplyMessage(boolean isSuccessful, Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.isSuccessful = isSuccessful;
    }

    public EditSourceCodeReplyMessage() {
    }

    public EditSourceCodeReplyMessage(Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
    }

    public boolean isIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }
    
    @Override
    public void doWork() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}