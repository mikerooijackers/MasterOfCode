/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jmslayermoduleee;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

/**
 *
 * @author Gebruiker
 */
@Stateless
public class ReplyBean {
    @Resource(mappedName = "jms/MasterOfCode/ReplyQueue")
    private Queue queue;
    
    @Resource(mappedName = "jms/MasterOfCodeConnectionFactory")
    private ConnectionFactory factory;
    
    private Connection connection;
    
    private Session session;
    
    private MessageProducer producer;
    
    @PostConstruct
    public void openSession() {
        try {
            connection = factory.createConnection();
            session = connection.createSession();
            producer = session.createProducer(queue);
        } catch (JMSException ex) {
            Logger.getLogger(ReplyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PreDestroy
    public void closeSession() {
        try {
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException ex) {
            Logger.getLogger(ReplyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void send(Serializable message, String requestMessageID/*, Long teamId*/) {
        try (JMSContext context = factory.createContext()) {
            ObjectMessage om = session.createObjectMessage(message);
            om.setJMSCorrelationID(requestMessageID);
            
//            if (teamId != -1L) {
//                om.setLongProperty("teamId", teamId);
//            }
            
            context.createProducer().send(queue, om);
            
            System.out.println("message really sent");
        } catch (JMSException ex) {
            Logger.getLogger(ReplyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
