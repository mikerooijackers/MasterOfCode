/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import com.mycompany.workspacemanagementmoduleb.WorkspaceService;
import mocjms.messages.main.OperationDrivenReplyMessage;
import mocjms.messages.main.OperationDrivenRequestMessage;
import mocjms.messages.reply.DeleteWorkspaceReplyMessage;

/**
 *
 * @author Gebruiker
 */
public class DeleteWorkspaceRequestMessage extends OperationDrivenRequestMessage {
    private Long competitionId;
    private Long teamId;

    public DeleteWorkspaceRequestMessage(Long competitionId, Long teamId) {
        this.competitionId = competitionId;
        this.teamId = teamId;
    }

    public DeleteWorkspaceRequestMessage() {
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Override
    public OperationDrivenReplyMessage generateReplyMessage() {
        String deletedWorkspacePath = WorkspaceService.getInstance().deleteWorkspace(competitionId, teamId);
        
        OperationDrivenReplyMessage message = new DeleteWorkspaceReplyMessage(deletedWorkspacePath, teamId, competitionId);
        return message;
    }
}
