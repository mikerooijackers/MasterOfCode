package Domein;

import java.util.Calendar;

public class Hint {

	/**
	 * numeber of a hint
	 */
	private int hintId;
	/**
	 * name of a hint
	 */
	private String name;
	/**
	 * description of a hint
	 */
	private String description;
	/**
	 * delay of a hint
	 */
	private Calendar delay;

	public int getHintId() {
		return this.hintId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDelay() {
		return this.delay;
	}

	public void setDelay(Calendar delay) {
		this.delay = delay;
	}

}