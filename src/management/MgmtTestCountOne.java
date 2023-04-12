package management;

import java.io.FileInputStream;
import java.io.IOException;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import performer.OverduePOM;

public class MgmtTestCountOne {
	
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
	
	public static String link = "Tlcg";  
	//Tlcg
	public static XSSFSheet ReadExcel() throws IOException
	{
		//String workingDir = System.getProperty("webdriver.chrome.driver","C:/March2022/PerformerPom/Driver/chromedriver.exe");
		fis = new FileInputStream("C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(15);					//Retrieving third sheet of Workbook
		return sheet;
	}
	
	@BeforeMethod
	void setBrowser() throws InterruptedException, IOException
	{
	//	String workingDir = System.getProperty("webdriver.chrome.driver","C:/March2022/PerformerPom/Driver/chromedriver.exe");
		extent = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\Reports\\CFOResultsStatotory.html",true);
		test = extent.startTest("Verify OpenBrowser");
		test.log(LogStatus.PASS, "Browser test is initiated");
		
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
		test.log(LogStatus.PASS, "Logging into system");
		
		XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		//Write "CFO-diy" for DIYProduction link.
		//Write "CFO" for login.avantis
		driver = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
			
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	public static void progress1(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,(30));
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id='imgcaldate']"))));
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Test(priority = 2)
	void CategoriesCountMatch() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on 'Categories'");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.CategoriesCountMatch(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void CompliancesCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Compliances'");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String string_Compliances =CFOcountPOM.readCompliances(driver).getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
		CFOcountPOM.readCompliances(driver).click();
		Thread.sleep(500);
		
