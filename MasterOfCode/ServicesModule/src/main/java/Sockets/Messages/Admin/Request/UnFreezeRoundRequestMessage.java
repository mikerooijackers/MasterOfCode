/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Admin.Request;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class UnFreezeRoundRequestMessage extends BaseMessage {
    
    public static final String messageType = MessageTypes.UnFreezeRoundRequestMessage.toString();
    
    private Long competitionId;
    private Long roundId;
    
    public UnFreezeRoundRequestMessage(){}
    
    public UnFreezeRoundRequestMessage(Long competitionId, Long roundId) {
        this.competitionId = competitionId;
        this.roundId = roundId;
    }
    
    public static UnFreezeRoundRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonCompetitionId = (Long) obj.get("CompetitionId");
        Long jsonRoundId = (Long) obj.get("RoundId");
        return new UnFreezeRoundRequestMessage(jsonCompetitionId, jsonRoundId);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        System.out.println("In the doAction of the UnfreezeRoundRequestMessage");
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("CompetitionId", this.competitionId);
        obj.put("RoundId", this.roundId);
        return obj.toJSONString();
    }
    
}
