/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Domein.Hint;
import Domein.MOCUser;
import Domein.Team;
import Service.CompetitionService;
import Service.UserService;
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
    UserService userService;
    @Inject
    CompetitionService competitionService;
    @Inject
    private CompetitorEndPoint endPoint;

    /**
     *
     * @param message
     * @return
     */
    @POST
    @Path("login")
    public MOCUser Login(LoginMessage message) {
        return null;
        
    }
    
    /**
     *
     * @param message
     * @return
     */
    @POST
    @Path("register")
    public MOCUser Register(RegisterMessage message) {
        
        return null;
        
    }
    
    /**
     *
     * @param code
     * @return
     */
    @POST
    @Path("activationcode")
    public Response ActivationCode(String code) {
        return null;
        
    }
    
    /**
     *
     * @param message
     * @return
     */
    @POST
    @Path("addtoteam")
    public MOCUser AddToTeam(TeamMessage message) {
        return null;
        
    }
    
    /**
     *
     * @return
     */
    @GET
    @Path("getallusers")
    public List<MOCUser> GetAllUsers() {
        return userService.GetAllUsers();
    }
    
    /**
     *
     * @return
     */
    @GET
    @Path("getallteams")
    public List<Team> GetAllTeams() {
        return null;
        
    }
    
    /**
     *
     * @return
     */
    @GET
    @Path("getcompetitiondata")
    public CompetitionData GetCompetitionData() {
        return null;
        
    }
    
    /**
     *
     * @return
     */
    @GET
    @Path("gethintsofcurrentround")
    public List<Hint> GetHintsOfCurrentRound() {
        return null;
        
    }
    
    /**
     *
     * @return
     */
    @GET
    @Path("test")
    public String test() {
        userService.test();
        return "hello";
    }
}
