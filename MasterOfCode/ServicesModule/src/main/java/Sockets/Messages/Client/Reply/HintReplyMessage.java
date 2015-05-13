/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Reply;

import Sockets.Messages.BaseMessage;
import java.io.Serializable;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class HintReplyMessage extends BaseMessage implements Serializable {
    
    public static final String MessageType = "hintMessage";
    private String hintMessage;
    
    public HintReplyMessage(){};
    
    public HintReplyMessage (String hintMessage) {
        this.hintMessage = hintMessage;
    }

    /**
     * @return the hintMessage
     */
    public String getHintMessage() {
        return hintMessage;
    }

    /**
     * @param hintMessage the hintMessage to set
     */
    public void setHintMessage(String hintMessage) {
        this.hintMessage = hintMessage;
    }
    
    public static HintReplyMessage decodeJSON(String JSON) {
        JSONObject obj = (JSONObject) JSONValue.parse(JSON);
        String jsonHintMessage = obj.get("hintMessage").toString();
        
        return new HintReplyMessage(jsonHintMessage);
    }
}
