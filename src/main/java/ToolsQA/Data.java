package ToolsQA;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Data {

	public static void main(String[] args) throws InterruptedException {

/*			comment the above line and uncomment below line to use Chrome
		    import org.openqa.selenium.chrome.ChromeD
	 		declaration and instantiation of objects/variables
			 System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
			 WebDriver driver = new FirefoxDriver();	
*/
		
//comment the above 2 lines and uncomment below 2 lines to use Chrome
		
				System.setProperty("webdriver.chrome.driver","./drivers/chrome/chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
		        String baseUrl = "https://www.nite.go.jp/en/chem/chrip/chrip_search/cmpInfLst?slIdxNm=&slScNm=RJ_04_071&slScCtNm=&slScRgNm=&ltCatFl=&slMdDplt=0&ltPgCt=500&stMd=&adMdCl=";
		        String expectedTitle = "Welcome: Mercury Tours";

		        // launch Fire fox and direct it to the Base URL
		        driver.get(baseUrl);

		        // get the actual value of the title
		        String actualTitle = driver.getTitle();
		        
		        //Find elements of main table
		        List <WebElement> rows = driver.findElements(By.xpath("//table[@class='list-table']/tbody/tr"));
		        System.out.println("No of rows are : " + rows.size());
		        
		        //iterate with main table
		        for (int i = 0;i < rows.size(); i++) {      	
		        	List <WebElement>  column = driver.findElements(By.xpath("//*[@id=\"content-area\"]/div[3]/table/tbody/tr/td/a"));
		        	//System.out.println(column.size());
		        	
		        	for (int j = 0;j < column.size(); j++) {
			        	Thread.sleep(300);
			        	column = driver.findElements(By.cssSelector("td[class^='t-cell t-column1']"));
			        	System.out.println(column.get(j).getText());
			        	column.get(j).click();
			        	
			        	Iterator<WebElement> iterator = column.iterator();
						while (iterator.hasNext()) {
							String data =driver.findElement(By.xpath("//td[contains(text(), 'CHRIP_ID')]/../td[@class='cols-width25 t-cell'][1]")).getText();
							String data2 =driver.findElement(By.xpath("//td[contains(text(), 'CHRIP_ID')]/../td[@class='cols-width25 t-cell'][2]")).getText();		        
							WebElement Value2 =driver.findElement(By.xpath("//*[contains(text(), 'Appendix')]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Value2);
							Thread.sleep(5000); 
							String s1 =Value2.getText();
							System.out.println(data );
							System.out.println(data2 );
							System.out.println(s1 );
							driver.findElement(By.xpath("//a[contains(text(), 'Interim Search Results')]")).click();
							Thread.sleep(5000);
							break;	        	      
		        	     }
		        	      Thread.sleep(3000);   

			        }
		        }
		        
	}
	
}
