/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Competition.CompetitionDataService;
import Competition.RoundMetaData;
import Domein.AnnotationData;
import Domein.AnnotationMethod;
import Domein.Assignment;
import Domein.Competition;
import Domein.Hint;
import Domein.MOCUser;
import Domein.Role;
import Domein.Round;
import Domein.Status;
import Domein.Team;
import Domein.UnitTestFile;
import JMS.WorkspaceServiceRequestBean;
import Sockets.Messages.BaseMessage;
import Sockets.Messages.Client.Reply.GetUserTestsReplyMessage;
import Sockets.Messages.Client.Reply.OtherTeamScoreReplyMessage;
import Sockets.Messages.Reply.GetParticipantsReplyMessage;
import Sockets.Messages.Reply.PauzeRoundReplyMessage;
import Sockets.Messages.Reply.StartRoundReplyMessage;
import Sockets.Messages.Reply.StopCompetitionReplyMessage;
import Sockets.Messages.Reply.StopRoundReplyMessage;
import Sockets.Messages.Reply.TeamActionReplyMessage;
import Timer.TimerData;
import Timer.TimerSessionBean;
import Timer.TimerType;
import WebSocket.AdminEndPoint;
import WebSocket.CompetitorEndPoint;
import WebSocket.SpectatorEndpoint;
import com.mycompany.workspacemanagementmoduleb.WorkspaceService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mocjms.messages.request.ExtractAssignmentToWorkspacesRequestMessage;

/**
 *
 * @author JordiK
 */
@Stateless
public class CommunicationBean {

    @EJB
    private AdminEndPoint adminEndpoint;

    @EJB
    private CompetitorEndPoint competitorEndpoint;

    @EJB
    private SpectatorEndpoint spectatorEndpoint;

    @EJB
    private WorkspaceServiceRequestBean workspaceServiceRequestBean;

    @EJB
    private TimerSessionBean timerSessionBean;

    @EJB
    private CompetitionDataService competitionDataService;

    @Inject
    private CompetitionService competitionService;

    @Inject
    private UserService userService;

    public CompetitionDataService getCompetitionDataService() {
        return this.competitionDataService;
    }

    public UserService getUserService() {
        return this.userService;
    }

    public void setRoundScoreOfUnsubmittedTeams() {

        userService.Register("blaat", "blaat", "blaat", Role.ADMIN, "blaat", "blaat", "blaat");

//        List<Team> teams = competitionDataService.GetTeams();
//        Long roundId = competitionDataService.getCurrentRound().getId();
//        List<RoundScore> roundScoresOfRound = competitionService.getRoundScoresOfRound(roundId);
//        
//        Set<Long> teamIdsNotToAdd = new HashSet<Long>();
//        
//        for (RoundScore rs : roundScoresOfRound) {
//            teamIdsNotToAdd.add(rs.getTeam().getId());
//        }
//        
//        for (Team team : teams) {
//            Long teamId = team.getId();
//            if (!teamIdsNotToAdd.contains(teamId)) { // if the team hasn't submitted a result
//                competitionService.setTeamRoundScore(teamId, roundId, 0);
//            }
//        }
//    }
    }

    /**
     * send Message To Competitor
     *
     * @param teamId
     * @param message
     */
    public void sendMessageToCompetitor(Long teamId, BaseMessage message) {
        competitorEndpoint.sendMessage(teamId, message);
    }

    /**
     * send Message To All Competitors
     *
     * @param message
     */
    public void sendMessageToAllCompetitors(BaseMessage message) {
        competitorEndpoint.sendToAll(message);
    }

    /**
     *
     * @param message
     */
    public void sendMessageToWorkspaceManegementBean(Serializable message) {
        workspaceServiceRequestBean.Send(message);
    }

    /**
     *
     * @param username
     * @param message
     */
    public void sendMessageToAdmin(String username, BaseMessage message) {
        adminEndpoint.sendMessage(username, message);
    }

    /**
     *
     * @param message
     */
    public void sendMessageToAllAdmins(BaseMessage message) {
        adminEndpoint.sendToAll(message);
    }

    /**
     *
     * @param timerData
     * @param duration
     */
    public void startTimer(TimerData timerData, long duration) {
        timerSessionBean.CreateTimer(duration, timerData);
    }

    /**
     *
     * @param timerData
     */
    public void stopTimer(TimerData timerData) {
        timerSessionBean.stopTimer(timerData);
    }

    /**
     *
     * @param timerData
     */
    public void pauseOrFreezeTimer(TimerData timerData) {
        timerSessionBean.pauseOrFreezeTimer(timerData);
    }

    /**
     *
     */
    public void resumeTimer() {
        timerSessionBean.resumeTimer();
    }

    /**
     *
     * @param newDuration
     * @param timerData
     */
    public void modifyTimerDuration(long newDuration, TimerData timerData) {
        timerSessionBean.modifyTimerDuration(newDuration, timerData);
    }

