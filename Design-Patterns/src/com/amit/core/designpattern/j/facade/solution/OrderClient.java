package com.amit.core.designpattern.j.facade.solution;

public class OrderClient {
	public static void main(String[] args) {
		
		OrderFacade facade = new OrderFacade();
		facade.processOrder("MacBook", 10);
		/*
		OrderProcessor orderProcessor = new OrderProcessor();
		if(orderProcessor.checkStock("MacBook")){
			String placeId = orderProcessor.placeOrder("MacBook", 10);
			orderProcessor.shipOrder(placeId);
		}
		*/
	}
}
/*

Run the OrderClient and we can see  that checking stock order placed order shipped, because we

have invoked those three methods, but we have to, as a client, the client application.

Our class will have to create the instance and then write all this logic.

And this logic will be repeated across client applications that are trying to use the order processor

That is where the facade pattern comes in.
****************************************
After using facade now the code looks so simple.

Instead of repeating the same logic across the clients and making multiple calls to the same instance,

if it is a network call and it is very expensive.

That is where Facade is very powerful and that is where it was introduced.

Initially, the client code becomes much simpler and they will use the facade instead of directly using

the order processor 


*/