/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class RunTestsByGroupReplyMessage extends BaseMessage {
    
    public static final String MessageType = "runTestsByGroupReplyMessage";
    
    private String result;
    
    public RunTestsByGroupReplyMessage(){}
    
    public RunTestsByGroupReplyMessage(String result) {
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
    
    public static RunTestsByGroupReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String jsonResult = obj.get("result").toString();
        return new RunTestsByGroupReplyMessage(jsonResult);
    }
}
