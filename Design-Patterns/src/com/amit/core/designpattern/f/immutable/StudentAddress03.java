package com.amit.core.designpattern.f.immutable;

public class StudentAddress03 {
	public static void main(String[] args) {
		StudentClone st = new StudentClone("Amit", "Kumar", new AddressClone("Kadugodi", "WhiteFiled", "Bangalore"));
		AddressClone ad = st.getAddress();
		System.out.println("Original Object : " +ad);

		ad.setFirstLine("Marathalli");
		ad.setSecondLine("Kalamandir");
		ad.setCity("Bangalore");
		
		System.out.println("After Changes: "+st.getAddress());
	}
}
/*
Even  if we changed values  inside cloned address object,  it has not affected original Address value  
inside User object.
*/
