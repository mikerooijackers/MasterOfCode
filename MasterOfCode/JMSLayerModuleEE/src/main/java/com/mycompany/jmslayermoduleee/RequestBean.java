/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jmslayermoduleee;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import mocjms.messages.main.OperationDrivenMessage;

/**
 *
 * @author Gebruiker
 */
@MessageDriven(mappedName = "jms/MasterOfCode/RequestQueueServer1")
public class RequestBean implements MessageListener {

    @Inject
    private ReplyBean replyBean;

    @Resource(mappedName = "jms/MasterOfCodeConnectionFactory")
    private ConnectionFactory factory;

    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            try {
                System.out.println("[[INFO]] JMS message received!");
                ObjectMessage objectMessage = (ObjectMessage) message;
//                long teamId = -1L; 
//                
//                try {
//                    teamId = objectMessage.getLongProperty("teamId");
//                } catch (JMSException ex) {
//                    System.out.println("throwing teamId exception");
//                    Logger.getLogger(RequestBean.class.getName()).log(Level.SEVERE, null, ex);
//                }

                Serializable object = objectMessage.getObject();

                Serializable reply = null;

                if (object instanceof OperationDrivenMessage) {
                    OperationDrivenMessage odm = (OperationDrivenMessage) object;
                    reply = odm.generateReplyMessage();
                }

                if (reply != null) {
                    replyBean.send(reply, objectMessage.getJMSMessageID()/*, teamId*/);
                    System.out.println("message sent");
                }
            } catch (JMSException ex) {
                Logger.getLogger(RequestBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
