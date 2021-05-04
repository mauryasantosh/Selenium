package Selenium.Maurya;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import org.testng.annotations.Test;
import Pojo.Location;
import Pojo.Place;
import Selenium.Maurya.Files.Payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class MapAPI {
@Test
public void AddTest()
{
	Location location = new Location();
	location.setLat("-38.383494");
	location.setLng("33.427362");
	
	Place place = new Place();
	place.setLocation(location);
	place.setName("API Testing Practice");
	place.setAccuracy(50);
	place.setAddress("29, side layout, cohen 09");
	place.setLanguage("French-IN");	
	place.setPhone_number("(+91) 983 893 3937");
	place.setWebsite("http://rahulshettyacademy.com");
	
	String[] types= {"shop","gym"};
	place.setTypes(Arrays.asList(types));
	
	RequestSpecification rsf= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").addQueryParam("key","qaclick123")
							.addHeader("Content-Type","application/json").setContentType(ContentType.JSON).build();
	 
	RequestSpecification req= given().spec(rsf).body(place);
	
	ResponseSpecification resf= new ResponseSpecBuilder().expectStatusCode(200).expectHeader("server","Apache/2.4.18 (Ubuntu)").build();
	
	String res=
			 	req.
			 	when().post("maps/api/place/add/json")			  
			 			.then().spec(resf)
			 			.extract().asString();
	  
	  System.out.println(res);

	}
}
