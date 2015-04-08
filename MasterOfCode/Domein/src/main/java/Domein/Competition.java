package Domein;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author mikerooijackers
 */
@Entity
public class Competition implements Serializable {

    /**
     * id of a competition
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * name of a competition
     */
    private String name;

    /**
     * start time of a competition
     */
    private Calendar startTime;
    private Status status;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "competitions")
    private Collection<Assignment> assignments;

    /**
     * Constructor Competition
     */
    public Competition() {
    }

    /**
     * get collection of assignment
     *
     * @return collection of assignment
     */
    public Collection<Assignment> getAssignments() {
        return assignments;
    }

    /**
     * set assignment
     *
     * @param assignments
     */
    public void setAssignments(Collection<Assignment> assignments) {
        this.assignments = assignments;
    }

    /**
     * get Competition ID
     *
     * @return long
     */
    public long getCompetitionId() {
        return this.id;
    }

    /**
     * get name
     *
     * @return string
     */
    public String getName() {
        return this.name;
    }

    /**
     * set name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get id
     *
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * set id
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * get status
     *
     * @return Status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * set status
     *
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * get starttime
     *
     * @return calender
     */
    public Calendar getStartTime() {
        return this.startTime;
    }

    /**
     * set starttime
     *
     * @param startTime
     */
    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

}
