package Seleniumproject.com.Selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MintraPageTest extends Baseclass {

	static WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait=new WebDriverWait(driver,15);
	
	public static void main(String[] args) throws InterruptedException {
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
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Men') and @class='desktop-main']")))
				.build().perform();
		action.moveToElement(driver.findElement(By.xpath("//li[@data-reactid='29']//a[contains(text(),'T-Shirts') ]")))
				.click().build().perform();
	
	
	
		 action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait=new WebDriverWait(driver,15);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='vertical-filters-filters brand-container']/div[2]")).click();
		//li[@class='FilterDirectory-listTitle ']
		Set<String> window=driver.getWindowHandles();
		Iterator< String> it=window.iterator();
		String parent=it.next();
		driver.switchTo().window(parent);
		js.executeScript("window.scrollBy(0,150)");
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Puma");
		Thread.sleep(1000);
		List<WebElement> allBrand=driver.findElements(By.xpath("//label[@class=' common-customCheckbox']"));
		Thread.sleep(3000);
		allBrand.stream().distinct().filter(s->s.getText().contains("Puma")).forEach(s->s.click());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//ul[@class='price-list']/li[2]/label/div")).click();
	
		Thread.sleep(5000);
		String productNumber = driver.findElement(By.xpath("//span[@class='title-count']")).getText().split(" ")[2];
		System.out.println(productNumber);
		action.moveToElement(driver.findElement(By.className("sort-sortBy"))).build().perform();
		Thread.sleep(4000);
		action.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Price: Low to High')]"))).click().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//h4[contains(text(),'Fabric 2')]"))).build().perform();
	
	
			Thread.sleep(4000);
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']//h4[@class='product-product']"));
		System.out.println(element.size());
		String exp="Colourblocked T-shirt";
		Thread.sleep(3000);
		int count=0;
		for (WebElement ele : element) {
			String text=ele.getText();
			System.out.println(text);
			Thread.sleep(500);
			if(text.equals(exp)) {
				ele.click();
				count++;
				break;
			}
		}
		Thread.sleep(3000);
		WebElement nextButton=driver.findElement(By.xpath("//li[@class='pagination-next']"));
		while (count==0) {
			js.executeScript("window.scrollBy(0,500)");
			nextButton.click();
			Thread.sleep(4000);
			element = driver.findElements(By.xpath("//li[@class='product-base']/a/div[2]/h4[@class='product-product']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			element.stream().filter(s->s.getText().equals(exp)).forEach(s->s.click());
			try {
			driver.findElement(By.xpath("//li[@class='pagination-next']"));
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
			
		}
}
	

	
}
