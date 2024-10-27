package New_property_Wadhghat;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pojo.CMS_browser;
import pom.CMS_Page;
import pom.LoginPage;
import pom.MutationApprovalPage;
import pom.NameCorrectionPage;
import utility.TakeScreenshoot;

public class Ferfar_Test extends BaseDriver{

	StopWatch stopWatch;
	
//	String akshep_no;
//	
//	@BeforeTest
//	public void beforetest() throws IOException
//	{
//		BaseDriver.GetData();
//		extent = new ExtentReports();
//		spark = new ExtentSparkReporter("ExtentReport.html");
//		extent.attachReporter(spark);
//		WebDriverManager.chromedriver().setup();
//		driver = CMS_browser.openBrowser(url);
//	}
//	
//	@Test(priority = 1)
//	public void loginPage() throws InterruptedException
//	{
//		test = extent.createTest("loginPage");
//		LoginPage loginpage = new LoginPage(driver);
//		loginpage.Enter_user_name(userid, driver);
//		loginpage.Enter_password(password);
//		loginpage.Click_login_btn(driver);
//		
//		try
//		{
//			loginpage.click_logout(driver);
//			loginpage.Enter_user_name(userid, driver);
//			loginpage.Enter_password(password);
//			loginpage.Click_login_btn(driver);
//		}
//		catch(Exception e)
//		{
//			
//		}
//	}
//	
	
