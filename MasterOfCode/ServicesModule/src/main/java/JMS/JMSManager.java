/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JMS;

import Sockets.Messages.BaseMessage;
import java.util.Map;
import mocjms.messages.main.OperationDrivenMessage;

/**
 *
 * @author mikerooijackers
 */
public class JMSManager {
    private Map<String, BaseMessage> requestSend;
    
    public void AddRequestSend(long messageID, OperationDrivenMessage message) {
        
    }
    
    public OperationDrivenMessage GetRequestSend(String messageID) {
        return null;
        
    }
    
}
