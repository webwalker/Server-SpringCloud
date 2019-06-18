package com.xujian.thinking.pattern.Structural.Decorator;

// "ConcreteDecoratorB"
public class ConcreteDecoratorB extends Decorator {
	public void Operation() {
		super.Operation();
		AddedBehavior();
		System.out.println("ConcreteDecoratorB.Operation()");
	}

	void AddedBehavior() {
	}
}
