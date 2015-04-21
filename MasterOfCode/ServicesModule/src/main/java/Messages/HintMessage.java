/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

import java.io.Serializable;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class HintMessage extends BaseMessage implements Serializable {
    
    public static final String MessageType = "hintMessage";
    private String hintMessage;
    
    public HintMessage(){};
    
    public HintMessage (Long competitionId, String hintMessage) {
        super(competitionId);
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
        Long jsonCompetitionId = (Long) obj.get("competitionId");
        String jsonHintMessage = obj.get("hintMessage").toString();
        
        return new HintMessage(jsonCompetitionId, jsonHintMessage);
    }
}
