package Reports;

import java.io.IOException;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import New_property_Wadhghat.BaseDriver;
import pojo.CMS_browser;
import pom.CollectionReportsPage;
import pom.LoginPage;
import utility.Delete_Files;

public class CollectionReports extends BaseDriver {
	JavascriptExecutor js;
	StopWatch stopWatch;
	WebDriver driver;
	
	@BeforeTest
	public void beforetest() throws IOException
	{
		Delete_Files Delete_files = new Delete_Files(driver);
		System.out.println(System.getProperty("user.dir"));
		Delete_files.Delete_files("\\PdfReports\\");
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("ExtentReport.html");
		extent.attachReporter(spark);
		BaseDriver.GetData();
//		WebDriverManager.chromedriver().setup();
		driver = CMS_browser.openBrowser(url);
		stopWatch = new StopWatch();
	}
	
	@Test(priority = 1)
	public void loginPage() throws InterruptedException
	{
		test = extent.createTest("loginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.Enter_user_name(userid, driver);
		
		loginpage.Enter_password(password);
		loginpage.Click_login_btn(driver);
		
		try
		{
			loginpage.click_logout(driver);
			loginpage.Enter_user_name(userid, driver);
			loginpage.Enter_password(password);
			loginpage.Click_login_btn(driver);	
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void collectiontest() throws InterruptedException {
		Thread.sleep(null);
		CollectionReportsPage collectionpage = new CollectionReportsPage(driver);
		collectionpage.CollectionReports_link(url, driver);
		
	}
	
		
	
}
