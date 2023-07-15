package Github;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRepo {
	@Test
	public void test1() throws IOException {
		RestAssured.baseURI = "https://api.github.com/user/repos";
		RequestSpecification request = RestAssured.given();

		byte[] dataFile= Files.readAllBytes(Paths.get("RepoData.json"));
		Response response = request.auth().oauth2("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").contentType(ContentType.JSON).accept(ContentType.JSON).body(dataFile).post();

		String body = response.getBody().asString();
		System.out.println("Response Body Is : " + body);
		System.out.println("Response Code Is : " + response.statusCode());

		Assert.assertEquals(response.statusCode(), 201);
	}
}
