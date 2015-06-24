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
public class StartCompetitionRequestMessage extends BaseMessage {
    
    /**
     *
     */
    public static final String messageType = MessageTypes.StartCompetitionReplyMessage.toString();
    
    private Long competitionId;
    
    /**
     *
     */
    public StartCompetitionRequestMessage(){
        
    }
    
    /**
     *
     * @param competitionId
     */
    public StartCompetitionRequestMessage(Long competitionId) {
        this.competitionId = competitionId;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static StartCompetitionRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonCompetitionId = (Long) obj.get("CompetitionId");
        return new StartCompetitionRequestMessage(jsonCompetitionId);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        System.out.println("In the doAction of the StartCompetitionRequestMessage");
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("CompetitionId", this.competitionId);
        return obj.toJSONString();
    }
    
}
