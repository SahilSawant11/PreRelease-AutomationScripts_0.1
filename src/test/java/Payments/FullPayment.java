package Payments;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import New_property_Wadhghat.BaseDriver;
import pom.CounterPaymentPage;
import pom.OfflinePaymentPage;
import utility.TakeScreenshoot;

public class FullPayment extends BaseDriver{
	TakeScreenshoot takescreenshot=new TakeScreenshoot(driver, null);
	StopWatch stopWatch;
	@Test
	public void Full_Payment() throws Exception
	{
		
		
		test = extent.createTest("Full_Payment of new created property");
		CounterPaymentPage counterpayment = null;
		stopWatch = new StopWatch();

		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
			
		offlinepaymentpage.Select_node_no(driver, node);
		offlinepaymentpage.Select_sector_no(driver, sector);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo);
		/////
		stopWatch.start();
		offlinepaymentpage.Click_search_property();
			
		counterpayment = new CounterPaymentPage(driver);
		counterpayment.Select_Finalcheckbox(driver);
		test.info("Time duration of Searching property on counter payment page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		
		
		String counterbeforePayment=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("New created Property ",MediaEntityBuilder.createScreenCaptureFromBase64String(counterbeforePayment).build());
		
		
		
		counterpayment.Enter_email_id(driver, "abc@123.gmail.com");
		counterpayment.Enter_mobile_no(driver, "1111111111");
		counterpayment.Select_bill_book_no("TEST2425");
		//counterpayment.Select_payment_mode("Cash");
//		counterpayment.Enter_behalf_payer_name(driver, "abc");
			
		/////
		stopWatch.reset();
		stopWatch.start();
		counterpayment.Click_pay_now(driver);
		counterpayment.confirm_payment(driver);
		counterpayment.Check_transaction_id(driver);
		counterpayment.Click_receipts_btn(driver);
		counterpayment.label_downloadReceipt(driver);
		counterpayment.downloadReceipt(driver);
		Thread.sleep(1000);
		test.info("Time duration of Payment: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		///

	}
	
	@AfterMethod
	public void aftermethod(ITestResult result,java.lang.reflect.Method m)
	{
		try
		{
			if(result.getStatus() == ITestResult.SUCCESS)
			{
				test.log(Status.PASS, "Test Pass " + result.getName());
				
				String a=	TakeScreenshoot.GetScreenshot(driver, m.getName());
				
				test.pass("<b>PASSED SCREENSHOTS</B>", MediaEntityBuilder.createScreenCaptureFromPath(a).build());
				
			}
			else if(result.getStatus() == ITestResult.FAILURE)
			{
				test.log(Status.FAIL, "Test Fail " + result.getName());
				test.log(Status.FAIL, "Test Fail " + result.getThrowable());
				String a=	TakeScreenshoot.GetScreenshot(driver, m.getName());
				
				test.fail("<b>FAILED SCREENSHOTS</B>", MediaEntityBuilder.createScreenCaptureFromPath(a).build());	
			}
			else if(result.getStatus() == ITestResult.SKIP)
			{
				test.log(Status.SKIP, "Test Skip " + result.getName());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		extent.flush();
		
	}
	

	
	@AfterTest
	public void aftertest()
	{
		extent.flush();
	}
}
