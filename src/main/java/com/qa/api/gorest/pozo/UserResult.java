package com.qa.api.gorest.pozo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.TestUtil;

import io.restassured.response.Response;

public class UserResult {

	@Test
	public void createUserWithFullJson(){
		
	String token = "c48d7cee7791ff0702943d6d716fbfd20328631653c38eb90823d2305a06d072";
	
	Self sf = new Self("http://www.sf.com");
	Edit ed = new Edit("http://www.ed.com");
	Avatar av = new Avatar("http://www.av.com");
	
	Links ln = new Links(sf, ed, av);
	
	UserInfo uf = new UserInfo("Tomy", "tomy1@test.com", "Male", "Active", "78786756", ln);
	
	String UserJsonPayload = TestUtil.getSerializedJSON(uf);
	System.out.println(UserJsonPayload);
	
	Map<String, String> authTokenMap = new HashMap<String, String>();
	authTokenMap.put("Authorization", "Bearer "+token);
	Response response = RestClient.doPost("JSON", "https://gorest.co.in", "/public-api/users", authTokenMap, null, true, uf);
	
	System.out.println(response.getStatusCode());
	System.out.println(response.prettyPrint());
	
}
}
