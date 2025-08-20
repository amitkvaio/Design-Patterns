package com.amit.core.designpattern.p.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerProducerClient {
	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(3);
		Producer producer = new  Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);
		Thread thProducer = new Thread(producer,"Producer1");
		Thread thConsumer = new Thread(consumer);
		thProducer.start();
		thConsumer.start();
	}
}
