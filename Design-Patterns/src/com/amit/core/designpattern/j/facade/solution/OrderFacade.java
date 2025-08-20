package com.amit.core.designpattern.j.facade.solution;

public class OrderFacade {
	public void processOrder(String name,int quantity) {
		OrderProcessor orderProcessor = new OrderProcessor();
		if(orderProcessor.checkStock(name)){
			String placeId = orderProcessor.placeOrder(name, quantity);
			orderProcessor.shipOrder(placeId);
		}
	}
}
