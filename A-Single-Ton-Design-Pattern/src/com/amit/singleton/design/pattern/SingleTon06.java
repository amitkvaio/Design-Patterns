// In cash of Serialization and De-serialization
package com.amit.singleton.design.pattern;

import java.io.Serializable;

import javax.naming.OperationNotSupportedException;

public class SingleTon06 implements Serializable {

	private static final long serialVersionUID = 1L;
	private static SingleTon06 singleTon;

	private SingleTon06() throws OperationNotSupportedException {
		if (singleTon != null) {
			throw new OperationNotSupportedException("Object creation is not supported!!");
		}
	}

	public static SingleTon06 getInstance() throws OperationNotSupportedException {
		if (singleTon == null) {
			singleTon = new SingleTon06();
		}
		return singleTon;
	}
}
