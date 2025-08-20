package com.amit.core.designpattern.a.singleton;

public class SinleTon10Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		SingleTon10 singleOne = SingleTon10.getInstace();
		SingleTon10 singleTwo = (SingleTon10)singleOne.clone();
		
		System.out.println("singleOne : "+singleOne.hashCode());
		System.out.println("singleTwo : "+singleTwo.hashCode());
	}
}
