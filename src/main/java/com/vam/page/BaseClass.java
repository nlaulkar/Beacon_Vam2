package com.vam.page;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass 
{
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static Actions act;
	
	
	public BaseClass() throws IOException
	{
		
		//initializing the Object repository file using dynamic path.
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\vam\\OR\\OR.properties");
		
		//loading the file in properties
		prop = new Properties();
		prop.load(ip);
		
		//execution based on the selected properties
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void initialize()
	{
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) 
		{
		
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\vam\\driver\\chromedriver.exe");
			ChromeOptions opt= new ChromeOptions();
			opt.setExperimentalOption("debuggerAddress", "localhost:9223");
			//driver = new ChromeDriver(opt);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(prop.getProperty("URL"));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
		}
	}
	
	public void sendKeys(String xpathKey, String userData)
	{
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(userData);
	}
	
	public void click(String xpathKey)
	{
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).click();
	}
	public WebElement findelement(String xpathKey)
	{
		WebElement element = driver.findElement(By.xpath(prop.getProperty(xpathKey)));
		return element;
	}
	public List<WebElement> findelements(String xpathKey)
	{
		List<WebElement> list = driver.findElements(By.xpath(prop.getProperty(xpathKey)));
		return list;
	}
	
	public boolean isLinkpreent(String xpathKey)
	{
		try
		{
			driver.findElement(By.xpath(prop.getProperty(xpathKey)));
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
