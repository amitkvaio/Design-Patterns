//Cloning
package com.amit.core.designpattern.a.singleton;

public class SingleTon09 implements Cloneable {
	
	public static final SingleTon09 instance = new SingleTon09();
	private SingleTon09() {}
	
	public static SingleTon09 getInstance() {
		return instance;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
