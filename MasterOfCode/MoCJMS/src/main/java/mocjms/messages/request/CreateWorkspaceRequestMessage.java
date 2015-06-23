/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import com.mycompany.workspacemanagementmoduleb.WorkspaceService;
import mocjms.messages.main.OperationDrivenReplyMessage;
import mocjms.messages.main.OperationDrivenRequestMessage;
import mocjms.messages.reply.CreateWorkspaceReplyMessage;

/**
 *
 * @author Gebruiker
 */
public class CreateWorkspaceRequestMessage extends OperationDrivenRequestMessage {
    private Long teamId;
    private Long competitionId;

    /**
     *
     */
    public CreateWorkspaceRequestMessage() {
    }

    /**
     *
     * @param teamId
     * @param competitionId
     */
    public CreateWorkspaceRequestMessage(Long teamId, Long competitionId) {
        this.teamId = teamId;
        this.competitionId = competitionId;
    }

    /**
     *
     * @return
     */
    public Long getTeamId() {
        return teamId;
    }

    /**
     *
     * @param teamId
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /**
     *
     * @return
     */
    public Long getCompetitionId() {
        return competitionId;
    }

    /**
     *
     * @param competitionId
     */
    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    @Override
    public OperationDrivenReplyMessage generateReplyMessage() {
        String workspacePath = WorkspaceService.getInstance().createWorkspace(competitionId, teamId);
        
        OperationDrivenReplyMessage message = new CreateWorkspaceReplyMessage(workspacePath, teamId, competitionId);
        return message;
    }
}
