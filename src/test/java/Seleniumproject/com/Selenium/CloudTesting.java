package Seleniumproject.com.Selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CloudTesting {

	public static final String USERNAME = "kumarnayak";
	  public static final String ACCESS_KEY = "1cfd8480-e90a-4e7b-a300-ea31c0d7a39c";
	  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	  
	public static void main(String[] args) throws MalformedURLException {
		
	/*	DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "91.0");
		 WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		 driver.get("http://www.airface.in/airface");
		System.out.println( driver.getTitle());*/
	}

}
