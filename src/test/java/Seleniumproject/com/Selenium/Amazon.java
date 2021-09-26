package Seleniumproject.com.Selenium;





	import java.util.Iterator;
	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	
	
	
	public class Amazon {
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
			driver.get("https://www.amazon.in/");

			// Login to the amazon site
		}

		@Test(priority = 1, testName = "Verify login process")
		public void LoginAmazon() throws InterruptedException {
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.id("nav-link-accountList"))).click().build().perform();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.id("ap_email")).sendKeys("9178327403");
			driver.findElement(By.xpath("//span[@id='continue']")).click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector("#ap_password")).sendKeys("9178327403");
			driver.findElement(By.cssSelector("#auth-signin-button")).click();

		}

		@Test(priority = 2,testName = "Select a Product")
		public void searchProd() throws InterruptedException {
			driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Samsung mobile", Keys.ENTER);
			WebElement element = driver.findElement(By.cssSelector("#s-result-sort-select"));
			Select select = new Select(element);
			select.selectByVisibleText("Price: Low to High");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//span[contains(text(),'₹10,000 - ₹20,000')]")).click();
			List<WebElement> listofmobile = driver.findElements(
					By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
			
			for (WebElement ele : listofmobile) {
				String expected=ele.getText();
				System.out.println(expected);
				String actual = "Samsung Galaxy M31 (Space Black, 6GB RAM, 128GB Storage)";
				if(actual.equals(expected)) {
					ele.click();
					break;
				}
			}
			Set<String> window=driver.getWindowHandles();
			Iterator<String> it=window.iterator();
			String parent=it.next();
			String child=it.next();
			driver.switchTo().window(child);
			Actions act = new Actions(driver);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//input[@id='add-to-cart-button']"))).click().perform();
			Thread.sleep(3000);
			
			action.moveToElement(driver.findElement(By.xpath("//form/span[@id='attach-sidesheet-view-cart-button']"))).click().build().perform();
			Thread.sleep(10000);
			action.moveToElement(driver.findElement(By.xpath("//div[@id='nav-tools']/a[5]"))).click().build().perform();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			action.moveToElement(driver.findElement(By.xpath
					("//div[@class='a-section a-spacing-mini sc-list-body sc-java-remote-feature']/div[3]/div[4]/div/div/div/div/div[2]/div/span[2]"))).click().build().perform();
		}
	}



