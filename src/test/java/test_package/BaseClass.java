package test_package;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import pageObject.ParentPage;
import resources.BrowserClass;

public class BaseClass extends BrowserClass {
	WebDriver driver;

	@Test
	
	public void getdata123() throws IOException, InterruptedException
	{
		driver = initializeDriver();
	    String baseUrl = "https://www.nite.go.jp/en/chem/chrip/chrip_search/cmpInfLst?slIdxNm=&slScNm=RJ_04_071&slScCtNm=&slScRgNm=&ltCatFl=&slMdDplt=0&ltPgCt=500&stMd=&adMdCl=";

	    driver.get(baseUrl);
        ParentPage Ppg = new ParentPage(driver);
        Ppg.getcolumn();
        String data1 = Ppg.data1;

}
}
