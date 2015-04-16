/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mocjms.messaging;

import java.io.Serializable;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Gebruiker
 */
public class MessagingGateway {
    private MessageProducer producer;
    private MessageConsumer consumer;
    private Session ses;
    private Connection connection;
    
    private Destination consumerDestination;
    
    public MessagingGateway(String requestQueue, String replyQueue)
    {
        try {
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
            
            props.put( ( "queue." + requestQueue ) ,requestQueue);
            props.put( ( "queue." + replyQueue ) ,replyQueue);
            Context jndiContext = new InitialContext(props);
            
            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
            connection = connectionFactory.createConnection();
            ses = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // connect to the sender channel
            producer = ses.createProducer((Destination) jndiContext.lookup(requestQueue));
            // connect to the receiver channel
            consumerDestination = (Destination) jndiContext.lookup(replyQueue);
            consumer = ses.createConsumer(consumerDestination);
        } catch (NamingException ex) {
            Logger.getLogger(MessagingGateway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JMSException ex) {
            Logger.getLogger(MessagingGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Destination getConsumerDestination() {
        return consumerDestination;
    }
    
    public MessagingGateway(String requestQueue)
    {
        try {
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
            props.put( ( "queue." + requestQueue ) ,requestQueue);
            Context jndiContext = new InitialContext(props);
            
            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
            connection = connectionFactory.createConnection();
            ses = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // connect to the receiver channel
            consumer = ses.createConsumer((Destination) jndiContext.lookup(requestQueue));
        } catch (NamingException ex) {
            Logger.getLogger(MessagingGateway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JMSException ex) {
            Logger.getLogger(MessagingGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Message createMsg(Serializable object)
    {
        ObjectMessage message = null;
        try {
            message = ses.createObjectMessage();
            message.setObject(object);
        } catch (JMSException ex) {
            Logger.getLogger(MessagingGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
    public boolean send(Message msg)
    {
        try {
            producer.send(msg);
            return true;
        } catch (JMSException ex) {
            Logger.getLogger(MessagingGateway.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean send(Message msg, Destination dest)
    {
        try {
            ses.createProducer(dest).send(msg);
            return true;
        } catch (JMSException ex) {
            Logger.getLogger(MessagingGateway.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void setListener(MessageListener l)
    {
        try {
            consumer.setMessageListener(l);
        } catch (JMSException ex) {
            Logger.getLogger(MessagingGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void openConnection()
    {
        try {
            connection.start();
        } catch (JMSException ex) {
            Logger.getLogger(MessagingGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
