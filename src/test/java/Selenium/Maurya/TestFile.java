package Selenium.Maurya;

/*import Selenium.Maurya.*;

import org.testng.Assert;
import org.testng.annotations.Parameters;*/
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestFile {

	
	  @Test(enabled=true)
	  
	  public void main1() 
	  { //run test on chrome
		  TestBase.setup(); 
		  App app = new App(); 
		  app.test1(); 
	  }
	  
	  @Test(priority=0,groups= {"ST","QA"}) 
		/* @Parameters({"t","t1"}) */ 
	  public void
	  B( /* String t,String t1 */) 
	  { 
		  App app = new App(); app.test2();
	  System.out.println("t+t1"); 
	  }
	  
	  @Test(priority=0) public void A() 
	  { App app = new App(); 
	  app.test3(); 
	  }
	 
	
	  @Test public void RegistrationSuccessful() 
	  {
		  RestAssured.baseURI ="https://reqres.in/api/users?page=2";	  
		  RequestSpecification httpRequest = RestAssured.given();
		  Response response = httpRequest.request(Method.GET);	 	 
	   
		  String responseBody = response.getBody().asString();
		  System.out.println(responseBody);
		  
	  }
	  
	  @Test public void RegistrationSuccessful1() 
	  {
		  RestAssured.baseURI ="https://reqres.in/api/users?page=2";	  
		  RequestSpecification httpRequest = RestAssured.given();
		  Response response = httpRequest.request(Method.GET);	 	 
	   
		  String responseBody = response.getBody().asString();
		  System.out.println(responseBody);
		  
	  }
	 
	  @Test public void RegistrationSuccessful2() 
	  {
		  RestAssured.baseURI ="https://reqres.in/api/users?page=2";	  
		  RequestSpecification httpRequest = RestAssured.given();
		  Response response = httpRequest.request(Method.GET);	 	 
	   
		  String responseBody = response.getBody().asString();
		  System.out.println(responseBody);
		  
	  }

	  @Test public void automationTest() 
	  {
		  RestAssured.baseURI ="https://rahulshettyacademy.com/";	  
		  given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		  .body("{\r\n"
		  		+ "  \"location\": {\r\n"
		  		+ "    \"lat\": -38.383494,\r\n"
		  		+ "    \"lng\": 33.427362\r\n"
		  		+ "  },\r\n"
		  		+ "  \"accuracy\": 50,\r\n"
		  		+ "  \"name\": \"Rahul Shetty Academy\",\r\n"
		  		+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
		  		+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
		  		+ "  \"types\": [\r\n"
		  		+ "    \"shoe park\",\r\n"
		  		+ "    \"shop\"\r\n"
		  		+ "  ],\r\n"
		  		+ "  \"website\": \"http://rahulshettyacademy.com\",\r\n"
		  		+ "  \"language\": \"French-IN\"\r\n"
		  		+ "}\r\n"
		  		+ "").when().post("maps/api/place/add/json")
		  .then().log().all().assertThat().statusCode(200);
		  
	  }

}
