/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Request;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class SubmitRequestMessage extends BaseMessage {

    /**
     *
     */
    public static final String messageType = MessageTypes.SubmitRequestMessage.toString();
    
    private Long teamId;
    
    /**
     * Constructor
     */
    public SubmitRequestMessage() {
    }
    
    /**
     *
     * @param teamId
     */
    public SubmitRequestMessage(Long teamId) {
        this.teamId = teamId;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static SubmitRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonTeamId = (Long) obj.get("TeamId");
        return new SubmitRequestMessage(jsonTeamId);
    }
    
    @Override
    public void doAction(CommunicationBean communicationBean) {
        /*
        TODO: PERFORM ACTIONS WHEN SOMEONE HANDS IN THEIR ASSIGNMENT
        */
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("TeamId", this.teamId);
        return obj.toString();
    }
    
}
