
# **Builder Design Pattern Example**

## **Problem Statement**

When creating an object with many optional parameters, using a constructor with multiple arguments makes the code **hard to read** and **confusing**.

* Example: Passing `null` values for parameters that are not required.
* Other developers will not know what each `null` corresponds to unless they check the class fields.
* This reduces readability and maintainability.

👉 **Problem:** Need a way to create objects with flexible parameters without writing confusing constructor calls.

---

## **Solution Statement**

The **Builder Design Pattern** solves this problem by:

* Allowing us to set only the required fields when creating an object.
* Providing readable and maintainable code by using method chaining.
* Avoiding large constructors with too many arguments.

👉 **Solution:** Use a **Builder Class** that constructs the `HttpClient` step by step, making the object creation more flexible and readable.

---

## **Problem Code (Without Builder Pattern)**

```java
package com.amit.core.designpattern.h.builder.problem;

/**
 * PROBLEM STATEMENT:
 * ------------------
 * Here, the HttpClient class has multiple fields (method, url, username, password, headers, body).
 * 
 * If we want to create an object, we must pass all values through the constructor, even if many are null.
 * 
 * Example:
 *     HttpClient client = new HttpClient("GET", "https://test.com", null, null, null, null);
 * 
 * Issues:
 *  - Hard to understand what these nulls represent.
 *  - Confusing and less readable code.
 *  - Not flexible for cases when we only need a few fields.
 */
public class HttpClient {
	private String method;
	private String url;
	private String userName;
	private String password;
	private String headers;
	private String body;

	public HttpClient(String method, String url, String userName, String password, String headers, String body) {
		super();
		this.method = method;
		this.url = url;
		this.userName = userName;
		this.password = password;
		this.headers = headers;
		this.body = body;
	}
}
```

```java
package com.amit.core.designpattern.h.builder.problem;

public class HttpClientTest {
	public static void main(String[] args) {
		// Confusing constructor call with null values
		HttpClient httpClient = new HttpClient("GET", "https://test.com", null, null, null, null);
		System.out.println("HttpClient created using constructor with nulls!");
	}
}
```

---

## **Solution Code (With Builder Pattern)**

```java
package com.amit.core.designpattern.h.builder.solution;

/**
 * SOLUTION STATEMENT:
 * -------------------
 * Using Builder Pattern, we create HttpClient objects step by step.
 * 
 * Advantages:
 *  - No need to pass null values.
 *  - Only set the fields we need.
 *  - Readable and flexible object creation.
 * 
 * Example:
 *     HttpClient client = new HttpClient.HttpClientBuilder()
 *                              .method("GET")
 *                              .url("https://www.test.com")
 *                              .secure("amit", "***")
 *                              .build();
 */
public class HttpClient {
	private String method;
	private String url;
	private String userName;
	private String password;
	private String headers;
	private String body;

	// Private constructor to be used only by Builder
	private HttpClient(HttpClientBuilder builder) {
		this.method = builder.method;
		this.url = builder.url;
		this.userName = builder.userName;
		this.password = builder.password;
		this.headers = builder.headers;
		this.body = builder.body;
	}

	@Override
	public String toString() {
		return "HttpClient [method=" + method + ", url=" + url + ", userName=" + userName 
				+ ", password=" + password + ", headers=" + headers + ", body=" + body + "]";
	}

	// Static Inner Builder Class
	public static class HttpClientBuilder {
		private String method;
		private String url;
		private String userName;
		private String password;
		private String headers;
		private String body;

		public HttpClientBuilder method(String method) {
			this.method = method;
			return this;
		}

		public HttpClientBuilder url(String url) {
			this.url = url;
			return this;
		}

		public HttpClientBuilder secure(String userName, String password) {
			this.userName = userName;
			this.password = password;
			return this;
		}

		public HttpClientBuilder headers(String headers) {
			this.headers = headers;
			return this;
		}

		public HttpClientBuilder body(String body) {
			this.body = body;
			return this;
		}

		public HttpClient build() {
			return new HttpClient(this);
		}
	}
}
```

```java
package com.amit.core.designpattern.h.builder.solution;

public class HttpClientBuilderTest {
	public static void main(String[] args) {
		// Creating HttpClient object using Builder Pattern
		HttpClient client = new HttpClient.HttpClientBuilder()
				.method("GET")
				.url("https://www.test.com")
				.secure("amit", "*****")
				.build();

		System.out.println(client);
	}
}
```

---

✅ **Key Use Cases of Builder Pattern**

* When an object has **many optional parameters**.
* When we want **readable and maintainable code**.
* Common in frameworks like **Lombok’s @Builder**, **StringBuilder**, **HttpRequest builders**, etc.

---