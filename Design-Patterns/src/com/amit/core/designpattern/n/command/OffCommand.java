package com.amit.core.designpattern.n.command;

public class OffCommand implements Command {

	Television television;
	
	public OffCommand(Television television) {
		super();
		this.television = television;
	}

	@Override
	public void execute() {
		television.off();
	}
	
}
