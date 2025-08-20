package com.amit.core.designpattern.c.b.bankfactory;

public class HDFCBank implements Bank {
	@Override
	public void go() {
		System.out.println("goBank method of HDFCBANK");
	}
}
