package com.amit.core.designpattern.o.waitnotify;

import java.util.Queue;
import java.util.Random;

public class Produser implements Runnable {
	
	Integer maxSize;
	Queue<Integer> sharedQueue;
	
	public Produser(Integer maxSize, Queue<Integer> queue) {
		this.maxSize = maxSize;
		this.sharedQueue = queue;
	}

	@Override
	public void run() {
		String thName = Thread.currentThread().getName();
		while (true) {
			synchronized (sharedQueue) {
				try {
					if (maxSize == sharedQueue.size()) {
						System.out.println("Que is full now !! " + thName +" thread is waiting ");
						sharedQueue.wait();
					}
					Random random = new Random();
					Integer num = random.nextInt(100);
					Thread.sleep(2000);
					System.out.println(thName + " added the number to the queue: " + num);
					sharedQueue.add(num);
					sharedQueue.notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
//http://tutorials.jenkov.com/java-concurrency/index.html
