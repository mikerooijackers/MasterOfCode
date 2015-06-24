/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Reply;

import Domein.SourceCode;
import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import java.util.ArrayList;
import java.util.List;
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
    
    private List<SourceCode> sourceFiles;
    
    public GetSourceFilesReplyMessage(){
        this.sourceFiles = new ArrayList<SourceCode>();
    }
    
    public GetSourceFilesReplyMessage(List<SourceCode> sourceFiles) {
        this.sourceFiles = sourceFiles;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static GetSourceFilesReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        List<SourceCode> jsonSourceFiles = (List<SourceCode>) obj.get("SourceFiles");
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
