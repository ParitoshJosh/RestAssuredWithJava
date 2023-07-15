package RestAPI;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParam {
	@Test
	public void test1() {
		RestAssured.baseURI = "http://localhost:3000/Employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/1");
		String body = response.getBody().asString();
		System.out.println("Response Body Is : " + body);
		System.out.println("Response Code Is : " + response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 200);
		
		Assert.assertTrue(body.contains("Pankaj"));
		
		JsonPath json = response.jsonPath();
		String  name = json.get("name");
		Assert.assertEquals(name, "Pankaj");
		
		
	}
}
