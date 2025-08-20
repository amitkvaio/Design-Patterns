package com.amit.core.designpattern.a.singleton;

public class SingleTon10 implements Cloneable {
	public static final SingleTon10 instance = new SingleTon10();
	private SingleTon10() {}
	
	
	public static SingleTon10 getInstace () {
		return instance;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Single Object is already created.");
	}
	
	// OR
	
	/*@Override
	protected SingleTon10 clone() throws CloneNotSupportedException {
		return getInstace();
	}*/
	
}
