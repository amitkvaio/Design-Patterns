package com.amit.core.designpattern.m.a.flyweight.prob;
public class PaintApp {

	public void render(int numberOfShapes) {

		Shape[] shape = new Shape[numberOfShapes+1];

		for (int i = 1; i <= numberOfShapes; i++) {
			if (i % 2 == 0) {
				shape[i] = new Circle();
				((Circle)shape[i]).setRadius(i);
				((Circle)shape[i]).setLineColor("Red");
				((Circle)shape[i]).setFillColor("White");
				shape[i].draw();
			}else {
				shape[i] = new Rectangle();
				((Rectangle)shape[i]).setLength(i);
				((Rectangle)shape[i]).setBreadth(i+i);
				((Rectangle)shape[i]).setFillStyle("Dotted");
				shape[i].draw();
			}
				
		}
	}
}

/*


The problem here is that every time we are creating the circle new object is being instantiated.

When we create a new circle a new object will be created.

Similarly when we create a new rectangle a new object has to be created because the state here.

All these fields are on the objects themselves.

So we need to set them on each one of them. 

We are going to move this state in the next lecture to the method itself as parameters and we will solve

this issue of creating a lot of objects in memory by using the flyweight pattern.

So if this number goes up to let's say hundred thousand then we'll end up having hundred thousand objects
in the memory.

*/
