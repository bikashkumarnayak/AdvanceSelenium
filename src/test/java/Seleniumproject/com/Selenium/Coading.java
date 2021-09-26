package Seleniumproject.com.Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Coading {
	static WebDriver  driver;
public static void main(String[] args) throws IOException {
		
		
		//Find element
		WebElement element=driver.findElement(By.xpath(""));
		//List of WebElement
		List<WebElement> elements=driver.findElements(By.xpath(""));
		//Window dimention
		int length=800;
		int wedth=900;
		Dimension d=new Dimension( length,  wedth);
		driver.manage().window().setSize(d);
		//window handle
		Set<String> Window=driver.getWindowHandles();
		Iterator<String> iterator=Window.iterator();
		String parent=iterator.next();
		driver.switchTo().window(parent);
		//Alert
		Alert alert=driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		alert.getText();
		alert.sendKeys("");
		//Handle the authontication popup entering username and password
		String url="http://username:password@the-site.com";
		//Action class
		Actions action=new Actions(driver);
		WebElement act=driver.findElement(By.xpath(""));
		action.moveToElement(act).build().perform();
		action.moveToElement(act).click().build().perform();
		//double click
		action.doubleClick(act).perform();
		//right click
		action.contextClick(act).perform();
		WebElement source=driver.findElement(By.xpath(""));
		WebElement destination=driver.findElement(By.xpath(""));
		action.dragAndDrop(source, destination).build().perform();
		WebElement element1=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement destination1=driver.findElement(By.xpath("//div[@id='droppable']"));
		action.clickAndHold(element1).moveToElement(destination1).release().build().perform();
		//Right click in a elemnt it should show somthing
		action.contextClick(element1).build().perform();
		//Take screenshot
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(""));
		//implicity wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Explicity wait
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("")));
		//how to handle Browser notification
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-Notification");
		driver=new ChromeDriver(co);
		//How to handle select class
		Select sel=new Select(driver.findElement(By.xpath("")));
		sel.selectByIndex(wedth);
		sel.selectByValue(parent);
		sel.selectByVisibleText(url);
		sel.deselectByIndex(wedth);
		sel.deselectByValue(url);
		sel.deselectByVisibleText(url);
		sel.deselectAll();
		//clear text box with out using cleare method
		driver.findElement(By.xpath("")).sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
		//ExcelSheet input
		File file=new File("");
		FileInputStream fs= new FileInputStream(file);
		Workbook wb=WorkbookFactory.create(fs);
		Sheet sh=wb.getSheetAt(0);
		sh.getRow(0);
		FileOutputStream fot=new FileOutputStream("");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Autoit script
		Runtime.getRuntime().exec("");
		//navigate method
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().to("");
		//scroll function javascriept;
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000);", "");
		js.executeScript("argument[0].scrollIntiView();", args);
		js.executeScript("argument[0].click", element);
		js.executeScript("argument[0].value=''", element);
	//How to username and password in alert
		driver.get("\"http://\" + abha_r + \":\" + myPassword + \"@\" + www.prime.amazon.com");
		String color=driver.findElement(By.xpath("")).getCssValue("");
		driver.switchTo().frame(wedth);
		driver.manage().deleteAllCookies();

	}

}
