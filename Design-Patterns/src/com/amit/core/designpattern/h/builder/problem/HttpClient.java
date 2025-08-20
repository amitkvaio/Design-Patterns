package com.amit.core.designpattern.h.builder.problem;

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
