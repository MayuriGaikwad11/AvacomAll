package cfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import implementation.ImplementPOM;

public class MgmtBita {

	public static WebDriver driver = null;		//WebDriver instance created
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	public static List<WebElement> elementsList1 = null;
	public static List<WebElement> elementsList2 = null;
	public static List<WebElement> elementsList3 = null;
	public static List<WebElement> elementsList4 = null;
	public static List<WebElement> menus = null;
	public int count = 0;
	public int interest = 0;					//Variable created for reading Interest
	public int penalty = 0;						//Variable created for reading Penalty
	
	public static String link = "mgmt";  
	
	public static XSSFSheet ReadExcel() throws IOException
	{
		fis = new FileInputStream("C:/Users/Mayuri Gaikwad/Desktop/PerformerPom/TestData/ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(11);					//Retrieving third sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws Exception
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\Reports\\ReviewerResults.html",true);
		test = extent.startTest("Verify OpenBrowser");
		test.log(LogStatus.INFO, "Browser test is initiated");
		
		XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 1)
	void Login() throws InterruptedException, IOException
	{
		test = extent.startTest("Loging In - MGMT (Statutory)");
		test.log(LogStatus.INFO, "Logging into system");
		
		XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
			
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	public static void progress1(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id='imgcaldate']"))));
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Test(priority = 5)
	void clickPenaltyStatutory() throws InterruptedException
	{
		test = extent.startTest("'Penalty' ");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		Thread.sleep(1500);
	//	String oldStr = CFOcountPOM.readPenaltyCount(driver).getText();
	//	String newStr = oldStr.replaceAll(",","");		//Removing comma (,) from the read input.
	//	int valuePenalty = Integer.parseInt(newStr);	//Storing old value of 'Compliances'.
		
		CFOcountPOM.readPenaltyCount(driver).click();					//Clicking on 'Penalty'.
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage(driver).click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Penalty - Excel file Export Successfully");
		CFOcountPOM.clickLocationPe(driver).click();
		Thread.sleep(1000);
		CFOcountPOM.clickExpand1(driver).click();
		Thread.sleep(1000);
		CFOcountPOM.clickABita(driver).click();
		Thread.sleep(500);
		CFOcountPOM.clickClear(driver).click();
		test.log(LogStatus.PASS, " Penalty - Clear Button Working  Successfully");
		Thread.sleep(1000);
		CFOcountPOM.clickInterest(driver).click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFGradingGraphDisplay"));	//Wait until frame get visible and switch to it.

		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		CFOcountPOM.clickExportImage(driver).click();

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, "Interest - Excel File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "  File does not downloaded.");
		}
		Thread.sleep(500);
		Thread.sleep(1000);
		CFOcountPOM.clickLocationInterest(driver).click();
		Thread.sleep(2000);
	//	CFOcountPOM.clickExpand2(driver).click();
	//	Thread.sleep(1000);
	//	CFOcountPOM.clickBita(driver).click();
		//Thread.sleep(2000);
		if(CFOcountPOM.clickClear(driver).isEnabled()) {
		CFOcountPOM.clickClear(driver).click();
		test.log(LogStatus.PASS, " Interest - Clear Button Working  Successfully");
		Thread.sleep(1000);
		}
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories(driver).click();
		
		Thread.sleep(3000);
		
		//CFOcountPOM.CountPenalty(driver, test, valuePenalty);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
/*
	@Test(priority = 2)
	void CompliancesCountMatch() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on 'Compliances'");
		test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.Compliances(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	//@Test(priority = 3)
	void NotCompleted_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Completed' Count Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(3000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(NotCompletedValue == total)
		{
			test.log(LogStatus.PASS, "Not Completed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.INFO, "Total Not Completed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Completed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.INFO, "Total 'Not Completed' Compliances : "+total+" | Total Sum : "+NotCompletedValue);
		}
	
		if(NotCompletedValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCount(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				CFOcountPOM.GraphCount(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				CFOcountPOM.GraphCount(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				CFOcountPOM.GraphCount(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
		}
		else
		{
			test.log(LogStatus.SKIP, " 'Completed' Compliance Count = "+NotCompletedValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
		}
		
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 4)
	void ClosedDelayed_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayed(driver).getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickClosedDelayed(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(ClosedDelayedValue == total)
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.INFO, "Total 'Closed Delayed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Closed Delayed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.INFO, "Total 'Closed Delayed' Compliances : "+total+" | Total Sum : "+ClosedDelayedValue);
		}
		
		if(ClosedDelayedValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCount1(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				CFOcountPOM.GraphCount1(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				CFOcountPOM.GraphCount1(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				CFOcountPOM.GraphCount1(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
		}
		else
		{
			test.log(LogStatus.SKIP, "'Closed Delayed' Compliance Count = "+ClosedDelayedValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 5)
	void ClosedTimely_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Timely' Count Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		Thread.sleep(500);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		try{
		Thread.sleep(1500);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimely(driver).getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimely(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(ClosedTimelyValue == total)
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.INFO, "Total 'Closed Timely' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Closed Timely' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.INFO, "Total 'Closed Timely' Compliances : "+total+" | Total Sum : "+ClosedTimelyValue);
		}
		
		if(ClosedTimelyValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCount1(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				CFOcountPOM.GraphCount1(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				CFOcountPOM.GraphCount1(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				CFOcountPOM.GraphCount1(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(1000);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
		}
		else
		{
			test.log(LogStatus.SKIP, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
		}catch(NumberFormatException ex){
			ex.printStackTrace();
		}
	}
	
	//@Test(priority = 6)
	void NotApplicable_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Applicable' Count Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");	
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,(30));
		wait.until(ExpectedConditions.visibilityOf(CFOcountPOM.clickNotApplicable(driver)));
		
		Thread.sleep(1000);
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickNotApplicable(driver).getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickNotApplicable(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(NotApplicableValue == total)
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.INFO, "Total 'Not Applicable' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Applicable' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.INFO, "Total 'Not Applicable' Compliances : "+total+" | Total Sum : "+NotApplicableValue);
		}
		
		if(NotApplicableValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCount1(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				CFOcountPOM.GraphCount1(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				CFOcountPOM.GraphCount1(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				CFOcountPOM.GraphCount1(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(1000);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			
			Thread.sleep(500);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		}
		else
		{
			test.log(LogStatus.SKIP, "'Not Applicable' Compliance Count = "+NotApplicableValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
			
			Thread.sleep(500);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	}
		*/
	
}