    /**
     *
     * @param message
     */
    public void sendMessageToEveryone(BaseMessage message) {
        competitorEndpoint.sendToAll(message);
        adminEndpoint.sendToAll(message);
        spectatorEndpoint.sendMessage(message);
    }

    /**
     *
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public String changePassword(int userId, String oldPassword, String newPassword) {
        return userService.changePassword(userId, oldPassword, newPassword);
    }

    /**
     *
     * @param competitionId
     */
    public void setCurrentCompetition(Long competitionId) {
        Competition competition = competitionService.FindCompetition(competitionId);
        competitionDataService.setCurrentCompetition(competition);
    }

    public void setCurrentRound(Long roundId) {
        Round round = competitionService.FindRound(roundId);
        competitionDataService.setCurrentRound(round);
    }

    /**
     *
     */
    public void startNextRoundOfCompetition() {
        long competitionId = competitionDataService.getCurrentCompetition().getId();
        Round currentRound = competitionDataService.getCurrentRound();
        if (currentRound != null) {
            competitionService.editRound(Status.STOP, currentRound.getId());
        }
        StopRoundReplyMessage stopRoundReplyMessage = new StopRoundReplyMessage();
        sendMessageToEveryone(stopRoundReplyMessage);

        Round nextRound = competitionService.getNextRound(competitionId);

        if (nextRound == null) {
            StopCompetitionReplyMessage stopCompetitionReplyMessage = new StopCompetitionReplyMessage();
            sendMessageToEveryone(stopCompetitionReplyMessage);
        } else {
            competitionDataService.setCurrentRound(nextRound);
            competitionService.editRound(Status.PLAYING, nextRound.getId());
            workspaceServiceRequestBean.Send(new ExtractAssignmentToWorkspacesRequestMessage(nextRound.getAssignment().getId(), nextRound.getId(), competitionId));
        }
    }

    /**
     *
     */
    public void PauseTheRound() {
        Round currentRound = competitionDataService.getCurrentRound();
        competitionService.editRound(Status.PAUSE, currentRound.getId());
        TimerData timerData = new TimerData(TimerType.RoundTimer);
        pauseOrFreezeTimer(timerData);
        PauzeRoundReplyMessage mes = new PauzeRoundReplyMessage();
        sendMessageToEveryone(mes);
    }

    /**
     *
     */
    public void FreezeTheRound() {
        Round currentRound = competitionDataService.getCurrentRound();
        competitionService.editRound(Status.FREEZE, currentRound.getId());
    }

    /**
     *
     */
    public void ResumeTheRound() {
        Round currentRound = competitionDataService.getCurrentRound();
        competitionService.editRound(Status.PLAYING, currentRound.getId());
        this.resumeTimer();
    }

    /**
     *
     */
    public void sendRoundMetaData() {
        Round currentRound = competitionDataService.getCurrentRound();

        Assignment assignment = currentRound.getAssignment();

        Long assignmentId = assignment.getId();
        List<AnnotationData> annotationData = WorkspaceService.getInstance().readAssignmentMetaData(assignmentId, false, true);

        StartRoundReplyMessage message = new StartRoundReplyMessage();
        List<Hint> hints = new ArrayList<Hint>();
        List<UnitTestFile> unitTestFiles = new ArrayList<UnitTestFile>();

        for (AnnotationData data : annotationData) {
            String annotationName = data.getAnnotationName();

            if (annotationName.equals("AssignCreator")) {
                List<AnnotationMethod> methods = data.getMethods();
                for (AnnotationMethod method : methods) {
                    String methodName = method.getName();
                    Object methodValue = method.getValue();
                    if (methodName.equals("creatorOrginisation")) {
                        message.setAssignCreatorCompany((String) methodValue);
                    } else if (methodName.equals("creatorName")) {
                        message.setAssignCreatorName((String) methodValue);
                    } else if (methodName.equals("creatorWebsite")) {
                        message.setAssignCreatorWeb((String) methodValue);
                    } else if (methodName.equals("creatorLogo")) {
                        message.setAssignCreatorLogo((String) methodValue);
                    }
                }
            } else if (annotationName.equals("AssignInformation")) {
                List<AnnotationMethod> methods = data.getMethods();
                for (AnnotationMethod method : methods) {
                    String methodName = method.getName();
                    Object methodValue = method.getValue();
                    if (methodName.equals("name")) {
                        message.setAssignName((String) methodValue);
                    } else if (methodName.equals("contestantDescription")) {
                        message.setAssignDescriptionCompetitors((String) methodValue);
                    } else if (methodName.equals("spectatorDescription")) {
                        message.setAssignDescriptionSpectators((String) methodValue);
                    } else if (methodName.equals("difficulty")) {
                        switch (methodValue.toString()) {
                            case "Easy":
                                message.setAssignDifficulty(1);
                            case "Medium":
                                message.setAssignDifficulty(2);
                            case "Hard":
                                message.setAssignDifficulty(3);
                            default:
                                message.setAssignDifficulty(2);
                        }
                    }
                }
            } else if (annotationName.equals("Hints")) {
                List<AnnotationMethod> methods = data.getMethods();
                for (AnnotationMethod method : methods) {
                    com.mycompany.annotations.Hint[] methodValue = (com.mycompany.annotations.Hint[]) method.getValue();

                    for (com.mycompany.annotations.Hint aHint : methodValue) {

                        Hint hint = new Hint();
                        hint.setName("Hint");

                        hint.setDelayInSeconds(aHint.delay());
                        hint.setDescription(aHint.description());

                        hints.add(hint);
                    }
                }
            } else if (annotationName.equals("Test")) {
                List<AnnotationMethod> methods = data.getMethods();
                boolean isUserTest = false;
                UnitTestFile utf = new UnitTestFile();
                for (AnnotationMethod method : methods) {
                    String methodName = method.getName();
                    Object methodValue = method.getValue();

                    if (methodName.equals("testName")) {
                        utf.setName((String) methodValue);
                    } else if (methodName.equals("description")) {
                        utf.setDescription((String) methodValue);
                    } else if (methodName.equals("groups")) {
                        String[] group = (String[]) methodValue;
                        for (int i = 0; i < group.length; i++) {
                            if (group[i].equals("user")) {
                                isUserTest = true;
                                break;
                            }
                        }
                    }
                }

                if (isUserTest) {
                    unitTestFiles.add(utf);
                }
            }
        }

        competitionDataService.setRoundMetaData(new RoundMetaData(message.getAssignCreatorName(), message.getAssignCreatorCompany(), message.getAssignCreatorLogo(), message.getAssignCreatorWeb(), message.getAssignName(), message.getAssignDescriptionSpectators(), message.getAssignDescriptionCompetitors(), message.getAssignDifficulty(), hints));

        int roundDurationInSeconds = competitionDataService.getCurrentRound().getDurationInSeconds();

        message.setDuration(roundDurationInSeconds);

        this.sendMessageToAllCompetitors(new GetUserTestsReplyMessage(unitTestFiles)); // send all unit test files
        this.sendMessageToAllCompetitors(message); // send the start round message

        competitionDataService.setHintsOfThisRound(hints);
        this.startTimer(new TimerData(TimerType.RoundTimer), (long) roundDurationInSeconds);

        for (int i = 0; i < hints.size(); i++) {
            this.startTimer(new TimerData((long) i + 1, hints.get(i).getDescription(), TimerType.HintTimer), (long) hints.get(i).getDelayInSeconds());
        }

        this.sendTeamActionMessage(-1L, "A round has started!");
    }

