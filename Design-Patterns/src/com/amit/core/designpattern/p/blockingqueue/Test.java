package com.amit.core.designpattern.p.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Bproduser implements Runnable{

	BlockingQueue<Integer> queue;
	Integer POISON;
	
	public Bproduser(BlockingQueue<Integer> qu,Integer poison) {
		this.queue=qu;
		this.POISON=poison;
	}
	
	@Override
	public void run() {
		try {
			process();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			while(true) {
				try {
					queue.put(POISON);
					break;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void process() throws InterruptedException {
		String thName = Thread.currentThread().getName();
		for (int i = 1; i <= 20 ; i++) {
			System.out.println(thName + "added element : "+i);
			queue.put(i);
			System.out.println(thName + "Remaing capacity is : "+queue.remainingCapacity());
			Thread.sleep(1000);
		}
	}
}

class Cconsumber implements Runnable{

	BlockingQueue<Integer> queue;
	public Cconsumber(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		try {
			process();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void process() throws InterruptedException {
		String thName = Thread.currentThread().getName();
		while(true) {
			Integer in = queue.take();
			System.out.println(thName + "taken the element : "+in);
			Thread.sleep(2000);
			if(in==-1) {
				break;
			}
		}
	}
}


public class Test {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
		Bproduser bproduser = new Bproduser(queue,-1);
		Cconsumber cconsumber = new Cconsumber(queue);
		Thread thproduser = new  Thread(bproduser,"[Produser] ");
		Thread thConsumer = new Thread(cconsumber, "[Consumber] ");
		thproduser.start();
		thConsumer.start();
		System.out.println("-------done-------");
	}
}
