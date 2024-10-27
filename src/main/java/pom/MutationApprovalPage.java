package pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MutationApprovalPage {

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtWadhghatRemark']") private WebElement approval_remark;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ApproveALL']") private WebElement approval_all;
	@FindBy(xpath = "//div[@id='ContentPlaceHolder1_PanelUpdateProgress']") private WebElement loading_page;
	
	public MutationApprovalPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Enter_approval_remark(String str, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(approval_remark));
		
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", approval_remark);
		Thread.sleep(500);
	
		approval_remark.sendKeys(str);
	}
	
	public void Button_approval_all(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(approval_all));
		
		approval_all.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void MutationApproval_link(String url, WebDriver driver)
	{
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "MutationApproval.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}
}
