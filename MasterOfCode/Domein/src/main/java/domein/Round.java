package domein;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author mikerooijackers
 */
@Entity
public class Round implements Serializable {

    /**
     * number of a round
     */
    private int roundNr;
    /**
     * duration of a round
     */
    private int durationInSeconds;
    /**
     * Status of a round
     */
    private Status status;

    @ManyToOne
    private Competition competition;

    @ManyToOne
    private Assignment assignment;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Constructor Round
     */
    public Round() {
    }

    /**
     * get duration in seconds
     *
     * @return int
     */
    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    /**
     * set duration in seconds
     *
     * @param durationInSeconds
     */
    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
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
     * get competition
     *
     * @return competition
     */
    public Competition getCompetition() {
        return competition;
    }

    /**
     * set competition
     *
     * @param competition
     */
    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    /**
     * get assignment
     *
     * @return assignment
     */
    public Assignment getAssignment() {
        return assignment;
    }

    /**
     * set assignment
     *
     * @param assignment
     */
    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    /**
     * get id round
     *
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * set id round
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * get round nr
     *
     * @return int
     */
    public int getRoundNr() {
        return this.roundNr;
    }

    /**
     * set roundnr
     *
     * @param roundNr
     */
    public void setRoundNr(int roundNr) {
        this.roundNr = roundNr;
    }

}
