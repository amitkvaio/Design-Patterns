//Using Enum
//VVI
package com.amit.core.designpattern.a.singleton;

public enum SingleTon08 {
	SINGLETON_ENUM;
	
	public void test() {
		System.out.println("From test() +"+this.hashCode());
	}
	
	public static void main(String[] args) {
		SingleTon08 en = SingleTon08.SINGLETON_ENUM;
		en.test();
		System.out.println(en.hashCode());
	}
}
/*

Although we can use all these techniques, there is one simple and easier way of creating a singleton class. 
As of JDK 1.5, we can create a singleton class using enums. 
The Enum constants are implicitly static and final and you cannot change their values once created.


we will get a compile time error when we attempt to explicitly instantiate an Enum object. 
As Enum gets loaded statically, it is thread-safe. The clone method in Enum is final which ensures 
that enum constants never get cloned. 

Enum is inherently serializable, the serialization mechanism ensures that duplicate 
instances are never created as a result of deserialization. 

Instantiation using reflection is also prohibited. 
These things ensure that no instance of an enum exists beyond the one defined by the enum constants.

*/
