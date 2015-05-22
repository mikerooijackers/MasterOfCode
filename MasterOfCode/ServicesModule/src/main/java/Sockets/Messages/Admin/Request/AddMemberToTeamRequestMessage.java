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
public class AddMemberToTeamRequestMessage extends BaseMessage {
    
    public static final String messageType = MessageTypes.AddMemberToTeamRequestMessage.toString();
    
    private Long teamId;
    private Long userId;
    
    public AddMemberToTeamRequestMessage() {}
    
    public AddMemberToTeamRequestMessage(Long teamId, Long userId) {
        this.teamId = teamId;
        this.userId = userId;
    }
    
    public static AddMemberToTeamRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonTeamId = (Long) obj.get("TeamId");
        Long jsonUserId = (Long) obj.get("UserId");
        return new AddMemberToTeamRequestMessage(jsonTeamId, jsonUserId);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("TeamId", this.teamId);
        obj.put("UserId", this.userId);
        return obj.toJSONString();
    }
    
}