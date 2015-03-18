/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import Domein.Team;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import services.WorkspaceService;

/**
 *
 * @author Gebruiker
 */
@Path("/workspace")
public class WorkSpaceResource {
    
    private static final WorkspaceService service = new WorkspaceService();
    
    @POST
    public void createWorkspace(Team team) {
        service.createWorkspace(team);
    }
}
