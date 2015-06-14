/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import JMS.WorkspaceServiceRequestBean;
import Sockets.Messages.BaseMessage;
import WebSocket.AdminEndPoint;
import WebSocket.CompetitorEndPoint;
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
    
    public void sendMessageToAdmin(String username, BaseMessage message) {
        adminEndpoint.sendMessage(username, message);
    }
    
    public void sendMessageToAllAdmins(BaseMessage message) {
        adminEndpoint.sendToAll(message);
    }
}
