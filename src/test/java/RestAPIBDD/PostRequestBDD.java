package RestAPIBDD;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequestBDD {

	@Test
	public void test1() {
		
		JSONObject jObj = new JSONObject();
		jObj.put("name", "Priya");
		jObj.put("salary", "65000");
		
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(jObj.toString())
		.when()
		.post("/create")
		.then()
		.statusCode(201)
		.log()
		.body();
	}
}
