package com.javacodegeeks.junitrestweb;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class EmployeeRestTest {
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8081;
	}

	@Test
	public void testUserFetchesSuccess() {
		get("/junitrestweb/webapi/employee/12")
		.then()
		.body("id", equalTo(12))
		.body("firstName", equalTo("sandya"))
		.body("lastName", equalTo("tangudu"))
		.body("designation", equalTo("CEO"));
	}
}
