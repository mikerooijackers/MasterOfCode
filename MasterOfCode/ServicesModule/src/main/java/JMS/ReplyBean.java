/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JMS;

import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;


/**
 *
 * @author mikerooijackers
 */
@MessageDriven(mappedName = "jms/MasterOfCode/ReplyQueue")
public class ReplyBean implements MessageListener {
    
    @Override
    public void onMessage(Message message) {
        System.out.println("reply received");
    }
}
