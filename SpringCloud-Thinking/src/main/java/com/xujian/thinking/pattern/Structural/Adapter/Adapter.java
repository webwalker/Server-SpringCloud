package com.xujian.thinking.pattern.Structural.Adapter;

// "Adapter" 
public class Adapter extends Target {
	private Adaptee adaptee = new Adaptee();

	@Override
	public void Request() {
		// Possibly do some other work
		// and then call SpecificRequest
		adaptee.SpecificRequest();
	}
}
