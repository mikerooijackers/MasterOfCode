/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessageUtils;

import Messages.BaseMessage;
import Messages.ContinueRoundMessage;
import Messages.FreezeRoundMessage;
import Messages.HintMessage;
import Messages.OtherTeamScoreMessage;
import Messages.PauseRoundMessage;
import Messages.StartCompetitionMessage;
import Messages.StartRoundMessage;
import Messages.StopCompetitionMessage;
import Messages.StopRoundMessage;
import Messages.UnfreezeRoundMessage;
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
