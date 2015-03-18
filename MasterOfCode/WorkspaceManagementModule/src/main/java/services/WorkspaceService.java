/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Domein.Team;
import dao.WorkspaceDAO;
import dao.WorkspaceDAOImpl;

/**
 *
 * @author Gebruiker
 */
public class WorkspaceService {
    private WorkspaceDAO dao;

    public WorkspaceService() {
        dao = new WorkspaceDAOImpl();
    }
    
    public void createWorkspace(Team team) {
        dao.createWorkspace(team);
    }
    
    public Team addTeam(Team team) {
        return dao.addTeam(team);
    }
}
