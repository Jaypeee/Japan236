package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObject.ParentPage;


public class BrowserClass {
	
	public WebDriver driver;
	
	
	public WebDriver initializeDriver() throws IOException
	{
//		Properties prop = new Properties();
//		FileInputStream fls = new FileInputStream("C://Users//jayap//Desktop//Lavanya//E2EProject//src//main//java//resources//data.properties");
//		
//		prop.load(fls);
//
//		String browserName1=prop.getProperty("browser");
//		System.out.println(browserName1);
//		if(browserName1.equalsIgnoreCase("chrome"))
//		{
			System.setProperty("webdriver.chrome.driver","./drivers/chrome/chromedriver.exe");
			driver = new ChromeDriver();
			FileHandler.writefile();
//		}
		
		return driver;

	}
	
	public void tearDown(){
		driver.quit();
	}

}
