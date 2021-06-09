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

public class POST_plan_settings {

	private static final Logger logger = LogManager.getLogger(POST_plan_settings.class);

	@Test
	// https://api.beta.envelopefinance.net/
	public void postplan_settings() throws IOException {

		// To read The Property File
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/data.properties");
		prop.load(ip);
		// make a request to specific base URI to server

		RestAssured.baseURI = prop.getProperty("API_URL");
		


		// RequestSpecification is used to pass headder and body

		RequestSpecification request = RestAssured.given();

		String payload = "{\n" + "    \"accounts\": [\n" + "        {\n"
				+ "            \"nickname\": \"JP Morgan Chase checking\",\n"
				+ "            \"name\": \"JP Morgan Chase star money market\",\n"
				+ "            \"institution_name\": \"JP Morgan Chase\",\n"
				+ "            \"account_number\": \"XXXX4357\",\n" + "            \"type\": \"CHECKING\",\n"
				+ "            \"balance\": {\n" + "                \"number\": 1885.46,\n"
				+ "                \"currency_code\": \"USD\"\n" + "            },\n"
				+ "            \"account_id\": \"ABC123\",\n" + "            \"error\": false,\n"
				+ "            \"public_token\": \"ABC123DEF456\"\n" + "        },\n" + "        {\n"
				+ "            \"nickname\": \"Synchrony MasterCard\",\n"
				+ "            \"name\": \"Synchrony Amazon.com MasterCard\",\n"
				+ "            \"institution_name\": \"Synchrony\",\n"
				+ "            \"account_number\": \"XXXX4357\",\n" + "            \"type\": \"CREDIT\",\n"
				+ "            \"balance\": {\n" + "                \"number\": -2775.25,\n"
				+ "                \"currency_code\": \"USD\"\n" + "            },\n"
				+ "            \"account_id\": \"UVW456\",\n" + "            \"error\": false,\n"
				+ "            \"public_token\": \"GHI789JKL012\"\n" + "        },\n" + "        {\n"
				+ "            \"nickname\": \"Citigroup Visa\",\n"
				+ "            \"name\": \"Citi Visa Signature Card\",\n"
				+ "            \"institution_name\": \"Citigroup\",\n"
				+ "            \"account_number\": \"XXXX4357\",\n" + "            \"type\": \"CREDIT\",\n"
				+ "            \"balance\": {\n" + "                \"number\": -9377.74,\n"
				+ "                \"currency_code\": \"USD\"\n" + "            },\n"
				+ "            \"account_id\": \"XYZ789\",\n" + "            \"error\": false,\n"
				+ "            \"public_token\": \"GHI789JKL012\"\n" + "        }\n" + "    ],\n"
				+ "    \"after_tax_monthly_income\": {\n" + "        \"number\": 4321,\n"
				+ "        \"currency_code\": \"USD\"\n" + "    },\n" + "    \"rainy_day_fund\": {\n"
				+ "        \"monthly_rainy_day_plan\": {\n" + "            \"number\": 300,\n"
				+ "            \"currency_code\": \"USD\"\n" + "        },\n" + "        \"target_balance\": {\n"
				+ "            \"number\": 200,\n" + "            \"currency_code\": \"USD\"\n" + "        }\n"
				+ "    },\n" + "    \"recurring_expenses\": [\n" + "        {\n"
				+ "            \"nickname\": \"Auto loan\",\n" + "            \"id\": \"abc\",\n"
				+ "            \"amount\": {\n" + "                \"number\": -337.86,\n"
				+ "                \"currency_code\": \"USD\"\n" + "            },\n"
				+ "            \"estimated_due_date\": 6\n" + "        },\n" + "        {\n"
				+ "            \"nickname\": \"Credit card - Interest\",\n" + "            \"id\": \"def\",\n"
				+ "            \"amount\": {\n" + "                \"number\": -217.64,\n"
				+ "                \"currency_code\": \"USD\"\n" + "            },\n"
				+ "            \"estimated_due_date\": 22\n" + "        },\n" + "        {\n"
				+ "            \"nickname\": \"Credit card - Principal\",\n" + "            \"id\": \"ghi\",\n"
				+ "            \"amount\": {\n" + "                \"number\": -217.33,\n"
				+ "                \"currency_code\": \"USD\"\n" + "            },\n"
				+ "            \"estimated_due_date\": 22\n" + "        },\n" + "        {\n"
				+ "            \"nickname\": \"Rent\",\n" + "            \"id\": \"jkl\",\n"
				+ "            \"amount\": {\n" + "                \"number\": -1375.00,\n"
				+ "                \"currency_code\": \"USD\"\n" + "            },\n"
				+ "            \"estimated_due_date\": 1\n" + "        },\n" + "        {\n"
				+ "            \"nickname\": \"Mobile phone service\",\n" + "            \"id\": \"mno\",\n"
				+ "            \"amount\": {\n" + "                \"number\": -106.16,\n"
				+ "                \"currency_code\": \"USD\"\n" + "            },\n"
				+ "            \"estimated_due_date\": 9\n" + "        },\n" + "        {\n"
				+ "            \"nickname\": \"Internet service\",\n" + "            \"id\": \"pqr\",\n"
				+ "            \"amount\": {\n" + "                \"number\": -72.31,\n"
				+ "                \"currency_code\": \"USD\"\n" + "            },\n"
				+ "            \"estimated_due_date\": 17\n" + "        },\n" + "        {\n"
				+ "            \"nickname\": \"Auto insurance\",\n" + "            \"id\": \"stu\",\n"
				+ "            \"amount\": {\n" + "                \"number\": -71.88,\n"
				+ "                \"currency_code\": \"USD\"\n" + "            },\n"
				+ "            \"estimated_due_date\": 17\n" + "        },\n" + "        {\n"
				+ "            \"nickname\": \"Electricity and Gas\",\n" + "            \"id\": \"vwx\",\n"
				+ "            \"amount\": {\n" + "                \"number\": -38.43,\n"
				+ "                \"currency_code\": \"USD\"\n" + "            },\n"
				+ "            \"estimated_due_date\": 17\n" + "        },\n" + "        {\n"
				+ "            \"nickname\": \"Gym membership\",\n" + "            \"id\": \"yza\",\n"
				+ "            \"amount\": {\n" + "                \"number\": -31.49,\n"
				+ "                \"currency_code\": \"USD\"\n" + "            },\n"
				+ "            \"estimated_due_date\": 17\n" + "        },\n" + "        {\n"
				+ "            \"nickname\": \"Netflix subscription\",\n" + "            \"id\": \"bcd\",\n"
				+ "            \"amount\": {\n" + "                \"number\": -12.99,\n"
				+ "                \"currency_code\": \"USD\"\n" + "            },\n"
				+ "            \"estimated_due_date\": 17\n" + "        }\n" + "    ],\n" + "    \"weekly_plan\": {\n"
				+ "        \"number\": 400,\n" + "        \"currency_code\": \"USD\"\n" + "    },\n"
				+ "    \"weekly_reserve\": {\n" + "        \"number\": 100,\n" + "        \"currency_code\": \"USD\"\n"
				+ "    }\n" + "}";
		// Passing Headders
		request.header("Authorization", prop.getProperty("Auth_Token"));
		logger.info("Passing Headders for Auth Token");
		request.header("Content-Type", "application/json");
		logger.info("Passing Headders for Content-Type");
		request.header("Accept", "application/json");
		logger.info("Passing Headders for Accept");


		//
		Response response_body = request.body(payload).post("/plan_settings");
		
		logger.info("Making a Request to end point with payload");
		
		String response=response_body.prettyPrint();
		
	     logger.info("Printing Response");

		logger.info(response);

		
		int statuscode = response_body.getStatusCode();
		// Make assertion for validating status code

		Assert.assertEquals(200, statuscode);
		logger.info("Checking Status code ");

		// creating a object to store response

		ResponseBody res = response_body.getBody();

		

		// converting response body from json to String
		String responseBodyAsString = res.asString();
		//logger.info("Converting response to String");
        


		// Comparing a value in response body and make assertion

		// Comparing a value in response body and make assertion

		// Assert.assertTrue(responseBodyAsString.contains("message"));

		// boolean Nullres=responseBodyAsString.contains("Null");
		// boolean Undefres=responseBodyAsString.contains("Undefined");
		// boolean errres=responseBodyAsString.contains("errorMessage");

		// Assert.assertFalse(responseBodyAsString.contains("Undefined"));
		// Assert.assertFalse(responseBodyAsString.contains("errorMessage"));

		// Assert.assertEquals(Nullres, "New plan settings have been submitted");

		boolean Nullres = responseBodyAsString.contains("null");
		

		 Assert.assertFalse(Nullres, "Found Null value ");
		logger.info("Checking Response is having any text as Null");

	}
}