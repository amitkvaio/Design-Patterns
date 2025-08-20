package com.amit.core.designpattern.b.b.shapefactory;

public class ShapeFactory {
	public static Shape getShape(ShapeEnum shapeEnum) {
		Shape shape = null;
		switch (shapeEnum) {
		case CIRCLE:
			shape = new Circle();
			break;
		case RECTABLE :
			shape = new Rectangle();
			break;
		case SQUARE :
			shape = new Square();
			break;
		default:
			System.out.println("Please enter the proper input!!");
			break;
		}
		return shape;
	}
}
