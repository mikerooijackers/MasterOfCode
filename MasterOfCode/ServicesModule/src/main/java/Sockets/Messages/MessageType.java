/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages;

/**
 *
 * @author mikerooijackers
 */
public enum MessageType {
    AddMemberToTeamRequestMessage(0), 
    AddRoundToCompetitionRequestMessage(1), 
    CreateCompetitionRequestMessage(2),
    CreateTeamRequestMessage(3),
    DeleteRoundRequestMessage(4),
    EditCompetitionRequestMessage(5),
    EditRoundRequestMessage(6),
    FreezeRoundRequestMessage(7),
    PauseRoundRequestMessage(8),
    PublishHintRequestMessage(9),
    RegisterMemberRequestMessage(10),
    RegisterTeamRequestMessage(11),
    RemoveMemberOfTeamRequestMessage(12),
    ResumeRequestMessage(13),
    StartCompetitionRequestMessage(14),
    StartRoundRequestMessage(15),
    StopCompetitionRequestMessage(16),
    UnFreezeRoundRequestMessage(17),
    CompileReplyMessage(18),
    ContinueRoundReplyMessage(19),
    GetSourceFilesReplyMessage(20),
    GetUserTestsReplyMessage(21),
    GroupTestsReplyMessage(22),
    HintReplyMessage(23),
    OtherTeamScoreReplyMessage(24),
    PauseRoundReplyMessage(25),
    UnfreezeRoundReplyMessage(26),
    UserTestsReplyMessage(27),
    ActionTeamRequestMessage(28),
    AddMemberToTeamClientRequestMessage(29),
    CompileRequestMessage(30),
    CreateTeamClientRequestMessage(31),
    EditSourceCodeRequestMessage(32),
    GetSourceFilesRequestMessage(33),
    GetUserTestsRequestMessage(34),
    GroupTestsRequestMessage(35),
    InviteMemberToTeamRequestMessage(36),
    RemoveMemberFromTeamRequestMessage(37),
    SubmitRequestMessage(38),
    UserTestsRequestMessage(39),
    FreezeRoundReplyMessage(40),
    PauzeRoundReplyMessage(41),
    ResumeRoundReplyMessage(42),
    ScoreReplyMessage(43),
    StartCompetitionReplyMessage(44),
    StartRoundReplyMessage(45),
    StopCompetitionReplyMessage(46),
    StopRoundReplyMessage(47),
    TeamActionReplyMessage(48),
    UnFreezeRoundReplyMessage(49),
    CompetitionEndedReplyMessage(50),
    CompetitionInfoReplyMessage(51),
    CompetitionNotStartetReplyMessage(52);
    
        
        private final long id;
        
        MessageType(long id) {
            this.id = id;
        }

    /**
     * get status id
     * @return long
     */
    public long getId() {
        return id;
    }
    
}
