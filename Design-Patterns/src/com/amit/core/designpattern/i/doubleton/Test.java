package com.amit.core.designpattern.i.doubleton;

enum single{
	SINGLETON;
	private single() {
		System.out.println("single()-");
	}
	
	public void singleTonTest() {
		System.out.println("i am test");
	}
}

public class Test {
	public static void main(String[] args) {
		single.SINGLETON.singleTonTest();
		System.out.println(single.SINGLETON.hashCode());
		System.out.println(single.SINGLETON.hashCode());
		System.out.println(single.SINGLETON.hashCode());
		System.out.println(single.SINGLETON.hashCode());
		System.out.println(single.SINGLETON.hashCode());
	}
}
