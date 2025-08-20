package com.amit.core.designpattern.b.b.shapefactory;

public class ShapeClient {
	public static void main(String[] args) {
		Shape circle = ShapeFactory.getShape(ShapeEnum.CIRCLE);
		circle.draw();
		Shape rectable = ShapeFactory.getShape(ShapeEnum.RECTABLE);
		rectable.draw();
		Shape square = ShapeFactory.getShape(ShapeEnum.SQUARE);
		square.draw();
		Shape notPresent = ShapeFactory.getShape(ShapeEnum.NOT_PRESENT);
		notPresent.draw();
	}
}
