package com.amit.factory.design.pattern.asbtract;

import com.amit.factory.design.pattern.drink.Drink;
import com.amit.factory.design.pattern.pizzafactory.Pizza;

public interface FoodFactory {
	Pizza createPizza();
	Drink createDrink();
}
