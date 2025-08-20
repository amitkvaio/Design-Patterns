package com.amit.core.designpattern.c.d.bankdepositeabstractfactory;

import com.amit.core.designpattern.c.b.bankfactory.Bank;
import com.amit.core.designpattern.c.c.depositfactory.Deposit;

public class Manager01 {
	public static void main(String[] args) {
		AbstractFactory bankFactory = FactoryProvider.getFactory("BANK");
		AbstractFactory deposit = FactoryProvider.getFactory("Deposit");

		Bank canaraBank = bankFactory.getBank("CanaraBank");
		canaraBank.go();

		Bank citiBank = bankFactory.getBank("CitiBank");
		citiBank.go();

		Bank denaBank = bankFactory.getBank("DenaBank");
		denaBank.go();

		Bank hdfcBank = bankFactory.getBank("HDFCBank");
		hdfcBank.go();
		System.out.println("***************************");
		Deposit dep = deposit.depositMoney("CanaraBankDepoist");
		dep.depositMoney();
	}
}
