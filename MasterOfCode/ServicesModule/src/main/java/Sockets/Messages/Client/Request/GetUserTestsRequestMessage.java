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
    public void GetUserTestsRequestMessage() {
    }

    /**
     * Constructor
     * @param teamId
     * @param testNames
     */
    public void GetUserTestsRequestMessage(long teamId, List<String> testNames) {
        this.teamId = teamId;
        this.testNames = testNames;
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
