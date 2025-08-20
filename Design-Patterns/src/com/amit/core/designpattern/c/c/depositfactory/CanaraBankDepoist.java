package com.amit.core.designpattern.c.c.depositfactory;

public class CanaraBankDepoist implements Deposit {
	@Override
	public void depositMoney() {
		System.out.println("depositMoney at Canara Bank");
	}
}
