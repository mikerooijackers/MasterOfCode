/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Request;

import Domein.Team;
import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import Sockets.Messages.Reply.GetAllTeamsReplyMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;

/**
 *
 * @author Jay
 */
public class GetTeamsRequestMessage extends BaseMessage {

    /**
     *
     */
    public static final String messageType = MessageTypes.GetParticipantsRequestMessage.toString();

    public static GetTeamsRequestMessage decodeJSON(String s) {
        return new GetTeamsRequestMessage();
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        List<Team> teamList = new ArrayList();
        
        Team team1 = new Team("workspacePath1", "Team 1", "Server 1", true);
        Team team2 = new Team("workspacePath2", "Team 2", "Server 1", false);
        team1.setId(9000);
        team2.setId(9001);

        teamList.add(team1);
        teamList.add(team2);
        
        GetAllTeamsReplyMessage message = new GetAllTeamsReplyMessage(teamList);
        communicationBean.sendMessageToAdmin("Jordi", message);
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        return obj.toJSONString();
    }

}
