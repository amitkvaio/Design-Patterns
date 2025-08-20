package com.amit.core.designpattern.e.proxy;

public class CustomerClient2 {
	public static void main(String[] args) {
		Customer customer = new CustomerProxyImpl();
		System.out.println(customer.getId());
		System.out.println(customer.getOrders());
		System.out.println(customer.getOrders().size());
		System.out.println("Finished");
	}
}

/*
 		orders are not being loaded so will use the customerproxy for this.
 
*/
