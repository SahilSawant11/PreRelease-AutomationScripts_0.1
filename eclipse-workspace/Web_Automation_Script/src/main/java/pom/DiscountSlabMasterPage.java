package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent;

public class DiscountSlabMasterPage {

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtDiscountDateFrom']") private WebElement from_date;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtDiscountDateTo']") private WebElement to_date;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtHour']") private WebElement from_h;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMinute']") private WebElement from_m;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtHour1']")  private WebElement to_h;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMinute1']") private WebElement to_m;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtDiscountRate']") private WebElement discountRate;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtDiscountYear']") private WebElement year;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_DDLZoneSectionNo']") private WebElement discountZone;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_SectorList_chkAll']") private WebElement AllSector;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_DDLPage']") private WebElement discountOnPage;
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_DDlPartial']") private WebElement tabPartialAllow;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_TxtAllwTran']") private WebElement tabAllowTransaction;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSave']") private WebElement save_btn;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnCancel']") private WebElement cancel_btn;
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_PanelUpdateProgress']") private WebElement pageloading;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_GVDiscountSlab_delBtn_0']") private WebElement removeDiscount;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_GVDiscountSlab_delBtn_1']") private WebElement removeDiscount2;
	
	//////////interest discount/////////////
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPercentage']") private WebElement interestOfflineDiscount;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPercentageOnline']") private WebElement interestOnlineDiscount;
	
	
	public DiscountSlabMasterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void icon_pageloading() throws InterruptedException
	{
		Thread.sleep(1000);
		while(pageloading.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting for complaint to search");
		}
		Thread.sleep(500);
	}
	
	public void RemoveDiscount(WebDriver driver)
	{
		try {
			while(removeDiscount.isDisplayed())
			{
				removeDiscount.click();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				Thread.sleep(1000);
				while(pageloading.getAttribute("aria-hidden").equals("false"))
				{
					Thread.sleep(500);
					System.out.println("waiting for complaint to search");
				}
				Thread.sleep(1000);
			}
			
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void waitForDiscountRow(String str)
	{
		int i=0;
		try {
			
			while(!removeDiscount.isDisplayed())
			{
				System.out.println(i);
				i++;
			}
			while(!removeDiscount2.isDisplayed())
			{
				System.out.println("error");
				i++;
			}
		}
		catch(Exception e)
		{
			while(!removeDiscount2.isDisplayed())
			{
				System.out.println("ok");
				i++;
			}
		}
		
	}
	
	
	public void Enter_from_date(String str)
	{
		from_date.clear();
		from_date.sendKeys(str);
	}
	
	
	public void Enter_to_date(String str)
	{
		to_date.clear();
		to_date.sendKeys(str);
	}
	
	public void Enter_from_h(String str)
	{
		from_h.clear();
		from_h.sendKeys(str);
	}
	
	public void Enter_from_m(String str)
	{
		from_m.clear();
		from_m.sendKeys(str);
	}
	
	public void Enter_to_h(String str)
	{
		to_h.clear();
		to_h.sendKeys(str);
	}
	
	public void Enter_to_m(String str)
	{
		to_m.clear();
		to_m.sendKeys(str);
	}
	
	public void Enter_discountRate(String str)
	{
		discountRate.clear();
		discountRate.sendKeys(str);
	}
	
	public void Enter_year(String str)
	{
		year.clear();
		year.sendKeys(str);
	}
	
	public void Select_discountZone(String str)
	{
		Select s = new Select(discountZone);
		s.selectByValue(str);
	}
	
	public void Check_AllSector()
	{
		AllSector.click();
	}
	
	public void Select_discountOnPage()
	{
		Select s = new Select(discountOnPage);
		s.selectByIndex(1);
	}
	
	public void Select_tabPartialAllow()
	{
		Select s = new Select(tabPartialAllow);
		s.selectByIndex(0);
	}
	
	public void Select_tabAllowTransaction(String str)
	{
		tabAllowTransaction.clear();
		tabAllowTransaction.sendKeys(str);
	}
	
	public void Button_save_btn()
	{
		save_btn.click();
	}
	
	public void Enter_interestOfflineDiscount(String str)
	{
		interestOfflineDiscount.clear();
		interestOfflineDiscount.sendKeys(str);
	}
	
	public void Enter_interestOnlineDiscount(String str)
	{
		interestOnlineDiscount.clear();
		interestOnlineDiscount.sendKeys(str);
	}
	
	
	public void DSM_link(String url, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "DiscountSlabMaster.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	
	public void IDSM_link(String url, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "InterestDiscountSlabMaster.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	
	
	
	
	
	
}
