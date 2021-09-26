package svg_Graph;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//URL-C:/Users/Bikash/Desktop/demo.html
//Test case-Take the x-path and verify the colour of the each svg picture 


public class Graph_svg {
	
	WebDriver driver;
	@Test
	public void handleSvg() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("C:/Users/Bikash/Desktop/demo.html");
		String text =driver.findElement(By.xpath("//*[name()='svg']//*[@id='cir']")).getAttribute("fill");
		System.out.println(text);
		assertEquals(text, "yellow");
	Rectangle value=driver.findElement(By.xpath("//*[name()='svg']//*[@id='rec']")).getRect();
		System.out.println(value);
		driver.close();
		
	}

}
