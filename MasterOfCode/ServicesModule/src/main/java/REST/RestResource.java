/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Sockets.Messages.HintMessage;
import WebSocket.CompetitorEndPoint;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.inject.Inject;

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
    
//    @POST
//    @Path("login")
//    public MOCUser Login(LoginMessage message) {
//        
//    }
//    
//    @POST
//    @Path("register")
//    public MOCUser Register(RegisterMessage message) {
//        
//    }
//    
//    @POST
//    @Path("activationcode")
//    public Response ActivationCode(String code) {
//        
//    }
//    
//    @POST
//    @Path("addtoteam")
//    public MOCUser AddToTeam(TeamMessage message) {
//        
//    }
//    
//    @GET
//    @Path("getallusers")
//    public List<MOCUser> GetAllUsers() {
//        
//    }
//    
//    @GET
//    @Path("getallteams")
//    public List<Team> GetAllTeams() {
//        
//    }
//    
//    @GET
//    @Path("getcompetitiondata")
//    public CompetitionData GetCompetitionData() {
//        
//    }
//    
//    @GET
//    @Path("gethintsofcurrentround")
//    public List<Hint> GetHintsOfCurrentRound() {
//        
//    }
}
