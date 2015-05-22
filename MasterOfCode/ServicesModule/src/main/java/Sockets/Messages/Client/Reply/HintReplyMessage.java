/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Reply;

import Enumerations.MessageTypes;
import Sockets.Messages.BaseMessage;
import java.io.Serializable;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class HintReplyMessage extends BaseMessage implements Serializable {
    
    /**
     *
     */
    public static final String messageType = MessageTypes.HintReplyMessage.toString();
    private String hintMessage;
    
    /**
     * Constructor
     */
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
    
    /**
     *
     * @param JSON
     * @return
     */
    public static HintReplyMessage decodeJSON(String JSON) {
        JSONObject obj = (JSONObject) JSONValue.parse(JSON);
        String jsonHintMessage = obj.get("hintMessage").toString();
        
        return new HintReplyMessage(jsonHintMessage);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("HintMessage", this.hintMessage);
        return obj.toString();
    }
}
