package com.amit.core.designpattern.n.command;

public class RemoteControl {
	public Command  command;

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void pressButton() {
		command.execute();
	}
}

/*

So whatever command is passed in or pressed on a remote control it will perform that command.
*/