package com.amit.core.designpattern.j.facade.problem;

public class OrderProcessor {
	public boolean checkStock(String name) {
		System.out.println("Checking stocks!");
		return true;
	}
	
	public String placeOrder(String name,int quantity) {
		System.out.println("Order Placed");
		return "12345";
	}
	
	public void shipOrder(String orderId) {
		System.out.println("Order Shipped");
	}
}
