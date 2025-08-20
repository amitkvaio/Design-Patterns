package com.amit.core.designpattern.c.c.depositfactory;

public class DenaBankDeposit implements Deposit {
	@Override
	public void depositMoney() {
		System.out.println("deposit money at Dena Bank");
	}
}
