package SmokTesting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import New_property_Wadhghat.BaseDriver;
import ch.qos.logback.core.util.Duration;
import pojo.CMS_browser;
import utility.TakeScreenshoot;

public class CheckPages  extends BaseDriver{
	TakeScreenshoot takescreenshot=new TakeScreenshoot(driver, null);
	StopWatch stopWatch;

	public static void main(String[] args) throws Exception {
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("ExtentReport.html");
		extent.attachReporter(spark);
		BaseDriver.GetData();
		//WebDriverManager.chromedriver().setup();
		
		String baseurl="https://cfcpanvelmc.org/pages/";
		driver = CMS_browser.openBrowser(baseurl);
		
		
		 Scanner scanner = new Scanner(System.in);
	        System.out.print("start Yes / no: ");
	        String userInput = scanner.nextLine();
	        test = extent.createTest("cash Payment");
		
		  String[] urls = {
				  "PageName","OnlinePayment","OfflinePayment","NewUser","NewRole","Response","PagePrevilages","CollectionReport","ActiveTaxes","ActiveYear","PageNameMaster","CouncilMaster","PageGroupMaster","BillBookAllocation","ChangePassword","ActiveTaxesEditableStatus","UniquePropertyNoEntryMaster","TransactionApproval","CollectionApproval","DiscountSlabMaster","BankMaster","GenerateBillReceipt","ApplcationSetting","TransferFee","NameCorrection","NewDataEntryTab","DashboardTabRegistration","NewTaxPayment","Approval","MutationApproval","SearchByOldRV","SearchByBillBookNoAndInvoiceNo","PaymentInitiatedStatus","WaterBillPayment","WaterBill/OfflinePayment","NewWaterConnection","WaterBill/NewConnectionBillPayment","OtherPayment","CMS","AutoWardEntry","QualityControlReports","CMSDetails","NewUserOTPMaster","QCScreen","Accountant","PropertyAudit","NotvariDetails","CashierAllocation","CashierScreen","CouncilApproval","OnlineGrievance","SendBalanceSMS","ImportMISTransactions","MinorChanges","ApprovalAllocation","DeploymentSchedule","UserLoginTracker","ReportEngine","CouncilApprovalReadOnly","AnamatRakkam","OccpancyAdvancePayment","SendSms","PropertyDataByNIC","PropertyDataByNIC","SelfAssessmentGrievance","OnlineGrievanceReadOnly","EBillEmailSEND","BlockUnblockProperties","HomeDashboard","PaymentMissMatched","MinusCollectionAdjust","GenarateQRandUnicodeAddress","CustomSmsSend","SocietyPaymentPosting","IGRMuation","PropertyMutationUsingIGR","SelfAssessmentApproval","ReportDownloadAccessDetails","QuickPay","BillDistributionTracker","NewReportEngine","PropertyTypeMaster","ReportAccess","RecoveryTracker","NDashboard","AdminDashboard","OnlinePaymentRefund","DiscountApprovals"
		        };

		  
		  
		        // Loop through each URL, take a screenshot and save it
		        for (String url : urls) {
		            try {
		            	
		            	
		            	driver.get(baseurl+url+".aspx");
		                
		                
		                // Take a screenshot
		                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		                
		                // Save the screenshot
		                String fileName = url.replace("https://", "").replace("http://", "").replace("/", "_") + ".png";
		                File destinationFile = new File("screenshots/" + fileName);
		                FileUtils.copyFile(screenshot, destinationFile);

		                test.log(Status.INFO, "Page  : "+url+"-:has open");
		                
		                String url1=TakeScreenshoot.GetScreenshotFullBase64(driver);
		        		test.pass("counter",MediaEntityBuilder.createScreenCaptureFromBase64String(url1).build());
		                
//		                System.out.println("Screenshot saved for: " + url);

		                WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
		                
		       try {
		    	   WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='form1']/div[3]/nav/div[1]/a"))); 
		    	   System.out.println(url+":Page Loaded");
				
			} catch (Exception e) {
				 System.out.println(url+":Page Server Error");
			}
		                
               
                
                
                // Replace with your element's locator

		          
		                
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }

		        extent.flush();     
	}

}
