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

    public String getAssignmentCreatorName() {
        return assignmentCreatorName;
    }

    public String getAssignmentCreatorOrganisation() {
        return assignmentCreatorOrganisation;
    }

    public String getAssignmentCreatorLogo() {
        return assignmentCreatorLogo;
    }

    public String getAssignmentCreatorWebsite() {
        return assignmentCreatorWebsite;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public String getAssignmentSpectatorDescription() {
        return assignmentSpectatorDescription;
    }

    public String getAssignmentContestantDescription() {
        return assignmentContestantDescription;
    }

    public String getAssignmentDifficulty() {
        return assignmentDifficulty;
    }

    public List<Hint> getHints() {
        return hints;
    }

    public void setAssignmentSpectatorDescription(String assignmentSpectatorDescription) {
        this.assignmentSpectatorDescription = assignmentSpectatorDescription;
    }

    public void setAssignmentContestantDescription(String assignmentContestantDescription) {
        this.assignmentContestantDescription = assignmentContestantDescription;
    }

    public void setAssignmentDifficulty(String assignmentDifficulty) {
        this.assignmentDifficulty = assignmentDifficulty;
    }
}
