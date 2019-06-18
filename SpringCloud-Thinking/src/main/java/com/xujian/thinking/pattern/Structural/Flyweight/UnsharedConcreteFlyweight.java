package com.xujian.thinking.pattern.Structural.Flyweight;

// "UnsharedConcreteFlyweight" 
public class UnsharedConcreteFlyweight extends Flyweight {
	public void Operation(int extrinsicstate) {
		System.out.println("UnsharedConcreteFlyweight: " + extrinsicstate);
	}
}
