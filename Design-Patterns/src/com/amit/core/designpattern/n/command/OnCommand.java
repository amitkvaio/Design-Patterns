package com.amit.core.designpattern.n.command;

public class OnCommand implements Command {

	Television television;
	
	public OnCommand(Television television) {
		super();
		this.television = television;
	}



	@Override
	public void execute() {
		television.on();
	}
	
}
