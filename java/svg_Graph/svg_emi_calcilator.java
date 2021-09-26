package svg_Graph;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//URL-https://emicalculator.net/
//i want to automate and fetch the data from graph
public class svg_emi_calcilator {

	WebDriver driver;
	@Test
	public void emi_cal() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1300)", "");
		
		
		
		List<WebElement> element=driver.findElements(By.xpath
	("//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group' ]//*[name()='rect']"));
		System.out.println(element.size());
		String svgtext=" //*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined' ]//*[name()='text']";
		Actions act=new Actions(driver);
		for (WebElement ele : element) {
			Thread.sleep(500);
			act.moveToElement(ele).perform();
			Thread.sleep(500);
			String text=driver.findElement(By.xpath(svgtext)).getText();
			System.out.println(text);
			
		}
		
		
	}
}
