package departmentHead;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

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

public class DeptCountPOM {
	
	private static WebElement categories = null;		
	
	public static WebElement SelectYear(WebDriver driver)		//Method for closing Message Popup
	{
		categories = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlperiod']"));
		return categories;
	}

	public static WebElement SelectAll(WebDriver driver)		//Method for closing Message Popup
	{
		categories = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlperiod']/option[7]"));
		return categories;
	}
	
	public static WebElement ClickApply(WebDriver driver)		//Method for closing Message Popup
	{
		categories = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnTopSearch']"));
		return categories;
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
		
		WebDriverWait wait = new WebDriverWait(driver, (180));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(10000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(10000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(10000);
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
			
	  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[1]");
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
		
		Thread.sleep(500);
		Thread.sleep(1000);
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
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}else {
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			
		}
	}
	
	public static void GraphCount1(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
		
		WebDriverWait wait = new WebDriverWait(driver,(180));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(10000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]/a");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
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
			//JavascriptExecutor jse=(JavascriptExecutor)driver;
			//jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "overView successfully");
				CFOcountPOM.closeDocument(driver).click();
				Thread.sleep(3000);
		Thread.sleep(500);
		
		Thread.sleep(1000);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
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
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}else {
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			
		}
	}
	
	public static void GraphCount2(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(1000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			Thread.sleep(5000);
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(5000);
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
			Thread.sleep(5000);
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
			Thread.sleep(5000);
		}
		
		WebDriverWait wait = new WebDriverWait(driver,(180));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(10000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(10000);
		if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]/a");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
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
			//JavascriptExecutor jse=(JavascriptExecutor)driver;
			//jse.executeScript("arguments[0].click();", ViewButton);
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
		Thread.sleep(5000);*/
		Thread.sleep(500);
		
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
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}else {
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			
		}
	}
	
	
	public static void RiskGraphCount1(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,(60));
	
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
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
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[19]/a[1]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
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
		//JavascriptExecutor js = (JavascriptExecutor) driver;
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
}else {		
             int count=0;
			
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();
			Thread.sleep(1000);
			if(count==ComplianceCount) {
			test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid.= 0");
			
			}
			else {
				test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count);
			}
			
		}
	}
	
	public static void RiskGraphCount1In(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,(60));
	
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(2000);
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
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[18]/a[1]");

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
		//JavascriptExecutor js = (JavascriptExecutor) driver;
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
}else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(2000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid = 0");
			
			
		}
	}
	
	public static void RiskGraphCount(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, (70));
		
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
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
}else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(2000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
	public static void RiskGraphCountIn(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, (70));
		
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
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
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[18]/a");
			
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
}else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(2000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
	
	public static void RiskGraphCountRE(WebDriver driver, ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
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
		//JavascriptExecutor jse=(JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
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
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.INFO, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.INFO, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	
	public static void GraphCountInPe1(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
		WebDriverWait wait = new WebDriverWait(driver,(60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
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
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[21]/a[1]");

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
					CFOcountPOM.closeCategories1(driver).click();
					
					test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
						
				}
	}
	
	public static void GraphCountInPe4(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
		WebDriverWait wait = new WebDriverWait(driver,(60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD(driver).getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
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
					CFOcountPOM.closeCategories1(driver).click();
					
					test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
						
				}
	}
	
	
	public static void GraphCountInPe(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
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
			Thread.sleep(3000);
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
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[21]/a");

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
		//JavascriptExecutor jse=(JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].click();", ViewButton);
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
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}	else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories1(driver).click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
				
		}
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
		
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
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
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[18]/a[1]");

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
			test.log(LogStatus.PASS, "'"+risk+"'  compliance count matches to numbers of items from grid.= 0");
			
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
		
		WebDriverWait wait = new WebDriverWait(driver, (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
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
			
			test.log(LogStatus.PASS, "View Successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Doc Download Successfully");
			ViewButton.get(2).click();
		//JavascriptExecutor jse=(JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].click();", ViewButton);
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
		CFOcountPOM.closeCategories(driver).click();					//Closing the High Risk Window.
		
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
}else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories(driver).click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"'  compliance count matches to numbers of items from grid.= 0");
			
		}
	}
 	
 	public static void GraphCountInPe2(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[1]");

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
			CFOcountPOM.closeCategories1(driver).click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"'  compliance count matches to numbers of items from grid.= 0");
			
		}
	}
	
	public static void GraphCountInPe3(WebDriver driver, ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical(driver).click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh(driver).click();						//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium(driver).click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow(driver).click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
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
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "View successfully");
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(3000);
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
		CFOcountPOM.closeCategories1(driver).click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
}else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories1(driver).click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"'  compliance count matches to numbers of items from grid.= 0");
			
		}
		
	}
	
	public static void DetailedReportIn(ExtentTest test, WebDriver driver, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, (180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports(driver).click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport(driver).click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(7000);
		WebElement select=	driver.findElement(By.xpath("//*[@id='example']/div/div[1]/div[1]/span"));
		select.click();
			driver.findElement(By.xpath("//*[@id='dropdownlistUserRole_listbox']/li[3]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='Applybtn']")).click();
			Thread.sleep(4000);
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
		WebElement select1=	driver.findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[1]/div[1]/span"));
		select1.click();
			driver.findElement(By.xpath("//*[@id='dropdownlistUserRole1_listbox']/li[3]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='Applybtn1']")).click();
			Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(1000);
/*	OverduePOM.clickcomplianceTypeAS(driver).click();
	Thread.sleep(2000);
	OverduePOM.clickcomplianceStaASD(driver).click();
	Thread.sleep(1000);
	OverduePOM.clickcomplianceStaASDIN(driver).click();
	*/
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
		
		WebElement close = driver.findElement(locator3);	
		Thread.sleep(4000);
	
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", close);
	test.log(LogStatus.PASS, "Advanced Search-overView successfully");
		Thread.sleep(4000);
	
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
			Thread.sleep(2000);
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
			//clickStartDate1(driver).click();
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
			*/
			OverduePOM.clickclearBtnA(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Advanced Search-Clear Button is working");
			CFOcountPOM.closeDocumentAS(driver).click();
			Thread.sleep(2000);
			OverduePOM.clickDashboard(driver).click();
			Thread.sleep(2000);
	}
	
	public static void complianceDocuments(ExtentTest test, WebDriver driver) throws InterruptedException, IOException
	{
		
WebDriverWait wait = new WebDriverWait(driver, (140));
	    
		Thread.sleep(500);
		CFOcountPOM.clickDocuments(driver).click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments(driver).click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[11]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = driver.findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, " :- View successfully.");
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(3000);
			ViewButton.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews"));
			CFOcountPOM.clickDownloadBtn(driver).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "  File downloaded successfully.");
			ViewButton.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument2(driver).click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "  OverView successfully.");
			 By locator1 = By.xpath("//*[@id='sel_chkbxMain']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes = driver.findElements(locator1);	
				Thread.sleep(3000);
				ChechBoxes.get(0).click();
				Thread.sleep(500);
				ChechBoxes.get(1).click();
				Thread.sleep(500);
				ChechBoxes.get(3).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='dvbtndownloadDocumentMain']")).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, " After Checking Multiple checkbox  File downloaded successfully.");
			/*	OverduePOM.clickRiskDE(driver).click();
				Thread.sleep(2000);
				OverduePOM.clickHighDE(driver).click();
				Thread.sleep(2000);
				OverduePOM.clickclearBtn(driver).click();
				Thread.sleep(2000);*/
				test.log(LogStatus.PASS, "Clear Button Working");
				CFOcountPOM.clickAdvancedSearch(driver).click();
				Thread.sleep(3000);
				
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-selectable'])[2]")));	//Wait till records table gets visible
			Thread.sleep(3000);
			By locator2 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[3]/td[19]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			List<WebElement> ViewButton1 = driver.findElements(locator2);	
			Thread.sleep(3000);
			ViewButton1.get(0).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search :- View successfully.");
			ViewButton1.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews"));
			CFOcountPOM.clickDownloadBtn(driver).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab(driver).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search - File downloaded successfully.");
			ViewButton1.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument2(driver).click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Advanced Search -  OverView successfully.");
			 By locator3 = By.xpath("//*[@id='sel_chkbx']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes1 = driver.findElements(locator3);	
				Thread.sleep(3000);
				ChechBoxes1.get(0).click();
				Thread.sleep(500);
				ChechBoxes1.get(1).click();
				Thread.sleep(500);
				ChechBoxes1.get(2).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='dvbtndownloadDocument']")).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, " Advanced Search - After Checking Multiple checkbox  File downloaded successfully.");
			/*	OverduePOM.SelectStatus(driver).click();
				Thread.sleep(1000);
				OverduePOM.SelectstatusCD(driver).click();
				Thread.sleep(2000);
				OverduePOM.clickclearBtnA(driver).click();*/
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/a[4]")).click();
				test.log(LogStatus.PASS, "Clear Button Working");
			//	CFOcountPOM.closeDocumentAS(driver).click();
				Thread.sleep(3000);
				OverduePOM.clickDashboard(driver).click();
		
	}


	
	
	
	
}
