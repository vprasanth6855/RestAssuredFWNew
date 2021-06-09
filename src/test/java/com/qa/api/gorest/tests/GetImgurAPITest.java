package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.Token;

import io.restassured.response.Response;

public class GetImgurAPITest {
	
	Map<Object, Object> tokenMap;
	String accessToken;
	String accountUsername;
	String refreshToken;
	
	
	@BeforeMethod
	public void setUp(){
		tokenMap = Token.getAccessToken();
		accessToken = tokenMap.get("access_token").toString();
		accountUsername = tokenMap.get("account_username").toString();
		refreshToken = tokenMap.get("refresh_token").toString();
	}

	@Test
	public void getAccountBlockStatusAPITest(){
		Map<String, String> authTokenMap = Token.getAuthToken();
		Response response = RestClient.doGet(null,"https://api.imgur.com", "/account/v1/"+accountUsername+"/block", authTokenMap, null, true);
		
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}
	
	@Test
	public void getAccountImageAPITest(){
		Map<String, String> authTokenMap = Token.getAuthToken();
		Response response = RestClient.doGet(null,"https://api.imgur.com", "/account/me/images", authTokenMap, null, true);
		
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}
	
	@Test
	public void uploadImagePostAPITest(){
		Map<String, String> clientIdMap = Token.getClientID();
		
		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("title", "TestTitle Api");
		formMap.put("description", "Test description api");
		Response response = RestClient.doPost("multipart", "https://api.imgur.com", "/3/image", clientIdMap, null, true, formMap);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}
}
