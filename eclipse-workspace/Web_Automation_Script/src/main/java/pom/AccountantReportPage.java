package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountantReportPage {
	
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnGetReport']") private WebElement zone_office_report_btn;
	
	
	public AccountantReportPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Zone_Office_Report_btn(WebDriver driver)
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		zone_office_report_btn.click();
	} 
	
	public void AccountantReports_link(String url, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "Accountant.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}

}
