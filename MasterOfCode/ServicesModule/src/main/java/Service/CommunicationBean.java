/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import JMS.WorkspaceServiceRequestBean;
import Sockets.Messages.BaseMessage;
import Timer.TimerData;
import Timer.TimerSessionBean;
import WebSocket.AdminEndPoint;
import WebSocket.CompetitorEndPoint;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;

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
    private WorkspaceServiceRequestBean workspaceServiceRequestBean;
    
    @EJB
    private TimerSessionBean timerSessionBean;
    
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
}
