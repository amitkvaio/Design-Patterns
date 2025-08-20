package com.amit.core.designpattern.f.immutable;

public class StudentAddress02 {
	public static void main(String[] args) {
		Student st = new Student("Amit", "Kumar", new ChildAddress("Kadugodi", "WhiteFiled", "Bangalore"));
		Address ad = st.getAddress();
		System.out.println(ad);
		ad.setFirstLine("Marathalli");
	}
}
