/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Domein.Team;
import java.io.File;

/**
 *
 * @author Gebruiker
 */
public class WorkspaceDAOImpl implements WorkspaceDAO {

    @Override
    public void createWorkspace(Team team) {
        // TODO
        String path = "C:\\workspaces\\" + team.getId();
        new File(path).mkdir();
        team.setWorkspacePath(path);
    }
    
}
