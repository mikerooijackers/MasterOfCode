/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Request;

import Competition.CompetitionDataService;
import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import Sockets.Messages.Client.Reply.GetSourceFilesReplyMessage;
import java.util.HashMap;
import mocjms.messages.request.GetSourceCodeFilesRequestMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class GetSourceFilesRequestMessage extends BaseMessage {

    /**
     *
     */
    public static final String messageType = MessageTypes.GetSourceFilesRequestMessage.toString();
    
    private Long teamId;
    
    /**
     * Constructor
     */
    public GetSourceFilesRequestMessage() {}
    
    public GetSourceFilesRequestMessage(Long teamId) {
        this.teamId = teamId;
    }
    
    public static GetSourceFilesRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonTeamId = (Long) obj.get("TeamId");
        return new GetSourceFilesRequestMessage(jsonTeamId);
    }
    
    @Override
    public void doAction(CommunicationBean communicationBean) {
        CompetitionDataService competitionDataService = communicationBean.getCompetitionDataService();
        Long competitionId = competitionDataService.getCurrentCompetition().getId();
        Long roundId = competitionDataService.getCurrentRound().getId();
        Long assignmentId = competitionDataService.getCurrentRound().getAssignment().getId();
        communicationBean.sendMessageToWorkspaceManegementBean(new GetSourceCodeFilesRequestMessage(assignmentId, teamId, roundId, competitionId));
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("TeamId", this.teamId);
        return obj.toString();
    }
    
}
