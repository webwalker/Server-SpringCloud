package com.xujian.thinking.pattern.Creational.Factory;

// "ConcreteCreator"
public class ConcreteCreatorB extends Creator {
	@Override
	public Product FactoryMethod() {
		return new ConcreteProductB();
	}
}