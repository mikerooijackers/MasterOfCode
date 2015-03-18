package Domein;

public class Round {

	/**
	 * number of a round
	 */
	private int roundNr;
	/**
	 * duration of a round
	 */
	private dateTime duration;
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

	public dateTime getDuration() {
		return this.duration;
	}

	public void setDuration(dateTime duration) {
		this.duration = duration;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}