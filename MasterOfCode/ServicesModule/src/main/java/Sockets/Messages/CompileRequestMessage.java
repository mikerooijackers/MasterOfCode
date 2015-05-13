/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class CompileRequestMessage extends BaseMessage {
    
    public static final String MessageType = "compileMessage";
    
    private Long teamId;
    
    public CompileRequestMessage(){}
    
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
    
    public static CompileRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonTeamId = (Long) obj.get("teamId");
        return new CompileRequestMessage(jsonTeamId);
    }
}
