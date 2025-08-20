package com.amit.prototype.design.pattern;

//Step 1: Prototype Interface
public interface Document extends Cloneable {
	Document clone();

	void setTitle(String title);

	void setAuthor(String author);

	void print();
}