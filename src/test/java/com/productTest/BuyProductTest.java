package com.productTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BuyProductTest {
	public static void main(String[] args) throws InterruptedException
	{
	//WebDriverManager.chromedriver().setup();
	ChromeOptions opt=new ChromeOptions();
	opt.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(opt);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.ajio.com/?gclid=CjwKCAjw9-KTBhBcEiwAr19ig2vftj9gMsh3PY-IEb3OoI0ctWwToD3uYp3PUJYE5TYDhDGkVYnx5BoCzhsQAvD_BwE");
	driver.findElement(By.xpath("//a[@title='KIDS']")).click();
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,2000);");
	driver.findElement(By.xpath("//a[@href='/s/starting-at-rs-199-4691-77081']")).click();
	Thread.sleep(2000);
	Set<String>allid=driver.getWindowHandles();
	for(String id:allid)
	{//
		driver.switchTo().window(id);
		if(driver.getTitle().contains("starting"))
		{
			break;
		}
	}
	WebElement sortDropdown=driver.findElement(By.xpath("//div[@class='sort ']/div/select"));
	Select s=new Select(sortDropdown);
	s.selectByValue("prce-desc");
	Thread.sleep(2000);
	
		
	}

}
