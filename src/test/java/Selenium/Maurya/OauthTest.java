package Selenium.Maurya;
import org.testng.annotations.Test;

import Pojo.GetCourses;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

public class OauthTest {

	@Test
	public void oauthTest()
	{	//get code from this url-
		// https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php
		String url ="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AY0e-g6UEhHBVvlmtXvEUSs2rMltz8Xs3lXLGwcTChaHdrQlaMAfVUDkFC62i_l0g0LVdg&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none#";

		String partialcode=url.split("code=")[1];
		String code=partialcode.split("&scope")[0];

		System.out.println(code);
		
		String res=
		given().urlEncodingEnabled(false)
			.queryParam("code",code)
			.queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
            .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
            .queryParam("grant_type","authorization_code")
            .queryParams("state", "verifyfjdss")
            .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
			.queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")			            
	   .when().log().all()
	   		.post("https://www.googleapis.com/oauth2/v4/token")
	   .then().log().all().extract().asString();
		
		JsonPath js =new JsonPath(res);			
		
		//Use of Pojo
		GetCourses getCourses=
				given().contentType("application/json").queryParams("access_token", js.getString("access_token")).expect().defaultParser(Parser.JSON)
				.when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourses.class);
		
		System.out.println(getCourses.getInstructor());
		
			
	}
	
}
