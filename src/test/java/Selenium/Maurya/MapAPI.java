package Selenium.Maurya;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import org.testng.annotations.Test;
import Pojo.Location;
import Pojo.Place;
import Selenium.Maurya.Files.Payload;
import io.restassured.RestAssured;

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
	
	 RestAssured.baseURI ="https://rahulshettyacademy.com/";	  
	 System.out.println(place);
	  String res=
			  given()
			  .queryParam("key","qaclick123")
			  .header("Content-Type","application/json")
			  .body(place)
			  
			  .when().post("maps/api/place/add/json")
			  
			  .then().assertThat().statusCode(200).body("scope",equalTo("APP")).header("server","Apache/2.4.18 (Ubuntu)").extract().response().asString();
	  
	  System.out.println(res);

	}
}
