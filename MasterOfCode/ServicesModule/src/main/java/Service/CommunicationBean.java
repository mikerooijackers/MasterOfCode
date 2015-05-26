/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import JMS.WorkspaceServiceRequestBean;
import WebSocket.AdminEndPoint;
import WebSocket.CompetitorEndPoint;
import javax.inject.Inject;

/**
 *
 * @author JordiK
 */
public class CommunicationBean {
    
    @Inject
    private AdminEndPoint adminEndpoint;
    
    @Inject
    private CompetitorEndPoint competitorEndpoint;
    
    @Inject
    private WorkspaceServiceRequestBean workspaceServiceRequestBean;
    
}
