package com.xujian.thinking.pattern.Behavioral.State;

// "ConcreteStateA"
public class ConcreteStateA extends State {

	@Override
	public void Handle(Context context) {
		context.setState(new ConcreteStateB());
	}

}
