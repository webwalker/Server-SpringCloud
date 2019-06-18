package com.xujian.thinking.pattern.Behavioral.Command;

// "Invoker" 
public class Invoker {
	private Command command;

	public void SetCommand(Command command) {
		this.command = command;
	}

	public void ExecuteCommand() {
		command.Execute();
	}
}
