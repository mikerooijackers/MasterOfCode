package Domein;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 *
 * @author mikerooijackers
 */
@Entity
@NamedQueries ({
    @NamedQuery(name = "AllTeams", query = "select t FROM Team t"),
    @NamedQuery(name = "GetTeamFromCompetition", query = "select t FROM Team t where t.competition.id = :competitionID")
})
public class Team implements JSONAware,Serializable {
    @Transient
    private Collection<MOCUser> members = new ArrayList();
    private int score;
    private String workspacePath;
    private String teamName;
    private String serverName;
    private boolean approved;
    
    @OneToOne
    private MOCUser initiator;

    @ManyToOne
    private Competition competition;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     *
     * @param workspacePath
     * @param teamName
     * @param serverName
     * @param approved
     */
    public Team(String workspacePath, String teamName, String serverName, boolean approved) {
        this.workspacePath = workspacePath;
        this.teamName = teamName;
        this.serverName = serverName;
        this.approved = approved;
    }
    
    /**
     *
     * @param teamName
     */
    public Team(String teamName) {
        this.teamName = teamName;
    }
    /**
     * get Team ID
     *
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * set Team ID
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Constructor
     */
    public Team() {
    }

    /**
     * get Members
     *
     * @return collection
     */
    public Collection<MOCUser> getMembers() {
        return this.members;
    }

    /**
     * Set Members
     *
     * @param members
     */
    public void setMembers(Collection<MOCUser> members) {
        this.members = members;
    }

    /**
     * Get Score
     *
     * @return int
     */
    public int getScore() {
        return score;
    }

    /**
     * Set Score
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Get WorkspacePath
     *
     * @return string
     */
    public String getWorkspacePath() {
        return workspacePath;
    }

    /**
     * Set WorkspacePath
     *
     * @param workspacePath
     */
    public void setWorkspacePath(String workspacePath) {
        this.workspacePath = workspacePath;
    }

    /**
     * Get Competition
     *
     * @return Competition
     */
    public Competition getCompetition() {
        return competition;
    }

    /**
     * Set Competition
     *
     * @param competition
     */
    public void setCompetition(Competition competition) {
        this.competition = competition;
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
     * get serverName
     * @return
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * set ServerName
     * @param serverName
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    /**
     * get number of Members
     * @return
     */
    public int getNumberofMembers() {
        return this.members.size();
    }

    /**
     * @return the approved
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * @param approved the approved to set
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("Members", this.members);
        obj.put("Score", this.score);
        obj.put("Workspacepath", this.workspacePath);
        obj.put("Competition", this.competition);
        obj.put("Id", this.id);
        obj.put("TeamName", this.teamName);
        obj.put("Approved", this.isApproved());
        return obj.toJSONString();
    }

    /**
     * @return the initiator
     */
    public MOCUser getInitiator() {
        return initiator;
    }

    /**
     * @param initiator the initiator to set
     */
    public void setInitiator(MOCUser initiator) {
        this.initiator = initiator;
    }
}