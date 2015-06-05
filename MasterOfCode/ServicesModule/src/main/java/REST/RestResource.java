/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Domein.Hint;
import Domein.MOCUser;
import Domein.Role;
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
        String email = message.getEmail();
        String password = message.getPassword();
        return userService.Login(email, password);
        
    }
    
    /**
     *
     * @param message
     * @return
     */
    @POST
    @Path("register")
    public MOCUser Register(RegisterMessage message) {
        String email = message.getEmail();
        String fullname = message.getFullname();
        String password = message.getPassword();
        Role privilege = message.getPrivilege();
        String activationCode = message.getActivationCode();
        return userService.Register(email, fullname, password, privilege, activationCode);
        
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
     * get all users
     * @return
     */
    @GET
    @Path("getallusers")
    public List<MOCUser> GetAllUsers() {
        return userService.GetAllUsers();
    }
    
    /**
     * get all teams 
     * @return
     */
    @GET
    @Path("getallteams")
    public List<Team> GetAllTeams() {
        return userService.GetAllTeams();
        
    }
    
    /**
     *
     * @return
     */
    @GET
    @Path("getcompetitionsdata")
    public CompetitionData GetCompetitionsData() {
        return competitionService.GetCompetitionsData();
        
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
