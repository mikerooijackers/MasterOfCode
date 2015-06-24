/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Reply;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class GetSourceFilesReplyMessage extends BaseMessage {
    
    /**
     *
     */
    public static final String messageType = MessageTypes.GetSourceFilesReplyMessage.toString();
    
    private Map<String, String> sourceFiles;
    
    /**
     *
     */
    public GetSourceFilesReplyMessage(){
    }
    
    /**
     *
     * @param sourceFiles
     */
    public GetSourceFilesReplyMessage(Map<String, String> sourceFiles) {
        this.sourceFiles = sourceFiles;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static GetSourceFilesReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Map<String, String> jsonSourceFiles = (Map<String, String>) obj.get("SourceFiles");
        return new GetSourceFilesReplyMessage(jsonSourceFiles);
    } 

    @Override
    public void doAction(CommunicationBean communicationBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("SourceFiles", this.sourceFiles);
        return obj.toJSONString();
    }
    
}
