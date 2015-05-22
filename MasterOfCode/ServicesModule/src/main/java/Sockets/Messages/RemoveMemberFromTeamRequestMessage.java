/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages;

import Domein.MOCUser;
import Enumerations.MessageTypes;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class RemoveMemberFromTeamRequestMessage extends BaseMessage {
    
    /**
     *
     */
    public static final String messageType = MessageTypes.RemoveMemberFromTeamRequestMessage.toString();
    
    private MOCUser userToRemove;
    
    /**
     * Constructor
     */
    public RemoveMemberFromTeamRequestMessage(){}
    
    /**
     *
     * @param user
     */
    public RemoveMemberFromTeamRequestMessage(MOCUser user) {
        this.userToRemove = user;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static RemoveMemberFromTeamRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        MOCUser jsonUser = (MOCUser) obj.get("userToRemove");
        return new RemoveMemberFromTeamRequestMessage(jsonUser);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the userToRemove
     */
    public MOCUser getUserToRemove() {
        return userToRemove;
    }

    /**
     * @param userToRemove the userToRemove to set
     */
    public void setUserToRemove(MOCUser userToRemove) {
        this.userToRemove = userToRemove;
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("UserToRemove", this.userToRemove);
        return obj.toString();
    }
    
}
