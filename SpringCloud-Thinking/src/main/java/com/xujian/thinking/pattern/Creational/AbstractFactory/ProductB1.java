package com.xujian.thinking.pattern.Creational.AbstractFactory;

// "ProductB1"
public class ProductB1 extends AbstractProductB {

	@Override
	public void Interact(AbstractProductA a) {
		System.out.println(this.getClass().getName() + " interacts with "
				+ a.getClass().getName());
	}
}
