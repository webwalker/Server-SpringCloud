package com.xujian.thinking.pattern.Behavioral.Memento;

// "Caretaker" 
public class Caretaker {
	private Memento memento;

	// Property
	/**
	 * @return the memento
	 */
	public Memento getMemento() {
		return memento;
	}

	/**
	 * @param memento
	 *            the memento to set
	 */
	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}
