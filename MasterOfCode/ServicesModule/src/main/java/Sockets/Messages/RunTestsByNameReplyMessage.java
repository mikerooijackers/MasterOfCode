/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages;

import Enumerations.MessageTypes;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class RunTestsByNameReplyMessage extends BaseMessage {
    
    public static final MessageTypes messageType = MessageTypes.RunTestsByNameReplyMessage;
    
    private List<String> results;
    
    public RunTestsByNameReplyMessage() {}
    
    public RunTestsByNameReplyMessage(List<String> results) {
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
    
    public static RunTestsByNameReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        List<String> jsonResults = (List<String>) obj.get("results");
        return new RunTestsByNameReplyMessage(jsonResults);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} 