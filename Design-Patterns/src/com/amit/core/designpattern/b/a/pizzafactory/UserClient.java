package com.amit.core.designpattern.b.a.pizzafactory;

public class UserClient {

	public static void main(String[] args) {
		PizzaStore ps = new PizzaStore();
		ps.orderPizza("chicken");
	}
}
