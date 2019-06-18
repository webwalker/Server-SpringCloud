package com.xujian.thinking.pattern.Creational.Prototype;

// "ConcretePrototype2"
public class ConcretePrototype2 extends Prototype {

	public ConcretePrototype2(String id) {
		super(id);
	}

	@Override
	public Prototype Clone() {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException exception) {
			System.err.println("AbstractSpoon is not Cloneable");
		}
		return (Prototype) object;
	}
}
