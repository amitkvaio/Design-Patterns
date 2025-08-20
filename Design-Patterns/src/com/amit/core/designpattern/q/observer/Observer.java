package com.amit.core.designpattern.q.observer;

public interface Observer {

	//How the subscriber come to know about the new vedio through the update.
	void update(String vedioName);

	//Subscriber should know which channel he is subscribing
	void subscriberChannel(Subject ch);

}