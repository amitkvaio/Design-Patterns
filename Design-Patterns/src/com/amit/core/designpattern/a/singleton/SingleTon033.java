package com.amit.core.designpattern.a.singleton;

public class SingleTon033 {
	public static SingleTon033 st = null;

	private SingleTon033() {
		System.out.println("Instance created by " + Thread.currentThread().getName());
	}

	public static SingleTon033 getInstance() {
		if (st == null) {
			// Simulating delay for thread switch
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			st = new SingleTon033(); // multiple threads can reach here
		}
		return st;
	}

	public static void main(String[] args) {
		Runnable task = () -> {
			SingleTon033 instance = SingleTon033.getInstance();
			System.out.println(
					"Instance hash: " + instance.hashCode() + " - Thread: " + Thread.currentThread().getName());
		};

		Thread t1 = new Thread(task, "Thread-1");
		Thread t2 = new Thread(task, "Thread-2");

		t1.start();
		t2.start();
	}
}
