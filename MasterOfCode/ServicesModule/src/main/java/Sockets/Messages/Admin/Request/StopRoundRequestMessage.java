package Sockets.Messages.Admin.Request;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Jay
 */
public class StopRoundRequestMessage extends BaseMessage {
    public static final String messageType = MessageTypes.StopRoundRequestMessage.toString();
    
    private Long competitionId;
    
    public StopRoundRequestMessage(){}
    
    public StopRoundRequestMessage(Long competitionId) {
        this.competitionId = competitionId;
    }
    
    public static StopRoundRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonCompetitionId = (Long) obj.get("CompetitionId");
        return new StopRoundRequestMessage(jsonCompetitionId);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        System.out.println("In the doAction of the StopRoundRequestMessage");
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("CompetitionId", this.competitionId);
        return obj.toJSONString();
    }

    /**
     * @return the competitionId
     */
    public Long getCompetitionId() {
        return competitionId;
    }

    /**
     * @param competitionId the competitionId to set
     */
    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }
}
