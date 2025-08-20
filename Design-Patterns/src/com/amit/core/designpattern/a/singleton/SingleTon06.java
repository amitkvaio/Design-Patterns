// In cash of Serialization and De-serialization
package com.amit.core.designpattern.a.singleton;

import java.io.Serializable;

public class SingleTon06 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static SingleTon06 singleTon = new SingleTon06();
	
	private SingleTon06() {
	}
	
	public static SingleTon06 getInstance() {
		return singleTon;
	}
	
	/*// implement readResolve method 
	// It is invoked when the object is de-serialized.
    protected Object readResolve() 
    { 
    	return singleTon; 
    } */
}
// check SingleTon06Client
