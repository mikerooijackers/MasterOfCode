/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import Domein.Team;
import Domein.SourceCode;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import services.WorkspaceService;

/**
 *
 * @author Gebruiker
 */
@Path("workspace")
public class WorkSpaceResource {
    
    private static final WorkspaceService service = new WorkspaceService();
    
    @POST
    public void createWorkspace(Team team, String workspacePath) {
        service.createWorkspace(team, workspacePath);
    }
    
    @DELETE
    public void deleteWorkspace(Team team, String workspacePath) {
        service.deleteWorkspace(team, workspacePath);
    }
    
    @GET
    @Path("{assignment}")
    public List<SourceCode> readSourceCodeOfAssignment(@PathParam("assignment") String assignment, Team team, String workspacePath, String sourceCodePath, String assignmentPath) {
        return service.readSourceCode(team, workspacePath, assignment, sourceCodePath, assignmentPath);
    }
    
    @POST
    @Path("editSourceCode")
    public void saveSourceCode(String sourceCodePath, String sourceCode) {
        service.editSourceCode(sourceCodePath, sourceCode);
    }
    
    @GET
    public boolean requestCompile(String sourcePath)
    {
        return service.requestCompile(sourcePath);
    }
}
