package RestAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithFile {
@Test
	public void test1() throws IOException {
	RestAssured.baseURI = "http://localhost:3000/Employees";
	RequestSpecification request = RestAssured.given();

	byte[] dataFile= Files.readAllBytes(Paths.get("data.json"));
	Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(dataFile).post("/create");

	String body = response.getBody().asString();
	System.out.println("Response Body Is : " + body);
	System.out.println("Response Code Is : " + response.statusCode());

	Assert.assertEquals(response.statusCode(), 201);

	}
}
