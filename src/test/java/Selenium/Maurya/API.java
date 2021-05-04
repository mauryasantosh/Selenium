 package Selenium.Maurya;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import Selenium.Maurya.Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

public class API {
	@Test
	public void addPlace()
	{	
			  RestAssured.baseURI ="https://rahulshettyacademy.com/";	  
			  
			  String res=
					  given()
					  .queryParam("key","qaclick123")
					  .header("Content-Type","application/json")
					  .body(Payload.addPayloadPost())
					  
					  .when().post("maps/api/place/add/json")
					  
					  .then().assertThat().statusCode(200).body("scope",equalTo("APP")).header("server","Apache/2.4.18 (Ubuntu)").extract().response().asString();
			  
			  			  
			  JsonPath js = new JsonPath(res);
			  
			  String newAdd= "TestNG";
			  
			  given()
			  .queryParam("key","qaclick123")
			  .header("Content-Type","application/json")
			  .body(Payload.updatePayload(js.getString("place_id"),newAdd))
			  
			  .when().put("/maps/api/place/update/json");
			  
			  String getRes=
			  given()
			  .queryParam("key","qaclick123")
			  .queryParam("place_id",js.getString("place_id"))
			  .header("Content-Type","application/json")
			  .when().get("/maps/api/place/get/json")
			  .then().assertThat().statusCode(200).extract().response().asString();
			  
			  js= new JsonPath(getRes);
			  System.out.println(js.getString("address"));
			  
			  
			  			  
			  Assert.assertEquals(newAdd,js.getString("address"));
			  
		  }	

	@Test
	public void jsonPath()
	{
		String jsonInput="{\r\n"
				+ "\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "\"courses\": [\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\r\n"
				+ "\"price\": 50,\r\n"
				+ "\r\n"
				+ "\"copies\": 6\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\r\n"
				+ "\"price\": 40,\r\n"
				+ "\r\n"
				+ "\"copies\": 4\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\r\n"
				+ "\"price\": 45,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "]\r\n"
				+ "\r\n"
				+ "}";
		JsonPath js = new JsonPath(jsonInput);
		int count=js.getInt("courses.size()");
		System.out.println(js.getInt("courses.size()"));
		System.out.println(js.getInt("dashboard.purchaseAmount"));
		System.out.println(js.getString("courses[0].title"));
		int sum=0;
		for(int i=0;i<count;i++)
		{
			System.out.println(js.getString("courses["+i+"].title")+" "+js.getString("courses["+i+"].price"));
			sum+=js.getInt("courses["+i+"].price")* js.getInt("courses["+i+"].copies");
		}
		
		System.out.println(sum);
		

	}
}

