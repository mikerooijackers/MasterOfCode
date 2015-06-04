/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.reply;

import com.mycompany.jmslayermodule.ReplyBean;
import java.util.ArrayList;
import java.util.List;
import mocjms.messages.main.CompetitionBaseMessage;
import mocjms.messages.main.OperationDrivenMessage;

/**
 *
 * @author Gebruiker
 */
public class UserTestReplyMessage extends CompetitionBaseMessage implements OperationDrivenMessage {

    private List<String> results;

    public UserTestReplyMessage(List<String> results) {
        this.results = results;
    }

    public UserTestReplyMessage(List<String> results, Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.results = results;
    }

    public UserTestReplyMessage() {
        this.results = new ArrayList<>();
    }

    public UserTestReplyMessage(Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.results = new ArrayList<>();
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }
    
    @Override
    public void doWork(ReplyBean replyBean) {
        replyBean.send(this);
    }
    
}
