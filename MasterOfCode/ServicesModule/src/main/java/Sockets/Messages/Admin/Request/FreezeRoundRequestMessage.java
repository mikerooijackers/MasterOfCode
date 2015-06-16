/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Admin.Request;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import Sockets.Messages.Reply.FreezeRoundReplyMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class FreezeRoundRequestMessage extends BaseMessage {
    
    public static final String messageType = MessageTypes.FreezeRoundRequestMessage.toString();
    
    private Long competitionId;
    private Long roundId;
    
    public FreezeRoundRequestMessage(){}
    
    public FreezeRoundRequestMessage(Long competitionId, Long roundId) {
        this.competitionId = competitionId;
        this.roundId = roundId;
    }
    
    public static FreezeRoundRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        return new FreezeRoundRequestMessage((Long) obj.get("CompetitionId"), (Long) obj.get("RoundId"));
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        FreezeRoundReplyMessage mes = new FreezeRoundReplyMessage();
        
        System.out.println("In the doAction of the FreezeRoundRequestMessage");
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
