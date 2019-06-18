package com.xujian.thinking.pattern.Behavioral.Mediator;

// "ConcreteMediator" 
public class ConcreteMediator extends Mediator {
	private ConcreteColleague1 colleague1;
	private ConcreteColleague2 colleague2;

	public void setColleague1(ConcreteColleague1 value) {
		this.colleague1 = value;
	}

	public void setColleague2(ConcreteColleague2 value) {
		this.colleague2 = value;
	}

	@Override
	public void Send(String message, Colleague colleague) {
		if (colleague == colleague1) {
			colleague2.Notify(message);
		} else {
			colleague1.Notify(message);
		}
	}
}
