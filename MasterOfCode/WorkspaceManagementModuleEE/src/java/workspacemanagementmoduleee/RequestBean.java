/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workspacemanagementmoduleee;

import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Gebruiker
 */
@MessageDriven(mappedName = "jms/MasterOfCode/RequestQueueServer1")
public class RequestBean implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            System.out.println("[[INFO]] JMSNewTweet message received!");
            ObjectMessage objectMessage = (ObjectMessage) message;
            
        }
    }
    
}
