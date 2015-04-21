/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

/**
 *
 * @author JordiK
 */
public class BaseMessage {
    
    private Long competitionId;
    
    public BaseMessage(){};
    
    public BaseMessage(Long competitionId) {
        this.competitionId = competitionId;
    }

    /**
     * @return the competitionId
     */
    public Long getCompetitionId() {
        return competitionId;
    }

    /**
     * @param competitionId the competitionId to set
     */
    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }
}
