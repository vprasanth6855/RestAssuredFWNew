package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

@Epic("Epic-101: Get user go rest api feature implementation...")
@Feature("US-1009get user api feature...")
public class GetUserTest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "c48d7cee7791ff0702943d6d716fbfd20328631653c38eb90823d2305a06d072";
	
	@Description("get all user lists api test...verify all users list from get call...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=1)
	public void getAllUserListAPITest(){
		
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer "+token);
		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, null, true);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}
	
	@Description("get all user lists api test with query params...verify all users list from get call...")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void getUserWithQueryParamsAPITest(){
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer "+token);
		
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "Aamod Chopra");
		params.put("gender", "Male");
		
		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, params, true);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}

}
