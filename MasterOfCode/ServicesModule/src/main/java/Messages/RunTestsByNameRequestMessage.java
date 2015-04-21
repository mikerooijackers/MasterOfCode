/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class RunTestsByNameRequestMessage extends BaseMessage {
    
    public static final String MessageType = "runTestsByNameRequestMessage";
    
    private Long teamId;
    private List<String> testNames;
    
    public RunTestsByNameRequestMessage(){}
    
    public RunTestsByNameRequestMessage(Long teamId, List<String> testNames) {
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
    
    public static RunTestsByNameRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonTeamId = (Long) obj.get("teamId");
        List<String> jsonTestNames = (List<String>) obj.get("testNames");
        return new RunTestsByNameRequestMessage(jsonTeamId, jsonTestNames);
    }
}
