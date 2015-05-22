/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Request;

import Enumerations.MessageTypes;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class GroupTestsRequestMessage extends BaseMessage {
    
    public static final String messageType = MessageTypes.GroupTestsRequestMessage.toString();
    
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
        Long jsonTeamId = (Long) obj.get("TeamId");
        String jsonTestGroup = obj.get("TestGroup").toString();
        return new GroupTestsRequestMessage(jsonTeamId, jsonTestGroup);
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
