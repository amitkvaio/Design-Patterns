package com.amit.prototype.design.pattern;

//Step 3: Client
public class PrototypeClient {
	public static void main(String[] args) {
		// Create a prototype document (Template)
		WordDocument prototype = new WordDocument("Default company letterhead and formatting");

		// Clone prototype for new documents
		WordDocument doc1 = (WordDocument) prototype.clone();
		doc1.setTitle("Offer Letter");
		doc1.setAuthor("HR Team");
		doc1.print();

		WordDocument doc2 = (WordDocument) prototype.clone();
		doc2.setTitle("Appointment Letter");
		doc2.setAuthor("HR Team");
		doc2.print();

		WordDocument doc3 = (WordDocument) prototype.clone();
		doc3.setTitle("Relieving Letter");
		doc3.setAuthor("HR Team");
		doc3.print();
	}
}

/*
Output
WordDocument [Title=Offer Letter, Author=HR Team, Content=Default company letterhead and formatting]
WordDocument [Title=Appointment Letter, Author=HR Team, Content=Default company letterhead and formatting]
WordDocument [Title=Relieving Letter, Author=HR Team, Content=Default company letterhead and formatting]
*/