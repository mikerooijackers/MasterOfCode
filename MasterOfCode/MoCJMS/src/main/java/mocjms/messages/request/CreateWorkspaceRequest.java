/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import Domein.Team;

/**
 *
 * @author Gebruiker
 */
public class CreateWorkspaceRequest {
    private Team team;
    private String workspacePath;

    public CreateWorkspaceRequest() {
    }

    public CreateWorkspaceRequest(Team team, String workspacePath) {
        this.team = team;
        this.workspacePath = workspacePath;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getWorkspacePath() {
        return workspacePath;
    }

    public void setWorkspacePath(String workspacePath) {
        this.workspacePath = workspacePath;
    }
}
