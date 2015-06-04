/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import com.mycompany.jmslayermodule.ReplyBean;
import com.mycompany.workspacemanagementmoduleb.WorkspaceService;
import mocjms.messages.main.OperationDrivenMessage;
import mocjms.messages.reply.CreateWorkspaceReplyMessage;

/**
 *
 * @author Gebruiker
 */
public class CreateWorkspaceRequestMessage implements OperationDrivenMessage {
    private Long teamId;
    private Long competitionId;

    public CreateWorkspaceRequestMessage() {
    }

    public CreateWorkspaceRequestMessage(Long teamId, Long competitionId) {
        this.teamId = teamId;
        this.competitionId = competitionId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    @Override
    public void doWork(ReplyBean replyBean) {
        String workspacePath = WorkspaceService.getInstance().createWorkspace(competitionId, teamId);
        
        OperationDrivenMessage message = new CreateWorkspaceReplyMessage(workspacePath, teamId, competitionId);
        replyBean.send(message);
    }
}
