package pageObject;

import java.io.BufferedWriter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ChildPage1 {
	
	public WebDriver driver;
	private JavascriptExecutor executor;
	public static BufferedWriter BW;
	
	@FindBy(how = How.XPATH,using = "//td[contains(text(), 'CHRIP_ID')]/../td[@class='cols-width25 t-cell'][1]")
	WebElement chripId;
	
	@FindBy(xpath = "//td[contains(text(), 'CHRIP_ID')]/../td[@class='cols-width25 t-cell'][2]")
	WebElement casNum;
	
	@FindBy(xpath="//td[contains(text(), 'ISHA Number')]//parent::tr//parent::tbody/tr/td/div")
	WebElement registr_number; //id-num2
	
	@FindBy(xpath="//td[contains(text(), 'ISHA Number')]//parent::tr/td/div")
	WebElement isha_number; //id-num3
	
	@FindBy(xpath="//td[contains(text(), 'Appendix')]//parent::tr//parent::tbody/tr[2]/td[2]")
	WebElement sub_Name; // name
	
	@FindBy(xpath = "//*[contains(text(), 'Appendix')]")
	WebElement appendix; //code3 + id-num4
	
	
	public ChildPage1 (WebDriver driver)
	{
		this.driver=driver;
		this.executor = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void NavigateToParent()
	{
		driver.navigate().back();
		driver.navigate().refresh();
		
	}
	
	
	

	public String getChildData(){
		
		int lastIndex;
	    int firstParenthesis;
	    int secondParenthesis;
	    String firstString=null;
	    String secondString=null;
	    String thirdString=null;
	    String totalSub = null;
	    String appendixNum = null;
		
		String regNum=null;
		String ishaNum=null;
		
		try{
			executor.executeScript("arguments[0].scrollIntoView(true);", registr_number);
			regNum = registr_number.getText();
		}catch(NoSuchElementException e){
			regNum = "";
		}
		try{
			executor.executeScript("arguments[0].scrollIntoView(true);", isha_number);
			ishaNum = isha_number.getText();
		}catch(NoSuchElementException e){
			ishaNum = "";
		}
		
		executor.executeScript("arguments[0].scrollIntoView(true);", appendix);
		appendixNum = appendix.getText();
		lastIndex = appendixNum.lastIndexOf("A");
	    firstParenthesis = appendixNum.indexOf("(");
	    secondParenthesis = appendixNum.indexOf(")");
	    firstString = appendixNum.substring(0, lastIndex).trim();
	    secondString = appendixNum.substring(lastIndex, firstParenthesis);
	    thirdString = appendixNum.substring(firstParenthesis+1, secondParenthesis);
	    totalSub = firstString+";"+secondString+";"+thirdString;
		
		String chrip = chripId.getText() +";"+ casNum.getText();
		String numbers = regNum+";"+ishaNum;
		String finaltext = chrip+";"+numbers+";"+sub_Name.getText()+";"+totalSub;				
		return finaltext;
	}
	

	
}
	