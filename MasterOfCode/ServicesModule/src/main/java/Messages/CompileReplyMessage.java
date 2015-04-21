/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class CompileReplyMessage extends BaseMessage {
    
    public static final String MessageType = "compileReplyMessage";
    
    private String result;
    private Long teamId;
    
    public CompileReplyMessage(){}
    
    public CompileReplyMessage(String result, Long teamId) {
        this.result = result;
        this.teamId = teamId;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
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
    
    public static CompileReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String jsonResult = obj.get("result").toString();
        Long jsonTeamId = (Long)obj.get("teamId");
        return new CompileReplyMessage(jsonResult, jsonTeamId);
    }
}
