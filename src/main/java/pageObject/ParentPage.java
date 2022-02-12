package pageObject;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ToolsQA.Data;
import resources.FileHandler;

public class ParentPage {
	
	public WebDriver driver;
	public String data1;
	public String data2;
	public String data3;
	public static BufferedWriter BW;	
	
	@FindBy (xpath="//a[contains(text(),'Next Page')][1]")
	WebElement nextPage;
	
	public ParentPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public static void writefile() throws IOException
	{
	  String TestFile = "D:\\temp2.txt";
//	  File FC = new File(TestFile);
//	 CreateFile fl = new CreateFile();
	  FileWriter FW = new FileWriter(TestFile);
	  BW = new BufferedWriter(FW);
	
	}
	
	
	
	
	
	
	public void getcolumn() throws InterruptedException, IOException
	{
//		ParentPage.writefile();
		List <WebElement>  column1 = driver.findElements(By.xpath("//*[@id=\"content-area\"]/div[3]/table/tbody/tr/td/a"));

		for (int j=498;j<=column1.size()+1;j++)
		{
			Thread.sleep(3000);
			WebElement link = driver.findElement(By.xpath("//*[@id=\"content-area\"]/div[3]/table/tbody/tr["+j+"]/td/a"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
			driver.findElement(By.xpath("//*[@id=\"content-area\"]/div[3]/table/tbody/tr["+j+"]/td/a")).click();
		 ChildPage Cp=new ChildPage(driver);
//		 System.out.println(Cp.getdata1().getText());
//		 System.out.println(Cp.getdata2().getText());
		 data1 = Cp.getdata1().getText();
		 data2 = Cp.getdata2().getText();
		 data3 = Cp.getdata3();
		 System.out.println(data1 + ' ' + data2 + ' ' + data3);
		 System.out.println(Cp.getdata2().getText());
			 BW.write(data1+ ' ' +data2+ ' ' +data3);
			 BW.newLine();
			 

// navigate to parent page after selecting data
		 Cp.NavigateToParent();
		 driver.navigate().refresh();
		 System.out.println(j);
		
			// After 
		if (j==column1.size()+1)
//			if (j==319)
		{
			Thread.sleep(3000);
//			List<WebElement> 
//			nextPages = driver.findElements(nextPage);
				
			    Select sel = new Select(driver.findElement(By.xpath("//*[@id='slMdDplt2']")));

			    List<WebElement> list = sel.getOptions();

			 
			        if(list.get(list.size()-1).isSelected())
			            break;
			            
			    
			WebElement nextPage = driver.findElement(By.xpath("//a[contains(text(),'Next Page')][1]"));
			System.out.println("displaystatus" + nextPage.isDisplayed());
//			WebElement developers_dropdown = driver.findElement(By.id("developers-menu-toggle"));
//			Select objSelect = new Select(developers_dropdown);
//			objSelect.selectByIndex(count);
			Thread.sleep(3000);
			
//			if(nextPages.size()>0)
//			if(nextPage.isDisplayed())
//			{
				System.out.println("color" + nextPage.getCssValue("color"));
			nextPage.click();
			getcolumn();
//			} while (
//					try {
//				     nextPage1.i
//		    } catch (org.openqa.selenium.NoSuchElementException e) {
			}
	
//		break;
			
			
		}
		

	
		BW.close();
	}
}
	
//	Data d = new Data();
	

//	System.out.println(d.column.size());
//    for (int j = 1;j <= column.size(); j++) {
//        // count columns with size() method
//    	Thread.sleep(300);
////    	column = driver.findElements(By.cssSelector("td[class^='t-cell t-column1']"));
////    	System.out.println(column.get(j).getText());
////    column.get(j).click();
//    	driver.navigate().refresh();
//    	driver.findElement(By.xpath("//*[@id=\"content-area\"]/div[3]/table/tbody/tr/td["+j+"]/a")).click();


