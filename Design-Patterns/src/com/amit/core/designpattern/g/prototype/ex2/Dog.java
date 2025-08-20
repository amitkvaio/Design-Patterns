package com.amit.core.designpattern.g.prototype.ex2;

public class Dog implements Animal {

	private String name;
	private int age;
	private String color;

	DogEar dogEar;
	Dogleg dogLeg;

	public Dog(String name, int age, String color, DogEar dogEar, Dogleg dogleg) {
		this.name = name;
		this.age = age;
		this.color = color;
		this.dogEar = dogEar;
		this.dogLeg = dogleg;
	}

	@Override
	public Animal clone() {
		Dog dog = null;
		try {
			dog = (Dog) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return dog;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", color=" + color + ", dogEar=" + dogEar + ", dogLeg=" + dogLeg
				+ "]";
	}

}
