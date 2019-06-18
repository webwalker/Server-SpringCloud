package com.xujian.thinking.pattern.Structural.Flyweight;

// "ConcreteFlyweight" 
public class ConcreteFlyweight extends Flyweight {
	public void Operation(int extrinsicstate) {
		System.out.println("ConcreteFlyweight: " + extrinsicstate);
	}
}
