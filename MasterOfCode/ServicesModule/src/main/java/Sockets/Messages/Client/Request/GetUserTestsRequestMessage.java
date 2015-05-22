/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Request;

import Enumerations.MessageTypes;
import Sockets.Messages.BaseMessage;
import Sockets.Messages.Reply.TeamActionReplyMessage;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class GetUserTestsRequestMessage extends BaseMessage {

    /**
     *
     */
    public static final String messageType = MessageTypes.GetUserTestsRequestMessage.toString();

    private long teamId;
    private List<String> testNames;

    /**
     * Constructor
     */
     public GetUserTestsRequestMessage() {
    }

    /**
     * Constructor
     * @param teamId
     * @param testNames
     */
    public GetUserTestsRequestMessage(long teamId, List<String> testNames) {
        this.teamId = teamId;
        this.testNames = testNames;
    }

    public static GetUserTestsRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        long jsonTeamId = (long)obj.get("TeamId");
        List<String> jsonTestNames = (List<String>)obj.get("TestNames");
        return new GetUserTestsRequestMessage(jsonTeamId, jsonTestNames);
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
