package com.xujian.thinking.pattern.Behavioral.Memento;

// "Memento"
public class Memento {
	private String state;

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	// Constructor
	public Memento(String state) {
		this.state = state;
	}
}
