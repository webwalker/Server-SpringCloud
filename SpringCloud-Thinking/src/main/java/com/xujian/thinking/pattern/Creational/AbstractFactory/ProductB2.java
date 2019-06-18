package com.xujian.thinking.pattern.Creational.AbstractFactory;

// "ProductB2"
public class ProductB2 extends AbstractProductB {
	@Override
	public void Interact(AbstractProductA a) {
		System.out.println(this.getClass().getName() + " interacts with "
				+ a.getClass().getName());
	}
}
