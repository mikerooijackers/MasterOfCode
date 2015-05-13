/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessageUtils;

import Sockets.Messages.BaseMessage;
import Sockets.Messages.Client.Reply.CompileReplyMessage;
import Sockets.Messages.Client.Request.CompileRequestMessage;
import Sockets.Messages.Client.Reply.ContinueRoundReplyMessage;
import Sockets.Messages.Client.Request.EditSourceCodeRequestMessage;
import Sockets.Messages.Client.Reply.FreezeRoundReplyMessage;
import Sockets.Messages.Client.Reply.HintReplyMessage;
import Sockets.Messages.Client.Reply.OtherTeamScoreReplyMessage;
import Sockets.Messages.Client.Reply.PauseRoundReplyMessage;
import Sockets.Messages.Client.Reply.GroupTestsReplyMessage;
import Sockets.Messages.Client.Request.GroupTestsRequestMessage;
import Sockets.Messages.Client.Reply.UserTestsReplyMessage;
import Sockets.Messages.Client.Request.UserTestsRequestMessage;
import Sockets.Messages.Reply.StartCompetitionReplyMessage;
import Sockets.Messages.Reply.StartRoundReplyMessage;
import Sockets.Messages.Reply.StopCompetitionReplyMessage;
import Sockets.Messages.Reply.StopRoundReplyMessage;
import Sockets.Messages.Reply.TeamActionReplyMessage;
import Sockets.Messages.Client.Reply.UnfreezeRoundReplyMessage;
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
        switch (obj.get("messageType").toString()) {
            case HintReplyMessage.MessageType:
                return HintReplyMessage.decodeJSON(s);
            case OtherTeamScoreReplyMessage.MessageType:
                return OtherTeamScoreReplyMessage.decodeJSON(s);
            case PauseRoundReplyMessage.MessageType:
                return PauseRoundReplyMessage.decodeJSON(s);
            case ContinueRoundReplyMessage.MessageType:
                return ContinueRoundReplyMessage.decodeJSON(s);
            case StartCompetitionReplyMessage.MessageType:
                return StartCompetitionReplyMessage.decodeJSON(s);
            case StopCompetitionReplyMessage.MessageType:
                return StopCompetitionReplyMessage.decodeJSON(s);
            case StartRoundReplyMessage.MessageType:
                return StartRoundReplyMessage.decodeJSON(s);
            case StopRoundReplyMessage.MessageType:
                return StopRoundReplyMessage.decodeJSON(s);
            case FreezeRoundReplyMessage.MessageType:
                return FreezeRoundReplyMessage.decodeJSON(s);
            case UnfreezeRoundReplyMessage.MessageType:
                return UnfreezeRoundReplyMessage.decodeJSON(s);
            case EditSourceCodeRequestMessage.MessageType:
                return EditSourceCodeRequestMessage.decodeJSON(s);
            case TeamActionReplyMessage.MessageType:
                return TeamActionReplyMessage.decodeJSON(s);
            case CompileRequestMessage.MessageType:
                return CompileRequestMessage.decodeJSON(s);
            case CompileReplyMessage.MessageType:
                return CompileReplyMessage.decodeJSON(s);
            case UserTestsRequestMessage.MessageType:
                return UserTestsRequestMessage.decodeJSON(s);
            case UserTestsReplyMessage.MessageType:
                return UserTestsReplyMessage.decodeJSON(s);
            case GroupTestsRequestMessage.MessageType:
                return GroupTestsRequestMessage.decodeJSON(s);
            case GroupTestsReplyMessage.MessageType:
                return GroupTestsReplyMessage.decodeJSON(s);
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
