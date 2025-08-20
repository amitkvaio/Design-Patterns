package com.amit.core.designpattern.f.immutable;

public class AddressClone implements Cloneable {
	String firstLine;
	String secondLine;
	String city;

	public AddressClone(String firstLine, String secondLine, String city) {
		this.firstLine = firstLine;
		this.secondLine = secondLine;
		this.city = city;
	}
	
	@Override
	protected AddressClone clone() throws CloneNotSupportedException {
		return (AddressClone) super.clone();
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
		return "AddressClone [firstLine=" + firstLine + ", secondLine=" + secondLine + ", city=" + city + "]";
	}

}
