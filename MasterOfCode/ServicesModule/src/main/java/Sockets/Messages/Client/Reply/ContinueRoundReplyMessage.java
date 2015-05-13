/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Reply;

import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class ContinueRoundReplyMessage extends BaseMessage {
    
    public static final String MessageType = "continueRoundMessage";
    
    public ContinueRoundReplyMessage(){}
    
    public static ContinueRoundReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        return new ContinueRoundReplyMessage();
    }
}