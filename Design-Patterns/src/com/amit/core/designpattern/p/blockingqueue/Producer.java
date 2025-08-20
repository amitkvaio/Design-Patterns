package com.amit.core.designpattern.p.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private final BlockingQueue<Integer> blockingQueue;

	public Producer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			process();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public void process() throws InterruptedException {
		// put 5 integer into the queue
		String thName = Thread.currentThread().getName();
		/*for (int i = 1; i <= 5; i++) {
			System.out.println(thName +" Put : " + i);
			blockingQueue.put(i);
			System.out.println(thName +"Queue remainingCapacity : " + blockingQueue.remainingCapacity());
			Thread.sleep(1000);
		}*/
		int i=1;
		while(true) {
			System.out.println(thName +" Put : " + i);
			blockingQueue.put(i);
			i++;
			System.out.println(thName +"Queue remainingCapacity : " + blockingQueue.remainingCapacity());
			Thread.sleep(1000);
		}
	}
}
