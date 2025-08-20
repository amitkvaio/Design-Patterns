package com.amit.core.designpattern.n.command;

public class Person {
	public static void main(String[] args) {
		Television television = new Television();
		RemoteControl control = new RemoteControl();
		OnCommand command = new OnCommand(television);
		control.setCommand(command);
		control.pressButton();
		System.out.println("Done");
	}
}

/*
The person will first create an instance of the receiver which is the television television.
Next he has to create an instance of the invoker which is the remote control.
Then Create the command which he wants to execute.
Set the command to the controller

*/