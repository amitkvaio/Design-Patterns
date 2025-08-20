package com.amit.singleton.design.pattern;

public class SingleTon01 {
	public static SingleTon01 sc = new SingleTon01();
	/*
		As we know, there is only one copy of the static variables of a class.
		As far as, the client code is using this sc static variable its fine. 
		But, if the client uses a new operator there would be a new instance of this class.
	*/
}

class Client{
	public static void main(String[] args) {
		System.out.println(SingleTon01.sc);
		System.out.println(new SingleTon01());
		System.out.println(new SingleTon01());
	}
}
