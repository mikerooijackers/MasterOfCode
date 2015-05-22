/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages;

import Enumerations.MessageTypes;
import org.json.simple.JSONObject;

/**
 *
 * @author JordiK
 */
public class DebugMessage extends BaseMessage {
    
    public static final String messageType = MessageTypes.DebugMessage.toString();
    
    public DebugMessage(){};
    
    public static DebugMessage decodeJSON(String s) {
        return new DebugMessage();
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        return obj.toJSONString();
    }
    
}
