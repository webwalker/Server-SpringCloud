package com.xujian.thinking.pattern.Creational.AbstractFactory;

// "ConcreteFactory1"
public class ConcreteFactory1 extends AbstractFactory {

	@Override
	public AbstractProductA CreateProductA() {
		return new ProductA1();
	}

	@Override
	public AbstractProductB CreateProductB() {
		return new ProductB1();
	}
}
