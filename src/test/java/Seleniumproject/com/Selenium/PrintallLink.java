package Seleniumproject.com.Selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrintallLink {

	WebDriver driver;
	@BeforeTest
	public void intialiationDriver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir").concat("\\Driver\\chromedriver.exe"));
		driver = new ChromeDriver();
		// Launch amazon site
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.gsmarena.com/");

		// Login to the amazon site
	}
	@Test(priority = 2)
	public void printAllTheElement() throws InterruptedException, IOException {
		Thread.sleep(3000);
		List<WebElement> element=driver.findElements(By.tagName("a"));
		System.out.println(element.size());
		Iterator< WebElement> it=element.iterator();
		while(it.hasNext()) {
			String text=it.next().getAttribute("href");
			System.out.println(text);
			getBrokenLink(text);
		}
	}
	@Test
	public static void getBrokenLink(String linkurl) throws IOException {
		URL url=new URL(linkurl);
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		con.setConnectTimeout(3000);
		con.connect();
		int res=con.getResponseCode();
		if(res>=400) {
			System.out.println(linkurl+" - "+con.getResponseMessage()+"is a broken link");
		}
		else {
			 System.out.println(linkurl+" - "+con.getResponseMessage());
        }
		}
	}

