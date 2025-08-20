package com.amit.core.designpattern.q.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {
	private String channelName;
	private String title;
	
	public Channel(String channelName) {
		this.channelName = channelName;
	}
	
	private List<Subscriber> subs = new ArrayList<Subscriber>();
	
	@Override
	public void subscribe(Subscriber sub) {
		subs.add(sub);
	}
	
	@Override
	public void unSubscribe(Observer sub) {
		subs.remove(sub);
	}
	
	//Calling for each subscriber and notifying them vedios has uploaded
	@Override
	public void notifySubscriber() {
		for (Observer sub : subs) {
			sub.update(title);
		}
	}
	
	@Override
	public void upload(String title) {
		this.title=title;
		notifySubscriber();
	}
	
}
