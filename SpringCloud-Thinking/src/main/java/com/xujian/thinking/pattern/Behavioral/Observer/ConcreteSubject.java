package com.xujian.thinking.pattern.Behavioral.Observer;

// "ConcreteSubject"
public class ConcreteSubject extends Subject {
	private String subjectState;

	// Property
	/**
	 * @return the subjectState
	 */
	public String getSubjectState() {
		return subjectState;
	}

	/**
	 * @param subjectState
	 *            the subjectState to set
	 */
	public void setSubjectState(String subjectState) {
		this.subjectState = subjectState;
	}
}
