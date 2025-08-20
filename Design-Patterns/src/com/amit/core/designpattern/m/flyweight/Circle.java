package com.amit.core.designpattern.m.flyweight;

public class Circle extends Shape {

	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Circle() {
		label = "Cicle";
	}

	// Separate the extrinsic state and passing as draw method parameter
	@Override
	public void draw(int radius, String fillColor, String lineColor) {
		
		System.out.println("Drawing a " + label + "  with radius " + radius + " Fill color " + fillColor
				+ " Line Color " + lineColor);
		System.out.println("Circleeee :"+this.hashCode());
	}

}
