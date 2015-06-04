/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.reply;

import com.mycompany.jmslayermodule.ReplyBean;
import mocjms.messages.main.OperationDrivenMessage;

/**
 *
 * @author Gebruiker
 */
public class DeleteWorkspaceReplyMessage implements OperationDrivenMessage {

    private String workspacePath;
    private Long teamId;
    private Long competitionId;

    public DeleteWorkspaceReplyMessage(String workspacePath, Long teamId, Long competitionId) {
        this.workspacePath = workspacePath;
        this.teamId = teamId;
        this.competitionId = competitionId;
    }

    public DeleteWorkspaceReplyMessage() {
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
    
    public String getWorkspacePath() {
        return workspacePath;
    }

    public void setWorkspacePath(String workspacePath) {
        this.workspacePath = workspacePath;
    }
    
    @Override
    public void doWork(ReplyBean replyBean) {
        //replyBean.send(this);
    }
    
}
