package com.amit.core.designpattern.f.immutable;

public final class StudentClone {
	private final String firstName;
	private final String lastName;
	private final AddressClone address;

	public StudentClone(String firstName, String lastName, AddressClone address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public AddressClone getAddress() {
		AddressClone ad = null;
		try {
			ad = address.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ad;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}
}
