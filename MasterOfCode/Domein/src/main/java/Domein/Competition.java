package Domein;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar startTime;
    private Status status;

    /**
     * Constructor Competition
     */
    public Competition() {
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
