/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Domein.Team;
import Domein.SourceCode;
import domain.AnnotationData;
import java.util.List;

/**
 *
 * @author Gebruiker
 */
public interface WorkspaceDAO {
    void createWorkspace(Team team, String workspacePath);
    void deleteWorkspace(Team team, String workspacePath);
    void editSourceCode(String sourceCodePath, String sourceCode);
    List<SourceCode> readSourceCode(Team team, String workspacePath, String assignment, String sourceCodePath, String assignmentPath);
    List<AnnotationData> readAssignmentMetaData(String assignmentPath, String assignment);
    void extractAssignmentToWorkspace(Team team, String workspacePath, String assignment, String assignmentPath);
    
     /**
     * Compiles the given application and shows a stack trace if the compilation
     * fails.
     * @param sourcePath
     * @return false if compilation fails, true if it succeeds
     */
    boolean requestCompile(String sourcePath);
}
