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
public class RegisterTeamRequestMessage extends BaseMessage {
    
    public static final String messageType = MessageTypes.RegisterTeamRequestMessage.toString();
    
    private Long teamId;
    private Long competitionId;
    
    public RegisterTeamRequestMessage(){}
    
    public RegisterTeamRequestMessage(Long teamId, Long competitionId) {
        this.teamId = teamId;
        this.competitionId = competitionId;
    }
    
    public static RegisterTeamRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonTeamId = (Long) obj.get("TeamId");
        Long jsonCompetitionId = (Long) obj.get("CompetitionId");
        return new RegisterTeamRequestMessage(jsonTeamId, jsonCompetitionId);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("TeamId", this.teamId);
        obj.put("CompetitionId", this.competitionId);
        return obj.toJSONString();
    }
    
}
