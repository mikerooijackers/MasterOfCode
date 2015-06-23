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
public class UserTestReplyMessage extends CompetitionBasedOperationDrivenReplyMessage {

    private String result;

    /**
     *
     */
    public UserTestReplyMessage() {
    }

    /**
     *
     * @param result
     * @param teamId
     * @param roundId
     * @param competitionId
     */
    public UserTestReplyMessage(String result, Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.result = result;
    }

    /**
     *
     * @return
     */
    public String getResult() {
        return result;
    }

    /**
     *
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }
}
