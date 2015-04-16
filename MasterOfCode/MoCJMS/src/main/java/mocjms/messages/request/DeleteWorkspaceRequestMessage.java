/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import mocjms.messages.main.OperationDrivenMessage;

/**
 *
 * @author Gebruiker
 */
public class DeleteWorkspaceRequestMessage implements OperationDrivenMessage {
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
    public void doWork() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
