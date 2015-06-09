/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import com.mycompany.workspacemanagementmoduleb.WorkspaceService;
import mocjms.messages.main.CompetitionBasedOperationDrivenReplyMessage;
import mocjms.messages.main.CompetitionBasedOperationDrivenRequestMessage;
import mocjms.messages.reply.GroupTestReplyMessage;

/**
 *
 * @author Gebruiker
 */
public class GroupTestRequestMessage extends CompetitionBasedOperationDrivenRequestMessage {

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
    public CompetitionBasedOperationDrivenReplyMessage generateReplyMessage() {
        String result = WorkspaceService.getInstance().runTestGroup(this.groupName, super.getCompetitionId(), super.getTeamId(), super.getRoundId());
        CompetitionBasedOperationDrivenReplyMessage reply = new GroupTestReplyMessage(super.getTeamId(), super.getRoundId(), super.getCompetitionId(), result);
        
        return reply;
    }
    
}
