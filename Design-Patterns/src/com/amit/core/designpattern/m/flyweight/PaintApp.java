package com.amit.core.designpattern.m.flyweight;

public class PaintApp {

	public void render(int numberOfShapes) {
		Shape shape = null;
		for (int i = 1; i <= numberOfShapes; i++) {
			if (i % 2 == 0) {
				shape = ShapeFactory.getShape("circle");
				shape.draw(i, "Red", "WHITE");
			} else {
				shape = ShapeFactory.getShape("rectangle");
				shape.draw(i, i + i, "DOTTED");
			}
		}
	}
}