		litigationPerformer.MethodsPOM.progress(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage(driver).click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		/*CFOcountPOM.clickLocation(driver).click();
		Thread.sleep(500);
		CFOcountPOM.clickBitaAurangabad(driver).click();
		Thread.sleep(3000);
		CFOcountPOM.clickClear(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Clear Button is working");*/	
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItems3(driver).click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItems3(driver).getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int ComcountGrid = Integer.parseInt(compliancesCount);
		if(CompliancesCountDas == ComcountGrid)
		{
			test.log(LogStatus.PASS, "Number of Compliances grid matches to Dashboard Compliances  Count.");
			test.log(LogStatus.PASS, "No of Compliances in the grid = "+ComcountGrid+" | Dashboard Compliances  Count = "+CompliancesCountDas);
		}
		else
		{
			test.log(LogStatus.FAIL, "Number of compliances does not matches to Dashboard Statutory Compliances Count.");
			test.log(LogStatus.FAIL, "No of Compliances in the grid = "+ComcountGrid+" | Dashboard Compliances  Count = "+CompliancesCountDas);
		}
		js.executeScript("window.scrollBy(500,0)");						//Scrolling UP window by 2000 px.
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories(driver).click();
		extent.endTest(test);
		extent.flush();
	}
	/*
	@Test(priority = 4)
	void UsersCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Users'");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String string_User =CFOcountPOM.clickUsersCount(driver).getText();		//Storing old value of Statutory overdue.
	int	UserCountDas = Integer.parseInt(string_User);
		CFOcountPOM.clickUsersCount(driver).click();
		Thread.sleep(500);
		
		litigationPerformer.MethodsPOM.progress(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,(60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.

		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD(driver).getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int UserGrid = Integer.parseInt(compliancesCount);
		if(UserCountDas == UserGrid)
		{
			test.log(LogStatus.PASS, "Number of User grid matches to Dashboard User  Count.");
			test.log(LogStatus.PASS, "No of User in the grid = "+UserGrid+" | Dashboard User  Count = "+UserCountDas);
		}
		else
		{
			test.log(LogStatus.FAIL, "Number of User does not matches to Dashboard User  Count.");
			test.log(LogStatus.FAIL, "No of User in the grid = "+UserGrid+" | Dashboard User  Count = "+UserCountDas);
		}
		
		js.executeScript("window.scrollBy(500,0)");						//Scrolling UP window by 2000 px.
		Thread.sleep(4000);
		CFOcountPOM.clickExportImage(driver).click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories(driver).click();
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5)
	void clickPenaltyStatutory() throws InterruptedException
	{
		test = extent.startTest("'Penalty' Export");
		test.log(LogStatus.PASS, "Test Initiated");
		
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
		test.log(LogStatus.PASS, "Excel file Export Successfully");
		CFOcountPOM.clickLocationPe(driver).click();
		Thread.sleep(1000);
		CFOcountPOM.clickExpand1(driver).click();
		Thread.sleep(1000);
		CFOcountPOM.clickABita(driver).click();
		Thread.sleep(500);
		CFOcountPOM.clickClear(driver).click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories(driver).click();
		
		Thread.sleep(3000);
		
		//CFOcountPOM.CountPenalty(driver, test, valuePenalty);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6)
	void SummaryofOverdueCompliances() throws InterruptedException
	{
		test = extent.startTest(" Summary of Overdue Compliances");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		CFOcountPOM.ClickShowAll(driver).click();        //Clicking on Show All
		Thread.sleep(3000);
		litigationPerformer.MethodsPOM.progress(driver);
		WebDriverWait wait = new WebDriverWait(driver, (100));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	WebElement farme=	driver.findElement(By.xpath("//*[@id='showdetails']"));
      driver.switchTo().frame(farme);
      Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
		 Thread.sleep(3000); 
	//	elementsList1=	CFOcountPOM.ActionviewList(driver);
		//elementsList1.get(1).click();                   //Clicking on OverdueView  button
	//	driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[16]/a[1]")).click();
	//	Thread.sleep(3000);
	//	CFOcountPOM.closeDocument(driver).click();						//Closing the View Document
		 CFOcountPOM.clickExportImage(driver).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(4000);
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			List<WebElement> ViewButtons = driver.findElements(locator);							
			ViewButtons.get(1).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "overView success");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			OverduePOM.clickRiskShowAll(driver).click();
			Thread.sleep(1000);
			OverduePOM.clickRiskSAhigh(driver).click();
			Thread.sleep(1000);
			OverduePOM.clickclearBtn(driver).click();
			test.log(LogStatus.PASS, "Clear successfully");
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			CFOcountPOM.closeCategories(driver).click();
			Thread.sleep(1000);
		extent.endTest(test);
		extent.flush();			
		
	}
	
	@Test(priority = 7)
	void NotCompleted_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Completed' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
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
			test.log(LogStatus.PASS, "Total Not Completed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Completed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Completed' Compliances : "+total+" | Total Sum : "+NotCompletedValue);
		}
	
		if(NotCompletedValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCountM(driver, test, "Critical", critical, "Statutory");
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
				CFOcountPOM.GraphCountM(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				CFOcountPOM.GraphCountM(driver, test, "Low", low, "Statutory");
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
	
	@Test(priority = 8)
	void ClosedDelayed_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Actions action = new Actions(driver);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
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
			test.log(LogStatus.PASS, "Total 'Closed Delayed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Closed Delayed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Closed Delayed' Compliances : "+total+" | Total Sum : "+ClosedDelayedValue);
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
	
	@Test(priority = 9)
	void ClosedTimely_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Timely' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Actions action = new Actions(driver);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
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
			test.log(LogStatus.PASS, "Total 'Closed Timely' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Closed Timely' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Closed Timely' Compliances : "+total+" | Total Sum : "+ClosedTimelyValue);
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
			
			Thread.sleep(500);
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
	
	@Test(priority = 10)
	void NotApplicable_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Applicable' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		//	js.executeScript("window.scrollBy(0,500)");	
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (30));
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
			test.log(LogStatus.PASS, "Total 'Not Applicable' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Applicable' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Applicable' Compliances : "+total+" | Total Sum : "+NotApplicableValue);
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
			
			Thread.sleep(1000);
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
		
	@Test(priority = 11)
	void Overdue_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Overdue' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickOverdue(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickOverdue(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "' Overdue' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Overdue' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
	
		if(OverdueValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCountM(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				CFOcountPOM.GraphCountM(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				CFOcountPOM.GraphCountM(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				CFOcountPOM.GraphCountM(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(5000);
			action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		else
		{
			test.log(LogStatus.SKIP, " 'Overdue' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 12)
	void dueToday_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'dueToday' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int dueTodayValue = Integer.parseInt(CFOcountPOM.clickdueToday(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickdueToday(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(dueTodayValue == total)
		{
			test.log(LogStatus.PASS, "' dueToday' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'dueToday' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+dueTodayValue);
		}
	
		if(dueTodayValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCountM(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				CFOcountPOM.GraphCountM(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				CFOcountPOM.GraphCountM(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				CFOcountPOM.GraphCountM(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(5000);
			action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		else
		{
			test.log(LogStatus.SKIP, " 'Due Today' Compliance Count = "+dueTodayValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13)
	void pendingForReview_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickpendingForReview(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickpendingForReview(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(pendingForReviewValue == total)
		{
			test.log(LogStatus.PASS, "' Pending For Review' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Pending For Review' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+pendingForReviewValue);
		}
	
		if(pendingForReviewValue > 0)
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
			
			Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		else
		{
			test.log(LogStatus.SKIP, " 'Pending For Review' Compliance Count = "+pendingForReviewValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
    @Test(priority = 14)
	void inProgress_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'In Progress' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(500);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int inProgressValue = Integer.parseInt(CFOcountPOM.clickinProgress(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickinProgress(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(inProgressValue == total)
		{
			test.log(LogStatus.PASS, "' In Progress' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'In Progress' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+inProgressValue);
		}
	
		if(inProgressValue > 0)
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
			
			Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		else
		{
			test.log(LogStatus.SKIP, " 'In Progress' Compliance Count = "+inProgressValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15)
	void rejected_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- ' Rejected' Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
	//	driver.navigate().refresh();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int rejectedValue = Integer.parseInt(CFOcountPOM.clickRejectedPe(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejectedPe(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		
		if(rejectedValue == total)
		{
			test.log(LogStatus.PASS, "' Rejected' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+rejectedValue);
		}
	
		if(rejectedValue > 0)
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
			
			Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		else
		{
			test.log(LogStatus.SKIP, " 'Rejected' Compliance Count = "+rejectedValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void BargraphIndustrySpeCriticalStatutory() throws InterruptedException
	{
		test = extent.startTest("Bar Graph - 'Industry Specific' Count Verification with 'Critical' Risk");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(1000);
		//performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.visibilityOf(CFOcountPOM.clickCategories(driver)));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int IndustrySpeCritical = Integer.parseInt(CFOcountPOM.clickIndustrySpeCritical(driver).getText());	//Reading the High value of Labour compliance
		
		Thread.sleep(1000);
		CFOcountPOM.clickIndustrySpeCritical(driver).click();					//Clicking on High bar of Labour  
		
		Thread.sleep(500);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely(driver).getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed(driver).getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted(driver).getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable(driver).getText());	//reading Not Applicable count.
		
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
		
		if(IndustrySpeCritical == total)
		{
			test.log(LogStatus.PASS, "'Industry Specific' - Critical' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'Industry Specific - Critical' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Industry Specific' - Critical' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'Industry Specific - Critical' Compliances : "+total+" | Total Sum : "+IndustrySpeCritical);
		}
		
		if(IndustrySpeCritical > 0)
		{
			if(ClosedTimely > 0)
			{
				CFOcountPOM.BarGraphCount(driver, test, "Closed Timely", ClosedTimely);
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical - Closed Timely' Count = "+ClosedTimely);
			}
			
			if(ClosedDelayed > 0)
			{
				CFOcountPOM.BarGraphCount(driver, test, "Closed Delayed", ClosedDelayed);
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical - Closed Delayed' Count = "+ClosedDelayed);
			}
			if(NotCompleted > 0)
			{
				CFOcountPOM.BarGraphCount1(driver, test, "Not Completed", NotCompleted);
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical - Not Completed' Count = "+NotCompleted);
			}
			if(NotApplicable > 0)
			{
				CFOcountPOM.BarGraphCount(driver, test, "Not Applicable", NotApplicable);
			}
			else
			{
				test.log(LogStatus.SKIP, "'Critical - Not Applicable' Count = "+NotApplicable);
			}
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
		}
		else
		{
			test.log(LogStatus.SKIP, "'Labour - Critical' Count = "+IndustrySpeCritical);
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17)
	void BargraphIndustrySpeHighStatutory() throws InterruptedException
	{
		test = extent.startTest("Bar Graph - 'Industry Specific' Count Verification with 'High' risk");
		test.log(LogStatus.PASS, "Test Initiated");
		Thread.sleep(4000);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
		
		String PendingReview = CFOcountPOM.clickIndustrySpeHigh(driver).getText();	//Reading the Pending For Review value of Human Resource
		PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
		
		Thread.sleep(4000);
		int IndustrySpeHigh = Integer.parseInt(PendingReview);	//Reading the Medium value of Labour compliance
		CFOcountPOM.clickIndustrySpeHigh(driver).click();					//Clicking on High bar of Labour  
		
		Thread.sleep(500);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely(driver).getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed(driver).getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted(driver).getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable(driver).getText());	//reading Not Applicable count.
		
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
		
		if(IndustrySpeHigh == total)
		{
			test.log(LogStatus.PASS, "'Industry Specific - High' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'Industry Specific - High' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Industry Specific - High' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'Industry Specific - High' Compliances : "+total+" | Total Sum : "+IndustrySpeHigh);
		}
		
		if(IndustrySpeHigh > 0)
		{
			if(ClosedTimely > 0)
			{
				CFOcountPOM.BarGraphCount(driver, test, "Closed Timely", ClosedTimely);
			}
			else
			{
				test.log(LogStatus.SKIP, "'High - Closed Timely' Count = "+ClosedTimely);
			}
			
			if(ClosedDelayed > 0)
			{
				CFOcountPOM.BarGraphCount(driver, test, "Closed Delayed", ClosedDelayed);
			}
			else
			{
				test.log(LogStatus.SKIP, "'High - Closed Delayed' Count = "+ClosedDelayed);
			}
			if(NotCompleted > 0)
			{
				CFOcountPOM.BarGraphCount1(driver, test, "Not Completed", NotCompleted);
			}
			else
			{
				test.log(LogStatus.SKIP, "'High - Not Completed' Count = "+NotCompleted);
			}
			if(NotApplicable > 0)
			{
				CFOcountPOM.BarGraphCount(driver, test, "Not Applicable", NotApplicable);
			}
			else
			{
				test.log(LogStatus.SKIP, "'High - Not Applicable' Count = "+NotApplicable);
			}
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
		
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			Thread.sleep(1000);
		//	performer.OverduePOM.clickDashboard(driver).click();
		}
		else
		{
			test.log(LogStatus.SKIP, "'Labour - High' Count = "+IndustrySpeHigh);
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
	
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 18)
	void BargraphIndustrySpeMediumStatutory() throws InterruptedException
	{
		test = extent.startTest("Bar Graph - 'Industry Specific' Count Verification with 'Medium' risk");
		test.log(LogStatus.PASS, "Test Initiated");
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(8000);
		int IndustrySpeMedium = Integer.parseInt(CFOcountPOM.clickIndustrySpeMedium(driver).getText());	//Reading the Medium value of Labour compliance
		Thread.sleep(2000);
		CFOcountPOM.clickIndustrySpeMedium(driver).click();					//Clicking on High bar of Labour  
		
		Thread.sleep(500);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely(driver).getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed(driver).getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted(driver).getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable(driver).getText());	//reading Not Applicable count.
		
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
		
		if(IndustrySpeMedium == total)
		{
			test.log(LogStatus.PASS, "'Industry Specific - High' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'Industry Specific - High' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Industry Specific - High' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'Industry Specific - High' Compliances : "+total+" | Total Sum : "+IndustrySpeMedium);
		}
		
		if(IndustrySpeMedium > 0)
		{
			if(ClosedTimely > 0)
			{
				CFOcountPOM.BarGraphCount(driver, test, "Closed Timely", ClosedTimely);
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium - Closed Timely' Count = "+ClosedTimely);
			}
			
			if(ClosedDelayed > 0)
			{
				CFOcountPOM.BarGraphCount(driver, test, "Closed Delayed", ClosedDelayed);
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium - Closed Delayed' Count = "+ClosedDelayed);
			}
			if(NotCompleted > 0)
			{
				CFOcountPOM.BarGraphCount1(driver, test, "Not Completed", NotCompleted);
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium - Not Completed' Count = "+NotCompleted);
			}
			if(NotApplicable > 0)
			{
				CFOcountPOM.BarGraphCount(driver, test, "Not Applicable", NotApplicable);
			}
			else
			{
				test.log(LogStatus.SKIP, "'Medium - Not Applicable' Count = "+NotApplicable);
			}
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
		}
		else
		{
			test.log(LogStatus.SKIP, "'Labour - Medium' Count = "+IndustrySpeMedium);
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
		}
		extent.endTest(test);
		extent.flush();
	}
	*/
	//@Test(priority = 19)
	void BargraphIndustrySpeLowStatutory() throws InterruptedException
	{
		test = extent.startTest("Bar Graph - 'Indistry Specific' Count Verification with 'Low' risk");
		test.log(LogStatus.PASS, "Test Initiated");
		
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
		
		
		Thread.sleep(5000);
		int IndustrySpeLow = Integer.parseInt(CFOcountPOM.clickIndustrySpeLow(driver).getText());	//Reading the Medium value of Labour compliance
		Thread.sleep(1000);
		CFOcountPOM.clickIndustrySpeLow(driver).click();					//Clicking on low bar of Indistry Specific  
		
		Thread.sleep(500);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely(driver).getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed(driver).getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted(driver).getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable(driver).getText());	//reading Not Applicable count.
		
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
		
