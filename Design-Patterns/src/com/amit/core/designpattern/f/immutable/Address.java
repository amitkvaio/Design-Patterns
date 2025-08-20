package com.amit.core.designpattern.f.immutable;

public class Address {
	String firstLine;
	String secondLine;
	String city;

	public Address(String firstLine, String secondLine, String city) {
		this.firstLine = firstLine;
		this.secondLine = secondLine;
		this.city = city;
	}

	
	public String getFirstLine() {
		return firstLine;
	}


	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}


	public String getSecondLine() {
		return secondLine;
	}


	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Address [firstLine=" + firstLine + ", secondLine=" + secondLine + ", city=" + city + "]";
	}

	
}
