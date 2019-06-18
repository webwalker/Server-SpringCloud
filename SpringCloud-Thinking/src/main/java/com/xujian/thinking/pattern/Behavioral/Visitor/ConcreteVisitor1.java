package com.xujian.thinking.pattern.Behavioral.Visitor;

// "ConcreteVisitor1" 
public class ConcreteVisitor1 extends Visitor {

	@Override
	public void VisitConcreteElementA(ConcreteElementA concreteElementA) {
		System.out.println(concreteElementA.getClass().getName()
				+ " visited by " + this.getClass().getName());
	}

	@Override
	public void VisitConcreteElementB(ConcreteElementB concreteElementB) {
		System.out.println(concreteElementB.getClass().getName()
				+ " visited by " + this.getClass().getName());

	}
}
