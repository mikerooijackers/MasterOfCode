/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Domein.Team;
import Domein.MOCUser;
import dao.WorkspaceDAO;
import dao.WorkspaceDAOImpl;
import Domein.SourceCode;
import domain.AnnotationData;
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
    
    public List<SourceCode> readSourceCode(Team team, String workspacePath, String assignment, String sourceCodePath, String assignmentPath) {
        return dao.readSourceCode(team, workspacePath, assignment, sourceCodePath, assignmentPath);
    }
    
    public List<AnnotationData> readAssignmentMetaData(String assignmentPath, String assignment) {
        return dao.readAssignmentMetaData(assignmentPath, assignment);
    }
    
    public void extractAssignmentToWorkspace(Team team, String workspacePath, String assignment, String assignmentPath) {
        dao.extractAssignmentToWorkspace(team, workspacePath, assignment, assignmentPath);
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
