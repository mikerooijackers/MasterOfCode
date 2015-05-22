/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enumerations;

/**
 *
 * @author JordiK, Mike Rooijackers
 */
public enum MessageTypes {
    AddMemberToTeamRequestMessage("AddMemberToTeamRequestMessage"), 
    AddRoundToCompetitionRequestMessage("AddRoundToCompetitionRequestMessage"), 
    CreateCompetitionRequestMessage("CreateCompetitionRequestMessage"),
    CreateTeamRequestMessage("CreateTeamRequestMessage"),
    DeleteRoundRequestMessage("DeleteRoundRequestMessage"),
    EditCompetitionRequestMessage("EditCompetitionRequestMessage"),
    EditRoundRequestMessage("EditRoundRequestMessage"),
    FreezeRoundRequestMessage("FreezeRoundRequestMessage"),
    PauseRoundRequestMessage("PauseRoundRequestMessage"),
    PublishHintRequestMessage("PublishHintRequestMessage"),
    RegisterMemberRequestMessage("RegisterMemberRequestMessage"),
    RegisterTeamRequestMessage("RegisterTeamRequestMessage"),
    RemoveMemberOfTeamRequestMessage("RemoveMemberOfTeamRequestMessage"),
    ResumeRequestMessage("ResumeRequestMessage"),
    StartCompetitionRequestMessage("StartCompetitionRequestMessage"),
    StartRoundRequestMessage("StartRoundRequestMessage"),
    StopCompetitionRequestMessage("StopCompetitionRequestMessage"),
    UnFreezeRoundRequestMessage("UnFreezeRoundRequestMessage"),
    CompileReplyMessage("CompileReplyMessage"),
    ContinueRoundReplyMessage("ContinueRoundReplyMessage"),
    GetSourceFilesReplyMessage("GetSourceFilesReplyMessage"),
    GetUserTestsReplyMessage("GetUserTestsReplyMessage"),
    GroupTestsReplyMessage("GroupTestsReplyMessage"),
    HintReplyMessage("HintReplyMessage"),
    OtherTeamScoreReplyMessage("OtherTeamScoreReplyMessage"),
    PauseRoundReplyMessage("PauseRoundReplyMessage"),
    UnfreezeRoundReplyMessage("UnfreezeRoundReplyMessage"),
    UserTestsReplyMessage("UserTestsReplyMessage"),
    ActionTeamRequestMessage("ActionTeamRequestMessage"),
    AddMemberToTeamClientRequestMessage("AddMemberToTeamClientRequestMessage"),
    CompileRequestMessage("CompileRequestMessage"),
    CreateTeamClientRequestMessage("CreateTeamClientRequestMessage"),
    EditSourceCodeRequestMessage("EditSourceCodeRequestMessage"),
    GetSourceFilesRequestMessage("GetSourceFilesRequestMessage"),
    GetUserTestsRequestMessage("GetUserTestsRequestMessage"),
    GroupTestsRequestMessage("GroupTestsRequestMessage"),
    InviteMemberToTeamRequestMessage("InviteMemberToTeamRequestMessage"),
    RemoveMemberFromTeamRequestMessage("RemoveMemberFromTeamRequestMessage"),
    SubmitRequestMessage("SubmitRequestMessage"),
    UserTestsRequestMessage("UserTestsRequestMessage"),
    FreezeRoundReplyMessage("FreezeRoundReplyMessage"),
    PauzeRoundReplyMessage("PauzeRoundReplyMessage"),
    ResumeRoundReplyMessage("ResumeRoundReplyMessage"),
    ScoreReplyMessage("ScoreReplyMessage"),
    StartCompetitionReplyMessage("StartCompetitionReplyMessage"),
    StartRoundReplyMessage("StartRoundReplyMessage"),
    StopCompetitionReplyMessage("StopCompetitionReplyMessage"),
    StopRoundReplyMessage("StopRoundReplyMessage"),
    TeamActionReplyMessage("TeamActionReplyMessage"),
    UnFreezeRoundReplyMessage("UnFreezeRoundReplyMessage"),
    CompetitionEndedReplyMessage("CompetitionEndedReplyMessage"),
    CompetitionInfoReplyMessage("CompetitionInfoReplyMessage"),
    CompetitionNotStartetReplyMessage("CompetitionNotStartetReplyMessage"),
    DebugMessage("DebugMessage"),
    NewSessionConnectionMessage("NewSessionConnectionMessage");
    
    private String name;
    
    MessageTypes(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
