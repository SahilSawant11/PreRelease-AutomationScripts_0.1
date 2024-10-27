package New_property_Wadhghat;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.testng.annotations.Test;

import pom.MinorChangesPage;
import pom.QRScaningPage;

public class QR_ScaningTest extends BaseDriver {
	
	StopWatch stopWatch;
  @Test(priority = 2)
  public void QR_ScaninigTest() throws Exception {
	  
	  
	    test = extent.createTest("QR_ScaninigTest");
		stopWatch = new StopWatch();
		QRScaningPage QR_ScaninigTest = new QRScaningPage(null);
		/////
		stopWatch.start();
		QR_ScaninigTest.QR_ScaninigTest_link(url, driver);
		test.info("Time duration of opening MinorChanges page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
	 
  }
  
  
  
  
}
