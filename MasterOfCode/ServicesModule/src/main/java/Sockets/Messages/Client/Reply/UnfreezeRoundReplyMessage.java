/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Reply;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class UnfreezeRoundReplyMessage extends BaseMessage {
    
    /**
     *
     */
    public static final String messageType = MessageTypes.UnFreezeRoundReplyMessage.toString();
    
    /**
     * Constructor
     */
    public UnfreezeRoundReplyMessage(){
    }
    
    /**
     * 
     * @param s
     * @return
     */
    public static UnfreezeRoundReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        return new UnfreezeRoundReplyMessage();
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