    public void registerUser(MOCUser user) {
        userService.Register(user);
    }

    public void sendParticipantListToAdmins() {
        GetParticipantsReplyMessage message = new GetParticipantsReplyMessage(userService.GetAllUsers());
        adminEndpoint.sendToAll(message);
    }

    public void sendStartCompetitionReplyMessage() {
        Competition comp = competitionDataService.getCurrentCompetition();
        String description = comp.getDescription();
        int numberOfRounds = competitionService.getNumberOfRounds(comp.getId());
        String name = comp.getName();
        Calendar startTime = comp.getStartTime();

        StopCompetitionReplyMessage mes = new StopCompetitionReplyMessage();
        sendMessageToEveryone(mes);
    }

    public void sendCompileRequest(Long teamId) {
        Long competitionId = competitionDataService.getCurrentCompetition().getId();
        Long roundId = competitionDataService.getCurrentRound().getId();
        mocjms.messages.request.CompileRequestMessage mess = new mocjms.messages.request.CompileRequestMessage(teamId, roundId, competitionId);
        this.sendMessageToWorkspaceManegementBean(mess);
    }

    public void sendTeamActionMessage(Long teamId, String message) {
        String messageToSend;
        if (teamId > 0) {
            Team team = userService.getTeam(teamId);
            messageToSend = team.getTeamName() + " " + message;
        } else {
            messageToSend = message;
        }
        this.sendMessageToEveryone(new TeamActionReplyMessage(messageToSend));
    }
    
    public void sendTurninRequest(Long teamId) {
        Long remainingTime = timerSessionBean.getTimerTimeRemaining(new TimerData(TimerType.RoundTimer));
        Long score = competitionDataService.getRoundMetaData().getAssignmentDifficulty() * remainingTime;
        
        Long competitionId = competitionDataService.getCurrentCompetition().getId();
        Long roundId = competitionDataService.getCurrentRound().getId();
        
        mocjms.messages.request.TurninRequestMessage mess = new mocjms.messages.request.TurninRequestMessage(teamId, roundId, competitionId, score);
        this.sendMessageToWorkspaceManegementBean(mess);
    }
    
    public void sendTeamScore(Long teamId, Long score) {
        String teamName = userService.getTeam(teamId).getTeamName();
        
        this.sendMessageToEveryone(new OtherTeamScoreReplyMessage(teamName, score));
    }
    
    public void addScoreToTeam(Long teamId, Long score) {
        userService.addToTeamScore(teamId, score);
    }

    @PostConstruct
    private void init() {
        this.setCurrentCompetition(1L);
        this.setCurrentRound(1L);
    }
}
