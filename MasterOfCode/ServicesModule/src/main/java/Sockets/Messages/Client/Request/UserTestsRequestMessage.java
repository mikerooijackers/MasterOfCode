/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Request;

import Enumerations.MessageTypes;
import Sockets.Messages.BaseMessage;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class UserTestsRequestMessage extends BaseMessage {
    
    /**
     *
     */
    public static final String messageType = MessageTypes.UserTestsRequestMessage.toString();
    
    private Long teamId;
    private List<String> testNames;
    
    /**
     * Constructor
     */
    public UserTestsRequestMessage(){}
    
    /**
     * Constructor
     * @param teamId
     * @param testNames
     */
    public UserTestsRequestMessage(Long teamId, List<String> testNames) {
        this.teamId = teamId;
        this.testNames = testNames;
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
     * @return the testNames
     */
    public List<String> getTestNames() {
        return testNames;
    }

    /**
     * @param testNames the testNames to set
     */
    public void setTestNames(List<String> testNames) {
        this.testNames = testNames;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static UserTestsRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonTeamId = (Long) obj.get("TeamId");
        List<String> jsonTestNames = (List<String>) obj.get("TestNames");
        return new UserTestsRequestMessage(jsonTeamId, jsonTestNames);
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
        obj.put("TestNames", this.testNames);
        return obj.toString();
    }
}
