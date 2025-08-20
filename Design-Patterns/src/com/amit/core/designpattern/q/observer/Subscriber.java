package com.amit.core.designpattern.q.observer;

public class Subscriber implements Observer {
	
	private String subScriberName;
	private Subject channel;
	
	public Subscriber(String name) {
		this.subScriberName = name;
	}
	
	//How the subscriber come to know about the new vedio through the update.
	@Override
	public void update(String vedioName) {
		System.out.println("Hey, " + subScriberName + " " + vedioName);
	}
	
	//Subscriber should know which channel he is subscribering.
	@Override
	public void subscriberChannel(Subject ch) {
		this.channel = ch;
	}
}
