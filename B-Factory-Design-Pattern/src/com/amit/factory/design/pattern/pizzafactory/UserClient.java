package com.amit.factory.design.pattern.pizzafactory;

public class UserClient {

	public static void main(String[] args) {
		PizzaStore ps = new PizzaStore();
		ps.orderPizza("chicken");
	}
}
