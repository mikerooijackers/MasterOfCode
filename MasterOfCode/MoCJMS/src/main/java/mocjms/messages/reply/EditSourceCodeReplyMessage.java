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
public class EditSourceCodeReplyMessage extends CompetitionBasedOperationDrivenReplyMessage {

    private boolean isSuccessful;

    /**
     *
     * @param isSuccessful
     */
    public EditSourceCodeReplyMessage(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    /**
     *
     * @param isSuccessful
     * @param teamId
     * @param roundId
     * @param competitionId
     */
    public EditSourceCodeReplyMessage(boolean isSuccessful, Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.isSuccessful = isSuccessful;
    }

    /**
     *
     */
    public EditSourceCodeReplyMessage() {
    }

    /**
     *
     * @param teamId
     * @param roundId
     * @param competitionId
     */
    public EditSourceCodeReplyMessage(Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
    }

    /**
     *
     * @return
     */
    public boolean isIsSuccessful() {
        return isSuccessful;
    }

    /**
     *
     * @param isSuccessful
     */
    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }
}
