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
public class GroupTestReplyMessage extends CompetitionBasedOperationDrivenReplyMessage {

    private String result;

    /**
     *
     */
    public GroupTestReplyMessage() {
    }

    /**
     *
     * @param teamId
     * @param roundId
     * @param competitionId
     * @param result
     */
    public GroupTestReplyMessage(Long teamId, Long roundId, Long competitionId, String result) {
        super(teamId, roundId, competitionId);
        this.result = result;
    }

    /**
     *
     * @return
     */
    public String getResult() {
        return this.result;
    }

    /**
     *
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }
}
