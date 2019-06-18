package com.xujian.thinking.pattern.Structural.Bridge;

// "Abstraction"
public class Abstraction {
	public Implementor implementor;

	/**
	 * @param implementor
	 *            the implementor to set
	 */
	public void setImplementor(Implementor implementor) {
		this.implementor = implementor;
	}

	public void Operation() {
		implementor.Operation();
	}
}
