package TestVagrant.Assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class validations {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();

		FileInputStream fis = new FileInputStream("C:\\Users\\satishkhardia\\workspace\\Assignment\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		return driver;
	}

	public void loadWeatherPage(WebDriver driver) {

		driver.manage().window().maximize();
		driver.findElement(By.id("h_sub_menu")).click();
		driver.findElement(By.partialLinkText("WEATHER")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}


	public String validateCity(String city, WebDriver driver) {
		driver.findElement(By.id("searchBox")).click();
		driver.findElement(By.id("searchBox")).sendKeys(city); // Search functionality to filter cities
		driver.findElement(By.id(city)).click();
		return driver.findElement(By.xpath("//div[@title='Ajmer']/div[2]")).getText();

	}

	public float getTemp(String city, WebDriver driver) {
		float temp = Float.parseFloat(driver.findElement(By.xpath("//div[@title='Ajmer']/div/span[2]")).getText());
		
		return temp;

	}

	public WebElement weatherDetails(String city, WebDriver driver) {
		driver.findElement(By.xpath("//div[@title='Ajmer']")).click();

		WebElement cityInfo = driver.findElement(By.xpath("//div[contains(@span,prop.getProperty(\"city\")]"));

		return cityInfo;

	}

	public boolean compare(float UITemp, float APITemp) {
		if (UITemp == APITemp) {

			System.out.println("Temp matched");
			return true;
		}

		else if ((UITemp - 10) == APITemp) {
			System.out.println("Temp matched");
			return true;
		} else if (UITemp == APITemp - 10) {
			System.out.println("Temp matched");
			return true;
		} else {
			System.out.println("Temp not matched");
			return false;

		}

	}

}