		if(IndustrySpeLow == total)
		{
			test.log(LogStatus.PASS, "'Indistry Specific - High' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'Indistry Specific - High' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Indistry Specific - High' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'Indistry Specific - High' Compliances : "+total+" | Total Sum : "+IndustrySpeLow);
		}
		
		if(IndustrySpeLow > 0)
		{
			if(ClosedTimely > 0)
			{
				CFOcountPOM.BarGraphCount(driver, test, "Closed Timely", ClosedTimely);
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low - Closed Timely' Count = "+ClosedTimely);
			}
			
			if(ClosedDelayed > 0)
			{
				CFOcountPOM.BarGraphCount(driver, test, "Closed Delayed", ClosedDelayed);
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low - Closed Delayed' Count = "+ClosedDelayed);
			}
		/*	if(NotCompleted > 0)
			{
				CFOcountPOM.BarGraphCount1(driver, test, "Not Completed", NotCompleted);
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low - Not Completed' Count = "+NotCompleted);
			}*/
			if(NotApplicable > 0)
			{
				CFOcountPOM.BarGraphCount(driver, test, "Not Applicable", NotApplicable);
			}
			else
			{
				test.log(LogStatus.SKIP, "'Low - Not Applicable' Count = "+NotApplicable);
			}
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			
			Thread.sleep(500);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		}
		else
		{
			test.log(LogStatus.SKIP, "'Labour - Low' Count = "+IndustrySpeLow);
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			
			Thread.sleep(500);
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	}
	
	 @AfterTest
		void Closing() throws InterruptedException
		{
		 test = extent.startTest("Verify Close Browser");
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "Browser Close");
			driver.close();
			extent.endTest(test);
			extent.flush();
		}	 

}
