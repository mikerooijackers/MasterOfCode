/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Reply;

import Enumerations.MessageTypes;
import Sockets.Messages.BaseMessage;
import Sockets.Messages.Spectator.CompetitionEndedReplyMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class UnFreezeRoundReplyMessage extends BaseMessage {

    public static final String messageType = MessageTypes.UnFreezeRoundReplyMessage.toString();
    
    public UnFreezeRoundReplyMessage() {}
    
    public static UnFreezeRoundReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        return new UnFreezeRoundReplyMessage();
    }
    
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
