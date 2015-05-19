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
public class RunTestsByGroupRequestMessage extends BaseMessage {
    
    public static final String messageType = MessageTypes.RunTestsByGroupRequestMessage.toString();
    
    private Long teamId;
    private String testGroup;
    
    public RunTestsByGroupRequestMessage(){}
    
    public RunTestsByGroupRequestMessage(Long teamId, String testGroup) {
        this.teamId = teamId;
        this.testGroup = testGroup;
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
     * @return the testGroup
     */
    public String getTestGroup() {
        return testGroup;
    }

    /**
     * @param testGroup the testGroup to set
     */
    public void setTestGroup(String testGroup) {
        this.testGroup = testGroup;
    }
    
    public static RunTestsByGroupRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonTeamId = (Long) obj.get("teamId");
        String jsonTestGroup = obj.get("testGroup").toString();
        return new RunTestsByGroupRequestMessage(jsonTeamId, jsonTestGroup);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("TeamId", this.teamId);
        obj.put("TestGroup", this.testGroup);
        return obj.toString();
    }
}
