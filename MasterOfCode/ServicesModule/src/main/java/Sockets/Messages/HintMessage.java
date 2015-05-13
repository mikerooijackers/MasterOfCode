/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages;

import Enumerations.MessageTypes;
import java.io.Serializable;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class HintMessage extends BaseMessage implements Serializable {
    
    public static final String messageType = MessageTypes.HintMessage.toString();
    private String hintMessage;
    
    public HintMessage(){};
    
    public HintMessage (String hintMessage) {
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
    
    public static HintMessage decodeJSON(String JSON) {
        JSONObject obj = (JSONObject) JSONValue.parse(JSON);
        String jsonHintMessage = obj.get("hintMessage").toString();
        
        return new HintMessage(jsonHintMessage);
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
