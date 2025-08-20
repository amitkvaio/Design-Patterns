package com.amit.core.designpattern.q.observer;

public interface Subject {

	void subscribe(Subscriber sub);

	void unSubscribe(Observer sub);

	//Calling for each subscriber and notifying them vedios has uploaded
	void notifySubscriber();

	void upload(String title);

}