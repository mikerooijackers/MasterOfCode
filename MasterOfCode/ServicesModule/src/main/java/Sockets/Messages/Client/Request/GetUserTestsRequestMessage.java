/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Request;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import Sockets.Messages.Client.Reply.GetUserTestsReplyMessage;
import java.util.HashMap;
import java.util.Map;
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

    /**
     * Constructor
     */
     public GetUserTestsRequestMessage() {
    }

    /**
     *
     * @param s
     * @return
     */
    public static GetUserTestsRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        return new GetUserTestsRequestMessage();
    }
    
    @Override
    public void doAction(CommunicationBean communicationBean) {
        Map<String, String> descriptions = new HashMap<>();
        descriptions.put("Test1", "This is the first test.");
        descriptions.put("Test2", "This is the seconds test.");
        descriptions.put("Test3", "This is the third test.");
        GetUserTestsReplyMessage mess = new GetUserTestsReplyMessage(descriptions);
        communicationBean.sendMessageToCompetitor("Noor", mess);
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        return obj.toString();
    }

}
