/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JMS;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

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
    //private QueueConnectionFactory factory;
    
    @Resource(mappedName = "jms/MasterOfCode/RequestQueueServer1")
    private Queue queue;
    
    @Resource(mappedName = "jms/MasterOfCodeConnectionFactory")
    private ConnectionFactory factory;
    
    @Inject
    private JMSManager manager;
    
    /**
     * send message
     * @param message
     */
    public void Send(Serializable message) {
        try (JMSContext context = factory.createContext()) {
            ObjectMessage msg = context.createObjectMessage(message);
            //manager.AddRequestSend(msg.getJMSMessageID(), message);
            context.createProducer().send(queue, msg);
        } //catch (JMSException ex) {
            //Logger.getLogger(WorkspaceServiceRequestBean.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }
    
    /**
     * send message with teamID
     * @param message
     * @param teamID
     */
    public void Send(Serializable message, long teamID) {
        try (JMSContext context = factory.createContext()) {
            ObjectMessage msg = context.createObjectMessage(message);
            //manager.AddRequestSend(msg.getJMSMessageID(), message);
            msg.setLongProperty("teamId", teamID);
            context.createProducer().send(queue, msg);
        } catch (JMSException ex) {
            Logger.getLogger(WorkspaceServiceRequestBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
