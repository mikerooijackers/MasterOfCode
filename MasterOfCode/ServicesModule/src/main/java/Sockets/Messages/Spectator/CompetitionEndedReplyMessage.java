/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Spectator;

import Enumerations.MessageTypes;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;

/**
 *
 * @author mikerooijackers
 */
public class CompetitionEndedReplyMessage extends BaseMessage {

    public static final String messageType = MessageTypes.CompetitionEndedReplyMessage.toString();
    
    public void CompetitionEndedReplyMessage(){}
    
    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        return obj.toString();
    }
    
}
