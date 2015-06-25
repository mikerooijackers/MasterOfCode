/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Reply;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class SubmitReplyMessage extends BaseMessage {
    
    public static final String MessageType = MessageTypes.SubmitReplyMessage.toString();
    
    private Long score;
    private boolean succeeded;
    
    public SubmitReplyMessage(){}
    
    public SubmitReplyMessage(Long score, boolean succeeded) {
        this.score = score;
        this.succeeded = succeeded;
    }
    
    public static SubmitReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonScore = (Long) obj.get("Score");
        boolean jsonSucceeded = (boolean) obj.get("Succeeded");
        return new SubmitReplyMessage(jsonScore, jsonSucceeded);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.MessageType);
        obj.put("Score", this.score);
        obj.put("Succeeded", this.succeeded);
        return obj.toJSONString();
    }
    
}
