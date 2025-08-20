package com.amit.core.designpattern.a.singleton;

public class SingleTon02 {
	public static SingleTon02 st = new SingleTon02();
	private SingleTon02() {
		
	}
	
	public static SingleTon02 getInstance() {
		return st;
	}
}
/*
By keeping the constructor private, no other class can instantiate this class.
The only way to get the object of this class is using the st static 
	variable which ensures only one object is there 
	
Providing a direct access to a class member is not a good idea. 
We will provide a method through which the st variable will get access, not directly.
As above shown in the code

Eager Initialization of the Object
**********************************
Eager initialization will be use when we insure that at least one time it being used in our application
	else there object will be created without any uses.

The one problem with this approach is that, the object would get created as soon as the class 
gets loaded into the JVM. If the object is never requested, there would be an object useless 
inside the memory.

It’s always a good approach that an object should get created when it is required. 
*/

