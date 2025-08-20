package com.amit.core.designpattern.h.builder.solution.exe2;

import java.util.Date;

public class Form {

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String address;
	private Date dob;
	private String email;
	private String backupEmail;
	private String spouseName;
	private String city;
	private String state;
	private String country;
	private String language;
	private String passwordHint;
	private String securityQuestion;
	private String securityAnswer;
	
	private Form(FormBuilder formBuilder) {

		this.firstName = formBuilder.firstName;
		this.lastName = formBuilder.lastName;
		this.userName = formBuilder.userName;
		this.password = formBuilder.password;
		this.address = formBuilder.address;
		this.dob = formBuilder.dob;
		this.email = formBuilder.email;
		this.backupEmail = formBuilder.backupEmail;
		this.spouseName = formBuilder.spouseName;
		this.city = formBuilder.city;
		this.state = formBuilder.state;
		this.country = formBuilder.country;
		this.language = formBuilder.language;
		this.passwordHint = formBuilder.passwordHint;
		this.securityQuestion = formBuilder.securityQuestion;
		this.securityAnswer = formBuilder.securityAnswer;
	}


	public static class FormBuilder {

		private String firstName;
		private String lastName;
		private String userName;
		private String password;
		private String address;
		private Date dob;
		private String email;
		private String backupEmail;
		private String spouseName;
		private String city;
		private String state;
		private String country;
		private String language;
		private String passwordHint;
		private String securityQuestion;
		private String securityAnswer;

		public FormBuilder(String firstName, String lastName, String userName, String password) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = userName;
			this.password = password;
		}

		public FormBuilder setAddress(String address) {
			this.address = address;
			return this;
		}

		public FormBuilder setDob(Date dob) {
			this.dob = dob;
			return this;
		}

		public FormBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public FormBuilder setBackupEmail(String backupEmail) {
			this.backupEmail = backupEmail;
			return this;
		}

		public FormBuilder setSpouseName(String spouseName) {
			this.spouseName = spouseName;
			return this;
		}

		public FormBuilder setCity(String city) {
			this.city = city;
			return this;
		}

		public FormBuilder setState(String state) {
			this.state = state;
			return this;
		}

		public FormBuilder setCountry(String country) {
			this.country = country;
			return this;
		}

		public FormBuilder setLanguage(String language) {
			this.language = language;
			return this;
		}

		public FormBuilder setPasswordHint(String passwordHint) {
			this.passwordHint = passwordHint;
			return this;
		}

		public FormBuilder setSecurityQuestion(String securityQuestion) {
			this.securityQuestion = securityQuestion;
			return this;
		}

		public FormBuilder setSecurityAnswer(String securityAnswer) {
			this.securityAnswer = securityAnswer;
			return this;
		}

		public Form build() {
			return new Form(this);
		}
	}
	
	@Override
	public String toString() {
		return "Form [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + ", address=" + address + ", dob=" + dob + ", email=" + email + ", backupEmail="
				+ backupEmail + ", spouseName=" + spouseName + ", city=" + city + ", state=" + state + ", country="
				+ country + ", language=" + language + ", passwordHint=" + passwordHint + ", securityQuestion="
				+ securityQuestion + ", securityAnswer=" + securityAnswer + "]";
	}

	public static void main(String[] args) {
		Form form = new Form.FormBuilder("Dave", "Carter", "DavCarter", "DAvCaEr123").setPasswordHint("MyName").setCity("NY")
				.setLanguage("English").build();
		System.out.println(form);
	}

	
	
}
