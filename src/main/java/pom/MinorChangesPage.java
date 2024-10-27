package pom;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinorChangesPage {

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMarathiOwnerName']") private WebElement kardharak;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtEnglishOwnerName']") private WebElement ownerName;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtWardNo']") private WebElement oldWardNo;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPartionNo']") private WebElement oldPartitionNo;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOldPropN']") private WebElement oldPropertyNo; 
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMarathiSocietyName_Minor']") private WebElement SocietyNameMarathi;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtEnglishSocietyName_Minor']") private WebElement SocietyNameEng;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtNewCTServeyNo']") private WebElement newCityservey;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtdukanimaratnav']") private WebElement dhukan;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtBuildingNameNew']") private WebElement shop;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMRToilet']") private WebElement rToilet;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMarathiPattaNew']") private WebElement patta;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtAddressNew']") private WebElement address;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMCToilet']") private WebElement cToilet;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtWingNo_Minor']") private WebElement wingNo;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMCFlatNo']") private WebElement flatNo;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtNewPlot']") private WebElement plotNo;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMobileNo']") private WebElement MobileNo;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMinorEmailID']") private WebElement email;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMinorRemark']") private WebElement remark;
	
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_GVMinorDocument_lnkUpload_0\"]/img") private WebElement uploadIcon;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_MP1FileUpload']") private WebElement choose_file;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_MP1Upload']") private WebElement upload_btn;
	@FindBy(xpath = "//th[text()='Document Name']") private WebElement doc;
	
	@FindBy(xpath = "//button[@class='confirm']") private WebElement ok_btn; //newly add
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSaveMinorChanges']") private WebElement save_btn;
	@FindBy(xpath = "//button[@id='ContentPlaceHolder1_btnCancel']") private WebElement cancel;
	
	@FindBy(xpath = "//button[contains(text(),'Yes')]") private WebElement yes_btn;
	@FindBy(xpath = "//button[contains(text(),'OK')]")  private WebElement ok_again_btn;
	
	
	@FindBy(id = "ContentPlaceHolder1_lblShowContact") private WebElement spanMobile; // on counter
	@FindBy(id = "ContentPlaceHolder1_lblShowOwnerName") private WebElement spankardharak; // on counter
	@FindBy(id = "ContentPlaceHolder1_lblShowSocietyName") private WebElement spanSocietyNav; // on counter
	@FindBy(id = "ContentPlaceHolder1_lblShowShopName") private WebElement spandukan; // on counter
	@FindBy(id = "ContentPlaceHolder1_lblShowOwnerAddress") private WebElement spanaddress; // on counter
	
	
	private static Map<String, String> storedValues = new HashMap<String, String>();
	
	
	public MinorChangesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Enter_oldWardNo(String str,WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(oldWardNo));
		Thread.sleep(500);
		
		oldWardNo.clear();
		oldWardNo.sendKeys(str);
	}
	
	public void Enter_oldPartitionNo(String str)
	{
		oldPartitionNo.clear();
		oldPartitionNo.sendKeys(str);
	}
	
	public void Enter_oldPropertyNo(String str)
	{
		oldPropertyNo.clear();
		oldPropertyNo.sendKeys(str);
	}
	
	public void Enter_SocietyNameMarathi(String str)
	{
		SocietyNameMarathi.clear();
		SocietyNameMarathi.sendKeys(str);
		String currentSocietyNav = SocietyNameMarathi.getAttribute("value");
		storedValues.put("SocietyName", currentSocietyNav);
	}
	
	public void Enter_SocietyNameEng(String str)
	{
		SocietyNameEng.clear();
		SocietyNameEng.sendKeys(str);
	}
	
	public void Enter_newCityservey(String str)
	{
		newCityservey.clear();
		newCityservey.sendKeys(str);
	}
	
	public void Enter_dhukan(String str)
	{
		
		dhukan.clear();
		dhukan.sendKeys(str);
		String currentdhukan = dhukan.getAttribute("value");
		storedValues.put("dhukan", currentdhukan);
	}
	
	public void Enter_shop(String str)
	{
		shop.clear();
		shop.sendKeys(str);
	}
	
	public void Enter_rToilet(String str)
	{
		rToilet.clear();
		rToilet.sendKeys(str);
	}
	
	public void Enter_patta(String str)
	{
		
		patta.clear();
		patta.sendKeys(str);
		String currentAddress = patta.getAttribute("value");
		storedValues.put("Address", currentAddress);
	}
	
	public void Enter_address(String str)
	{
		address.clear();
		address.sendKeys(str);
	}
	
	public void Enter_cToilet(String str)
	{
		cToilet.clear();
		cToilet.sendKeys(str);
	}
	
	public void Enter_wingNo(String str)
	{
		wingNo.clear();
		wingNo.sendKeys(str);
	}
	
	public void Enter_flatNo(String str)
	{
		flatNo.clear();
		flatNo.sendKeys(str);
	}
	
	public void Enter_plotNo(String str)
	{
		plotNo.clear();
		plotNo.sendKeys(str);
	}
	
	public void Enter_MobileNo(String str)
	{
		
		MobileNo.clear();
		MobileNo.sendKeys(str);
		String currentMobileNo = MobileNo.getAttribute("value");
		storedValues.put("MobileNo", currentMobileNo);
	}
	
	public void Enter_email(String str)
	{
		email.clear();
		email.sendKeys(str);
	}
	

	
	public void Enter_remark(String str)
	{
		remark.clear();
		remark.sendKeys(str);
	}
	
	public void Button_uploadIcon(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", doc);
		Thread.sleep(500);
		
		Thread.sleep(1000);
		uploadIcon.click();
	}
	
	public void Button_choose_file(String str, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(choose_file));
		
		Thread.sleep(2000);
		choose_file.sendKeys(str);
//		String s = "C:\\fakepath\\PDFFILE.pdf";
//		String s1 = choose_file.getAttribute("value");
//		Thread.sleep(5000);
//		while(!s1.equalsIgnoreCase(s))
//		{
//			Thread.sleep(500);
//			s1 = choose_file.getAttribute("value");
//			System.out.println("no minor changes");
//		}
		Thread.sleep(5000);
	}
	
	public void Button_upload_btn() throws InterruptedException
	{
		Thread.sleep(2000);
		upload_btn.click();
	}
	
	public void Button_ok_btn(WebDriver driver) throws InterruptedException  // newly add
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(ok_btn));
		Thread.sleep(2000);
		ok_btn.click();
	}
	
	public void Buttonr_save_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(save_btn));
	
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save_btn);
		Thread.sleep(500);
		
		save_btn.click();
	}
	
	public void Button_yes_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(yes_btn));
		Thread.sleep(2000);
		yes_btn.click();
	}
	
	public void Button_ok_again_btn(WebDriver driver) throws InterruptedException  // newly add
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(ok_btn));
		Thread.sleep(2000);
		ok_again_btn.click();
	}
	
	public void MinorChanges_link(String url, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "MinorChanges.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	public static String getStoredValue(String key) {
        return storedValues.get(key);

	}
	
	public String getSpanMobileNo() {
		
        return spanMobile.getText(); 
    }
	
	public String getSpanKardharak() {
		
        return spankardharak.getText(); 
    }
	
	public String getSpanSocietyNav() {
	
		return spanSocietyNav.getText(); 
	}
	
	public String getSpanDukanNav() {
	
		return spandukan.getText(); 
	}
	
	public String getSpanAddress() {
	
		return spanaddress.getText(); 
	}
}	

