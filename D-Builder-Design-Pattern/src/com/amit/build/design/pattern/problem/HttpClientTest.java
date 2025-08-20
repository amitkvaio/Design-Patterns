package com.amit.build.design.pattern.problem;

public class HttpClientTest {
	public static void main(String[] args) {
		HttpClient httpClient = new HttpClient("Get", "https://test.com", null, null, null, null);
		System.out.println("HttpClient :" + httpClient);
	}
}
/*

When we create an object using a constructor with many parameters, the code becomes confusing.
Example:
HttpClient client = new HttpClient("GET", "https://test.com", null, null, null, null);

Any developer looking at this code will not immediately know what each null represents.
To understand it, they must go back and check the class definition to see which field each parameter corresponds to.
This makes the code hard to read, less maintainable, and error-prone.

*/