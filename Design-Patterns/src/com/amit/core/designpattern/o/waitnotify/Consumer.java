package com.amit.core.designpattern.o.waitnotify;

import java.util.Queue;

public class Consumer implements Runnable {
	
	Queue<Integer> sharedQueue;
	
	public Consumer(Queue<Integer> queue) {
		this.sharedQueue = queue;
	}
	
	@Override
	public void run() {
		String thName = Thread.currentThread().getName();
		while (true) {
			synchronized (sharedQueue) {
				try {
					if (sharedQueue.isEmpty()) {
						System.out.println(thName + " Waiting as Queue is empty !!");
						sharedQueue.wait();
					}
					Integer num = sharedQueue.poll();
					Thread.sleep(3000);
					System.out.println("Consumed Number " + num + " by " + thName);
					sharedQueue.notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
