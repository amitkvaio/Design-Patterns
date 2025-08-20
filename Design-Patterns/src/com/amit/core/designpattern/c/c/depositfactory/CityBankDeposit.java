package com.amit.core.designpattern.c.c.depositfactory;

public class CityBankDeposit implements Deposit {
	@Override
	public void depositMoney() {
		System.out.println("deposit money at City Bank");
	}
}