	@Test(priority = 2)
	public void cmsPageFerfar() throws InterruptedException
	{
		test = extent.createTest("cmsPageFerfar");
		stopWatch = new StopWatch();
		CMS_Page cmspage = new CMS_Page(driver);
		cmspage.CMS_link(url, driver);
		cmspage.Button_register_Grievance(driver);
	}
	
	
	@Test(priority = 3,dependsOnMethods = "cmsPageFerfar")
	public void cmsRegisterPageFerfar() throws InterruptedException
	{
		test = extent.createTest("cmsRegisterPageFerfar");
		CMS_Page cmspage = new CMS_Page(driver);
		cmspage.select_node_no(node, driver);
		cmspage.select_sector_no(sector, driver);
		cmspage.icon_pageloading();
		cmspage.Enter_property_no(PropertyNo, driver);
		cmspage.Button_get_property_btn();
	}
	
	
	@Test(priority = 4, dependsOnMethods = "cmsRegisterPageFerfar")
	public void cmsComplaintRegisterFerfar() throws Exception
	{
		test = extent.createTest("cmsComplaintRegisterFerfar");
		CMS_Page cmspage = new CMS_Page(driver);
		cmspage.Button_akshep_nondava_btn(driver);
		cmspage.select_aakshep_prakar(ferfar_aakshep_prakar, driver);
		cmspage.Enter_date(date);
		cmspage.Enter_mobile(mobile);
		cmspage.Enter_remark(cms_remark);
		
		String cmsComplaintRegister=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Entered Floor info",MediaEntityBuilder.createScreenCaptureFromBase64String(cmsComplaintRegister).build());
		/////
		stopWatch.start();
		cmspage.Button_akshep_nondava_btn2(driver);
		cmspage.Button_yes_btn(driver);
		cmspage.pageloading(driver);
		cmspage.Button_ok_btn(driver);
		test.info("Time duration of Registaring Ferfar Complaint: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		akshep_no = cmspage.fetch_akshep_no(driver);
	}
	
	@Test(priority = 5, dependsOnMethods = "cmsComplaintRegisterFerfar")
	public void searchComplaintFerfar() throws InterruptedException
	{
		test = extent.createTest("searchComplaintFerfar");
		CMS_Page cmspage = new CMS_Page(driver);
		cmspage.CMS_link(url, driver);
		cmspage.Button_filter_btn(driver);
		cmspage.Enter_complaint_Id(driver, akshep_no);
		/////
		stopWatch.reset();
		stopWatch.start();
		cmspage.Button_Search_property(driver);
		cmspage.icon_pageloading();
		test.info("Time duration of Search Ferfar Property on CMS Page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		cmspage.Fetch_grievance_id(driver);
		cmspage.Button_grivance_select_btn(driver);
		cmspage.Button_make_correction_btn(driver);
	}
	
	@Test(priority = 6, dependsOnMethods = "searchComplaintFerfar")
	public void NamechangeFerfar() throws Exception
	{
		int i=0;
		test = extent.createTest("NamechangeFerfar");
		NameCorrectionPage namechange = new NameCorrectionPage(driver);
		namechange.Enter_kardharak(ferfar_kardharak, driver);
		namechange.Enter_taxpayer(ferfar_taxpayer);
		namechange.Enter_bhogvatdar(ferfar_bhogvatdar);
		namechange.Enter_occupier(ferfar_occupier);
		namechange.Button_addToList(driver);
		namechange.icon_pageloading();
		namechange.Button_addRenter(driver);
		namechange.Button_selectFloor(driver);
		while(!ferfar_bhadekaru.equals(namechange.lable_editBhadekaru()))
		{
			Thread.sleep(500);
			i++;
			System.out.println("wait in 1st edit bhadekaru");
			if(i>20)
			{
				break;
			}
		}
		namechange.Enter_bhadekari(ferfar_bhadekaru, driver);
		namechange.Enter_renter(ferfar_Renter, driver);
		namechange.Button_addToListRenter(driver);
		i=0;
		while(!ferfar_bhadekaru.equals(namechange.Text_lableBhadekari()))
		{
			Thread.sleep(500);
			i++;
			System.out.println("wait in 1st lable bhadekaru");
			if(i>20)
			{
				break;
			}
		}
		namechange.Button_saveRenter(driver);
		Thread.sleep(20000);
		namechange.Enter_oldPurchaseDate(ferfar_oldPurchaseDate, driver);
		namechange.Enter_newPurchaseDate(ferfar_newPurchaseDate);
		namechange.Enter_orderNo(ferfar_orderNo);
		namechange.Enter_trnsferDate(ferfar_trnsferDate);
		namechange.Enter_remark(ferfar_remark);
		
		String Namechange=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Entered Floor info",MediaEntityBuilder.createScreenCaptureFromBase64String(Namechange).build());
		
		namechange.Scroll_document_title(driver);
		namechange.Scroll_document9(driver);
		namechange.Link_uploadLink9();
		namechange.Upload_choose_file(System.getProperty("user.dir")+"\\AddTaxes file\\PDFFILE.pdf", driver);
		namechange.Button_uploadFile_btn();
		namechange.Button_saveAndProceed_btn(driver);
		namechange.Button_print_btn(driver);
		namechange.Scroll_document_title(driver);
		namechange.Scroll_document10(driver);
		namechange.Link_uploadLink10();
		namechange.Upload_choose_file(System.getProperty("user.dir")+"\\AddTaxes file\\PDFFILE.pdf", driver);
		namechange.Button_uploadFile_btn();
		/////
		stopWatch.reset();
		stopWatch.start();
		namechange.Button_sendToApproval_btn(driver);
	}
	
	@Test(priority = 7, dependsOnMethods = "NamechangeFerfar")
	public void FerfarApproval() throws Exception
	{
		test = extent.createTest("FerfarApproval");
		CMS_Page cmspage = new CMS_Page(driver);
		cmspage.icon_pageloading();
		test.info("Time duration of Sending for Approval: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		cmspage.CMS_link(url, driver);
		cmspage.Button_filter_btn(driver);
		cmspage.Enter_complaint_Id(driver, akshep_no);
		cmspage.Button_Search_property(driver);
		cmspage.icon_pageloading();
		cmspage.Fetch_grievance_id(driver);
		cmspage.Button_grivance_select_btn(driver);
		cmspage.Button_verify_correction_btn(driver);
		MutationApprovalPage mutationpage = new MutationApprovalPage(driver);
		
		String PendingApproval=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Entered Floor info",MediaEntityBuilder.createScreenCaptureFromBase64String(PendingApproval).build());
		
		mutationpage.Enter_approval_remark("test", driver);
		/////
		stopWatch.reset();
		stopWatch.start();
		mutationpage.Button_approval_all(driver);
		test.info("Time duration of Approval process: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
	}
	
	
	@AfterMethod
	public void aftermethod(ITestResult result, java.lang.reflect.Method m)
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
	}
}
