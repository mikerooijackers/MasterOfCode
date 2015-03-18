package Domein;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Round {

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
        
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

    public Round() {
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
        

	public int getRoundNr() {
		return this.roundNr;
	}

	public void setRoundNr(int roundNr) {
		this.roundNr = roundNr;
	}

}