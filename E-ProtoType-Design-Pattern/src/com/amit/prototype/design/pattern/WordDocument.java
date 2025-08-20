package com.amit.prototype.design.pattern;

//Step 2: Concrete Prototype (Word Document)
public class WordDocument implements Document {
	private String title;
	private String author;
	private String content;

	public WordDocument(String content) {
		this.content = content;
	}

	@Override
	public Document clone() {
		try {
			return (Document) super.clone(); // shallow copy
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public void print() {
		System.out.println("WordDocument [Title=" + title + ", Author=" + author + ", Content=" + content + "]");
	}
}
