package pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Council_approval {

	
	@FindBy(xpath = "//*[@id='tableComplaint_filter']/label/input") public WebElement Quick_search;
	@FindBy(xpath = "//*[@id='btnApprove']") private WebElement open_approvalpopup;
	@FindBy(xpath = "//*[@id='tblbodyComplaint']/tr/td[2]") private WebElement complaintid;
	@FindBy(xpath = "//*[@id='modalApprove']/div/div/div[3]/div/a[2]") private WebElement nextbutton;
	@FindBy(xpath = "//*[@id='txtApprovalRemark']") private WebElement Approvalremark;
	@FindBy(xpath = "//*[@id='btnMdlApprove']") private WebElement Approval_BTN;
	
	public Council_approval(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void pageloading(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor j = (JavascriptExecutor)driver;
	    if (j.executeScript
	    		("return document.readyState").toString().equals("complete")){
	    		System.out.println("Page loaded properly.");
	    	}
	    Thread.sleep(500);
	}
	

	
	public void Search_complaint(WebDriver driver,String str) throws InterruptedException
	{
		Thread.sleep(10000);
		System.out.println(Quick_search);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Quick_search));
		Thread.sleep(500);
		Quick_search.sendKeys(str);
	}
	
	public void clickToOpen(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(10000);
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(open_approvalpopup));
		Thread.sleep(500);
		open_approvalpopup.click();
	}
	
	public String Fetch_grievance_id(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(complaintid));
		
		Thread.sleep(2000);
		String val = complaintid.getText();
		return val;
	}
	
	public void clicknext(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(nextbutton));
		Thread.sleep(500);
		nextbutton.click();
		Thread.sleep(1000);
	}
	
	public void Enter_remark(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(Approvalremark));
		Thread.sleep(500);
		Approvalremark.sendKeys("test approval remark");
		Thread.sleep(1000);
	}
	
	public void clickOnapproval(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(Approval_BTN));
		Thread.sleep(500);
		Approval_BTN.click();
		Thread.sleep(1000);
	}
	
	
	
}


