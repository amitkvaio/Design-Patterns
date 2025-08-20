//Using Reflection
package com.amit.core.designpattern.a.singleton;

import java.lang.reflect.Constructor;

public class SingleTon07Client {
	
	public static void main(String[] args) {
		 SingleTon06 singleOne = SingleTon06.getInstance();
		 SingleTon06 singleTwo = null;
		try {
			Constructor[] constructors = SingleTon06.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				singleTwo = (SingleTon06) constructor.newInstance();
				break;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("HashCode : singleTon : "+singleOne.hashCode());
		System.out.println("HashCode : singleTwo : "+singleTwo.hashCode());
		 
	}
}

/*

HashCode : singleTon : 865113938
HashCode : singleTwo : 1442407170

Tow different object being created - so it destroy the single ton property.
***************************************************************************
To overcome issue raised by reflection, enums are used because java ensures internally that 
enum value is instantiated only once. Since java Enums are globally accessible, 
they can be used for singletons. Its only drawback is that it is not flexible i.e 
it does not allow lazy initialization.
*/