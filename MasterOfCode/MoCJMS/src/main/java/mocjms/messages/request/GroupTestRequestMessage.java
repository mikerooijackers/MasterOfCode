/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import com.mycompany.jmslayermodule.ReplyBean;
import mocjms.messages.main.CompetitionBaseMessage;
import mocjms.messages.main.OperationDrivenMessage;

/**
 *
 * @author Gebruiker
 */
public class GroupTestRequestMessage extends CompetitionBaseMessage implements OperationDrivenMessage {

    private String groupName;

    public GroupTestRequestMessage() {
    }

    public GroupTestRequestMessage(Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
    }

    public GroupTestRequestMessage(String groupName) {
        this.groupName = groupName;
    }

    public GroupTestRequestMessage(String groupName, Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    @Override
    public void doWork(ReplyBean replyBean) {
        
    }
    
}
