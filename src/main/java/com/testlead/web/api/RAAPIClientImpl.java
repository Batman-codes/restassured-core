package com.testlead.web.api;

import com.testleaf.web.api.APIClient;
import com.testleaf.web.api.ResponseAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RAAPIClientImpl implements APIClient{

	@Override
	public ResponseAPI get(String endpoint) {
		
		return new RAAPIResponseImpl(RestAssured.get(endpoint));
	}

	@Override
	public ResponseAPI post(String endpoint, Object body) {
		
		Response response = RestAssured.given().header("Content-Type","application/json").body(body).post(endpoint);
		
		return new RAAPIResponseImpl(response);
	}

	@Override
	public ResponseAPI put(String endpoint, Object body) {
		
		Response response = RestAssured.given().header("Content-Type","application/json").body(body).put(endpoint);
		
		return new RAAPIResponseImpl(response);
	}

	@Override
	public ResponseAPI delete(String endpoint) {
		return new RAAPIResponseImpl(RestAssured.delete(endpoint));
	}

}
