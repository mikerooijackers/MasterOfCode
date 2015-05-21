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
        String messageTypeString = obj.get("MessageType").toString();
        MessageTypes mt = MessageTypes.valueOf(messageTypeString);
        switch (mt) {
            case CompileReplyMessage:
                return CompileReplyMessage.decodeJSON(s);
            case CompileRequestMessage:
                return CompileRequestMessage.decodeJSON(s);
            case RunTestsByGroupRequestMessage:
                return RunTestsByGroupRequestMessage.decodeJSON(s);
            case RunTestsByGroupReplyMessage:
                return RunTestsByGroupReplyMessage.decodeJSON(s);
            case RunTestsByNameRequestMessage:
                return RunTestsByNameRequestMessage.decodeJSON(s);
            case RunTestsByNameReplyMessage:
                return RunTestsByNameReplyMessage.decodeJSON(s);
            case OtherTeamScoreMessage:
                return OtherTeamScoreMessage.decodeJSON(s);
            case HintMessage:
                return HintMessage.decodeJSON(s);
            case TeamActionMessage:
                return TeamActionMessage.decodeJSON(s);
            case EditSourceCodeMessage:
                return EditSourceCodeMessage.decodeJSON(s);
            case StartRoundMessage:
                return StartRoundMessage.decodeJSON(s);
            case StopRoundMessage:
                return StopRoundMessage.decodeJSON(s);
            case PauseRoundMessage:
                return PauseRoundMessage.decodeJSON(s);
            case ContinueRoundMessage:
                return ContinueRoundMessage.decodeJSON(s);
            case FreezeRoundMessage:
                return FreezeRoundMessage.decodeJSON(s);
            case UnfreezeRoundMessage:
                return UnfreezeRoundMessage.decodeJSON(s);
            case StartCompetitionMessage:
                return StartCompetitionMessage.decodeJSON(s);
            case StopCompetitionMessage:
                return StopCompetitionMessage.decodeJSON(s);
            case AddMembersToTeamRequestMessage:
                return AddMembersToTeamRequestMessage.decodeJSON(s);
            case CreateTeamRequestMessage:
                return CreateTeamRequestMessage.decodeJSON(s);
            case RemoveMemberFromTeamRequestMessage:
                return RemoveMemberFromTeamRequestMessage.decodeJSON(s);
            case GetSourceFilesRequestMessage:
                return GetSourceFilesRequestMessage.decodeJSON(s);
            case NewSessionConnectionMessage:
                return NewSessionConnectionMessage.decodeJSON(s);
            case DebugMessage:
                return DebugMessage.decodeJSON(s);
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
