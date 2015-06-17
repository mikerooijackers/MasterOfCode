/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import domein.Competition;
import domein.Hint;
import domein.MOCUser;
import domein.Role;
import domein.Team;
import Service.CompetitionService;
import Service.UserService;
import WebSocket.CompetitorEndPoint;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

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
    @Inject
    private JMS.WorkspaceServiceRequestBean bean;
    
    /**
     *
     * @param message
     * @return
     */
    @POST
    @Path("login")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
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
        String company = message.getCompany();
        String telephone = message.getTelephone();
        return userService.Register(email, fullname, password, privilege, activationCode, company, telephone);
    }
    
    /**
     *
     * @param code
     * @param userId
     * @return
     */
//    @POST
//    @Path("activationcode")
//    public String SetActivationCode(String code, long userId) {
//        return userService.SetActivationCode(code, userId);
//    }
    
    /**
     *
     * @param message
     * @return
     */
    @POST
    @Path("addtoteam")
    public MOCUser AddToTeam(TeamMessage message) {
        long userId = message.getUserId();
        long teamId = message.getTeamId();
        return userService.AddToTeam(userId, teamId);
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
    public List<Competition> GetCompetitionsData() {
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
        return "hello";
    }
    
    @GET
    @Path("testjms")
    public String testjms() {
        mocjms.messages.main.OperationDrivenRequestMessage mes = new mocjms.messages.request.CreateWorkspaceRequestMessage(0L, 0L); //new mocjms.messages.request.ExtractAssignmentToWorkspacesRequestMessage(0L, 1L, 0L); //new mocjms.messages.request.CreateWorkspaceRequestMessage(5L, 0L);
        bean.Send(mes);
        return "ok";
    }
}
