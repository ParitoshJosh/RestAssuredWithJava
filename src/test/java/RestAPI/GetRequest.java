package RestAPI;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	public void test1() {

		RestAssured.baseURI = "http://localhost:3000/Employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		String body = response.getBody().asString();
		System.out.println("Response Body Is : " + body);
		System.out.println("Response Code Is : " + response.statusCode());
		System.out.println("Response Header Is : " + response.getHeaders().asList());
		Assert.assertEquals(response.statusCode(), 200);

		//Print all the names
		JsonPath json = response.jsonPath();
		List<String> names = json.get("name");
		for (String name : names) {
			System.out.println(name);
		}

	}
}
