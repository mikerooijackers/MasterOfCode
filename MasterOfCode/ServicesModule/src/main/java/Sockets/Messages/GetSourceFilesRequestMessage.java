/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages;

import Enumerations.MessageTypes;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class GetSourceFilesRequestMessage extends BaseMessage {
    
    public static final MessageTypes messageType = MessageTypes.GetSourceFilesRequestMessage;
    
    private Long teamId;
    private Long roundId;
    
    public GetSourceFilesRequestMessage(){}
    
    public GetSourceFilesRequestMessage(Long teamId, Long roundId) {
        this.teamId = teamId;
        this.roundId = roundId;
    }
    
    public static GetSourceFilesRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonTeamId = (Long) obj.get("teamId");
        Long jsonRoundId = (Long) obj.get("roundId");
        return new GetSourceFilesRequestMessage(jsonTeamId, jsonRoundId);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
     * @return the roundId
     */
    public Long getRoundId() {
        return roundId;
    }

    /**
     * @param roundId the roundId to set
     */
    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    @Override
    public String toJSONString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
