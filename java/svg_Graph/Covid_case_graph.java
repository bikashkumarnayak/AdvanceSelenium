package svg_Graph;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Covid_case_graph {

	WebDriver driver;

	@Test
	public void covid_case() throws  InterruptedException, ParseException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.navigate().to(
				"https://www.google.com/search?q=covid+case+in+india&rlz=1C1SQJL_enIN969IN969&sxsrf=AOaemvK0tgLH9a1ZRhhuHzy9uk-xuSwuyA%3A1632631912870&ei=aPxPYf_CNPaI9u8PxIe8yA8&oq=covid+case+in+india&gs_lcp=Cgdnd3Mtd2l6EAMyBwgAEEcQsAMyBwgAEEcQsAMyBwgAEEcQsAMyBwgAEEcQsAMyBwgAEEcQsAMyBwgAEEcQsAMyBwgAEEcQsAMyBwgAEEcQsAMyBwgAELADEEMyCQgAELADEAoQQ0oECEEYAFAAWABgi-cUaAFwAngAgAEAiAEAkgEAmAEAyAEKwAEB&sclient=gws-wiz&ved=0ahUKEwj_ltzp65vzAhV2hP0HHcQDD_kQ4dUDCA4&uact=5");

		driver.manage().window().maximize();
		Thread.sleep(4000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1600)", "");
		Thread.sleep(5000);
		WebElement ele=driver.findElement(By.xpath("(//*[local-name()='svg' and @class='uch-psvg'])[2]"));
		int toplefty=((ele.getSize().getHeight())/2)-ele.getSize().getHeight();
		int toprightx=((ele.getSize().getWidth())/2)-ele.getSize().getWidth();
		Actions act =new Actions(driver);
		String stsrt_date="20-03-2020";
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		Date d1=sdf.parse(stsrt_date);
		Date d2=new Date();
		long dif_date=TimeUnit.MILLISECONDS.toDays(d2.getTime()-d1.getTime());
		for(int i=0;i<dif_date;i++) {
			act.moveToElement(ele, toprightx+i, toplefty).perform();
			String value=driver.findElement(By.xpath("//table[@class='swWWne']/tbody")).getText();
			System.out.println(value);
		}
	}
}
