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
 * @author JordiK
 */
public class CompileRequestMessage extends BaseMessage {

    /**
     *
     */
    public static final String messageType = MessageTypes.CompileRequestMessage.toString();

    private Long teamId;

    /**
     * Constructor
     */
    public CompileRequestMessage() {
    }

    /**
     * Constructor
     *
     * @param teamId
     */
    public CompileRequestMessage(Long teamId) {
        this.teamId = teamId;
    }

    /**
     * @return the teamId
     */
    public Long getTeamId() {
        return teamId;
    }

    /**
     * @param teamId the teamId to set
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /**
     *
     * @param s
     * @return
     */
    public static CompileRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonTeamId = (Long) obj.get("TeamId");
        return new CompileRequestMessage(jsonTeamId);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        mocjms.messages.request.CompileRequestMessage mess = new mocjms.messages.request.CompileRequestMessage(this.teamId, 2L, 2L);
        communicationBean.sendMessageToWorkspaceManegementBean(mess);
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("TeamId", this.teamId);
        return obj.toString();
    }
}
