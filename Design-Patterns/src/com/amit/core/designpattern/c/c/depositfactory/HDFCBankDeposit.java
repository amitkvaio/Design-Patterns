package com.amit.core.designpattern.c.c.depositfactory;

public class HDFCBankDeposit implements Deposit {
	@Override
	public void depositMoney() {
		System.out.println("deposit Money at HDFC BANK");
	}
}
