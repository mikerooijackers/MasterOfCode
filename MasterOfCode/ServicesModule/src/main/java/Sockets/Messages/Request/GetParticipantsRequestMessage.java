package Sockets.Messages.Request;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;

/**
 *
 * @author Jay
 */
public class GetParticipantsRequestMessage extends BaseMessage {

    /**
     *
     */
    public static final String messageType = MessageTypes.GetParticipantsRequestMessage.toString();
    
    /**
     *
     * @param s
     * @return
     */
    public static GetParticipantsRequestMessage decodeJSON(String s) {
        return new GetParticipantsRequestMessage();
    }
    
    @Override
    public void doAction(CommunicationBean communicationBean) {
        communicationBean.sendParticipantListToAdmins();
    }
    
    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        return obj.toJSONString();
    }
    
}
