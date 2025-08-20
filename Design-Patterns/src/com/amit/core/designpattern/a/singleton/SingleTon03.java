package com.amit.core.designpattern.a.singleton;

public class SingleTon03 {
	public static SingleTon03 st = null;
	private SingleTon03() {
		
	}
	public static SingleTon03 getInstance() {
		if(st==null) {
			st = new SingleTon03();
		}
		return st;
	}
}

/*

Lazy Initialization of object
*****************************
object will be created when the class being used.

So, we will create an object on the first  call and then will return the same object on other 
successive calls

Note :  But this code will fail in a multi-threaded environment.
*/
