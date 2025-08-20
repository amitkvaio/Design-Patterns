package com.amit.core.designpattern.f.immutable;

final class SingleP {
	private final String name;
	private final int roll;

	public SingleP(final String name, final int roll) {
		this.name = name;
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public int getRoll() {
		return roll;
	}
}

public class Immutable {
	public static void main(String[] args) {
		SingleP s1 = new SingleP("amit", 101);
		System.out.println(s1.getName());
		System.out.println(s1.getRoll());
		System.out.println("Name--");
	}
}
/*

Immutable class means that once an object is created, we cannot change its content. 
	In Java, all the wrapper classes (like String, Boolean, Byte, Short) and String class is immutable. 
	We can create our own immutable class as well.

Following are the requirements:
• Class must be declared as final (So that child classes can’t be created)
• Data members in the class must be declared as final 
	(So that we can’t change the value of it after object creation)
• A parameterized constructor
• Getter method for all the variables in it
• No setters(To not have option to change the value of the instance variable) 

*/
