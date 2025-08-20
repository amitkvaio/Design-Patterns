package com.amit.core.designpattern.c.d.bankdepositeabstractfactory;

import com.amit.core.designpattern.c.b.bankfactory.Bank;
import com.amit.core.designpattern.c.c.depositfactory.CanaraBankDepoist;
import com.amit.core.designpattern.c.c.depositfactory.CityBankDeposit;
import com.amit.core.designpattern.c.c.depositfactory.DenaBankDeposit;
import com.amit.core.designpattern.c.c.depositfactory.Deposit;
import com.amit.core.designpattern.c.c.depositfactory.HDFCBankDeposit;

public class DepositFactory extends AbstractFactory {
	@Override
	public Deposit depositMoney(String deposit) {
		if (deposit == null) {
			return null;
		} else if ("CanaraBankDepoist".equalsIgnoreCase(deposit)) {
			return new CanaraBankDepoist();
		} else if ("CityBankDeposit".equalsIgnoreCase(deposit)) {
			return new CityBankDeposit();
		} else if ("DenaBankDeposit".equalsIgnoreCase(deposit)) {
			return new DenaBankDeposit();
		} else if ("HDFCBankDeposit".equalsIgnoreCase(deposit)) {
			return new HDFCBankDeposit();
		}
		return null;
	}

	@Override
	public Bank getBank(String bank) {
		return null;
	}
}
