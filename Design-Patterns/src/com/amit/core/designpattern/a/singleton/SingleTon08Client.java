//Using Enum
package com.amit.core.designpattern.a.singleton;

import java.lang.reflect.Constructor;

public class SingleTon08Client {
	public static void main(String[] args) {
		SingleTon08 singleOne = SingleTon08.SINGLETON_ENUM;
		SingleTon08 singleTwo = null;
		try {
			Constructor[] constructors = SingleTon08.class.getDeclaredConstructors();
			/*for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				singleTwo = (SingleTon06) constructor.newInstance();
				break;
			}*/
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("HashCode : singleTon : " + singleOne.hashCode());
		System.out.println("HashCode : singleTwo : " + singleTwo.hashCode());

	}
}

/*

Overcome reflection issue: 
	To overcome issue raised by reflection, enums are used because java ensures internally 
	that enum value is instantiated only once. Since java Enums are globally accessible, 
	they can be used for singletons. Its only drawback is that it is not flexible i.e 
	it does not allow lazy initialization.

As enums don’t have any constructor so it is not possible for Reflection to utilize it. 
	Enums have their by-default constructor, we can’t invoke them by ourself. 
	JVM handles the creation and invocation of enum constructors internally. 
	As enums don’t give their constructor definition to the program, it is not possible 
	for us to access them by Reflection also. Hence, reflection can’t break 
	singleton property in case of enums.

*/