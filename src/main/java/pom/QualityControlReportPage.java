package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QualityControlReportPage {
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ddlReports']") WebElement select_report ;
	//@FindBy(xpath = "//select[@name='ContentPlaceHolder1_ddlReports']//option[2]") WebElement defaulter_report ;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ddlNodeNo']") private WebElement node_no ;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ddlSectorNo']") private WebElement sector_no ;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlSectorNo']//option") private WebElement sector_options;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ddlFromProperty']") private WebElement from_property ;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ddlToProperty']") private WebElement to_property;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ddlInterest']") private WebElement interest_option ;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtAmount']") private WebElement enter_amount;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnShow']") private WebElement show_btn ;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnExport']") private WebElement export_btn ;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnExport']") private WebElement current_option ;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnExport']") private WebElement pending_option;
	
	public QualityControlReportPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Select_report_type(WebDriver driver, String str)
	{
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_report));
		Select report = new Select(select_report);
		report.selectByVisibleText("Defaulter Reports");
	}
	
/*	public void Select_defaulter_report(WebDriver driver, String str)
	{
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(defaulter_report));
		Select defaulter_report_type = new Select(defaulter_report);
		defaulter_report_type.selectByValue(str);
	}
*/	
	
	public void Select_node_no(WebDriver driver,String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(node_no));
		Select node = new Select(node_no);
		node.selectByValue(str);
	}
	
	public void Select_sector_no(WebDriver driver, String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(120000));
		wait.until(ExpectedConditions.visibilityOf(sector_options));
		Select sector = new Select(sector_no);
		sector.selectByValue(str);
	}
	
	public void Select_from_property(WebDriver driver, String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOf(from_property));
		Select from_prop = new Select(from_property);
		from_prop.selectByValue(str);
	}
	
	public void Select_to_property(WebDriver driver, String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOf(to_property));
		Select to_prop = new Select(to_property);
		to_prop.selectByValue(str);
	}
	
	public void current_checkbox() throws InterruptedException
	{
		Thread.sleep(1000);
		current_option.click();
	}
	
	public void pending_checkbox() throws InterruptedException
	{
		Thread.sleep(1000);
		pending_option.click();
	}
	
	public void Enter_tax_amount(String str)
	{
		enter_amount.clear();
		enter_amount.sendKeys(str);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
