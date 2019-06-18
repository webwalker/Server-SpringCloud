package com.xujian.thinking.pattern.Creational.AbstractFactory;

// "ConcreteFactory2"
public class ConcreteFactory2 extends AbstractFactory {
	@Override
	public AbstractProductA CreateProductA() {
		return new ProductA2();
	}

	@Override
	public AbstractProductB CreateProductB() {
		return new ProductB2();
	}
}
