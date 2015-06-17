/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mikerooijackers
 */
@Entity
public class Configuration implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ConfigurationID;
    private int minMembersOfTeam;
    private int maxMembersOfTeam;

    /**
     * constructor
     */
    public Configuration() {
    }
    
    /**
     * get configurationID
     * @return
     */
    public int getConfigurationID() {
        return ConfigurationID;
    }

    /**
     * set configurationID
     * @param ConfigurationID
     */
    public void setConfigurationID(int ConfigurationID) {
        this.ConfigurationID = ConfigurationID;
    }

    /**
     * get minimal members of team
     * @return
     */
    public int getMinMembersOfTeam() {
        return minMembersOfTeam;
    }

    /**
     * get minimal members of team
     * @param minMembersOfTeam
     */
    public void setMinMembersOfTeam(int minMembersOfTeam) {
        this.minMembersOfTeam = minMembersOfTeam;
    }

    /**
     * get maximal members of team
     * @return
     */
    public int getMaxMembersOfTeam() {
        return maxMembersOfTeam;
    }

    /**
     * set maximal members of team
     * @param maxMembersOfTeam
     */
    public void setMaxMembersOfTeam(int maxMembersOfTeam) {
        this.maxMembersOfTeam = maxMembersOfTeam;
    }
    
    
    
}
