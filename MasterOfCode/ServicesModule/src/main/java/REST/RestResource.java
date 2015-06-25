/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Competition.CompetitionDataService;
import Domein.Competition;
import Domein.Hint;
import Domein.MOCUser;
import Domein.Role;
import Domein.Team;
import Service.CommunicationBean;
import Service.CompetitionService;
import Service.UserService;
import WebSocket.CompetitorEndPoint;
import emailUtils.EmailMessenger;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import mocjms.messages.request.CreateWorkspaceRequestMessage;

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
    @Inject
    private EmailMessenger mailMessenger;

    @EJB
    private CommunicationBean communicationBean;

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
        MOCUser user = userService.Login(email, password);
        if (user.getTeam() != null) {
            user.getTeam().setInitiator(null);
        }
        return user;
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

    @POST
    @Path("createteam")
    @Produces({MediaType.APPLICATION_JSON})
    public Team CreateTeam(CreateTeamMessage message) {
        String teamName = message.getTeamName();
        String initiator = message.getInitiator();
        List<String> members = message.getMembers();
        long competitionId = communicationBean.getCompetitionDataService().getCurrentCompetition().getId();
        
        Team team = userService.createTeam(teamName, initiator, members, competitionId);
        
        communicationBean.sendMessageToWorkspaceManegementBean(new CreateWorkspaceRequestMessage(team.getId(), competitionId));
        for (String address : members) {
            if (!address.equals("")) {
                mailMessenger.sendAddedToTeamMessage(address, members, team.getTeamName(), initiator);
            }
        }
        team.setInitiator(null);
//        team.setMembers(userService.getTeamMembers(team));
        return team;
    }

    /**
     * get all users
     *
     * @return
     */
    @GET
    @Path("getallusers")
    public List<MOCUser> GetAllUsers() {
        return userService.GetAllUsers();
    }

    /**
     * get all teams
     *
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

    @GET
    @Path("getteammembers/{teamid}")
    public List<MOCUser> getTeamMembers(@PathParam(value = "teamid") Long teamId) {
        Team team = userService.getTeam(teamId);
        List<MOCUser> members = userService.getTeamMembers(team);
        return members;
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
        //mocjms.messages.main.OperationDrivenRequestMessage mes = new mocjms.messages.request.CreateWorkspaceRequestMessage(0L, 0L); //new mocjms.messages.request.ExtractAssignmentToWorkspacesRequestMessage(0L, 1L, 0L); //new mocjms.messages.request.CreateWorkspaceRequestMessage(5L, 0L);
        //bean.Send(mes);
        //Round nextRound = competitionService.getNextRound();
        //communicationBean.sendRoundMetaData();
        //communicationBean.startNextRoundOfCompetition();
        //Competition currentCompetition = communicationBean.getCompetitionDataService().getCurrentCompetition();

        //new Sockets.Messages.Client.Request.GetSourceFilesRequestMessage(1L).doAction(communicationBean);
        communicationBean.setRoundScoreOfUnsubmittedTeams();
        return "ok";
    }
}
