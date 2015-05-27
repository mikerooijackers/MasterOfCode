/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessageUtils;

import Enumerations.MessageTypes;
import Sockets.Messages.AddMemberToTeamRequestMessage;
import Sockets.Messages.Admin.Request.AddRoundToCompetitionRequestMessage;
import Sockets.Messages.Admin.Request.CreateCompetitionRequestMessage;
import Sockets.Messages.Admin.Request.CreateTeamRequestMessage;
import Sockets.Messages.Admin.Request.DeleteRoundRequestMessage;
import Sockets.Messages.Admin.Request.EditCompetitionRequestMessage;
import Sockets.Messages.Admin.Request.EditRoundRequestMessage;
import Sockets.Messages.Admin.Request.FreezeRoundRequestMessage;
import Sockets.Messages.Admin.Request.PauseRoundRequestMessage;
import Sockets.Messages.Admin.Request.PublishHintRequestMessage;
import Sockets.Messages.Admin.Request.RegisterMemberRequestMessage;
import Sockets.Messages.Admin.Request.RegisterTeamRequestMessage;
import Sockets.Messages.Admin.Request.RemoveMemberOfTeamRequestMessage;
import Sockets.Messages.Admin.Request.ResumeRoundRequestMessage;
import Sockets.Messages.Admin.Request.StartCompetitionRequestMessage;
import Sockets.Messages.Admin.Request.StartRoundRequestMessage;
import Sockets.Messages.Admin.Request.StopCompetitionRequestMessage;
import Sockets.Messages.Admin.Request.UnFreezeRoundRequestMessage;
import Sockets.Messages.BaseMessage;
import Sockets.Messages.Client.Reply.CompileReplyMessage;
import Sockets.Messages.Client.Reply.ContinueRoundReplyMessage;
import Sockets.Messages.Client.Reply.GetSourceFilesReplyMessage;
import Sockets.Messages.Client.Reply.GetUserTestsReplyMessage;
import Sockets.Messages.Client.Reply.GroupTestsReplyMessage;
import Sockets.Messages.Client.Reply.HintReplyMessage;
import Sockets.Messages.Client.Reply.OtherTeamScoreReplyMessage;
import Sockets.Messages.Client.Reply.PauseRoundReplyMessage;
import Sockets.Messages.Client.Reply.UnfreezeRoundReplyMessage;
import Sockets.Messages.Client.Reply.UserTestsReplyMessage;
import Sockets.Messages.Client.Request.ActionTeamRequestMessage;
import Sockets.Messages.Client.Request.AddMemberToTeamClientRequestMessage;
import Sockets.Messages.Client.Request.CompileRequestMessage;
import Sockets.Messages.Client.Request.CreateTeamClientRequestMessage;
import Sockets.Messages.Client.Request.EditSourceCodeRequestMessage;
import Sockets.Messages.Client.Request.GetUserTestsRequestMessage;
import Sockets.Messages.Client.Request.GroupTestsRequestMessage;
import Sockets.Messages.Client.Request.InviteMemberToTeamRequestMessage;
import Sockets.Messages.Client.Request.SubmitRequestMessage;
import Sockets.Messages.Client.Request.UserTestsRequestMessage;
import Sockets.Messages.DebugMessage;
import Sockets.Messages.GetSourceFilesRequestMessage;
import Sockets.Messages.NewSessionConnectionMessage;
import Sockets.Messages.RemoveMemberFromTeamRequestMessage;
import Sockets.Messages.Reply.FreezeRoundReplyMessage;
import Sockets.Messages.Reply.PauzeRoundReplyMessage;
import Sockets.Messages.Reply.ResumeRoundReplyMessage;
import Sockets.Messages.Reply.ScoreReplyMessage;
import Sockets.Messages.Reply.StartCompetitionReplyMessage;
import Sockets.Messages.Reply.StartRoundReplyMessage;
import Sockets.Messages.Reply.StopCompetitionReplyMessage;
import Sockets.Messages.Reply.StopRoundReplyMessage;
import Sockets.Messages.Reply.TeamActionReplyMessage;
import Sockets.Messages.Spectator.CompetitionEndedReplyMessage;
import Sockets.Messages.Spectator.CompetitionInfoReplyMessage;
import Sockets.Messages.Spectator.CompetitionNotStartetReplyMessage;
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
                RemoveMemberFromTeamRequestMessage.decodeJSON(s);
            case AddRoundToCompetitionRequestMessage:
                AddRoundToCompetitionRequestMessage.decodeJSON(s);
            case CreateCompetitionRequestMessage:
                CreateCompetitionRequestMessage.decodeJSON(s);
            case DeleteRoundRequestMessage:
                DeleteRoundRequestMessage.decodeJSON(s);
            case EditCompetitionRequestMessage:
                EditCompetitionRequestMessage.decodeJSON(s);
            case EditRoundRequestMessage:
                EditRoundRequestMessage.decodeJSON(s);
            case FreezeRoundRequestMessage:
                FreezeRoundRequestMessage.decodeJSON(s);
            case PauseRoundRequestMessage:
                PauseRoundRequestMessage.decodeJSON(s);
            case PublishHintRequestMessage:
                PublishHintRequestMessage.decodeJSON(s);
            case RegisterMemberRequestMessage:
                RegisterMemberRequestMessage.decodeJSON(s);
            case RegisterTeamRequestMessage:
                RegisterTeamRequestMessage.decodeJSON(s);
            case RemoveMemberOfTeamRequestMessage:
                RemoveMemberOfTeamRequestMessage.decodeJSON(s);
            case ResumeRequestMessage:
                ResumeRoundRequestMessage.decodeJSON(s);
            case StartCompetitionRequestMessage:
                StartCompetitionRequestMessage.decodeJSON(s);
            case StartRoundRequestMessage:
                StartRoundRequestMessage.decodeJSON(s);
            case StopCompetitionRequestMessage:
                StopCompetitionRequestMessage.decodeJSON(s);
            case UnFreezeRoundRequestMessage:
                UnFreezeRoundRequestMessage.decodeJSON(s);
            case ContinueRoundReplyMessage:
                ContinueRoundReplyMessage.decodeJSON(s);
            case GetSourceFilesReplyMessage:
                GetSourceFilesReplyMessage.decodeJSON(s);
            case GetUserTestsReplyMessage:
                GetUserTestsReplyMessage.decodeJSON(s);
            case GroupTestsReplyMessage:
                GroupTestsReplyMessage.decodeJSON(s);
            case HintReplyMessage:
                HintReplyMessage.decodeJSON(s);
            case OtherTeamScoreReplyMessage:
                OtherTeamScoreReplyMessage.decodeJSON(s);
            case PauseRoundReplyMessage:
                PauseRoundReplyMessage.decodeJSON(s);
            case UnFreezeRoundReplyMessage:
                UnfreezeRoundReplyMessage.decodeJSON(s);
            case UserTestsReplyMessage:
                UserTestsReplyMessage.decodeJSON(s);
            case ActionTeamRequestMessage:
                ActionTeamRequestMessage.decodeJSON(s);
            case AddMemberToTeamClientRequestMessage:
                AddMemberToTeamClientRequestMessage.decodeJSON(s);
            case CompileRequestMessage:
                CompileRequestMessage.decodeJSON(s);
            case CreateTeamClientRequestMessage:
                CreateTeamClientRequestMessage.decodeJSON(s);
            case EditSourceCodeRequestMessage:
                EditSourceCodeRequestMessage.decodeJSON(s);
            case GetUserTestsRequestMessage:
                GetUserTestsRequestMessage.decodeJSON(s);
            case GroupTestsRequestMessage:
                GroupTestsRequestMessage.decodeJSON(s);
            case InviteMemberToTeamRequestMessage:
                InviteMemberToTeamRequestMessage.decodeJSON(s);
            case SubmitRequestMessage:
                SubmitRequestMessage.decodeJSON(s);
            case UserTestsRequestMessage:
                UserTestsRequestMessage.decodeJSON(s);
            case FreezeRoundReplyMessage:
                FreezeRoundReplyMessage.decodeJSON(s);
            case PauzeRoundReplyMessage:
                PauzeRoundReplyMessage.decodeJSON(s);
            case ResumeRoundReplyMessage:
                ResumeRoundReplyMessage.decodeJSON(s);
            case ScoreReplyMessage:
                ScoreReplyMessage.decodeJSON(s);
            case StartCompetitionReplyMessage:
                StartCompetitionReplyMessage.decodeJSON(s);
            case StartRoundReplyMessage:
                StartRoundReplyMessage.decodeJSON(s);
            case StopCompetitionReplyMessage:
                StopCompetitionReplyMessage.decodeJSON(s);
            case StopRoundReplyMessage:
                StopRoundReplyMessage.decodeJSON(s);
            case TeamActionReplyMessage:
                TeamActionReplyMessage.decodeJSON(s);
            case CompetitionEndedReplyMessage:
                CompetitionEndedReplyMessage.decodeJSON(s);
            case CompetitionInfoReplyMessage:
                CompetitionInfoReplyMessage.decodeJSON(s);
            case CompetitionNotStartetReplyMessage:
                CompetitionNotStartetReplyMessage.decodeJSON(s);
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
