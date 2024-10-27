package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollPage {

	public static void scrollTestPage(WebDriver driver, WebElement str) throws InterruptedException
	{
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", str);
		Thread.sleep(500);
	}
}
