/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.reply;

import mocjms.messages.main.CompetitionBasedOperationDrivenReplyMessage;

/**
 *
 * @author JordiK
 */
public class TurninReplyMessage extends CompetitionBasedOperationDrivenReplyMessage {
    
    private boolean succeeded;
    private Long score;
    
    public TurninReplyMessage(){}
    
    /**
     * 
     * @param teamId
     * @param roundId
     * @param competitionId
     * @param succeeded 
     */
    public TurninReplyMessage(Long teamId, Long roundId, Long competitionId, boolean succeeded, Long score) {
        super(teamId, roundId, competitionId);
        this.succeeded = succeeded;
        this.score = score;
    }

    /**
     * @return the succeeded
     */
    public boolean isSucceeded() {
        return succeeded;
    }

    /**
     * @param succeeded the succeeded to set
     */
    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    /**
     * @return the score
     */
    public Long getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Long score) {
        this.score = score;
    }
    
}
