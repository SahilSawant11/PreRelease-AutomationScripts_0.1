package pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NameCorrectionPage {

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOwnerMFstName']") private WebElement kardharak;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOwnerFstName']") private WebElement taxpayer;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMarathiOccupierName']") private WebElement bhogvatdar;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtEnglishOccupierName']") private WebElement occupier;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnAdd']") private WebElement addToList;
	
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnRenter']") private WebElement addRenter;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_GRVRenter_lnkEdit_0']") private WebElement selectFloor;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblMFN']") private WebElement editBhadekaru;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtRenterFirstNameM']") private WebElement bhadekari;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtRenterFirstName']") private WebElement renter;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnAddRenter']") private WebElement addToListRenter;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnRenterSave']") private WebElement saveRenter;
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_GRVRenter\"]/tbody/tr[2]/td[6]") private WebElement lableBhadekari;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOldOwnerPurchaseDate']") private WebElement oldPurchaseDate;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtNewOwnerPurchaseDate']") private WebElement newPurchaseDate;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOrderNo']") private WebElement orderNo;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtTranferDate']") private WebElement trnsferDate;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtRemark']") private WebElement remark;
	
	@FindBy(xpath = "//th[text()='Document Name']") private WebElement document_title;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVWadhGhatDocument_lblDocumentName_8']") private WebElement document9;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_GVWadhGhatDocument_lnkUpload_8']") private WebElement uploadLink9;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_FileUploadControl']") private WebElement choose_file;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_UploadButton']") private WebElement uploadFile_btn;
	
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnUpdateMutionData']") private WebElement saveAndProceed_btn;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnFerFarPrint']") private WebElement print_btn;
	
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVWadhGhatDocument_lblDocumentName_9']") private WebElement document10;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_GVWadhGhatDocument_lnkUpload_9']") private WebElement uploadLink10;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnSendToApproval']") private WebElement sendToApproval_btn;
	
	@FindBy(xpath = "//div[@id='ContentPlaceHolder1_PanelUpdateProgress']") private WebElement loading_page;
	
	public NameCorrectionPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void CMS_link(String url, WebDriver driver)
	{
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "NameCorrection.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	public void icon_pageloading() throws InterruptedException
	{
		try {
			Thread.sleep(1000);
			while(loading_page.getAttribute("aria-hidden").equals("false"))
			{
				Thread.sleep(500);
				System.out.println("waiting for Name change");
			}
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void Enter_kardharak(String str, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOf(kardharak));
		
		kardharak.clear();
		kardharak.sendKeys(str);
	}
	
	public void Enter_taxpayer(String str)
	{
		taxpayer.clear();
		taxpayer.sendKeys(str);
	}
	
	public void Enter_bhogvatdar(String str)
	{
		bhogvatdar.clear();
		bhogvatdar.sendKeys(str);
	}
	
	public void Enter_occupier(String str)
	{
		occupier.clear();
		occupier.sendKeys(str);
	}
	
	public void Button_addToList(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOf(addToList));

		addToList.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	
	public void Button_addRenter(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(addRenter));
		
		addRenter.click();
	}
	
	public void Button_selectFloor(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30000));
		wait.until(ExpectedConditions.visibilityOf(selectFloor));
		Thread.sleep(1000);
		selectFloor.click();
	}
	
	public String lable_editBhadekaru()
	{
		return editBhadekaru.getText();
	}
	
	public void Enter_bhadekari(String str, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30000));
		wait.until(ExpectedConditions.visibilityOf(bhadekari));
		bhadekari.clear();
		bhadekari.sendKeys(str);
	}
	
	public void Enter_renter(String str, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30000));
		wait.until(ExpectedConditions.visibilityOf(renter));
		renter.clear();
		renter.sendKeys(str);
	}
	
	public void Button_addToListRenter(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30000));
		wait.until(ExpectedConditions.visibilityOf(addToListRenter));
		Thread.sleep(2000);
		addToListRenter.click();
	}
	
	public void Button_saveRenter(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30000));
		wait.until(ExpectedConditions.visibilityOf(saveRenter));
		
		saveRenter.click();
	}
	
	public String Text_lableBhadekari()
	{
		return lableBhadekari.getText();
	}
	
	public void Enter_oldPurchaseDate(String str, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30000));
		wait.until(ExpectedConditions.visibilityOf(oldPurchaseDate));
		Thread.sleep(1000);
		oldPurchaseDate.clear();
		oldPurchaseDate.sendKeys(str);
	}
	
	public void Enter_newPurchaseDate(String str)
	{
		newPurchaseDate.clear();
		newPurchaseDate.sendKeys(str);
	}
	
	public void Enter_orderNo(String str)
	{
		orderNo.clear();
		orderNo.sendKeys(str);
	}
	
	public void Enter_trnsferDate(String str)
	{
		trnsferDate.clear();
		trnsferDate.sendKeys(str);
	}
	
	public void Enter_remark(String str)
	{
		remark.clear();
		remark.sendKeys(str);
	}
	
	public void Scroll_document_title(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(120000));
		wait.until(ExpectedConditions.visibilityOf(document_title));
		Thread.sleep(500);
		
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", document_title);
		Thread.sleep(500);
	}
	
	public void Scroll_document9(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", document9);
		Thread.sleep(500);
	}
	
	public void Link_uploadLink9() throws InterruptedException
	{
		Thread.sleep(500);
		uploadLink9.click();
	}
	
	public void Upload_choose_file(String str, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(120000));
		wait.until(ExpectedConditions.visibilityOf(choose_file));
		Thread.sleep(500);
		choose_file.sendKeys(str);
	}
	
	public void Button_uploadFile_btn() throws InterruptedException
	{
		Thread.sleep(2000);
		uploadFile_btn.click();
	}
	
	public void Scroll_document10(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", document10);
		Thread.sleep(500);
	}
	
	public void Link_uploadLink10() throws InterruptedException
	{
		Thread.sleep(500);
		uploadLink10.click();
	}
	
	public void Button_saveAndProceed_btn(WebDriver driver) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(120000));
		wait.until(ExpectedConditions.visibilityOf(saveAndProceed_btn));
	
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveAndProceed_btn);
		Thread.sleep(500);
		
		saveAndProceed_btn.click();
	}
	
	public void Button_print_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(120000));
		wait.until(ExpectedConditions.visibilityOf(print_btn));
		
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", print_btn);
		Thread.sleep(500);
		
		print_btn.click();
	}
	
	
	public void Button_sendToApproval_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(120000));
		wait.until(ExpectedConditions.visibilityOf(sendToApproval_btn));
		
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sendToApproval_btn);
		Thread.sleep(500);
		
		sendToApproval_btn.click();
	}
	
	
}
