package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ToolsQA.Data;

public class ChildPage {
	
	public WebDriver driver;
	
	public ChildPage (WebDriver driver)
	{
		this.driver=driver;
	}
	
	By data1 = By.xpath("//td[contains(text(), 'CHRIP_ID')]/../td[@class='cols-width25 t-cell'][1]");
	By data2 = By.xpath("//td[contains(text(), 'CHRIP_ID')]/../td[@class='cols-width25 t-cell'][2]");
	By data3 = By.xpath("//*[contains(text(), 'Appendix')]");
	
	public WebElement getdata1()
	{
		 return driver.findElement(data1);

	}
	
	public WebElement getdata2()
	{
		 return driver.findElement(data2);

	}
	
	public String getdata3()
	{
	       WebElement Value2 =driver.findElement(data3);
	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Value2);
            return Value2.getText();
	}
	
	public void NavigateToParent()
	{
		driver.navigate().back();
		driver.navigate().refresh();
	}
	
}
	
//	Data d = new Data();
//	
//
//	System.out.println(d.column.size());
//    for (int j = 1;j <= column.size(); j++) {
//        // count columns with size() method
//    	Thread.sleep(300);
////    	column = driver.findElements(By.cssSelector("td[class^='t-cell t-column1']"));
////    	System.out.println(column.get(j).getText());
////    column.get(j).click();
//    	driver.navigate().refresh();
//    	driver.findElement(By.xpath("//*[@id=\"content-area\"]/div[3]/table/tbody/tr/td["+j+"]/a")).click();
//
//}
