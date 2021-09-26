package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Paramitarize {

	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void initdriver(String name) {
		if(name.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		}
		else if(name.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
	}
	@Test
	public void testing() throws IOException, InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		WebElement element=driver.findElement(By.xpath("//input[@id='txtPassword']"));
		driver.findElement(with(By.tagName("input")).above(element)).sendKeys("Admin");
		WebElement pas=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		driver.findElement(with(By.tagName("input")).below(pas)).sendKeys("admin123");
		driver.switchTo().newWindow(WindowType.TAB);
//	File src=pas.getScreenshotAs(OutputType.FILE);
//	FileUtils.copyFile(src, new File("E:\\my project\\MavenProject\\com.Selenium\\screen\\screenshot.png"));
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		String par=it.next();
		String ch=it.next();
		driver.switchTo().window(ch);
		Thread.sleep(3000);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	@AfterTest
	public void quit() {
		driver.close();
	}
}
