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
public class StartCompetitionRequestMessage extends BaseMessage {
    
    public static final String messageType = MessageTypes.StartCompetitionReplyMessage.toString();
    
    private Long competitionId;
    
    public StartCompetitionRequestMessage(){};
    
    public StartCompetitionRequestMessage(Long competitionId) {
        this.competitionId = competitionId;
    }
    
    public static StartCompetitionRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonCompetitionId = (Long) obj.get("CompetitionId");
        return new StartCompetitionRequestMessage(jsonCompetitionId);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("CompetitionId", this.competitionId);
        return obj.toJSONString();
    }
    
}
