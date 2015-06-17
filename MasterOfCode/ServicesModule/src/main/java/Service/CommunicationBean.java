/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Competition.CompetitionDataService;
import Domein.AnnotationData;
import Domein.Competition;
import Domein.Round;
import Domein.Status;
import JMS.WorkspaceServiceRequestBean;
import Sockets.Messages.BaseMessage;
import Timer.TimerData;
import Timer.TimerSessionBean;
import WebSocket.AdminEndPoint;
import WebSocket.CompetitorEndPoint;
import WebSocket.SpectatorEndpoint;
import com.mycompany.workspacemanagementmoduleb.WorkspaceService;
import java.io.Serializable;
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
    
    /**
     * send Message To Competitor
     * @param username
     * @param message
     */
    public void sendMessageToCompetitor(String username, BaseMessage message) {
        competitorEndpoint.sendMessage(username, message);
    }
    
    /**
     * send Message To All Competitors
     * @param message
     */
    public void sendMessageToAllCompetitors(BaseMessage message) {
        competitorEndpoint.sendToAll(message);
    }
    
    public void sendMessageToWorkspaceManegementBean(Serializable message) {
        workspaceServiceRequestBean.Send(message);
    }
    public void sendMessageToAdmin(String username, BaseMessage message) {
        adminEndpoint.sendMessage(username, message);
    }
    
    public void sendMessageToAllAdmins(BaseMessage message) {
        adminEndpoint.sendToAll(message);
    }
    
    public void startTimer(TimerData timerData, long duration) {
        timerSessionBean.CreateTimer(duration, timerData);
    }
    
    public void stopTimer(TimerData timerData) {
        timerSessionBean.stopTimer(timerData);
    }
    
    public void pauseOrFreezeTimer(TimerData timerData) {
        timerSessionBean.pauseOrFreezeTimer(timerData);
    }
    
    public void resumeTimer() {
        timerSessionBean.resumeTimer();
    }
    
    public void modifyTimerDuration(long newDuration, TimerData timerData) {
        timerSessionBean.modifyTimerDuration(newDuration, timerData);
    }
    
    public void sendMessageToEveryone(BaseMessage message) {
        competitorEndpoint.sendToAll(message);
        adminEndpoint.sendToAll(message);
        spectatorEndpoint.sendMessage(message);
    }
    
    public void setCurrentCompetition(Long competitionId) {
        Competition competition = competitionService.FindCompetition(competitionId);
        competitionDataService.setCurrentCompetition(competition);
    }
    
    public void startNextRoundOfCompetition() {
        long competitionId = competitionDataService.getCurrentCompetition().getId();
        Round nextRound = competitionService.getNextRound(competitionId);
        competitionDataService.setCurrentRound(nextRound);
        competitionService.editRound(Status.PLAYING, nextRound.getId());
        workspaceServiceRequestBean.Send(new ExtractAssignmentToWorkspacesRequestMessage(nextRound.getAssignment().getId(), nextRound.getId(), competitionId));
    }
    
    public void sendRoundMetaData() {
        long assignmentId = competitionDataService.getCurrentRound().getAssignment().getId();
        List<AnnotationData> annotationData = WorkspaceService.getInstance().readAssignmentMetaData(assignmentId);
        
    }
    
    @PostConstruct
    public void init() {
        this.setCurrentCompetition(1L);
        
        Round nextRound = competitionService.getNextRound(1L);
        competitionDataService.setCurrentRound(nextRound);
    }
}
