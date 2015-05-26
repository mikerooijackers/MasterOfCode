/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JMS;

import javax.ejb.Stateless;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import mocjms.messages.main.OperationDrivenMessage;

/**
 *
 * @author mikerooijackers
 */
@Stateless
public class WorkspaceServiceRequestBean {
    private Queue quequeServer1;
    private Queue quequeServer2;
    private Queue nextCompileRequestQueue;
    private Queue nextTestRequestQueue;
    private Queue nextGroupRequestQueue;
    private QueueConnectionFactory factory;
    
    /**
     * send message
     * @param message
     */
    public void Send(OperationDrivenMessage message) {
        
    }
    
    /**
     * send message with teamID
     * @param message
     * @param teamID
     */
    public void Send(OperationDrivenMessage message, long teamID) {
        
    }
}
