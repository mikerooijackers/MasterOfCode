/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.main;

import java.io.Serializable;

/**
 *
 * @author Gebruiker
 */
public abstract class CompetitionBasedOperationDrivenRequestMessage extends CompetitionBaseMessage implements Serializable, OperationDrivenMessage {

    public CompetitionBasedOperationDrivenRequestMessage(Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
    }

    public CompetitionBasedOperationDrivenRequestMessage() {
        super();
    }
    
    @Override
    public abstract CompetitionBasedOperationDrivenReplyMessage generateReplyMessage();
}
