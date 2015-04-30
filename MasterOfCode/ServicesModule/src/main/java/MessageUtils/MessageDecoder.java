/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessageUtils;

import Sockets.Messages.BaseMessage;
import Sockets.Messages.CompileReplyMessage;
import Sockets.Messages.CompileRequestMessage;
import Sockets.Messages.ContinueRoundMessage;
import Sockets.Messages.EditSourceCodeMessage;
import Sockets.Messages.FreezeRoundMessage;
import Sockets.Messages.HintMessage;
import Sockets.Messages.OtherTeamScoreMessage;
import Sockets.Messages.PauseRoundMessage;
import Sockets.Messages.RunTestsByGroupReplyMessage;
import Sockets.Messages.RunTestsByGroupRequestMessage;
import Sockets.Messages.RunTestsByNameReplyMessage;
import Sockets.Messages.RunTestsByNameRequestMessage;
import Sockets.Messages.StartCompetitionMessage;
import Sockets.Messages.StartRoundMessage;
import Sockets.Messages.StopCompetitionMessage;
import Sockets.Messages.StopRoundMessage;
import Sockets.Messages.TeamActionMessage;
import Sockets.Messages.UnfreezeRoundMessage;
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
            case HintMessage.MessageType:
                return HintMessage.decodeJSON(s);
            case OtherTeamScoreMessage.MessageType:
                return OtherTeamScoreMessage.decodeJSON(s);
            case PauseRoundMessage.MessageType:
                return PauseRoundMessage.decodeJSON(s);
            case ContinueRoundMessage.MessageType:
                return ContinueRoundMessage.decodeJSON(s);
            case StartCompetitionMessage.MessageType:
                return StartCompetitionMessage.decodeJSON(s);
            case StopCompetitionMessage.MessageType:
                return StopCompetitionMessage.decodeJSON(s);
            case StartRoundMessage.MessageType:
                return StartRoundMessage.decodeJSON(s);
            case StopRoundMessage.MessageType:
                return StopRoundMessage.decodeJSON(s);
            case FreezeRoundMessage.MessageType:
                return FreezeRoundMessage.decodeJSON(s);
            case UnfreezeRoundMessage.MessageType:
                return UnfreezeRoundMessage.decodeJSON(s);
            case EditSourceCodeMessage.MessageType:
                return EditSourceCodeMessage.decodeJSON(s);
            case TeamActionMessage.MessageType:
                return TeamActionMessage.decodeJSON(s);
            case CompileRequestMessage.MessageType:
                return CompileRequestMessage.decodeJSON(s);
            case CompileReplyMessage.MessageType:
                return CompileReplyMessage.decodeJSON(s);
            case RunTestsByNameRequestMessage.MessageType:
                return RunTestsByNameRequestMessage.decodeJSON(s);
            case RunTestsByNameReplyMessage.MessageType:
                return RunTestsByNameReplyMessage.decodeJSON(s);
            case RunTestsByGroupRequestMessage.MessageType:
                return RunTestsByGroupRequestMessage.decodeJSON(s);
            case RunTestsByGroupReplyMessage.MessageType:
                return RunTestsByGroupReplyMessage.decodeJSON(s);
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
