package com.amit.factory.design.pattern.client;

import com.amit.factory.design.pattern.asbtract.FoodFactory;
import com.amit.factory.design.pattern.asbtract.ItalianFoodFactory;
import com.amit.factory.design.pattern.drink.Drink;
import com.amit.factory.design.pattern.pizzafactory.Pizza;

public class UserClient {
	public static void main(String[] args) {
		// Choose Factory at runtime
		FoodFactory factory = new ItalianFoodFactory(); 

		Pizza pizza = factory.createPizza();
		Drink drink = factory.createDrink();

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		drink.serve();
	}
}
