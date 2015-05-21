/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Domein.Hint;
import Domein.MOCUser;
import Domein.Team;
import WebSocket.CompetitorEndPoint;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author mikerooijackers
 */
@Path("/RestResource")
@Stateless
public class RestResource {

    @Inject
    private CompetitorEndPoint endPoint;

    @POST
    @Path("login")
    public MOCUser Login(LoginMessage message) {
        return null;
        
    }
    
    @POST
    @Path("register")
    public MOCUser Register(RegisterMessage message) {
        return null;
        
    }
    
    @POST
    @Path("activationcode")
    public Response ActivationCode(String code) {
        return null;
        
    }
    
    @POST
    @Path("addtoteam")
    public MOCUser AddToTeam(TeamMessage message) {
        return null;
        
    }
    
    @GET
    @Path("getallusers")
    public List<MOCUser> GetAllUsers() {
        return null;
        
    }
    
    @GET
    @Path("getallteams")
    public List<Team> GetAllTeams() {
        return null;
        
    }
    
    @GET
    @Path("getcompetitiondata")
    public CompetitionData GetCompetitionData() {
        return null;
        
    }
    
    @GET
    @Path("gethintsofcurrentround")
    public List<Hint> GetHintsOfCurrentRound() {
        return null;
        
    }
}
