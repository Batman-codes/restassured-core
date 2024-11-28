package com.testlead.web.api;

import java.util.Map;
import java.util.stream.Collectors;

import com.testleaf.web.api.ResponseAPI;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class RAAPIResponseImpl implements ResponseAPI{
	
	private Response response;
	
	public RAAPIResponseImpl(Response response) {
		this.response = response;
	}

	@Override
	public int getStatusCode() {
		
		return response.getStatusCode();
		
	}

	@Override
	public String getStatusMessage() {
		
		return response.getStatusLine();
	}

	@Override
	public Object getResponseBody() {
		
		return response.getBody();
	}

	@Override
	public Map<String, String> getResponseHeader() {
		
		return response.getHeaders().asList().stream().collect(Collectors.toMap(Header::getName, Header::getValue));
	}

}
