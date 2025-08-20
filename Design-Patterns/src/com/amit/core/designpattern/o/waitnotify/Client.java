package com.amit.core.designpattern.o.waitnotify;

import java.util.LinkedList;
import java.util.Queue;

public class Client {
	public static void main(String[] args) {
		Queue<Integer> sharedQueue = new LinkedList<Integer>();
		Produser p1 = new Produser(4, sharedQueue);
		Consumer c1 = new Consumer(sharedQueue);
		
		Thread produserThread = new Thread(p1, "PRODUSER");
		Thread consumerThread = new Thread(c1, "CONSUMER");
		
		produserThread.start();
		consumerThread.start();
		System.out.println("Main end");
	}
}
