package com.amit.factory.design.pattern.asbtract;

import com.amit.factory.design.pattern.drink.Drink;
import com.amit.factory.design.pattern.drink.MasalaChai;
import com.amit.factory.design.pattern.pizzafactory.Pizza;
import com.amit.factory.design.pattern.pizzafactory.VeggiePizza;

public class IndianFoodFactory implements FoodFactory {

	@Override
	public Pizza createPizza() {
		return new VeggiePizza();
	}

	@Override
	public Drink createDrink() {
		return new MasalaChai();
	}
}
