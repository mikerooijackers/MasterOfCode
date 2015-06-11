/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JMS;

import Sockets.Messages.BaseMessage;
import java.io.Serializable;
import java.util.Map;
import javax.ejb.Singleton;
import mocjms.messages.main.OperationDrivenMessage;

/**
 *
 * @author mikerooijackers
 */
@Singleton
public class JMSManager {
    private Map<String, Serializable> requestSend;
    
    /**
     * add request send
     * @param messageID
     * @param message
     */
    public void AddRequestSend(String messageID, Serializable message) {
        requestSend.put(messageID, message);
    }
    
    /**
     * get request send
     * @param messageID
     * @return
     */
    public Serializable GetRequestSend(String messageID) {
        return requestSend.get(messageID);
    }
    
}
