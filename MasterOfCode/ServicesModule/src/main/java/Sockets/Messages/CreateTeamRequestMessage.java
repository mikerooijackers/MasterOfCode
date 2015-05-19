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
public class CreateTeamRequestMessage extends BaseMessage {
    
    public static final String messageType = MessageTypes.CreateTeamRequestMessage.toString();
    
    private String teamName;
    private MOCUser initiator;
    
    public CreateTeamRequestMessage(){}
    
    public CreateTeamRequestMessage(String teamName, MOCUser initiator) {
        this.teamName = teamName;
        this.initiator = initiator;
    }
    
    public static CreateTeamRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String jsonTeamName = obj.get("teamName").toString();
        MOCUser jsonInitiator = (MOCUser) (obj.get("initiator"));
        return new CreateTeamRequestMessage(jsonTeamName, jsonInitiator);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * @return the initiator
     */
    public MOCUser getInitiator() {
        return initiator;
    }

    /**
     * @param initiator the initiator to set
     */
    public void setInitiator(MOCUser initiator) {
        this.initiator = initiator;
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("TeamName", this.teamName);
        obj.put("Initiator", this.initiator);
        return obj.toString();
    }
    
}
