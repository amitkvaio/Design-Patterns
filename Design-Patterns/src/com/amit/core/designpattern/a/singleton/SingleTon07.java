//The following example shows how you can protect your class from getting instantiated more than once
package com.amit.core.designpattern.a.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingleTon07 implements Serializable {

	private static final long serialVersionUID = 1L;

	public static SingleTon07 st = new SingleTon07();

	private SingleTon07() {
		if (st != null) {
			throw new IllegalStateException("Already created.");
		}
	}

	public static SingleTon07 getInstance() {
		return st;
	}

	private Object readResolve() throws ObjectStreamException {
		return st;
	}

	private Object writeReplace() throws ObjectStreamException {
		return st;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Singleton, cannot be clonned");
	}

	@SuppressWarnings("unused")
	private static Class getClass(String classname) throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader == null)
			classLoader = SingleTon06.class.getClassLoader();
		return (classLoader.loadClass(classname));
	}

}
/*
  
  How many way to break the singleton pattern
  ----------------------------------------- 
  • If the class is Serializable. 
  • If it’s Clonable. 
  • It can be break by Reﬂection. 
  • And also if, the class is loaded by multiple class loaders.

  	• Implement the readResolve() and writeReplace()methods in our singleton class and return the same object through them.
	• we should also implement the clone() method and throw an exception so that the singleton cannot be cloned.
	• An "if condition" inside the constructor can prevent the singleton from getting instantiated more than once using reﬂection.

	• To prevent the singleton getting instantiated from different class loaders, we can implement the getClass() method. 
	The above getClass() method associates the classloader with the current thread; 
	
	if that classloader is null, the method uses the same classloader that loaded the singleton class.

 */