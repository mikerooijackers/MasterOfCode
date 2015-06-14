package Sockets.Messages;

import Domein.MOCUser;
import Domein.Team;
import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.Reply.GetParticipantsReplyMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;

public class DebugMessage extends BaseMessage {

    /**
     *
     */
    public static final String messageType = MessageTypes.DebugMessage.toString();

    public static DebugMessage decodeJSON(String s) {
        return new DebugMessage();
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        Team team = new Team();
        team.setId(9000);
        List<MOCUser> userList = new ArrayList();
        userList.add(new MOCUser("John", "password", "email", "John Schipper", null, team, "S61E", "040-1234567"));
        userList.add(new MOCUser("Jordi", "password", "email", "Jordi Knol", null, team, "S61E", "040-9876543"));
        userList.add(new MOCUser("Maaike", "password", "email", "Maaike Jansen", null, team, "S61E", "040-1478523"));

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
