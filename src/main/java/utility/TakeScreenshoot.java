package utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TakeScreenshoot {


	File SD,DS;
	TakesScreenshot tax ;
	static WebDriver wb;
	public TakeScreenshoot (WebDriver wb, String str)
	{
		PageFactory.initElements(wb, this);
	}
	
	public void TakeScreenshot_fullScreen(String imagename, WebDriver wb, String imagepath) throws Exception {
		tax =((TakesScreenshot)wb);
		//Call getScreenshotAs method to create image file
		SD=tax.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		DS=new File(imagepath+imagename+".jpg");
		//Copy file at destination
		FileUtils.copyFile(SD, DS);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
	
	
	public void TakeScreenshot_element(WebDriver wb,String elementpath,String imagename) throws Exception {
		
		WebDriverWait wait=new WebDriverWait(wb, Duration.ofSeconds(50), Duration.ofSeconds(5));
		////////////////////////////screenshot////////////////////council name//////////////
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementpath)));
		WebElement councilname=wb.findElement(By.xpath("//*[@id=\"lblCouncilname\"]"));
		File SM=councilname.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DM=new File(System.getProperty("user.dir")+"\\result\\img\\"+imagename+".jpg");
		//Copy file at destination
		FileUtils.copyFile(SM, DM);
		Thread.sleep(1000);
		/////////////////////////////////////////////////////////////////////
	}
	
public static String GetScreenshot(WebDriver wb, String imagename) throws Exception {
	
	TakesScreenshot ts=(TakesScreenshot)wb;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File DM=new File(System.getProperty("user.dir")+"\\result\\img\\"+imagename+".jpg");
	FileUtils.copyFile(src, DM );
	
	
		return DM.getAbsolutePath();

	}

public static String GetScreenshotElement(WebDriver wb, String imagename, String elementpath) throws Exception {
	
	WebDriverWait wait=new WebDriverWait(wb, Duration.ofSeconds(50), Duration.ofSeconds(5));
	////////////////////////////screenshot////////////////////council name//////////////
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementpath)));
	WebElement councilname=wb.findElement(By.xpath(elementpath));
	File src=councilname.getScreenshotAs(OutputType.FILE);
	File DM=new File(System.getProperty("user.dir")+"\\result\\img\\"+imagename+".jpg");
	FileUtils.copyFile(src, DM );
	
	
		return DM.getAbsolutePath();

	}

public static String GetScreenshotBase64(WebDriver wb, String elementpath) throws Exception {
	WebDriverWait wait=new WebDriverWait(wb, Duration.ofSeconds(50), Duration.ofSeconds(5));
	////////////////////////////screenshot////////////////////council name//////////////
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementpath)));
	WebElement councilname=wb.findElement(By.xpath(elementpath));
	

	String base65=councilname.getScreenshotAs(OutputType.BASE64);
	
	
	
	
		return base65;

	}
public static String GetScreenshotFullBase64(WebDriver wb) throws Exception {
	
	TakesScreenshot ts=(TakesScreenshot)wb;
	String base65=ts.getScreenshotAs(OutputType.BASE64);
	return base65;

	}

//////////////////////if any exception take screenshot///////////////////////

	private void captureException(String filename) throws Exception {
		File sourceFile = ((TakesScreenshot) wb).getScreenshotAs(OutputType.FILE);
	File destFile = new File(System.getProperty("user.dir")+"\\result\\img\\"+filename+".jpg");
	FileUtils.copyFile(sourceFile, destFile);
		System.out.println("Screenshot saved successfully");

	}
	
}
