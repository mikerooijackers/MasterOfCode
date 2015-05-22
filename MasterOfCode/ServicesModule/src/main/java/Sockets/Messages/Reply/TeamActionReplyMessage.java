/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Reply;

import Enumerations.MessageTypes;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class TeamActionReplyMessage extends BaseMessage {
    
    /**
     *
     */
    public static final String messageType = MessageTypes.TeamActionReplyMessage.toString();
    
    private String action;
    
    /**
     * Constructor
     */
    public TeamActionReplyMessage(){
        
    }
    
    /**
     * Constructor
     * @param action
     */
    public TeamActionReplyMessage(String action) {
        this.action = action;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static TeamActionReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String jsonAction = obj.get("action").toString();
        return new TeamActionReplyMessage(jsonAction);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("Action", this.action);
        return obj.toString();
    }
}
