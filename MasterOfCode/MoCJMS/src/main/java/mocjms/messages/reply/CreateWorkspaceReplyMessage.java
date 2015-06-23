/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.reply;

import mocjms.messages.main.OperationDrivenReplyMessage;

/**
 *
 * @author Gebruiker
 */
public class CreateWorkspaceReplyMessage extends OperationDrivenReplyMessage {

    private String workspacePath;
    private Long teamId;
    private Long competitionId;

    /**
     *
     * @param workspacePath
     * @param teamId
     * @param competitionId
     */
    public CreateWorkspaceReplyMessage(String workspacePath, Long teamId, Long competitionId) {
        this.workspacePath = workspacePath;
        this.teamId = teamId;
        this.competitionId = competitionId;
    }

    /**
     *
     */
    public CreateWorkspaceReplyMessage() {
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

    /**
     *
     * @return
     */
    public String getWorkspacePath() {
        return workspacePath;
    }

    /**
     *
     * @param workspacePath
     */
    public void setWorkspacePath(String workspacePath) {
        this.workspacePath = workspacePath;
    }
}
