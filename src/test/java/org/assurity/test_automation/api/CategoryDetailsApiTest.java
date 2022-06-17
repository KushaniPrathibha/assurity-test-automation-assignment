package org.assurity.test_automation.api;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * API automation testing for 
 * "https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false"
 * 
 * @author Kushani
 *
 */
public class CategoryDetailsApiTest {

	RequestSpecification requestSpecification = null;
	ResponseSpecification responseSpecification = null;

	@BeforeTest
	public void setupSpecifications() {

		requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://api.tmsandbox.co.nz");
		requestSpecification.basePath("/v1/Categories/{categoryId}/Details.json");
		requestSpecification.queryParam("catalogue", false);

		responseSpecification = RestAssured.expect();
		responseSpecification.contentType(ContentType.JSON);
		responseSpecification.time(Matchers.lessThan(5000L));
	}

	/**
	 * Testing response parameters for a valid categoryId
	 * categoryId = 6327
	 * Expected: 
	 * httpStatus = 200
	 * Name = "Carbon credits"
	 */
	@Test
	void test_getCategoryDetails_name_success() {
		requestSpecification.pathParams("categoryId", 6327)
		.then().spec(responseSpecification)
		.statusCode(200)
			.body("CanRelist", equalTo(true));
	}

	/**
	 * Testing response parameters for  a valid categoryId
	 * categoryId = 6327
	 * Expected:
	 * httpStatus = 200 
	 * CanRelist = true
	 */
	@Test
	void test_getCategoryDetails_CanRelist_success() {
		requestSpecification.pathParams("categoryId", 6327)
		.then().spec(responseSpecification)
		.statusCode(200)
			.body("CanRelist", equalTo(true));
	}

	/**
	 * Testing response parameters for  a valid categoryId
	 * categoryId = 6327
	 * Expected: 
	 * httpStatus = 200
	 * The Promotions element with Name = "Gallery" has a Description that
	 * contains the text "Good position in category"
	 */
	@Test
	void test_getCategoryDetails_description_success() {
		requestSpecification.pathParams("categoryId", 6327)
		.then().spec(responseSpecification)
		.statusCode(200)
			.body("Promotions.find {it.Name =='Gallery'}.Description", containsString("Good position in category"));
	}

	/**
	 * Testing for http status code and response for an invalid categoryId
	 * categoryId = 67890
	 * Expected:
	 * httpStatus = 400
	 * ErrorDescription = Category 67890 was not found
	 */
	@Test
	void test_getCategoryDetails_failure() {
		requestSpecification.pathParams("categoryId", 67890).then().spec(responseSpecification)
				.statusCode(400).body("ErrorDescription", equalTo("Category 67890 was not found"));
	}

}
