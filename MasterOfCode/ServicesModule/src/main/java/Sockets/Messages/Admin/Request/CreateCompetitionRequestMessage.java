/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Admin.Request;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import java.util.Calendar;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class CreateCompetitionRequestMessage extends BaseMessage {
    
    /**
     *
     */
    public static final String messageType = MessageTypes.CreateCompetitionRequestMessage.toString();
    
    private String name;
    private String description;
    private Calendar startTime = Calendar.getInstance();
    
    /**
     *
     */
    public CreateCompetitionRequestMessage(){
    }
    
    /**
     *
     * @param name
     * @param description
     * @param startTime
     */
    public CreateCompetitionRequestMessage(String name, String description, Long startTime) {
        this.name = name;
        this.description = description;
        this.startTime.setTimeInMillis(startTime);
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static CreateCompetitionRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String jsonName = obj.get("Name").toString();
        String jsonDescription = obj.get("Description").toString();
        Long jsonStartTime = (Long) obj.get("StartTime");
        return new CreateCompetitionRequestMessage(jsonName, jsonDescription, jsonStartTime);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("Name", this.name);
        obj.put("Description", this.description);
        obj.put("StartTime", this.startTime.getTimeInMillis());
        return obj.toJSONString();
    }
    
}
