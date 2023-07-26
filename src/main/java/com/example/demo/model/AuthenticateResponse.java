package com.example.demo.model;

public class AuthenticateResponse {
	
	private final String jwtToken;

	public AuthenticateResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}
	
	

}
