package Sockets.Messages;

import Domein.MOCUser;
import Enumerations.MessageTypes;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class DebugMessage extends BaseMessage {

    public static final String messageType = MessageTypes.DebugMessage.toString();
    
        public static DebugMessage decodeJSON(String s) {
        return new DebugMessage();
    }
    
    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
