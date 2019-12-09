package getWeatherRequests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import io.restassured.RestAssured.*;
import io.restassured.response.Response;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class GetWeatherByCityName {
	
	private static final String HOST = "https://samples.openweathermap.org/data/2.5";
	private static final String LONDON_WEATHER_RESOURCE = "/weather?q=London,uk";
	
	private static final String API_KEY = "&appid=" + System.getenv("OPEN_WEATHER_MAP_API_KEY");
	
	private Response response = null;
	
	/*
	 * Example of a RestAssured test where the endpoint call is performed inside the test method and the response
	 * stored in a Response object to assert using TestNG assertion methods. 
	 */
	
//	@Test
//	public void testResponseCode() {
//		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
//		int code = resp.getStatusCode();
//		System.out.println("Status code is " + code);
//		Assert.assertEquals(code, 200);
//	}
	
	@BeforeTest(enabled=true)
	public void callWeatherEndpoint() {
		System.out.println("Calling Weather Endpoint...");
		response = get(HOST + LONDON_WEATHER_RESOURCE + API_KEY);
		System.out.println("Weather Endpoint got a response.");
	}

	/* 
	 * Example of a RestAssured test where the endpoint call is performed inside the test method.
	 */
	
//	@Test(enabled=true, priority=1)
//	public void testResponseCodeIs200() {
//		System.out.println(getCurrentTestName());
//		when().get(HOST + LONDON_WEATHER_RESOURCE + API_KEY)
//		.then().assertThat().statusCode(200);
//		System.out.println("Response code is 200.");
//	}
	
	@Test(enabled=true, priority=1)
	public void testResponseCodeIs200() {
		System.out.println("testResponseCodeIs200");
		response.then().assertThat().statusCode(200);
		System.out.println("-- Response code is 200.");
	}
	
	@Test(enabled=true, priority=2)
	public void testResponseBodyIsNotEmpty() {
		System.out.println("testResponseBodyIsNotEmpty");
		response.then().assertThat().body("$", notNullValue());
		System.out.println("-- Response body is not empty.");
	}
	
	@Test(enabled=true, priority=3)
	public void testResponseSchema() {
		System.out.println("testResponseSchema");
		response.then().assertThat().body(matchesJsonSchemaInClasspath("json/schemas/city-weather-schema.json"));
		System.out.println("-- Response schema is correct.");
	}
	
	/* 
	 * This test method is meant to fail by using a wrong schema file which will not match the response
	 * received by the enpoint call.
	 */
	@Test(enabled=true, priority=4)
	public void testResponseSchemaWrong() {
		System.out.println("testResponseSchemaWrong");
		response.then().assertThat().body(matchesJsonSchemaInClasspath("json/schemas/city-weather-schema-wrong.json"));
		System.out.println("-- Response schema is correct.");
	}
	
	@Test(enabled=true, priority=5)
	public void testResponseTime() {
		System.out.println("testResponseTime");
		response.then().assertThat().time(lessThan((long)2000), TimeUnit.MILLISECONDS);
		System.out.println("-- Response time is less than or equal to 2000 milliseconds.");
	}
	
}
