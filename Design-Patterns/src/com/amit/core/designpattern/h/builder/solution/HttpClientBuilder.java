package com.amit.core.designpattern.h.builder.solution;

public class HttpClientBuilder {
	public static void main(String[] args) {
		HttpClient client = new HttpClient.HttpClientBuilder()
				.method("GET")
				.url("https://www.test.com")
				.secure("amit", "***")
				.build();
		System.out.println(client);
	}
}
