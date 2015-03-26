/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Domein.Team;
import dao.WorkspaceDAO;
import dao.WorkspaceDAOImpl;
import Domein.SourceCode;
import java.util.List;

/**
 *
 * @author Gebruiker
 */
public class WorkspaceService {
    private WorkspaceDAO dao;

    public WorkspaceService() {
        dao = new WorkspaceDAOImpl();
    }
    
    public void createWorkspace(Team team, String workspacePath) {
        dao.createWorkspace(team, workspacePath);
    }
    
    public void deleteWorkspace(Team team, String workspacePath) {
        dao.deleteWorkspace(team, workspacePath);
    }
    
    public void editSourceCode(String sourceCodePath, String sourceCode) {
        dao.editSourceCode(sourceCodePath, sourceCode);
    }
    
    public List<SourceCode> readSourceCode(Team team, String workspacePath, String assignment, String sourceCodePath) {
        return dao.readSourceCode(team, workspacePath, assignment, sourceCodePath);
    }
    
    public boolean requestCompile(String sourcePath)
    {
        return dao.requestCompile(sourcePath);
    }
    
//    public Team addTeam(Team team) {
//        return dao.addTeam(team);
//    }
//    
//    public MOCUser addUser(MOCUser user) {
//        return dao.addUser(user);
//    }
//    
//    public Team findTeam() {
//        return dao.findTeam();
//    }
}
