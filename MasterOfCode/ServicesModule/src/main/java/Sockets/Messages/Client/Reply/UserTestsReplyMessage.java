/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Reply;

import Enumerations.MessageTypes;
import Sockets.Messages.BaseMessage;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class UserTestsReplyMessage extends BaseMessage {
    
    /**
     * 
     */
    public static final String messageType = MessageTypes.UserTestsReplyMessage.toString();
    
    private List<String> results;
    
    /**
     * Constructor
     */
    public UserTestsReplyMessage() {}
    
    /**
     *
     * @param results
     */
    public UserTestsReplyMessage(List<String> results) {
        this.results = results;
    }

    /**
     * @return the results
     */
    public List<String> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<String> results) {
        this.results = results;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static UserTestsReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        List<String> jsonResults = (List<String>) obj.get("results");
        return new UserTestsReplyMessage(jsonResults);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("Results", this.results);
        return obj.toString();
    }
} 
