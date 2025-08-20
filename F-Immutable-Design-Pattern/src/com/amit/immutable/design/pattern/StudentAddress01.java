package com.amit.immutable.design.pattern;

public class StudentAddress01 {
	public static void main(String[] args) {
		Student st = new Student("Amit", "Kumar", new Address("Kadugodi", "WhiteFiled", "Bangalore"));
		System.out.println("St Before :"+st);
		Address ad = st.getAddress();
		
		ad.setFirstLine("Marathalli");
		ad.setSecondLine("Kalamandir");
		ad.setCity("Bangalore");
		System.out.println("St After :"+st);
	}
}

/*
Here Address object is getting changes so - Address object is not immutable.

*/