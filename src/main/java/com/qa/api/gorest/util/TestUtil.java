package com.qa.api.gorest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
	/**
	 * This method is used to convert pojo object to a JSON STRING
	 * @param obj
	 * @return
	 */

	public static String getSerializedJSON(Object obj){
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try{
		jsonString = mapper.writeValueAsString(obj);
		System.out.println("JSON BODY PAYLOAD====>"+jsonString);
		}catch(JsonProcessingException e){
			e.printStackTrace();
		}
		
		return jsonString;
		
	}
}
