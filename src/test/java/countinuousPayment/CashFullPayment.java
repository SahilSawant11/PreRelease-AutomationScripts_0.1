package countinuousPayment;

import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import New_property_Wadhghat.BaseDriver;
//import pojo.Browser;
import pojo.CMS_browser;
import pom.CounterPaymentPage;
import pom.LoginPage;
import pom.OfflinePaymentPage;
import utility.TakeScreenshoot;
import utility.dataForAllproperty;

public class CashFullPayment extends BaseDriver {

	WebDriver driver;
	@BeforeTest
	public void getPropertynames() throws InterruptedException, IOException
	{
		BaseDriver.GetData();
		driver = CMS_browser.openBrowser(url);
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
	
	@Test(dataProvider = "collectionData")
	public void Test_Full_Payment(String ward_no, String sector, String property, String paymentmode) throws InterruptedException
	{
		CounterPaymentPage counterpayment = null;
		OfflinePaymentPage offlinepaymentpage = null;
		try
		{
			offlinepaymentpage = new OfflinePaymentPage(driver);
			offlinepaymentpage.counterPayment(driver, url);
			offlinepaymentpage.Click_property_no_radio_btn(driver);
			
			offlinepaymentpage.Select_node_no(driver, node1);
			offlinepaymentpage.Select_sector_no(driver, sector1);
			offlinepaymentpage.Enter_property_no(driver, PropertyNo1);
			offlinepaymentpage.Click_search_property();
			counterpayment = new CounterPaymentPage(driver);
			counterpayment.Select_fullpayment(driver);
			
			counterpayment.Enter_email_id(driver, "abc@123.gmail.com");
			counterpayment.Enter_mobile_no(driver, "1111111111");
			counterpayment.Select_bill_book_no("TEST23");
			counterpayment.Select_payment_mode(paymentmode);
			counterpayment.Enter_behalf_payer_name(driver, "abc");

			counterpayment.Click_pay_now(driver);
			counterpayment.confirm_payment(driver);
			counterpayment.Check_transaction_id(driver);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
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
	
	
	
	
}
