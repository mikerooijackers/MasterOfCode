/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import java.util.List;

/**
 *
 * @author JordiK
 */
public class CreateTeamMessage {
    private String teamName;
    private String initiator;
    private List<String> members;
    
    public CreateTeamMessage(){}
    
    public CreateTeamMessage(String teamName, String initiator, List<String> members) {
        this.teamName = teamName;
        this.initiator = initiator;
        this.members = members;
    }

    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * @return the members
     */
    public List<String> getMembers() {
        return members;
    }

    /**
     * @param members the members to set
     */
    public void setMembers(List<String> members) {
        this.members = members;
    }

    /**
     * @return the initiator
     */
    public String getInitiator() {
        return initiator;
    }

    /**
     * @param initiator the initiator to set
     */
    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }
}
