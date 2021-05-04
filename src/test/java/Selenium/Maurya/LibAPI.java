package Selenium.Maurya;
import io.restassured.RestAssured;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Selenium.Maurya.Files.Payload;

public class LibAPI {
	
	
@Test(dataProvider="bookdata")
public void Add(String isbn,String aisle)
{	
	RestAssured.baseURI="http://216.10.245.166/";
	RestAssured.given()
		.body(Payload.AddBook(isbn, aisle))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200);
	
	}


@Test
public void delete() throws IOException
{	
	String str = new String(Files.readAllBytes(Paths.get("C:\\Users\\mauryas\\eclipse-workspace\\Selenium\\src\\test\\java\\Selenium\\Maurya\\Files\\Add.json")));
	
	RestAssured.baseURI="http://216.10.245.166/";
	RestAssured.given().header("Content-Type","application/json").log().all()
	.body(str)
	.when().delete("Library/DeleteBook.php")
	.then().log().all();
	
}


@DataProvider(name="bookdata")
	public Object[][] getBookData()
	{
	return new Object[][] {{"dqsr","9870"},{"dyzr","9610"}};	
	}
}
