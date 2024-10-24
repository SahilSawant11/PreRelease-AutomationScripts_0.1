package Reports;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.base.Stopwatch;

import New_property_Wadhghat.BaseDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pojo.CMS_browser;
import pom.LoginPage;
import pom.QualityControlReportPage;

	
	public class QualityControlReports extends BaseDriver {
		Stopwatch stopwatch;
		WebDriver driver;
		
		
		@BeforeTest
		public void beforetest() throws IOException
		{
			extent = new ExtentReports();
			spark = new ExtentSparkReporter("ExtentReport.html");
			extent.attachReporter(spark);
			BaseDriver.GetData();
			WebDriverManager.chromedriver().setup();
			driver = CMS_browser.openBrowser(url);
		}
		
		@Test(priority = 1)
		public void loginPage() throws InterruptedException
		{
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
	
		@Test(priority = 2)
	    public void QualityControl() throws Exception {
	        test = extent.createTest("Quality Control Test");
	        driver.get("http://testpanvelmc.ptaxcollection.com:8080/Pages/QualityControlReports.aspx");
	        
		}
		
		
		@AfterTest
	    public void tearDown() {
	      //  if (driver != null) {
	       //     driver.quit();
	     //   }
	        extent.flush();
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
