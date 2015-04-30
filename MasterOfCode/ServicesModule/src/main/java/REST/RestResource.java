/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import javax.ws.rs.core.*;
import javax.ws.rs.*;
import Domein.*;
import java.util.List;

/**
 * REST Web Service
 *
 * @author mikerooijackers
 */
@Path("")
public class RestResource {

    /**
     * Creates a new instance of RestResource
     */
    public RestResource() {
    }
    
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
