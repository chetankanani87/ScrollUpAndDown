package scrollUpAndDown;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import lib.BrowserDriverUtility;
import lib.ExtentReportUtility;
import lib.ScreenshotUtility;

public class ScrollUpAndDown {
	static WebDriver dr = BrowserDriverUtility.InvokeBrowser("webdriver.chrome.driver",
			"C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\chromedriver.exe", "https://www.jqueryui.com");
	static ExtentReports report = ExtentReportUtility.InvokeExtentReport();;
	static ExtentTest logger = report.createTest("Scrolling Up And Down");
	
	public static void main(String args[]) throws IOException {
		String path;
		
		path = ScreenshotUtility.CaptureScreenshot(dr, "1_MainPage");
		logger.pass("Main Page - Screenshot taken.", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		//Down type casting of webdriver 'dr' to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("window.scrollBy(0,1000)");
		
		path = ScreenshotUtility.CaptureScreenshot(dr, "2_ScrollDownPage");
		logger.pass("After Scrolling Down - Screenshot taken.", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		js.executeScript("window.scrollBy(0,-1000)");
		path = ScreenshotUtility.CaptureScreenshot(dr, "3_ScrollUpPage");
		logger.pass("After Scrolling Up - Screenshot taken.", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		dr.findElement(By.xpath("//a[contains(text(),'Draggable')]")).click();
		path = ScreenshotUtility.CaptureScreenshot(dr, "4_ClickOnDragabble");
		logger.pass("After Scrolling Up click on 'Dragabble' element - Screenshot taken.", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		report.flush();
		dr.close();

	}
}
