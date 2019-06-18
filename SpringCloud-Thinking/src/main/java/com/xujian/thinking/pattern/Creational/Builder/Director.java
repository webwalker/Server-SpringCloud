package com.xujian.thinking.pattern.Creational.Builder;

// "Director" 
public class Director {
	// Builder uses a complex series of steps
	public void Construct(Builder builder) {
		builder.BuildPartA();
		builder.BuildPartB();
	}
}