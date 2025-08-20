package com.amit.core.designpattern.j.facade.problem;

public class OrderClient {
	public static void main(String[] args) {
		OrderProcessor orderProcessor = new OrderProcessor();
		if(orderProcessor.checkStock("MacBook")){
			String placeId = orderProcessor.placeOrder("MacBook", 10);
			orderProcessor.shipOrder(placeId);
		}
	}
}
/*

Run the OrderClient and we can see  that checking stock order placed order shipped, because we

have invoked those three methods, but we have to, as a client, the client application.

Our class will have to create the instance and then write all this logic.

And this logic will be repeated across client applications that are trying to use the order processor

That is where the facade pattern comes in.
****************************************

*/