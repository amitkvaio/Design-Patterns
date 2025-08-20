package com.amit.core.designpattern.h.builder.problem;

public class HttpClientTest {
	public static void main(String[] args) {
		HttpClient httpClient = new HttpClient("Get", "https://test.com", null, null, null, null);
		System.out.println("HttpClient");
	}
}
/*

Any developer who looks at this code will be very confused by looking at this constructor.

He will not know what these nulls correspond to unless he goes and checks the class itself and looks

at these fields.

This is not very readable and maintainable code.

That is where the builder pattern comes in when we have a requirement to create an object.

But we want to initialize certain fields of the object while instantiating it, and we don't need all

of them at any given point in time.

We might need all of them, but it gives us the option.

The builder pattern gives us the option of building whatever we want, leaving the rest and the code will

be much more readable instead of confusing others like this.

*/