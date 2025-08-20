package com.amit.core.designpattern.c.d.bankdepositeabstractfactory;

public class FactoryProvider {
	public static AbstractFactory getFactory(String option) {
		if (option == null) {
			return null;
		} else if ("Bank".equalsIgnoreCase(option)) {
			System.out.println("You have choosen Bank option");
			return new BankFactory();
		} else if ("Deposit".equalsIgnoreCase(option)) {
			System.out.println("You have choosen Deposit option");
			return new DepositFactory();
		}
		return null;
	}
}
