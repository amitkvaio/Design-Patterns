package com.amit.core.designpattern.a.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingleTon06Client {
	public static void main(String[] args) {
		SingleTon06 singleTon = SingleTon06.getInstance();
		try {
			serialization(singleTon);
			SingleTon06 single = deserilization("test.ser");
			System.out.println("HashCode : singleTon : "+singleTon.hashCode());
			System.out.println("HashCode : single : "+single.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void serialization(SingleTon06 singleTon) throws IOException {
		FileOutputStream outputStream = new FileOutputStream("test.ser");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(singleTon);
		System.out.println("Serialization has been done!!!");
		outputStream.close();
	}
	
	public static SingleTon06 deserilization(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
		SingleTon06 single = (SingleTon06)inputStream.readObject();
		return single;
	}
}
/*
output :
Serialization has been done!!!
HashCode : singleTon : 589431969
HashCode : single : 1078694789

So it destroys the singleton pattern, 
To overcome this scenario all we need to do it provide the implementation of readResolve() method.
in serialized class
*/
