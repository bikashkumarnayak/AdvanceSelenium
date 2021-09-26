package Seleniumproject.com.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Baseclass {
	WebDriver driver;
	@Test
	public  void initdriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir").concat("\\Driver\\chromedriver.exe"));
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		// Launch amazon site
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Login to the amazon site
	}

	@AfterTest
	public void down() {

	driver.quit();
}
}
