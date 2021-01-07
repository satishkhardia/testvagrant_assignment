package TestVagrant.Assignment;

import org.openqa.selenium.WebDriver;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.getResponseDetails;

public class API_test extends validations {

	/*
	 * RestAssured.baseURI="api.openweathermap.org/data/2.5/";
	 * RequestSpecification httpRequest = RestAssured.given(); Response
	 * response= httpRequest.queryParam("q","Ajmer")
	 * .queyParam("appid","7fe67bf08c80ded756e598d6f8fedaea") .get("/weather");
	 * String responseBody= response.getBody().asString(); System.out.println(
	 * "Response Body is -->"+responseBody);
	 */

	public float getTempInAPI(String city, WebDriver driver) {
		getResponseDetails resp = given().queryParam("q", prop.getProperty("city"))
										 .queyParam("appid", "7fe67bf08c80ded756e598d6f8fedaea").expect().defaultParser(Parser.JSON).when()
										 .get("api.openweathermap.org/data/2.5/").as(getResponseDetails.class);
		float temprature = resp.getMain().getTemp();
		return temprature;

	}

}
