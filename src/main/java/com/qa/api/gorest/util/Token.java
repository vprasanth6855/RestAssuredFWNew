package com.qa.api.gorest.util;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Token {
	
	public static Map<Object, Object> appTokenMap;
	public static Map<String, String> tokenMap = new HashMap<String, String>();
	public static String clientId = "13a1321579c2d32";
	
	@Test
	public static Map<Object, Object> getAccessToken(){
		
		Map<String, String> formParams = new HashMap<String, String>();
		formParams.put("refresh_token", "6bc96e266f70122c0829f7454c9545528dfa8171");
		formParams.put("client_id", "13a1321579c2d32");
		formParams.put("client_secret", "c81fcc885c8ccd473b3e5136b8d6109f608ef949");
		formParams.put("grant_type", "refresh_token");
		
		JsonPath tokenJson = given()
		 .formParams(formParams)
		.post("https://api.imgur.com/oauth2/token")
		.then()
		 .extract().jsonPath();
		
		System.out.println(tokenJson.getMap(""));
		
		appTokenMap =  tokenJson.getMap("");
		return appTokenMap;
	
		
	}
	
	public static Map<String, String> getAuthToken(){
		String authToken = appTokenMap.get("access_token").toString();
		System.out.println("Auth token========> "+authToken);
		tokenMap.put("Authorization", "Bearer "+authToken);
		return tokenMap;
	}
	
	public static Map<String, String> getClientID(){
		
		System.out.println("client id========> "+clientId);
		tokenMap.put("Authorization", "Client-ID "+clientId);
		return tokenMap;
	}
	
	
}
