/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Competition;

import Domein.Hint;
import java.util.List;

/**
 *
 * @author mikerooijackers
 */
class RoundMetaData {
    private String assignmentCreatorName;
    private String assignmentCreatorOrganisation;
    private String assignmentCreatorLogo;
    private String assignmentCreatorWebsite;
    private String assignmentName;
    private String assignmentSpectatorDescription;
    private String assignmentContestantDescription;
    private String assignmentDifficulty;
    private List<Hint> hints;

    public RoundMetaData(String assignmentCreatorName, String assignmentCreatorOrganisation, String assignmentCreatorLogo, String assignmentCreatorWebsite, String assignmentName, String assignmentSpectatorDescription, String assignmentContestantDescription, String assignmentDifficulty, List<Hint> hints) {
        this.assignmentCreatorName = assignmentCreatorName;
        this.assignmentCreatorOrganisation = assignmentCreatorOrganisation;
        this.assignmentCreatorLogo = assignmentCreatorLogo;
        this.assignmentCreatorWebsite = assignmentCreatorWebsite;
        this.assignmentName = assignmentName;
        this.assignmentSpectatorDescription = assignmentSpectatorDescription;
        this.assignmentContestantDescription = assignmentContestantDescription;
        this.assignmentDifficulty = assignmentDifficulty;
        this.hints = hints;
    }

    /**
     * get assignement creator name
     * @return assignment creator name
     */
    public String getAssignmentCreatorName() {
        return assignmentCreatorName;
    }

    /**
     * get assignment creator organisation
     * @return assignmentcreator organisation
     */
    public String getAssignmentCreatorOrganisation() {
        return assignmentCreatorOrganisation;
    }

    /**
     * get assignement crator logo
     * @return assignement creator logo
     */
    public String getAssignmentCreatorLogo() {
        return assignmentCreatorLogo;
    }

    /**
     * get assignment creator website
     * @return assignement creator website
     */
    public String getAssignmentCreatorWebsite() {
        return assignmentCreatorWebsite;
    }

    /**
     * get assignement name
     * @return assignement name
     */
    public String getAssignmentName() {
        return assignmentName;
    }

    /**
     * get assignement spectator description
     * @return assignement spectator description
     */
    public String getAssignmentSpectatorDescription() {
        return assignmentSpectatorDescription;
    }

    /**
     * get assignement constestant description
     * @return assignement constestant description
     */
    public String getAssignmentContestantDescription() {
        return assignmentContestantDescription;
    }

    /**
     * get Assignment Difficulty
     * @return Assignment Difficulty
     */
    public String getAssignmentDifficulty() {
        return assignmentDifficulty;
    }

    /**
     * get all hints
     * @return hints
     */
    public List<Hint> getHints() {
        return hints;
    }

    /**
     * set Assignment Spectator Description
     * @param assignmentSpectatorDescription 
     */
    public void setAssignmentSpectatorDescription(String assignmentSpectatorDescription) {
        this.assignmentSpectatorDescription = assignmentSpectatorDescription;
    }

    /**
     * set Assignment Contestant Description
     * @param assignmentContestantDescription 
     */
    public void setAssignmentContestantDescription(String assignmentContestantDescription) {
        this.assignmentContestantDescription = assignmentContestantDescription;
    }

    /**
     * set Assignment Difficulty
     * @param assignmentDifficulty 
     */
    public void setAssignmentDifficulty(String assignmentDifficulty) {
        this.assignmentDifficulty = assignmentDifficulty;
    }
}
