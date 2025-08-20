package com.amit.core.designpattern.c.d.bankdepositeabstractfactory;

import com.amit.core.designpattern.c.b.bankfactory.Bank;
import com.amit.core.designpattern.c.b.bankfactory.CanaraBank;
import com.amit.core.designpattern.c.b.bankfactory.CitiBank;
import com.amit.core.designpattern.c.b.bankfactory.DenaBank;
import com.amit.core.designpattern.c.b.bankfactory.HDFCBank;
import com.amit.core.designpattern.c.c.depositfactory.Deposit;

public class BankFactory extends AbstractFactory {

	@Override
	public Bank getBank(String bank) {
		if (bank == null) {
			return null;
		} else if ("CanaraBank".equalsIgnoreCase(bank)) {
			return new CanaraBank();
		} else if ("CitiBank".equalsIgnoreCase(bank)) {
			return new CitiBank();
		} else if ("DenaBank".equalsIgnoreCase(bank)) {
			return new DenaBank();
		} else if ("HDFCBank".equalsIgnoreCase(bank)) {
			return new HDFCBank();
		}
		return null;
	}

	@Override
	public Deposit depositMoney(String deposit) {
		return null;
	}
}
