package Domein;

import java.util.Calendar;

public class Round {

	/**
	 * number of a round
	 */
	private int roundNr;
	/**
	 * duration of a round
	 */
	private Calendar duration;
	/**
	 * Status of a round
	 */
	private Status status;

	public int getRoundNr() {
		return this.roundNr;
	}

	public void setRoundNr(int roundNr) {
		this.roundNr = roundNr;
	}

	public Calendar getDuration() {
		return this.duration;
	}

	public void setDuration(Calendar duration) {
		this.duration = duration;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}