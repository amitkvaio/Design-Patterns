package com.amit.core.designpattern.a.singleton;

public class SingleTon04 {
	public static SingleTon04 st = null;
	
	private SingleTon04() {
		
	}
	
	public static synchronized SingleTon04 getInstance() {
		if(st == null) {
			st = new SingleTon04();
		}
		return st;
	}
}


/*

Imagine two threads concurrently
********************************
accessing the class, thread t1 gives the first call to the getInstance() method, 
it checks if the static variable st is null and then gets interrupted due to some reason. 

Another thread t2 calls the getInstance() method successfully passes the if check
and instantiates the object. Then, thread t1 gets awake and it also creates the object. 
At this time, there would be two objects of this class.

To avoid this, we will use the synchronized keyword to the getInstance() method. 
With this way, we force every thread to wait its turn before it can enter the method. 
So, no two threads will enter the method at the same time. 

The Synchronization comes with a price, it will decrease the performance, but if the call to 
	the getInstance() method isn’t causing a substantial overhead for your application,

*/