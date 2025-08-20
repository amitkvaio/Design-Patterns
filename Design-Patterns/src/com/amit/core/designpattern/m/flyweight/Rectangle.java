package com.amit.core.designpattern.m.flyweight;

public class Rectangle extends Shape {
	private String label;

	public Rectangle() {
		label = "Rectangle";
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	// Separate the extrinsic state and passing as draw method parameter
	
	@Override
	public void draw(int length, int breadth, String fillStyle) {
		
		System.out.println(
				"Drawing a " + label + "  with lenght " + length + " Breadth " + breadth + " Fill Style " + fillStyle);
		
		System.out.println("Rectangle :"+this.hashCode());
	}

}
