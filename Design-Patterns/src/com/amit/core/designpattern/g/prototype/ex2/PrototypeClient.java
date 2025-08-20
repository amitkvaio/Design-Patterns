package com.amit.core.designpattern.g.prototype.ex2;

public class PrototypeClient {
	public static void main(String[] args) {
		Dog dog = (Dog)AnimalCache.getAnimal("dog");
		System.out.println(dog.toString());
		
		Dog cloneddog1 = (Dog)AnimalCache.getAnimal("dog");
		cloneddog1.setName("Twinkle");
		cloneddog1.setAge(5);
		cloneddog1.setColor("Brown");
		System.out.println(cloneddog1);
		
		Dog cloneddog2 = (Dog)AnimalCache.getAnimal("dog");
		cloneddog2.setName("Yes");
		cloneddog2.setAge(10);
		cloneddog2.setColor("Brown-Mix");
		System.out.println(cloneddog2);
		
		Dog cloneddog3 = (Dog)AnimalCache.getAnimal("dog");
		cloneddog3.setName("Tom");
		cloneddog3.setAge(7);
		cloneddog3.setColor("Black");
		System.out.println(cloneddog3);
		
		
		System.out.println("done");
	}
}
