package com.amit.core.designpattern.p.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private final BlockingQueue<Integer> blockingQueue;

	public Consumer(BlockingQueue<Integer> bQueue) {
		this.blockingQueue = bQueue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Integer take = blockingQueue.poll();
				process(take);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}

	private void process(Integer take) throws InterruptedException {
		System.out.println("[Consumer] Take : " + take);
		Thread.sleep(2000);
	}
}
