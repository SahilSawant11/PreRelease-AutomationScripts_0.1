package Reports;

import java.io.IOException;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.base.Stopwatch;

import New_property_Wadhghat.BaseDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
import pojo.CMS_browser;
import pom.LoginPage;
import pom.QualityControlPages;
import utility.Delete_Files;

	
	public class QualityControlReports extends BaseDriver {
		Stopwatch stopwatch;
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
//			WebDriverManager.chromedriver().setup();
			driver = CMS_browser.openBrowser(url);
		//	stopWatch = new StopWatch();
		}
		
		@Test(priority = 1)
		public void loginPage() throws InterruptedException
		{
			test = extent.createTest("loginPage");
			LoginPage loginpage = new LoginPage(driver);
			loginpage.Enter_user_name(userid, driver);
			
			loginpage.Enter_password(password);
			Thread.sleep(10000);
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
	    public void Defaulter_report_test() throws Exception {
	        test = extent.createTest("Defaulter Report Test");
	        QualityControlPages qcpage = new QualityControlPages(driver);
	        qcpage.Quality_Control_Page_link(url,driver);
	        qcpage.Select_defaulter_reports(driver);
	        qcpage.Select_zone(driver);
	        Thread.sleep(5000);
	        qcpage.Select_ward(driver);
	        Thread.sleep(5000);
	        qcpage.Select_from_proprty(driver);
	        Thread.sleep(5000);
	        qcpage.Select_to_proprty(driver);
	        Thread.sleep(5000);
	        qcpage.Select_with_interest(driver);
	        Thread.sleep(5000);
	        qcpage.Enter_amount(driver);
	        qcpage.Show_button(driver);
	        
	       
		}
		
		
		@AfterTest
	    public void tearDown() {
	      //  if (driver != null) {
	       //     driver.quit();
	     //   }
	        extent.flush();
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
