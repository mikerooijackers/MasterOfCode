/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Admin.Request;

import Enumerations.MessageTypes;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class PublishHintRequestMessage extends BaseMessage {
    
    public static final String messageType = MessageTypes.PublishHintRequestMessage.toString();
    
    private Long hintId;
    
    public PublishHintRequestMessage(){}
    
    public PublishHintRequestMessage(Long hintId){
        this.hintId = hintId;
    }
    
    public static PublishHintRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonHintId = (Long) obj.get("HintId");
        return new PublishHintRequestMessage(jsonHintId);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("HintId", this.hintId);
        return obj.toJSONString();
    }
    
}