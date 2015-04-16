/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.reply;

import java.util.ArrayList;
import java.util.List;
import mocjms.messages.main.CompetitionBaseMessage;
import mocjms.messages.main.OperationDrivenMessage;

/**
 *
 * @author Gebruiker
 */
public class GroupTestReplyMessage extends CompetitionBaseMessage implements OperationDrivenMessage {

    private List<String> results;

    public GroupTestReplyMessage() {
        this.results = new ArrayList<>();
    }

    public GroupTestReplyMessage(Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.results = new ArrayList<>();
    }

    public GroupTestReplyMessage(List<String> results) {
        this.results = results;
    }

    public GroupTestReplyMessage(List<String> results, Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.results = results;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }
    
    @Override
    public void doWork() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
