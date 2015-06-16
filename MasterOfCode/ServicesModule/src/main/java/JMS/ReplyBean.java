/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JMS;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;


/**
 *
 * @author mikerooijackers
 */
@MessageDriven(mappedName = "jms/MasterOfCode/ReplyQueue")
public class ReplyBean implements MessageListener {
    
    @Inject
    private JMSManager manager;
    
    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            try {
                System.out.println("[[INFO]] JMS message received!");
                ObjectMessage objectMessage = (ObjectMessage) message;
                long teamId = -1L; 
                
                try {
                    teamId = objectMessage.getLongProperty("teamId");
                } catch (JMSException ex) {
                    Logger.getLogger(ReplyBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Serializable object = objectMessage.getObject();
                
                
            } catch (JMSException ex) {
                Logger.getLogger(ReplyBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("reply received");
    }
}
