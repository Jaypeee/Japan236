package pageObject;



import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ParentPage1 {
	
	public WebDriver driver;
	public static BufferedWriter BW;

	@FindBy(xpath="//*[@id=\"content-area\"]/div[2]/a/font")
	WebElement byChripId;
	
	@FindBy (xpath="//a[contains(text(),'Next Page')][1]")
	WebElement nextPage;
	
	@FindBy(id = "slMdDplt2")
	WebElement dropDown;
	
	public ParentPage1 (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	public List <WebElement> parentPageColumns() 
	{
		List <WebElement>  column1 = driver.findElements(By.xpath("//table[@class=\"list-table\"]/tbody/tr/td/a"));
		return column1;
	}
	
	
	public void getNumberOfParentSheets(){
		Select sel = new Select(driver.findElement(By.xpath("//*[@id='slMdDplt2']")));
	    List<WebElement> list = sel.getOptions();
	}
	
	public int getNumberOfSubs(){
	    String getNumberSub = driver.findElement(By.xpath("//div[@class= \"item-box\"][2]/div")).getText();
	    int startIndex = getNumberSub.indexOf("/");
	    int endIndex = getNumberSub.indexOf("Next Page");
	    int totalSub = Integer.valueOf(getNumberSub.substring(startIndex+1, endIndex).trim());
	    return totalSub;
	}
	
	public int getParentPagess(){
		 Select sel = new Select(dropDown);
		 List<WebElement> list = sel.getOptions();
		 int maxNumberOfPages = list.size();
		return maxNumberOfPages;
		 
	}
	
	public void clickOnNextPage(){
		if(nextPage.isEnabled()){
			nextPage.click();
		}else{
			System.out.println("No further Pages");
		}
		
		
	}
	
	
	
	
	
	
}
	
