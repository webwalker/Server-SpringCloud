package com.xujian.thinking.pattern.Behavioral.Observer;

// "ConcreteObserver" 
public class ConcreteObserver extends Observer {
	private String name;
	private String observerState;
	private ConcreteSubject subject;

	/**
	 * @return the subject
	 */
	public ConcreteSubject getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(ConcreteSubject subject) {
		this.subject = subject;
	}

	// Constructor
	public ConcreteObserver(ConcreteSubject subject, String name) {
		this.subject = subject;
		this.name = name;
	}

	@Override
	public void Update() {
		observerState = subject.getSubjectState();
		System.out.println("Observer " + name + "'s new state is "
				+ observerState);
	}
}