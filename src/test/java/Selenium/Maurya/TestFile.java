package Selenium.Maurya;

import Selenium.Maurya.*;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
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

}
