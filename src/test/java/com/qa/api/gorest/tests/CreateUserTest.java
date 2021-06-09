package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.gorest.pozo.user;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.ExcelUtil;

import io.restassured.response.Response;

public class CreateUserTest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "c48d7cee7791ff0702943d6d716fbfd20328631653c38eb90823d2305a06d072";
	
	@DataProvider
	public Object[][] getUserData(){
		Object userData[][] = ExcelUtil.getTestData("userdata");
		return userData;
	}
	
	@Test(dataProvider = "getUserData")
	public void createUserAPIPOSTTest(String name, String email, String gender, String status){
		
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer "+token);
		
		//user user1 = new user("vini v", "vini@test.com", "Female", "Active");
		user user1 = new user(name, email, gender, status);
		
		Response response = RestClient.doPost("JSON", baseURI, basePath, authTokenMap, null, true, user1);
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println("==================================");
	}

}
