package pom;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CollectionReportsPage {
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtPropertyUniqueNo']") private WebElement upic_code_checkbox;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtPropertyWise']") private WebElement property_no_radio_btn;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlNodeNo']") private WebElement node_no;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlSectorNo']") private WebElement sector_no;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlSectorNo']//option") private WebElement sector_options;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtPropertyNo']") private WebElement property_no;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnGetProperty']") private WebElement search_property;
	
	
	
	public void Click_upic_code_checkbox() throws InterruptedException
	{
		Thread.sleep(1000);
		upic_code_checkbox.click();
	}
	
	public void Click_property_no_radio_btn(WebDriver driver)
	{			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(120000));
		wait.until(ExpectedConditions.visibilityOf(property_no_radio_btn));
		
		property_no_radio_btn.click();
	}
	
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
	
	public void Enter_property_no(WebDriver driver, String str) throws InterruptedException
	{
		property_no.sendKeys(str);
		Thread.sleep(2000);
		
		
		
		  if (str.contains("-")) {
			  property_no.sendKeys(Keys.ARROW_DOWN);
				property_no.sendKeys(Keys.ENTER);
	        } else {
	          
	        }
		  
	}
	
	public void Click_search_property() throws InterruptedException
	{
		Thread.sleep(1000);
		search_property.click();
	}
	
	public void CollectionReports_link(String url, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "CollectionReport.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}

}
