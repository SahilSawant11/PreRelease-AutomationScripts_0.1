package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QRScaningPage {
	
	@FindBy(xpath = "/html/body/form/div[4]/section/section/section[3]/div[2]/div/div[2]/div[1]/div[3]/input") private WebElement complaint_Id;
	
	
	//@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtFilterComplaintID']") private WebElement complaint_Id;
	
	
	
	
	public QRScaningPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public void Enter_complaint_Id(WebDriver driver, String str) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(complaint_Id));
		Thread.sleep(500);
		complaint_Id.sendKeys(str);
	}
	
	
	
	
	
	
	
	
	
	public void QR_ScaninigTest_link(String url, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "offlinePayment.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}

}
