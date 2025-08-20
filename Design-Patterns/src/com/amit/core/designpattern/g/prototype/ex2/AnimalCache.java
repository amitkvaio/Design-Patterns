package com.amit.core.designpattern.g.prototype.ex2;

import java.util.Hashtable;

public class AnimalCache {
	private static Hashtable<String, Animal> animalMap = new Hashtable<>();

	public static Animal getAnimal(String animalType) {
		Dog dog = (Dog) animalMap.get(animalType);
		if (dog == null) {
			Dogleg d = new Dogleg();
			d.setNoOfLeg(4);

			DogEar dogEar = new DogEar();
			dogEar.setNoOfEar(2);

			dog = new Dog("Doggy", 2, "White", dogEar, d);
			animalMap.put("dog", dog);
			System.out.println("New object has been created and added to hashtable!!");
		}
		return dog.clone();
	}
}
