package com.xujian.thinking.pattern.Behavioral.State;

// "Context" 
public class Context {
	private State state;

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(State state) {
		this.state = state;
		System.out.println("State: " + state.getClass().getName());
	}

	// Constructor
	public Context(State state) {
		this.setState(state);
	}

	public void Request() {
		state.Handle(this);
	}
}