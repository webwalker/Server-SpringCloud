package com.xujian.thinking.pattern.Behavioral.Command;

// "Command" 
public abstract class Command {
	protected Receiver receiver;

	// Constructor
	public Command(Receiver receiver) {
		this.receiver = receiver;
	}

	public abstract void Execute();
}
