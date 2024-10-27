package SmokTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	 private WebDriver driver = testbrowser.getDriver();

	    @Test
	    public void testOne() {
	        driver.get("https://example.com");
	        // Your Selenium code for test one
	    }

	    @AfterClass
	    public void cleanUp() {
	        // Optional: Clean up if necessary; WebDriver is reused in Test2
	    }
}
