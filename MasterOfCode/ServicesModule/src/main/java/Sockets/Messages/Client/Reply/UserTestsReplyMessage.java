/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Reply;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class UserTestsReplyMessage extends BaseMessage {
    
    /**
     * 
     */
    public static final String messageType = MessageTypes.UserTestsReplyMessage.toString();
    
    private String result;
    
    /**
     * Constructor
     */
    public UserTestsReplyMessage() {}
    
    /**
     *
     * @param results
     */
    public UserTestsReplyMessage(String result) {
        this.result = result;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static UserTestsReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String jsonResult = obj.get("results").toString();
        return new UserTestsReplyMessage(jsonResult);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("Result", this.result);
        return obj.toString();
    }
} 
