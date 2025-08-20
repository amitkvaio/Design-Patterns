package com.amit.core.designpattern.f.immutable;

import java.util.Collections;
import java.util.List;

public final class StduentUnmodifiable {
	private final String name;
	private final int age;
	private List<Address> addressList;

	public StduentUnmodifiable(final String name, final int age, final List<Address> addresslist) {
		this.name = name;
		this.age = age;
		this.addressList = addresslist;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public List<Address> getAddressList() {
		return Collections.unmodifiableList(addressList);
	}

	@Override
	public String toString() {
		return "StduentUnmodifiable [name=" + name + ", age=" + age + ", addressList=" + addressList + "]";
	}
}
