package com.amit.factory.design.pattern.asbtract;

import com.amit.factory.design.pattern.drink.Coke;
import com.amit.factory.design.pattern.drink.Drink;
import com.amit.factory.design.pattern.pizzafactory.CheesePizza;
import com.amit.factory.design.pattern.pizzafactory.Pizza;

public class ItalianFoodFactory implements FoodFactory {

	public Pizza createPizza() {
		return new CheesePizza();
	}

	public Drink createDrink() {
		return new Coke();
	}
}
