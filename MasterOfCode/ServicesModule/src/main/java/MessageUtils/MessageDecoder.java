/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessageUtils;

import Enumerations.MessageTypes;
import Sockets.Messages.*;
import Sockets.Messages.Admin.Request.*;
import Sockets.Messages.Client.Reply.*;
import Sockets.Messages.Client.Request.*;
import Sockets.Messages.Reply.*;
import Sockets.Messages.Request.GetParticipantsRequestMessage;
import Sockets.Messages.Request.GetTeamsRequestMessage;
import Sockets.Messages.Spectator.*;
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
        System.out.println("Decoding: " + s);
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String messageTypeString = obj.get("MessageType").toString();
        MessageTypes mt = MessageTypes.valueOf(messageTypeString);
        switch (mt) {
            case CompileReplyMessage:
                return CompileReplyMessage.decodeJSON(s);
            case NewSessionConnectionMessage:
                return NewSessionConnectionMessage.decodeJSON(s);
            case DebugMessage:
                return DebugMessage.decodeJSON(s);
            case AddMemberToTeamRequestMessage:
                return AddMemberToTeamRequestMessage.decodeJSON(s);
            case CreateTeamRequestMessage:
                return CreateTeamRequestMessage.decodeJSON(s);
            case GetSourceFilesRequestMessage:
                return GetSourceFilesRequestMessage.decodeJSON(s);
            case RemoveMemberFromTeamRequestMessage:
                return RemoveMemberFromTeamRequestMessage.decodeJSON(s);
            case AddRoundToCompetitionRequestMessage:
                return AddRoundToCompetitionRequestMessage.decodeJSON(s);
            case CreateCompetitionRequestMessage:
                return CreateCompetitionRequestMessage.decodeJSON(s);
            case DeleteRoundRequestMessage:
                return DeleteRoundRequestMessage.decodeJSON(s);
            case EditCompetitionRequestMessage:
                return EditCompetitionRequestMessage.decodeJSON(s);
            case EditRoundRequestMessage:
                return EditRoundRequestMessage.decodeJSON(s);
            case FreezeRoundRequestMessage:
                return FreezeRoundRequestMessage.decodeJSON(s);
            case PauseRoundRequestMessage:
                return PauseRoundRequestMessage.decodeJSON(s);
            case PublishHintRequestMessage:
                return PublishHintRequestMessage.decodeJSON(s);
            case RegisterMemberRequestMessage:
                return RegisterMemberRequestMessage.decodeJSON(s);
            case RegisterTeamRequestMessage:
                return RegisterTeamRequestMessage.decodeJSON(s);
            case RemoveMemberOfTeamRequestMessage:
                return RemoveMemberOfTeamRequestMessage.decodeJSON(s);
            case ResumeRequestMessage:
                return ResumeRoundRequestMessage.decodeJSON(s);
            case StartCompetitionRequestMessage:
                return StartCompetitionRequestMessage.decodeJSON(s);
            case StartRoundRequestMessage:
                return StartRoundRequestMessage.decodeJSON(s);
            case StopCompetitionRequestMessage:
                return StopCompetitionRequestMessage.decodeJSON(s);
            case UnFreezeRoundRequestMessage:
                return UnFreezeRoundRequestMessage.decodeJSON(s);
            case ContinueRoundReplyMessage:
                return ContinueRoundReplyMessage.decodeJSON(s);
            case GetSourceFilesReplyMessage:
                return GetSourceFilesReplyMessage.decodeJSON(s);
            case GetUserTestsReplyMessage:
                return GetUserTestsReplyMessage.decodeJSON(s);
            case GroupTestsReplyMessage:
                return GroupTestsReplyMessage.decodeJSON(s);
            case HintReplyMessage:
                return HintReplyMessage.decodeJSON(s);
            case OtherTeamScoreReplyMessage:
                return OtherTeamScoreReplyMessage.decodeJSON(s);
            case PauseRoundReplyMessage:
                return PauseRoundReplyMessage.decodeJSON(s);
            case UnFreezeRoundReplyMessage:
                return UnfreezeRoundReplyMessage.decodeJSON(s);
            case UserTestsReplyMessage:
                return UserTestsReplyMessage.decodeJSON(s);
            case ActionTeamRequestMessage:
                return ActionTeamRequestMessage.decodeJSON(s);
            case AddMemberToTeamClientRequestMessage:
                return AddMemberToTeamClientRequestMessage.decodeJSON(s);
            case CompileRequestMessage:
                return CompileRequestMessage.decodeJSON(s);
            case CreateTeamClientRequestMessage:
                return CreateTeamClientRequestMessage.decodeJSON(s);
            case EditSourceCodeRequestMessage:
                return EditSourceCodeRequestMessage.decodeJSON(s);
            case GetUserTestsRequestMessage:
                return GetUserTestsRequestMessage.decodeJSON(s);
            case GroupTestsRequestMessage:
                return GroupTestsRequestMessage.decodeJSON(s);
            case InviteMemberToTeamRequestMessage:
                return InviteMemberToTeamRequestMessage.decodeJSON(s);
            case SubmitRequestMessage:
                return SubmitRequestMessage.decodeJSON(s);
            case UserTestsRequestMessage:
                return UserTestsRequestMessage.decodeJSON(s);
            case FreezeRoundReplyMessage:
                return FreezeRoundReplyMessage.decodeJSON(s);
            case PauzeRoundReplyMessage:
                return PauzeRoundReplyMessage.decodeJSON(s);
            case ResumeRoundReplyMessage:
                return ResumeRoundReplyMessage.decodeJSON(s);
            case ScoreReplyMessage:
                return ScoreReplyMessage.decodeJSON(s);
            case StartCompetitionReplyMessage:
                return StartCompetitionReplyMessage.decodeJSON(s);
            case StartRoundReplyMessage:
                return StartRoundReplyMessage.decodeJSON(s);
            case StopCompetitionReplyMessage:
                return StopCompetitionReplyMessage.decodeJSON(s);
            case StopRoundReplyMessage:
                return StopRoundReplyMessage.decodeJSON(s);
            case TeamActionReplyMessage:
                return TeamActionReplyMessage.decodeJSON(s);
            case CompetitionEndedReplyMessage:
                return CompetitionEndedReplyMessage.decodeJSON(s);
            case CompetitionInfoReplyMessage:
                return CompetitionInfoReplyMessage.decodeJSON(s);
            case CompetitionNotStartetReplyMessage:
                return CompetitionNotStartetReplyMessage.decodeJSON(s);
            case GetParticipantsReplyMessage:
                return GetParticipantsReplyMessage.decodeJSON(s);
            case GetAllTeamsReplyMessage:
                return GetAllTeamsReplyMessage.decodeJSON(s);
            case GetParticipantsRequestMessage:
                return GetParticipantsRequestMessage.decodeJSON(s);
            case GetTeamsRequestMessage:
                return GetTeamsRequestMessage.decodeJSON(s);
            case StopRoundRequestMessage:
                return StopRoundRequestMessage.decodeJSON(s);
            case ChangePasswordRequestMessage:
                return ChangePasswordRequestMessage.decodeJSON(s);
            case ChangePasswordReplyMessage:
                return ChangePasswordReplyMessage.DecodeJSON(s);
            case NewUserSessionConnectionMessage:
                return NewUserSessionConnectionMessage.decodeJSON(s);
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
