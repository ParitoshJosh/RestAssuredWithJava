package RestAPI;


import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithJasonObject {
	@Test
	public void test1() {

		JSONObject jObj = new JSONObject();
		jObj.put("name", "Greg");
		jObj.put("salary", "30000");

		RestAssured.baseURI = "http://localhost:3000/Employees";
		RequestSpecification request = RestAssured.given();

		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(jObj.toString()).post("/create");

		String body = response.getBody().asString();
		System.out.println("Response Body Is : " + body);
		System.out.println("Response Code Is : " + response.statusCode());

		Assert.assertEquals(response.statusCode(), 201);

	}
}
