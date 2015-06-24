/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Reply;

import Domein.UnitTestFile;
import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class GetUserTestsReplyMessage extends BaseMessage {
    
    public static final String messageType = MessageTypes.GetUserTestsReplyMessage.toString();
    
    private List<UnitTestFile> userTests;
    
    public GetUserTestsReplyMessage(){
        this.userTests = new ArrayList<UnitTestFile>();
    }
    
    public GetUserTestsReplyMessage(List<UnitTestFile> userTests) {
        this.userTests = userTests;
    }
    
    public static GetUserTestsReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        List<UnitTestFile> jsonUserTests = (List<UnitTestFile>) obj.get("UserTests");
        return new GetUserTestsReplyMessage(jsonUserTests);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("UserTests", this.userTests);
        return obj.toJSONString();
    }
    
}
