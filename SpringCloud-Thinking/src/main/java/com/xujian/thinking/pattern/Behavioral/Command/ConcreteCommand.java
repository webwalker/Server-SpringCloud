package com.xujian.thinking.pattern.Behavioral.Command;

// "ConcreteCommand" 
public class ConcreteCommand extends Command {

	public ConcreteCommand(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void Execute() {
		receiver.Action();
	}
}