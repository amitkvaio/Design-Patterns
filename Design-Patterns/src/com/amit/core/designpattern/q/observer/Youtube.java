package com.amit.core.designpattern.q.observer;

public class Youtube {
	public static void main(String[] args) {
		
		//Creating the channel
		Subject channel = new Channel("GFG");
		
		//Creating the subscriber
		Subscriber sub1 = new Subscriber("Amit");
		Subscriber sub2 = new Subscriber("Raja");
		Subscriber sub3 = new Subscriber("Sunil");
		Subscriber sub4 = new Subscriber("Roshan");
		Subscriber sub5 = new Subscriber("Niraj");
		
		//Adding into the list -> Preparing the list of subscriber
		channel.subscribe(sub1);
		channel.subscribe(sub2);
		channel.subscribe(sub3);
		channel.subscribe(sub4);
		channel.subscribe(sub5);
		
		//Each subscriber has to subscriber their desire channel
		sub1.subscriberChannel(channel);
		sub2.subscriberChannel(channel);
		sub3.subscriberChannel(channel);
		sub4.subscriberChannel(channel);
		sub5.subscriberChannel(channel);
		
		//upload new vedios
		channel.upload("Observer Desing pattern vedios has uploaded!! Please watch.");
		
		//un subscribing GFG channel by Sunil
		channel.unSubscribe(sub3);
		
		System.out.println("*****************************************************");
		//upload again new vedios
		channel.upload("Interview Prepration vedios has uploaded!! Please watch.");
		
	}
}


//Observer will Observe the subject