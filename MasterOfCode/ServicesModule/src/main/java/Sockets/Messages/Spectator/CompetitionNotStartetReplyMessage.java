/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Spectator;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class CompetitionNotStartetReplyMessage extends BaseMessage {

    /**
     *
     */
    public static final String messageType = MessageTypes.CompetitionNotStartetReplyMessage.toString();
    
    /**
     * Constructor
     */
    public CompetitionNotStartetReplyMessage() {
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static CompetitionNotStartetReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        return new CompetitionNotStartetReplyMessage();
    }
    
    @Override
    public void doAction(CommunicationBean communicationBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        return obj.toString();
    }

}
