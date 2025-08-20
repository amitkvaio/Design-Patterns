package com.amit.core.designpattern.a.singleton;

public class SingleTon09Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		SingleTon09 singleOne = SingleTon09.getInstance();
		SingleTon09 singleTwo = (SingleTon09)singleOne.clone();
		
		System.out.println("singleOne : "+singleOne.hashCode());
		System.out.println("singleTwo : "+singleTwo.hashCode());
	}
}

/*
output : 
singleOne : 865113938
singleTwo : 1442407170
-- Creating two different object using cloning violating the singleTon Design Pattern
 	Cloning is a concept to create duplicate objects. 
 	Using clone we can create copy of object. 
 	Suppose, we ceate clone of a singleton object, 
 	then it wil create a copy that is there are two instances of a singleton class, 
 	Hence the class is no more singleton. 
 	
Overcome Cloning issue:- 
------------------------
To overcome this issue, override clone() method and throw an exception from 
clone method that is CloneNotSupportedException or return the same object.  
Now whenever user will try to create clone of singleton object, 
it will throw exception and hence our class remains singleton.
Check SingleTon10 and SinleTon10Client
*/