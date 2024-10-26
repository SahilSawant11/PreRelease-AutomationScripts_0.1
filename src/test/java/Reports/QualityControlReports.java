package Reports;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.base.Stopwatch;

import New_property_Wadhghat.BaseDriver;

import pojo.CMS_browser;
import pom.LoginPage;
import pom.QualityControlPages;
import utility.Delete_Files;
import utility.TakeScreenshoot;

	
	public class QualityControlReports extends BaseDriver {
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
			driver = CMS_browser.openBrowser(url);
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
	        StopWatch stopWatch = new StopWatch();
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
	        Thread.sleep(10000);    
	        stopWatch.start();
	        qcpage.Export_button(driver); 
			Thread.sleep(15000);
			 String defaulterGenerated = null;
				try {
					defaulterGenerated = TakeScreenshoot.GetScreenshotFullBase64(driver);
				} catch (Exception e) {
					e.printStackTrace();
				}
			test.info("Time duration of exporting Collection Report: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
			test.pass("Total Defaulter Report Generated ✔",MediaEntityBuilder.createScreenCaptureFromBase64String(defaulterGenerated).build());
			 stopWatch.stop();
		}
		
		@Test(priority = 3)
	    public void Total_Outstanding_report_test() throws Exception {
	        test = extent.createTest("Total Outstanding Report Test");
	        QualityControlPages qcpage = new QualityControlPages(driver);
	        StopWatch stopWatch = new StopWatch();
	        qcpage.Quality_Control_Page_link(url,driver);
	        Thread.sleep(10000);
	        qcpage.Select_total_outstanding(driver);
	        Thread.sleep(10000);
	        qcpage.Select_zone_totaloutstanding(driver);
	        Thread.sleep(10000);
	        qcpage.Select_ward_totaloutstanding(driver);
	        Thread.sleep(5000);
	        qcpage.Select_from_proprty_totaloutstanding(driver);
	        Thread.sleep(5000);
	        qcpage.Select_to_proprty_totaloutstanding(driver);
	        Thread.sleep(5000);
	        stopWatch.start();
	        qcpage.Totaloutstanding_export_button(driver);
	        Thread.sleep(120000);
	        String totaloutstandingGenerated = null;
			try {
				totaloutstandingGenerated = TakeScreenshoot.GetScreenshotFullBase64(driver);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			test.info("Time duration of exporting Collection Report: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
			test.pass("Total Outstanding Report Generated ✔",MediaEntityBuilder.createScreenCaptureFromBase64String(totaloutstandingGenerated).build());
			 stopWatch.stop();
			Thread.sleep(5000);
		}
			
		@AfterTest
	    public void tearDown() {
	      //  if (driver != null) {
	       //     driver.quit();
	     //   }
	        extent.flush();
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
