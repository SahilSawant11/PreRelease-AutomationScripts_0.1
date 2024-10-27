package pom_PCMC;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AMC {

	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblShowPropertyNo']") private WebElement property_no_lable;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblShowOwnerName']") private WebElement kar_dharak_nav_lable;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnRefreshTaxes']") private WebElement Refresh_Taxes_btn;
	
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVWadhGhatDocument_lblDocumentName_8']") private WebElement scroll_sthalpahani_ahaval;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_GVWadhGhatDocument_lnkUpload_8']") private WebElement upload_durusti_patra9;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_GVWadhGhatDocument_lnkUpload_9']") private WebElement upload_wadhaghat_kagadpatra10;
	
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnSaveDataOnAddTaxes']") private WebElement save_btn;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnRegisterN']") private WebElement addTax_complaint_register_btn_no;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnPrintWadhghat']") private WebElement print_approval_btn;
	
	@FindBy(xpath = "//div[text()='Data saved successfully.']") private WebElement data_save;
	@FindBy(xpath = "/html/body/div[3]/div[7]/button") private WebElement no_OCdate_popup;
	@FindBy(xpath = "/html/body/div[3]/p") private WebElement sendToApproval;
	
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnSendToApproval']") private WebElement send_to_approval_btn;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_MP1FileUpload']") private WebElement choose_file;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_MP1Upload']") private WebElement upload_btn;
	@FindBy(xpath = "//div[@id='ContentPlaceHolder1_PanelUpdateProgress']") private WebElement loading_page;
	
	
	public AMC(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String Fetch_property_no_lable(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(property_no_lable));
		
		String str = property_no_lable.getText();
		return str;
	}
	
	public String Fetch_kar_dharak_nav_lable()
	{
		String str = kar_dharak_nav_lable.getText();
		return str;
	}
	
	public void Button_Refresh_Taxes_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(Refresh_Taxes_btn));
		
		Refresh_Taxes_btn.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
}
