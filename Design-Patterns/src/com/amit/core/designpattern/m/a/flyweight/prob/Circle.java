package com.amit.core.designpattern.m.a.flyweight.prob;

public class Circle implements Shape {

	private String label;
	private int radius;
	private String fillColor;
	private String lineColor;

	public Circle() {
		label = "Cicle";
	}

	@Override
	public void draw() {
		
		System.out.println("Drawing a " + label + "  with radius " + radius + " Fill color " + fillColor
				+ " Line Color " + lineColor);
		
		//System.out.println("Circleeee :"+this.hashCode());
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String getFillColor() {
		return fillColor;
	}

	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	public String getLineColor() {
		return lineColor;
	}

	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}

	@Override
	public String toString() {
		return "Circle [label=" + label + ", radius=" + radius + ", fillColor=" + fillColor + ", lineColor=" + lineColor
				+ "]";
	}
}
