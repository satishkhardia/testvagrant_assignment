package TestVagrant.Assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test extends validations {

	public WebDriver driver;

	@BeforeTest

	public void initialize() throws IOException {
	driver = initializeDriver();

	}

	@Test
	public void tests() {

		driver.get(prop.getProperty("url"));
		loadWeatherPage(driver);
		String city = prop.getProperty("city");
		String UI_City = validateCity(city,driver);
		Assert.assertEquals(city, UI_City);
		float tempInFaren = getTemp(city, driver);
		WebElement cityInfo = weatherDetails(city, driver);
		Assert.assertEquals(city, cityInfo);
		API_test api = new API_test();
		float temprature = api.getTempInAPI(city, driver);
		compare(tempInFaren, temprature);

	}

	@AfterTest
	public void EndTest() {
		driver.close();
	}

}
