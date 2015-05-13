/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Reply;

import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class GroupTestsReplyMessage extends BaseMessage {
    
    public static final String MessageType = "runTestsByGroupReplyMessage";
    
    private String result;
    
    public GroupTestsReplyMessage(){}
    
    public GroupTestsReplyMessage(String result) {
        this.result = result;
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
    
    public static GroupTestsReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String jsonResult = obj.get("result").toString();
        return new GroupTestsReplyMessage(jsonResult);
    }
}
