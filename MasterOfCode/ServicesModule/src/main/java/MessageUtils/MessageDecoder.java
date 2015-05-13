/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessageUtils;

import Enumerations.MessageTypes;
import Sockets.Messages.*;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class MessageDecoder implements Decoder.Text<BaseMessage> {

    @Override
    public BaseMessage decode(String s) throws DecodeException {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        switch ((MessageTypes) obj.get("messageType")) {
            case CompileReplyMessage:
                CompileReplyMessage.decodeJSON(s);
            case CompileRequestMessage:
                CompileRequestMessage.decodeJSON(s);
            case RunTestsByGroupRequestMessage:
                RunTestsByGroupRequestMessage.decodeJSON(s);
            case RunTestsByGroupReplyMessage:
                RunTestsByGroupReplyMessage.decodeJSON(s);
            case RunTestsByNameRequestMessage:
                RunTestsByNameRequestMessage.decodeJSON(s);
            case RunTestsByNameReplyMessage:
                RunTestsByNameReplyMessage.decodeJSON(s);
            case OtherTeamScoreMessage:
                OtherTeamScoreMessage.decodeJSON(s);
            case HintMessage:
                HintMessage.decodeJSON(s);
            case TeamActionMessage:
                TeamActionMessage.decodeJSON(s);
            case EditSourceCodeMessage:
                EditSourceCodeMessage.decodeJSON(s);
            case StartRoundMessage:
                StartRoundMessage.decodeJSON(s);
            case StopRoundMessage:
                StopRoundMessage.decodeJSON(s);
            case PauseRoundMessage:
                PauseRoundMessage.decodeJSON(s);
            case ContinueRoundMessage:
                ContinueRoundMessage.decodeJSON(s);
            case FreezeRoundMessage:
                FreezeRoundMessage.decodeJSON(s);
            case UnfreezeRoundMessage:
                UnfreezeRoundMessage.decodeJSON(s);
            case StartCompetitionMessage:
                StartCompetitionMessage.decodeJSON(s);
            case StopCompetitionMessage:
                StopCompetitionMessage.decodeJSON(s);
            case AddMembersToTeamRequestMessage:
                AddMembersToTeamRequestMessage.decodeJSON(s);
            case CreateTeamRequestMessage:
                CreateTeamRequestMessage.decodeJSON(s);
            case RemoveMemberFromTeamRequestMessage:
                RemoveMemberFromTeamRequestMessage.decodeJSON(s);
            case GetSourceFilesRequestMessage:
                GetSourceFilesRequestMessage.decodeJSON(s);
        }
        return null;
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig config) {
        System.out.println("Decoder initiated");
    }

    @Override
    public void destroy() {
        System.out.println("Decoder destroyed");
    }
    
}
