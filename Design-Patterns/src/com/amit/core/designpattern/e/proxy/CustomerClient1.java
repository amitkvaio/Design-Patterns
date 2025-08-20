package com.amit.core.designpattern.e.proxy;

public class CustomerClient1 {
	public static void main(String[] args) {
		Customer customer = new CustomerImpl();
		System.out.println(customer.getId());
		System.out.println(customer.getOrders());
		System.out.println("Finished");
	}
}

/*
	orders are not being loaded so will use the customerproxy for this. 
*/
