package Mypursu_API;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Tets {
	
	
	@Test
	public void Reponse() throws IOException {

		// To read The Property File
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/data.properties");
		prop.load(ip);
// make a request to specific base URI to server

		//RestAssured.baseURI = prop.getProperty("API_URL");
		RestAssured.baseURI="https://do.api.dev.mypursu.com/api/mypursureward";

//RequestSpecification is used to pass headder and body

		RequestSpecification request = RestAssured.given();

		// Payload can be passed here
		String payload = "{\"mobileNum\":\"7095296113\"}";

// Passing  Headders 
		//request.header("Authorization", prop.getProperty("Auth_Token"));
		request.header("Content-Type", "application/json");
	//	request.header("Accept", "application/json");

		Response response_body = request.body(payload).post("/getotp");
		response_body.prettyPrint();
		
		ResponseBody res = response_body.getBody();

		// Printing response with help of responseObject

		res.prettyPrint();

		// converting response body from json to String
		String responseBodyAsString = res.asString();
		//response_body.prettyPrint();
		
		//Assert.assertFalse(responseBodyAsString.contains("error"));
		
		//boolean ACT=  Assert.assertFalse(responseBodyAsString.contains("false"));

		
     	boolean ACT=responseBodyAsString.contains("false");
		
		
		Assert.assertEquals(ACT,true);

}
}
