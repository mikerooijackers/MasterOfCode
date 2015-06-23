package Sockets.Messages.Reply;

import Domein.MOCUser;
import Domein.Team;
import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Jay
 */
public class GetAllTeamsReplyMessage extends BaseMessage {

    /**
     *
     */
    public static final String messageType = MessageTypes.GetAllTeamsReplyMessage.toString();

    private List<Team> teamList = new ArrayList();

    /**
     *
     */
    public GetAllTeamsReplyMessage() {
    }

    /**
     *
     * @param teamList
     */
    public GetAllTeamsReplyMessage(List<Team> teamList) {
        this.teamList = teamList;
    }

    /**
     *
     * @param s
     * @return
     */
    public static GetAllTeamsReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        List<Team> jsonTeamList = (List<Team>) obj.get("teamList");
        return new GetAllTeamsReplyMessage(jsonTeamList);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        System.out.println("In the doAction of the GetAllTeamsReplyMessage");
    }

    @Override
    public String toJSONString() {
        int teamAmount = teamList.size();
        int indexTeam = 0;
        int memberAmount;
        int indexMembers = 0;
        
        String json = "";

        json += "{";
        json += "\"MessageType\": \"" + GetAllTeamsReplyMessage.messageType + "\",";

        json += "\"Teams\" : {";

        for (Team team : teamList) {
            json += "\"" + team.getId() + "\" :";
            json += "{";
            json += "\"Score\": \"" + team.getScore() + "\", ";
            json += "\"Workspacepath\": \"" + team.getWorkspacePath() + "\", ";
            json += "\"TeamName\": \"" + team.getTeamName() + "\", ";
            json += "\"ServerName\": \"" + team.getServerName() + "\", ";
            json += "\"Approved\": \"" + team.isApproved() + "\", ";
            json += "\"Members\" : [";
            
            memberAmount = team.getNumberofMembers();
            
            for (MOCUser member : team.getMembers()){
                json += "\"" + member.getFullName() + "\"";
                
                if (indexMembers != memberAmount -1) {
                    json += ", ";
                }
            }
            
            json += "]";
            json += "}";

            if (indexTeam != teamAmount - 1) {
                json += ", ";
            }

            indexTeam++;
        }

        json += "}";
        json += "}";

        return json;
    }

}
