/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Admin.Request;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import Sockets.Messages.Reply.StopCompetitionReplyMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class StopCompetitionRequestMessage extends BaseMessage {
    
    /**
     *
     */
    public static final String messageType = MessageTypes.StopCompetitionRequestMessage.toString();
    
    private Long competitionId;
    
    /**
     *
     */
    public StopCompetitionRequestMessage(){
    }
    
    /**
     *
     * @param competitionId
     */
    public StopCompetitionRequestMessage(Long competitionId) {
        this.competitionId = competitionId;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static StopCompetitionRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonCompetitionId = (Long) obj.get("CompetitionId");
        return new StopCompetitionRequestMessage(jsonCompetitionId);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        StopCompetitionReplyMessage mes = new StopCompetitionReplyMessage();
        communicationBean.sendMessageToEveryone(mes);
        
        System.out.println("In the doAction of the StopCompetitionRequestMessage");
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("CompetitionId", this.competitionId);
        return obj.toJSONString();
    }

    /**
     * @return the competitionId
     */
    public Long getCompetitionId() {
        return competitionId;
    }

    /**
     * @param competitionId the competitionId to set
     */
    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }
    
}
