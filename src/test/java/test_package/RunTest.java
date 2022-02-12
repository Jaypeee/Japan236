package test_package;

import java.io.BufferedWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObject.ChildPage1;
import pageObject.ParentPage1;
import resources.BrowserClass;
import resources.FileHandler;

public class RunTest extends BrowserClass{
	
	WebDriver driver;
	ParentPage1 pg;
	ChildPage1 cp;
	static BufferedWriter BW;

	@Test
	
	public void getdata123() throws IOException, InterruptedException
	{
		driver = initializeDriver();
	    String baseUrl = "https://www.nite.go.jp/en/chem/chrip/chrip_search/cmpInfDsp?cid=C006-238-30A&slIdxNm=&slScNm=RJ_04_071&slScCtNm=&slScRgNm=&bcPtn=4";
	    driver.get(baseUrl);
	    Thread.sleep(3000);
	    System.out.println(driver.findElement(By.xpath("//a[contains(text(), 'Industrial')]//parent::div//parent::div//following::ul/li/div/div/table/tbody/tr[1]/td[2]")).getText());
	    System.out.println(driver.findElement(By.xpath("//a[contains(text(), 'Industrial')]//parent::div//parent::div//following::ul/li/div/div/table/tbody/tr[2]/td[2]")).getText());
	    System.out.println(driver.findElement(By.xpath("//td[contains(text(), 'Appendix')]//parent::tr//parent::tbody/tr[2]/td[2]")).getText());

	    
	    
	    
	   /* BW=CreateFile.getBW();
	    
        pg = new ParentPage1(driver);
        int numberOfSubstanceOnPage = pg.parentPageColumns().size();
        WebElement pointer = null;
        
        for (int j=1;j<=10;j++)
		{
			Thread.sleep(3000);
			pointer= pg.parentPageColumns().get(j);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pointer);
			pointer.click();
		
			cp= new ChildPage1(driver);
			String cData = cp.getChildData();
			System.out.println(cData);
			
			try {
				BW.write(cData);
				BW.newLine();
			}catch (IOException e) {
				System.out.println("Not writining into Text File");
				e.printStackTrace();
			}
			
			cp.NavigateToParent();	
			
			
		}
		
		pg.clickOnNextPage();
		
		
        
        BW.close();
        tearDown();*/

	}
	
	
	

}
