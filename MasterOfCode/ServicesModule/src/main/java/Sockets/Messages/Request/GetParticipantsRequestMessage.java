package Sockets.Messages.Request;

import Domein.MOCUser;
import Domein.Team;
import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import Sockets.Messages.Reply.GetParticipantsReplyMessage;
import java.util.ArrayList;
import java.util.List;
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
        Team team1 = new Team("workspacePath1", "Team 1", "Server 1", true);
        Team team2 = new Team("workspacePath2", "Team 2", "Server 1", false);
        team1.setId(9000);
        team2.setId(9001);
        
        List<MOCUser> userList = new ArrayList();
        userList.add(new MOCUser("John", "password", "email", "John Schipper", null, team1, "S61E", "040-1234567"));
        userList.add(new MOCUser("Jordi", "password", "email", "Jordi Knol", null, team1, "S61E", "040-9876543"));
        userList.add(new MOCUser("Maaike", "password", "email", "Maaike Jansen", null, team1, "S61E", "040-1478523"));
        userList.add(new MOCUser("Mike", "password", "email", "Mike Rooijackers", null, team2, "S61E", "040-1234567"));
        userList.add(new MOCUser("Tim", "password", "email", "Tim Hermens", null, team2, "S61E", "040-9876543"));
        userList.add(new MOCUser("Noor", "password", "email", "Noor van Oekel", null, team2, "S61E", "040-1478523"));
        GetParticipantsReplyMessage message = new GetParticipantsReplyMessage(userList);
        communicationBean.sendMessageToAdmin("Jordi", message);
    }
    
    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        return obj.toJSONString();
    }
    
}
