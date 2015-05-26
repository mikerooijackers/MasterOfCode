/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Reply;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
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
        String jsonAction = obj.get("Action").toString();
        return new TeamActionReplyMessage(jsonAction);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
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
