package auditor;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import performer.OverduePOM;

public class AuditorcountPOM {
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	private static WebElement date = null;		
	
	
	public static WebElement DateText(WebDriver driver)		//Method for closing Message Popup
	{
		date = driver.findElement(By.xpath("//*[@id='txtAdvStartDate']"));
		return date;
	}
	
	
	public static WebElement DateYear(WebDriver driver)		//Method for closing Message Popup
	{
		date = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]"));
		return date;
	}
	
	public static WebElement Year(WebDriver driver)		//Method for closing Message Popup
	{
		date = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]/option[8]"));
		return date;
	}
	
	public static WebElement DateMonth(WebDriver driver)		//Method for closing Message Popup
	{
		date = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]"));
		return date;
	}
	
	public static WebElement Month(WebDriver driver)	
	//Method for closing Message Popup
	{
		date = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]/option[4]"));
		return date;
	}
	
	public static WebElement Date(WebDriver driver)		//Method for closing Message Popup
	{
		date = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a"));
		return date;
	}
	
	public static WebElement Apply(WebDriver driver)		//Method for closing Message Popup
	{
		date = driver.findElement(By.xpath("//*[@id='btnTopSearch']"));
		return date;
	}
	
	public static WebElement Status(WebDriver driver)		//Method for closing Message Popup
	{
		date = driver.findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[3]"));
		return date;
	}
	
	
	public static void GraphCount(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(2000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, (80));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	/*	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(1000);
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(10000);*/
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("///*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[1]")));
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			//*[@id="grid"]/div[3]/table/tbody/tr[1]/td[17]/a
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[20]/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
		
		Thread.sleep(500);
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(1000);
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		Thread.sleep(2000);
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
/*	}else {
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(300,0)");	
		Thread.sleep(1000);
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		CFOcountPOM.closeCategories(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
		
		
	}*/
	}
	
	public static void GraphCountLow(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(driver, (70));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(1000);
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[19]/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
		
		Thread.sleep(500);
		
		Thread.sleep(1000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
	}else {
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(300,0)");	
		Thread.sleep(1000);
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		CFOcountPOM.closeCategories(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
		
		
	}
	}
	
	public static void GraphCount1(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(3000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(driver,(180));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	/*	js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(10000);*/
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a")));
		Thread.sleep(5000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(6000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1(driver).click();
			test.log(LogStatus.PASS, "View successfully");
			Thread.sleep(3000);
			
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
		
		Thread.sleep(1000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
	/*	}else {
			
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			
		}*/
	}
	
	public static void GraphCount2(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(3000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver,(140));
		Thread.sleep(8000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	
		Thread.sleep(8000);
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);*/
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a")));
		Thread.sleep(5000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1(driver).click();
			test.log(LogStatus.PASS, "View successfully");
			Thread.sleep(3000);
			
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			/*
			ViewButton.get(4).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews4"));	//Wait until frame get visible and switch to it.
			Thread.sleep(500);
			CFOcountPOM.EnterRemark(driver).sendKeys("remark");
			Thread.sleep(1000);
			CFOcountPOM.ReOpen(driver).click();
			Thread.sleep(8000);
			String msg =driver.switchTo().alert().getText();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			test.log(LogStatus.PASS, "Message Display " +msg);
Thread.sleep(1000);
driver.switchTo().parentFrame();
Thread.sleep(5000);
	*/
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
	}
	
	
	public static void RiskGraphCount(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, (70));
		Actions action = new Actions(driver);
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1(driver).click();
			test.log(LogStatus.PASS, "View successfully");
			Thread.sleep(3000);
			
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
		
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the Not Completed compliance window.
		
		if(count1 == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	public static void RiskGraphCount2(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, (70));
		Actions action = new Actions(driver);
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(5000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(4000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "View successfully");
			Thread.sleep(3000);
			
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
		
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			/*ViewButton.get(4).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews4"));	//Wait until frame get visible and switch to it.
			Thread.sleep(500);
			CFOcountPOM.EnterRemark(driver).sendKeys("remark");
			Thread.sleep(1000);
			CFOcountPOM.ReOpen(driver).click();
			Thread.sleep(8000);
			String msg =driver.switchTo().alert().getText();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			test.log(LogStatus.PASS, "Message Display " +msg);
Thread.sleep(1000);
driver.switchTo().parentFrame();
Thread.sleep(5000);*/
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the Not Completed compliance window.
		
		if(count1 == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	
	public static void RiskGraphCount1(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, (120));
		Actions action = new Actions(driver);
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(4000);
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[20]/a[1]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "overView Successfully");
		
	//	elementsList = CFOcountPOM.selectDropdown(driver);				//It is a dropdown but don't have Select tag.
		//elementsList.get(0).click();									//Clicking on first dropdown
		Thread.sleep(500);
	/*	if(Complaince.equalsIgnoreCase("Internal"))
		{
			action.moveToElement(CFOcountPOM.selectFirst1(driver)).click().build().perform();	//Selecting first option of the drop down. (ABCD PVT LTD)
		}
		else
		{
			action.moveToElement(CFOcountPOM.selectFirst(driver)).click().build().perform();	//Selecting first option of the drop down. (BITA CONSULTING)
		}*/
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the Not Completed compliance window.
		
		if(count1 == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	public static void RiskGraphCount11(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, (120));
		Actions action = new Actions(driver);
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(4000);
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[20]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "overView Successfully");
		
	//	elementsList = CFOcountPOM.selectDropdown(driver);				//It is a dropdown but don't have Select tag.
		//elementsList.get(0).click();									//Clicking on first dropdown
		Thread.sleep(500);
	/*	if(Complaince.equalsIgnoreCase("Internal"))
		{
			action.moveToElement(CFOcountPOM.selectFirst1(driver)).click().build().perform();	//Selecting first option of the drop down. (ABCD PVT LTD)
		}
		else
		{
			action.moveToElement(CFOcountPOM.selectFirst(driver)).click().build().perform();	//Selecting first option of the drop down. (BITA CONSULTING)
		}*/
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the Not Completed compliance window.
		
		if(count1 == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	
	public static void RiskGraphCountIn(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, (60));
		Actions action = new Actions(driver);
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[1]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the Not Completed compliance window.
		
		if(count1 == ComplianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	public static void RiskGraphCountIn1(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, (60));
		Actions action = new Actions(driver);
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
/*By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[18]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);*/
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1(driver).click();
			test.log(LogStatus.PASS, "View successfully");
			Thread.sleep(3000);
			
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
		
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the Not Completed compliance window.
		
		if(count1 == ComplianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	
	public static void DetailedReport(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (140));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(4000);
		CFOcountPOM.clickExportImage(driver).click();			//Exporting (Downloading) file
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Export File successfully");
		By locator = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td/a[1]");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(5000);
		CFOcountPOM.closeDocument1(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "overView successfully");
	//	CFOcountPOM.closeDocument1(driver).click();
		Thread.sleep(4000);
		CFOcountPOM.clickAdvancedSearch(driver).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(5000);
	//	clickExportExcel(driver).click();
		Thread.sleep(3000);
		By locator1 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a[1]");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton1 = driver.findElement(locator1);	
		Thread.sleep(4000);
	JavascriptExecutor jse1=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse1.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Advanced Search - overView successfully");
		Thread.sleep(1000);
		By locator3 = By.xpath("//*[@id='divOverView1']/div/div/div[1]/button");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement close = driver.findElement(locator3);	
		Thread.sleep(4000);
	//JavascriptExecutor jse=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", close);
		Thread.sleep(4000);
	//	CFOcountPOM.closeDocument2(driver).click();
		Thread.sleep(4000);
		CFOcountPOM.clickExportExcel(driver).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Advanced Search - Export successfully");
	/*	CFOcountPOM.selectMonth1(driver).click();
		Thread.sleep(3000);
		
		CFOcountPOM.selectLastSixMon(driver).click();
		Thread.sleep(2000);
		CFOcountPOM.clickApplyAd(driver).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
		Thread.sleep(5000);
		//	clickExportExcel(driver).click();
			Thread.sleep(2000);
			By locator2 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton2 = driver.findElement(locator1);	
			Thread.sleep(4000);
		JavascriptExecutor jse2=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse1.executeScript("arguments[0].click();", ViewButton2);
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Advanced Search -After Selecting Month overView successfully");
			CFOcountPOM.closeDocument2(driver).click();
			Thread.sleep(4000);
			CFOcountPOM.clickExportExcel(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search -After Selecting Month - Export successfully");
			//clickStartDate1(driver).click();*/
			CFOcountPOM.clickStartDate11(driver).sendKeys("23-Nov-2022");
			CFOcountPOM.clickLastDate11(driver).sendKeys("30-Nov-2022");
			Thread.sleep(2000);
			CFOcountPOM.clickApplyAd(driver).click();
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Advanced Search -Apply Button Working  successfully");
			CFOcountPOM.closeDocumentAS(driver).click();
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();
	}
	
	public static void GraphCountIn(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(driver, (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(4000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "View successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
		//JavascriptExecutor jse=(JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}
		else {
					
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(300,0)");	
					Thread.sleep(2000);
					driver.switchTo().parentFrame();
					CFOcountPOM.closeCategories(driver).click();
					Thread.sleep(1000);
					test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
						
				}
	}
	
	public static void GraphCountIn1(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(driver,(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
	}
	
	public static void GraphCountIn3(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[1]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
	}
	
	public static void GraphCountIn2(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "View successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
		Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}
		else {
					
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(300,0)");	
					Thread.sleep(1000);
					driver.switchTo().parentFrame();
					CFOcountPOM.closeCategories(driver).click();
					Thread.sleep(1000);
					test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
						
				}
	}
	
	public static void GraphCountInPe(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,(60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "View successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
			
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories1(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
	}
	
	public static void GraphCountInPe1(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(1000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(4000);
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		
		try                                                          
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[1]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
			
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories1(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}
		else {
					
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(300,0)");	
					Thread.sleep(1000);
					driver.switchTo().parentFrame();
					Thread.sleep(3000);
					CFOcountPOM.closeCategories1(driver).click();
					Thread.sleep(3000);
					test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
						
				}
	}
	
	public static void GraphCountSatPe(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "View successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			ViewButton.get(2).click();
			test.log(LogStatus.PASS, "Download Doc successfully");
		
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories1(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}
		else {
			int count=0;
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(300,0)");	
					Thread.sleep(1000);
					driver.switchTo().parentFrame();
					CFOcountPOM.closeCategories1(driver).click();
					
					
					if(count==complianceCount) {
						test.log(LogStatus.PASS, "'"+risk+"'  compliance count matches to numbers of items from grid.= 0");
						
						}
						else {
							test.log(LogStatus.FAIL, "'"+risk+"' Complaince Count = "+ complianceCount + " | Total no of items from grid = "+ count);
						}	
				}
	}
	
	
	public static void GraphCountSatPe1(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(1000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(4000);
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try                                                          
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[22]/a[1]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
			
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD(driver).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems(driver).getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		CFOcountPOM.closeCategories1(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}
		else {
					
					int count=0;
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(300,0)");	
					Thread.sleep(1000);
					driver.switchTo().parentFrame();
					CFOcountPOM.closeCategories1(driver).click();
					
				
					if(count==complianceCount) {
						test.log(LogStatus.PASS, "'"+risk+"'  compliance count matches to numbers of items from grid.= 0");
						
						}
						else {
							test.log(LogStatus.FAIL, "'"+risk+"' Complaince Count = "+ complianceCount + " | Total no of items from grid = "+ count);
						}		
				}
	}
	
	public static void DetailedReportIn(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (160));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(7000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(1000);
		OverduePOM.clickcomplianceType(driver).click();
		Thread.sleep(1000);
		OverduePOM.clickcomplianceSta(driver).click();
		Thread.sleep(1000);
		OverduePOM.clickcomplianceIN(driver).click();
		Thread.sleep(4000);
		CFOcountPOM.clickExportImage(driver).click();			//Exporting (Downloading) file
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Export successfully");
		Thread.sleep(4000);
		By locator = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td/a[1]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(1000);
		CFOcountPOM.closeDocument1(driver).click();
		test.log(LogStatus.PASS, "overView successfully");
	
		Thread.sleep(3000);
		OverduePOM.clickRiskD(driver).click();
		Thread.sleep(1000);
		By locatorR = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[8]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement clickHigh = driver.findElement(locatorR);	
		Thread.sleep(4000);
	jse.executeScript("arguments[0].click();", clickHigh);
		Thread.sleep(4000);
		
		OverduePOM.clickclearBtn(driver).click();
		test.log(LogStatus.PASS, "Clear Button is working");
		Thread.sleep(7000);
		CFOcountPOM.clickAdvancedSearch(driver).click();
		Thread.sleep(8000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(1000);
/*	OverduePOM.clickcomplianceTypeAS(driver).click();
	Thread.sleep(2000);
//	OverduePOM.clickcomplianceStaASA(driver).click();
	By locatorR1 = By.xpath("(//*[@class='k-checkbox-wrapper'])[89]");
	wait.until(ExpectedConditions.presenceOfElementLocated(locatorR1));
	Thread.sleep(4000);
	
	WebElement click = driver.findElement(locatorR1);	
	Thread.sleep(4000);
jse.executeScript("arguments[0].click();", click);
	Thread.sleep(4000);
	By locatorR2 = By.xpath("(//*[@class='k-checkbox-wrapper'])[90]");
	wait.until(ExpectedConditions.presenceOfElementLocated(locatorR2));
	Thread.sleep(4000);
	
	WebElement click1 = driver.findElement(locatorR2);	
	Thread.sleep(4000);
jse.executeScript("arguments[0].click();", click1);
	Thread.sleep(4000);*/
	Thread.sleep(1000);
//	OverduePOM.clickcomplianceINASMA(driver).click();
	
		Thread.sleep(3000);
		By locator1 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a[1]");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton1 = driver.findElement(locator1);	
		Thread.sleep(4000);
	JavascriptExecutor jse1=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse1.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(5000);
		
		By locator3 = By.xpath("//*[@id='divOverView1']/div/div/div[1]/button");
		  
		wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement close = driver.findElement(locator3);	
		Thread.sleep(4000);
	//JavascriptExecutor jse=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", close);
	test.log(LogStatus.PASS, "Advanced Search-overView successfully");
		Thread.sleep(4000);
	//	CFOcountPOM.closeDocument2(driver).click();
		Thread.sleep(4000);
		CFOcountPOM.clickExportExcel(driver).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Advanced Search-Export successfully");
	/*	CFOcountPOM.selectMonth1(driver).click();
		Thread.sleep(3000);
		
		CFOcountPOM.selectLastSixMon(driver).click();
		Thread.sleep(2000);
		CFOcountPOM.clickApplyAd(driver).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
		Thread.sleep(5000);
		//	clickExportExcel(driver).click();
			Thread.sleep(2000);//*[@id="grid1"]/div[3]/table/tbody/tr[1]/td[27]/a[1]
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[27]/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton2 = driver.findElement(locator1);	
			Thread.sleep(4000);
		JavascriptExecutor jse2=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse1.executeScript("arguments[0].click();", ViewButton2);
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Advanced Search-After Apply Month-overView success");
			CFOcountPOM.closeDocument2(driver).click();
			Thread.sleep(4000);
			CFOcountPOM.clickExportExcel(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search-After Apply Month-Export Succefully");
			//clickStartDate1(driver).click();*/
			CFOcountPOM.clickStartDate11(driver).sendKeys("23-Nov-2022");
			CFOcountPOM.clickLastDate11(driver).sendKeys("30-Nov-2022");
			Thread.sleep(2000);
			CFOcountPOM.clickApplyAd(driver).click();
			Thread.sleep(3000);
	CFOcountPOM.clickExportExcel(driver).click();
        	Thread.sleep(3000);
			OverduePOM.clickRiskDA(driver).click();
			Thread.sleep(1000);
			By locatorRA = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[72]");
			wait.until(ExpectedConditions.presenceOfElementLocated(locatorRA));
			Thread.sleep(4000);
			
			WebElement clickHighA = driver.findElement(locatorRA);	
			Thread.sleep(4000);
		jse.executeScript("arguments[0].click();", clickHighA);
			Thread.sleep(4000);
			
			OverduePOM.clickclearBtnA(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Advanced Search-Clear Button is working");
			CFOcountPOM.closeDocumentAS(driver).click();
			Thread.sleep(2000);
			OverduePOM.clickDashboard(driver).click();
	}
	
	public static void DetailedReportRE(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (140));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(4000);
		Thread.sleep(2000);
		CFOcountPOM.Status(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.Filter(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ClosedTimely(driver).click();	
		Thread.sleep(2000);
		CFOcountPOM.ClosedDelayedA(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.NotApplicableA(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(1000);
		CFOcountPOM.ClickFilter(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(1000);
		
		By locator = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td/a[3]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews5"));	//Wait until frame get visible and switch to it.
		Thread.sleep(500);
		CFOcountPOM.EnterRemark(driver).sendKeys("remark");
		Thread.sleep(1000);
		CFOcountPOM.ReOpen(driver).click();
		Thread.sleep(8000);
		String msg =driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Message Display " +msg);
Thread.sleep(1000);
driver.switchTo().parentFrame();


Thread.sleep(2000);
performer.OverduePOM.clickDashboard(driver).click();
Thread.sleep(2000);
	}
	
}