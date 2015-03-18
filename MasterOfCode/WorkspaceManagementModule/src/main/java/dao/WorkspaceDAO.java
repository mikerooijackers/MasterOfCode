/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Domein.Team;

/**
 *
 * @author Gebruiker
 */
public interface WorkspaceDAO {
    void createWorkspace(Team team);
    
    //delete
    Team addTeam(Team team);
}
