package com.xujian.thinking.pattern.Behavioral.Memento;

// "Originator" 
public class Originator {
	private String state;

	// Property
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
		System.out.println("State = " + state);
	}

	public Memento CreateMemento() {
		return (new Memento(state));
	}

	public void SetMemento(Memento memento) {
		System.out.println("Restoring state");
		setState(memento.getState());
	}
}