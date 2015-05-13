/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Request;

import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class GroupTestsRequestMessage extends BaseMessage {
    
    public static final String MessageType = "runTestsByGroupRequestMessage";
    
    private Long teamId;
    private String testGroup;
    
    public GroupTestsRequestMessage(){}
    
    public GroupTestsRequestMessage(Long teamId, String testGroup) {
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
    
    public static GroupTestsRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonTeamId = (Long) obj.get("teamId");
        String jsonTestGroup = obj.get("testGroup").toString();
        return new GroupTestsRequestMessage(jsonTeamId, jsonTestGroup);
    }
}