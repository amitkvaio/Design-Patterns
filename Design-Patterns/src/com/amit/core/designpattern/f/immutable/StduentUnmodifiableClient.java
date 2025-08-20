package com.amit.core.designpattern.f.immutable;

import java.util.ArrayList;
import java.util.List;

public class StduentUnmodifiableClient {
	public static void main(String[] args) {
		
		Address ad1=new Address("Kadugodi", "Hanumanthappa", "Bangalore");
		Address ad2=new Address("Marathalli", "KalaMandir", "Bangalore");
		List<Address> addList = new ArrayList<Address>();
		addList.add(ad1);
		addList.add(ad2);
		
		StduentUnmodifiable std = new StduentUnmodifiable("Amit", 30,addList );
		System.out.println("Std:"+std);
		std.getAddressList().remove(0);
		System.out.println(std.getAddressList());
	}
}
