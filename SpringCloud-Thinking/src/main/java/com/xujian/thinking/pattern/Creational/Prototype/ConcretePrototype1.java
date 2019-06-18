package com.xujian.thinking.pattern.Creational.Prototype;

// "ConcretePrototype1"
public class ConcretePrototype1 extends Prototype {

	public ConcretePrototype1(String id) {
		super(id);
	}

	@Override
	public Prototype Clone() {
		// Shallow copy
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException exception) {
			System.err.println("AbstractSpoon is not Cloneable");
		}
		return (Prototype) object;
	}
}
