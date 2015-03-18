package Domein;

import java.util.Calendar;

public class Competition {

	/**
	 * id of a competition
	 */
	private int competitionId;
	/**
	 * name of a competition
	 */
	private String name;
	/**
	 * Score of a competition
	 */
	private float score;
	/**
	 * start time of a competition
	 */
	private Calendar startTime;
	private Status status;

	public int getCompetitionId() {
		return this.competitionId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getScore() {
		return this.score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public Calendar getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

}