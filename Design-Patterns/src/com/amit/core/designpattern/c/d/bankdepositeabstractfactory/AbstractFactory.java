package com.amit.core.designpattern.c.d.bankdepositeabstractfactory;

import com.amit.core.designpattern.c.b.bankfactory.Bank;
import com.amit.core.designpattern.c.c.depositfactory.Deposit;

public abstract class AbstractFactory {
	abstract Bank getBank(String bank);
	abstract Deposit depositMoney(String deposit);
}
