package com.xujian.thinking.pattern.Creational.AbstractFactory;

// "Client" - the interaction environment of the products
public class Client {
	private AbstractProductA AbstractProductA;
	private AbstractProductB AbstractProductB;

	// Constructor
	public Client(AbstractFactory factory) {
		AbstractProductA = factory.CreateProductA();
		AbstractProductB = factory.CreateProductB();
	}

	public void Run() {
		AbstractProductB.Interact(AbstractProductA);
	}
}
