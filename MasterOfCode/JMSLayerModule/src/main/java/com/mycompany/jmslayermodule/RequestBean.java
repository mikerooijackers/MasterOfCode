/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jmslayermodule;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
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
    
    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            try {
                System.out.println("[[INFO]] JMS message received!");
                ObjectMessage objectMessage = (ObjectMessage) message;
                Serializable object = objectMessage.getObject();
                
                if (object instanceof OperationDrivenMessage) {
                    OperationDrivenMessage odm = (OperationDrivenMessage) object;
                    //odm.doWork(replyBean);
                }
            } catch (JMSException ex) {
                Logger.getLogger(RequestBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
