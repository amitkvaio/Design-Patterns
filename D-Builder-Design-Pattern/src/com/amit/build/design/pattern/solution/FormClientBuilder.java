package com.amit.build.design.pattern.solution;


public class FormClientBuilder {
	public static void main(String[] args) {
		Form form = new Form.FormBuilder("Dave", "Carter", "DavCarter", "DAvCaEr123").setPasswordHint("MyName").setCity("NY")
				.setLanguage("English").build();
		System.out.println(form);
	}
}

