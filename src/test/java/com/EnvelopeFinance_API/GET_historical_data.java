package com.EnvelopeFinance_API;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GET_historical_data {
	
	private static final Logger logger = LogManager.getLogger(GET_historical_data.class);

	
	@Test
	public static void historical_data() throws IOException {

		// To read property file

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/data.properties");
		prop.load(ip);

		// Make a request to specific url

		RestAssured.baseURI = prop.getProperty("API_URL");
		// Creating request specification is used to pass headers

		RequestSpecification request = RestAssured.given();

		// Payload can be passed here
		String payload = "";

		// Passing header with Object of requestspecification
		request.header("Authorization", prop.getProperty("Auth_Token"));
		logger.info("Passing Headders for Auth Token");
		request.header("Content-Type", "application/json");
		logger.info("Passing Headders for Content-Type");
		request.header("Accept", "application/json");
		logger.info("Passing Headders for Accept");


		// Making a request to server With help of response object

		Response response_body = request.body(payload).get("/historical_data");
		logger.info("Making a Request to end point with payload");

		String response=response_body.prettyPrint();
		
	     logger.info("Printing Response");

		logger.info(response);
		
		int statuscode = response_body.getStatusCode();
		// Make assertion for validating status code

		Assert.assertEquals(200, statuscode);
		logger.info("Checking Status code ");


		ResponseBody res =response_body.getBody();
	
		// converting response body from json to String
		String responseBodyAsString = res.asString();
		
		//logger.info("Converting response to String");


		// Comparing a value in response body and make assertion


		// Comparing a value in response body and make assertion

		//Assert.assertTrue(responseBodyAsString.contains("message"));
		/*
		Assert.assertFalse(responseBodyAsString.contains("Null"));
		Assert.assertFalse(responseBodyAsString.contains("Undefined"));
		Assert.assertFalse(responseBodyAsString.contains("errorMessage"));
		*/
		    
		boolean Nullres = responseBodyAsString.contains("null");

		Assert.assertFalse( Nullres,"Found Null value ");
		logger.info("Checking Response is having any text as Null");





		


	}

}
