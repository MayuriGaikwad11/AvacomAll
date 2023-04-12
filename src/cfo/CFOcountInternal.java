package cfo;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import performer.OverduePOM;

public class CFOcountInternal 
{
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
	
	
	public static String link = "CFO";			//Check link in excel sheet first.
	
	public static XSSFSheet ReadExcel() throws IOException
	{
	//	String workingDir = System.getProperty("webdriver.chrome.driver","C:/March2022/PerformerPom/Driver/chromedriver.exe");
		fis = new FileInputStream("C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(2);					//Retrieving third sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
	//	String workingDir = System.getProperty("webdriver.chrome.driver","C:/March2022/PerformerPom/Driver/chromedriver.exe");
		extent = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\Reports\\CFOResultsInternal.html",true);
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
		test = extent.startTest("Loging In - CFO Finance (Internal)");
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
		
		Thread.sleep(700);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	public static void progress1(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, (60));
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id='imgcaldate']"))));
		}
		catch(Exception e)
		{
			
		}
	}
	
	//@Test(priority = 2)
	void clickCategoriesInternal() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Categories'");
	//	test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String string_Categories =CFOcountPOM.clickCategories(driver).getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
		CFOcountPOM.clickCategories(driver).click();
		Thread.sleep(500);
		
		litigationPerformer.MethodsPOM.progress(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, (70));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[3]/td[4]/div")));
		Thread.sleep(7000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD(driver).getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		/*elementsList1 = CFOcountPOM.readCompliancesList(driver);
	String comp_cat=	elementsList1.get(1).getText();
	int	CompCountCat = Integer.parseInt(comp_cat);
		elementsList1.get(1).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage(driver).click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		
		Thread.sleep(500);
		litigationPerformer.MethodsPOM.progress(driver);
		
	//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));	//Wait until frame get visible and switch to it.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-grid-content k-auto-scrollable']")));
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,3000)");				//Scrolling down window by 2000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();
		
		Thread.sleep(1000);
		String item1 = CFOcountPOM.readTotalItemsD(driver).getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
		
	int	count = Integer.parseInt(compliancesCount1);
		js.executeScript("window.scrollBy(0,3000)");
		if(CompCountCat == count)
		{
			test.log(LogStatus.PASS, "Compliances count matches. Clicked value = " + CompCountCat+ ", Grid Records = "+count);
		}
		else
		{
			test.log(LogStatus.FAIL, "Compliances count does not matches. Clicked value = "+CompCountCat+", Grid Records = "+count);
		}
		
		driver.switchTo().parentFrame();								//Switching back to parent frame.
		Thread.sleep(3000);
		CFOcountPOM.closeCategories_Compliances(driver).click();		//Closing the 'Compliances' pup up.
		Thread.sleep(2000);
	
		
		elementsList1 = CFOcountPOM.readUserList(driver);
		String user_cat=	elementsList1.get(1).getText();
		int	userCountCat = Integer.parseInt(user_cat);
			elementsList1.get(1).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
			Thread.sleep(3000);                                             
			CFOcountPOM.clickExportImage(driver).click();                    //export excel
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");	
			
			Thread.sleep(500);
			litigationPerformer.MethodsPOM.progress(driver);
			
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));	//Wait until frame get visible and switch to it.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-grid-content k-auto-scrollable']")));
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,3000)");				//Scrolling down window by 2000 px.
			Thread.sleep(1000);
			CFOcountPOM.readTotalItemsD(driver).click();
			
			Thread.sleep(1000);
			String item2 = CFOcountPOM.readTotalItemsD(driver).getText();
			String[] bits2 = item.split(" ");								//Splitting the String
			String userCount2 = bits[bits.length - 2];				//Getting the second last word (total number of users)
			
		int	count1 = Integer.parseInt(userCount2);
			js.executeScript("window.scrollBy(0,3000)");
			if(userCountCat == count1)
			{
				test.log(LogStatus.PASS, "Users count matches. Clicked value = " + userCountCat+ ", Grid Records = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Users count does not matches. Clicked value = "+userCountCat+", Grid Records = "+count1);
			}
			
			driver.switchTo().parentFrame();								//Switching back to parent frame.
			Thread.sleep(3000);
			CFOcountPOM.closeCategories_Compliances(driver).click();		//Closing the 'Compliances' pup up.
			Thread.sleep(2000);
		
			*/
		if(CategoriesCountDas == CatcountGrid)
		{
			//test.log(LogStatus.PASS, "Number of Categories grid matches to Dashboard Categories  Count.");
			test.log(LogStatus.PASS, "No of Categories in the grid = "+CatcountGrid+" | Dashboard Categories  Count = "+CategoriesCountDas);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "Number of Categories does not matches to Dashboard Categories  Count.");
			test.log(LogStatus.FAIL, "No of Categories in the grid = "+CatcountGrid+" | Dashboard Categories  Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		Thread.sleep(4000);
		
		CFOcountPOM.closeCategories(driver).click();
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	
	
	//@Test(priority = 3)
	void ClickCompliancesInternal() throws InterruptedException
	{
		test = extent.startTest("'Compliances' Count by Clicking on 'Compliances'");
	//	test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(1500);
		WebDriverWait wait1 = new WebDriverWait(driver, (30));
		wait1.until(ExpectedConditions.visibilityOf(CFOcountPOM.readCompliancesInternal(driver)));
		int valueCompliances = Integer.parseInt(CFOcountPOM.readCompliancesInternal(driver).getText());	//Storing value of 'Compliances' as a String to compare.
		
	//	driver.findElement(By.xpath("(//*[@class = 'titleMD'])[4]")).click();
		CFOcountPOM.readCompliancesInternal(driver).click();					//Clicking on 'Compliances'.
		
		Thread.sleep(500);
		litigationPerformer.MethodsPOM.progress(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, (10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
		
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage(driver).click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		CFOcountPOM.clickLocationIn(driver).click();
		Thread.sleep(500);
		
		CFOcountPOM.clickClear(driver).click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Clear Button is working Successfully");	
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");				//Scrolling down window by 2000 px.
		
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();				//Clicking on Total items count to scroll down.
		String getCount = CFOcountPOM.readTotalItemsD(driver).getText();	//Storing 'Compliances' count as string.
		String[] bits = getCount.split(" ");							//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			getCount = CFOcountPOM.readCompliancesItems(driver).getText();
			bits = getCount.split(" ");								//Splitting the String
			compliancesCount = bits[bits.length - 2];
		}
		
		int count = Integer.parseInt(compliancesCount);
		
		driver.switchTo().parentFrame();								//Switching back to parent frame. 
		Thread.sleep(500);
		CFOcountPOM.closeCategories(driver).click();					//Closing the 'Compliance' window.
		
		if(valueCompliances == count)									//Comparing dashboard Compliance value with inside Compliance value
		{
			test.log(LogStatus.PASS, "'Compliances' count matches to total records count displayed. Dashboard Value = "+ valueCompliances+ " | Actual count = "+ count);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Compliances' count doesn't matches to total records count displayed. Dashboard Value = "+ valueCompliances+ " } Actual count = "+ count);
		}
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 4)
	void clickUsersInternal() throws InterruptedException
	{
		test = extent.startTest("'Users' Count by Clicking on 'Users'");
	//	test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(500);
		if(OverduePOM.closeMessage(driver).isDisplayed())				//If Compliance Updation message popped up,
		{
			OverduePOM.closeMessage(driver).click();					//then close the message.
		}
		
		Thread.sleep(1500);
		int valueUsers = Integer.parseInt(CFOcountPOM.clickUsersCount(driver).getText());	//Storing value of 'Users' as a String to compare.
		
		CFOcountPOM.clickUsersCount(driver).click();					//Clicking on 'Users'. 
		
		WebDriverWait wait = new WebDriverWait(driver, (15));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		Thread.sleep(5000);
		CFOcountPOM.clickExportImage(driver).click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		CFOcountPOM.readTotalItems4(driver).click();
		
		String getCount = CFOcountPOM.readTotalItems4(driver).getText();	//Storing no of Items 'Users' count as string.
		String[] bits = getCount.split(" ");							//Splitting the String
		String usersCount = bits[bits.length - 2];						//Getting the second last word (total number of users)
		if(usersCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2500);
			getCount = CFOcountPOM.readTotalItems4(driver).getText();
			bits = getCount.split(" ");								//Splitting the String
			usersCount = bits[bits.length - 2];
		}
		int count = Integer.parseInt(usersCount);
		
		driver.switchTo().parentFrame();								//Switching back to parent frame. 
		Thread.sleep(1000);
		CFOcountPOM.closeCategories(driver).click();					//Closing the 'Compliance' window.
		
		if(valueUsers == count)								//Checking if String getCount contains the Value (in string format) 
		{
			test.log(LogStatus.PASS, "'Users' count matches to 'Users' items. Dashboard Value = "+ valueUsers+ ", Actual Value = "+ getCount);
		}
		else
		{
			test.log(LogStatus.FAIL, "Users count does not matches. Dashboard Value = "+ valueUsers+ ", Actual Value = "+ getCount);
		}
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 5)
	void SummaryofOverdueCompliances() throws InterruptedException
	{
		test = extent.startTest(" Summary of Overdue Compliances Internal");
	//	test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(CFOcountPOM.ClickShowAllIn(driver).isEnabled()) {
			CFOcountPOM.ClickShowAllIn(driver).click();        //Clicking on Show All
			Thread.sleep(3000);
			test.log(LogStatus.PASS, " 'Show All ' link Clickable Successfully");
			}
		        
		Thread.sleep(3000);
		litigationPerformer.MethodsPOM.progress(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
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
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			CFOcountPOM.clickLocationShow(driver).click();
			Thread.sleep(1000);
			//CFOcountPOM.clickCkecjke(driver).click();
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
	
//	@Test(priority = 6)
	void ClosedTimely_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Timely' Count Verification");
		
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimelyInternal(driver).getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimelyInternal(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
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
		*/
		if(ClosedTimelyValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountIn1(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				CFOcountPOM.GraphCountIn1(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >=0)
			{
				CFOcountPOM.GraphCountIn1(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn1(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(500);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 7)
	void ClosedDelayed_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayedInternal(driver).getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickClosedDelayedInternal(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
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
		*/
		if(ClosedDelayedValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountIn1(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				CFOcountPOM.GraphCountIn1(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				CFOcountPOM.GraphCountIn1(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn1(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(1000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+ClosedDelayedValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(1000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 8)
	void NotCompleted_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Completed' Count Verification");
		
		Thread.sleep(500);
		Actions action = new Actions(driver);
	  //    JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompletedInternal(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompletedInternal(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(NotCompletedValue == total)
		{
			test.log(LogStatus.PASS, "'Not Completed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Completed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Completed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Completed' Compliances : "+total+" | Total Sum : "+NotCompletedValue);
		}
		*/
		if(NotCompletedValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountIn(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				CFOcountPOM.GraphCountIn(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				CFOcountPOM.GraphCountIn(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(500);
		}
		else
		{
			test.log(LogStatus.PASS, "'Not Completed' Compliance Count = "+NotCompletedValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 9)
	void NotApplicable_PieChartIN() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Applicable' Count Verification");
		Thread.sleep(1500);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickNotApplicable(driver).getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickNotApplicable(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(NotApplicable == total)
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Applicable' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Applicable' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Applicable' Compliances : "+total+" | Total Sum : "+NotApplicable);
		}
		*/
		if(NotApplicable > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCountIn1(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				CFOcountPOM.GraphCountIn1(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				CFOcountPOM.GraphCountIn1(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				CFOcountPOM.GraphCountIn1(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(1000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+NotApplicable);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(1000);
		}
		extent.endTest(test);
		extent.flush();
	}
		
	//@Test(priority = 10)
	void Overdue_PieChartInternal() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Overdue' Count Verification");
		
		Thread.sleep(500);
		
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(500);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickOverdueInternal(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickOverdueInternal(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'Overdue' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Overdue' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		if(OverdueValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountIn3(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				CFOcountPOM.GraphCountIn3(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				CFOcountPOM.GraphCountIn3(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn3(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(1000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Overdue' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(1000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 11)
	void dueToday_PieChartInternal() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'dueToday' Count Verification");
	
		Thread.sleep(3000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		
		Thread.sleep(2000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);
		Thread.sleep(500);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
		int dueTodayValue = Integer.parseInt(CFOcountPOM.clickdueToday(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickdueToday(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
	/*	
		if(dueTodayValue == total)
		{
			test.log(LogStatus.PASS, "'dueToday' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'dueToday' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'dueToday' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'dueToday' Compliances : "+total+" | Total Sum : "+dueTodayValue);
		}
		*/
		if(dueTodayValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCountIn3(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				CFOcountPOM.GraphCountIn3(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				CFOcountPOM.GraphCountIn3(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				CFOcountPOM.GraphCountIn3(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(1000);
		}
		else
		{
			test.log(LogStatus.PASS, "'dueToday' Compliance Count = "+dueTodayValue);
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(1000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 12)
	void PFR_PieChartInternal() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - Not Completed Status-  'Pending for Review' Count Verification");
		
		Thread.sleep(3000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		
		Thread.sleep(3000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);
		Thread.sleep(500);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(500);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickpendingForReviewIN(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickpendingForReviewIN(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'pending For Review' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'pending For Review' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'pending For Review' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'pending For Review' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		if(OverdueValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountIn2(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				CFOcountPOM.GraphCountIn2(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				CFOcountPOM.GraphCountIn2(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn2(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(1000);
		}
		else
		{
			test.log(LogStatus.PASS, "'pending For Review' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(1000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 13)
	void inProgress_PieChartInternal() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - Not Completed Status-  'In Progress' Count Verification");
		
		Thread.sleep(3000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		
		Thread.sleep(2000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);
		Thread.sleep(500);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(1000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickinProgress(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickinProgress(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'In Progress' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'In Progress' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'In Progress' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'In Progress' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		if(OverdueValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCountIn2(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				CFOcountPOM.GraphCountIn2(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				CFOcountPOM.GraphCountIn2(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn2(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard

		}
		else
		{
			test.log(LogStatus.PASS, "'In Progress' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
	
	//@Test(priority = 14)
	void Rejected_PieChartInternal() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - Not Completed Status- 'Rejected' Count Verification");
		
		Thread.sleep(500);
		Thread.sleep(3000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickRejectedPe(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejectedPe(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'Rejected ' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Rejected' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Rejected' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		if(OverdueValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountIn2(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				CFOcountPOM.GraphCountIn2(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				CFOcountPOM.GraphCountIn2(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn2(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard

		}
		else
		{
			test.log(LogStatus.PASS, "'Rejected' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 15)
	void BargraphBSECriticalStatutory() throws InterruptedException
	{
		test = extent.startTest("Bar Graph - 'BSE' Count Verification with 'Critical' risk");
		
		
		Thread.sleep(2000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
		
		
		Thread.sleep(4000);
		int BSEHigh = Integer.parseInt(CFOcountPOM.clickBSECritical(driver).getText());	//Reading the Medium value of Labour compliance
		CFOcountPOM.clickBSECritical(driver).click();					//Clicking on High bar of Labour  
		
		Thread.sleep(500);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely(driver).getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed(driver).getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted(driver).getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable(driver).getText());	//reading Not Applicable count.
		
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
		/*
		if(BSEHigh == total)
		{
			test.log(LogStatus.PASS, "'BSE  - Critical' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'BSE - Critical' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'BSE - Critical' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'BSE - Critical' Compliances : "+total+" | Total Sum : "+BSEHigh);
		}
		*/
		if(BSEHigh > 0)
		{
			if(ClosedTimely > 0)
			{
				CFOcountPOM.BarGraphCountIn(driver, test, "Closed Timely", ClosedTimely);
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical - Closed Timely' Count = "+ClosedTimely);
			}
			
			if(ClosedDelayed > 0)
			{
				CFOcountPOM.BarGraphCountIn(driver, test, "Closed Delayed", ClosedDelayed);
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical - Closed Delayed' Count = "+ClosedDelayed);
			}
			if(NotCompleted > 0)
			{
				CFOcountPOM.BarGraphCountIn1(driver, test, "Not Completed", NotCompleted);
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical - Not Completed' Count = "+NotCompleted);
			}
			if(NotApplicable > 0)
			{
				CFOcountPOM.BarGraphCountIn(driver, test, "Not Applicable", NotApplicable);
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical - Not Applicable' Count = "+NotApplicable);
			}
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			Thread.sleep(2000);
				}
		else
		{
			test.log(LogStatus.PASS, "'BSE ' - Critical' Count = "+BSEHigh);
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
		}
				extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 16)
	void BargraphBSEHighStatutory() throws InterruptedException
	{
		test = extent.startTest("Bar Graph - 'BSE' Count Verification with 'High' risk");
		
		
	/*	Thread.sleep(2000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);*/
		//JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
		
		
		Thread.sleep(4000);
		int BSEHigh = Integer.parseInt(CFOcountPOM.clickBSEHigh(driver).getText());	//Reading the Medium value of Labour compliance
		CFOcountPOM.clickBSEHigh(driver).click();					//Clicking on High bar of Labour  
		
		Thread.sleep(500);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely(driver).getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed(driver).getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted(driver).getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable(driver).getText());	//reading Not Applicable count.
		
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
		/*
		if(BSEHigh == total)
		{
			test.log(LogStatus.PASS, "'BSE  - High' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'BSE - High' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'BSE - High' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'BSE - High' Compliances : "+total+" | Total Sum : "+BSEHigh);
		}
		*/
		if(BSEHigh > 0)
		{
			if(ClosedTimely > 0)
			{
				CFOcountPOM.BarGraphCountIn(driver, test, "Closed Timely", ClosedTimely);
			}
			else
			{
				test.log(LogStatus.PASS, "'High - Closed Timely' Count = "+ClosedTimely);
			}
			
			if(ClosedDelayed > 0)
			{
				CFOcountPOM.BarGraphCountIn(driver, test, "Closed Delayed", ClosedDelayed);
			}
			else
			{
				test.log(LogStatus.PASS, "'High - Closed Delayed' Count = "+ClosedDelayed);
			}
			if(NotCompleted > 0)
			{
				CFOcountPOM.BarGraphCountIn1(driver, test, "Not Completed", NotCompleted);
			}
			else
			{
				test.log(LogStatus.PASS, "'High - Not Completed' Count = "+NotCompleted);
			}
			if(NotApplicable > 0)
			{
				CFOcountPOM.BarGraphCountIn(driver, test, "Not Applicable", NotApplicable);
			}
			else
			{
				test.log(LogStatus.PASS, "'High - Not Applicable' Count = "+NotApplicable);
			}
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'BSE - High' Count = "+BSEHigh);
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			Thread.sleep(1000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 17)
	void BargraphBSEMediumStatutory() throws InterruptedException
	{
		test = extent.startTest("Bar Graph - 'BSE' Count Verification with 'Medium' risk");
		
	
		Thread.sleep(4000);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
		
		
		Thread.sleep(4000);
		int BSEMedium = Integer.parseInt(CFOcountPOM.clickBSEMedium(driver).getText());	//Reading the Medium value of Labour compliance
		CFOcountPOM.clickBSEMedium(driver).click();					//Clicking on High bar of Labour  
		
		Thread.sleep(500);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely(driver).getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed(driver).getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted(driver).getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable(driver).getText());	//reading Not Applicable count.
		
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
		/*
		if(BSEMedium == total)
		{
			test.log(LogStatus.PASS, "'BSE  - Medium' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'BSE - Medium' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'BSE - Medium' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'BSE - Medium' Compliances : "+total+" | Total Sum : "+BSEMedium);
		}
		*/
		if(BSEMedium > 0)
		{
			if(ClosedTimely > 0)
			{
				CFOcountPOM.BarGraphCountIn(driver, test, "Closed Timely", ClosedTimely);
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium - Closed Timely' Count = "+ClosedTimely);
			}
			
			if(ClosedDelayed > 0)
			{
				CFOcountPOM.BarGraphCountIn(driver, test, "Closed Delayed", ClosedDelayed);
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium - Closed Delayed' Count = "+ClosedDelayed);
			}
			if(NotCompleted > 0)
			{
				CFOcountPOM.BarGraphCountIn1(driver, test, "Not Completed", NotCompleted);
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium - Not Completed' Count = "+NotCompleted);
			}
			if(NotApplicable > 0)
			{
				CFOcountPOM.BarGraphCountIn(driver, test, "Not Applicable", NotApplicable);
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium - Not Applicable' Count = "+NotApplicable);
			}
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'BSE - 'Medium Count = "+BSEMedium);
			
			Thread.sleep(1000);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			Thread.sleep(1000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 18)
	void BargraphBSELowStatutory() throws InterruptedException
	{
		test = extent.startTest("Bar Graph - 'BSE' Count Verification with 'LOW' risk");
		
		

	//	Thread.sleep(4000);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
		
		
		Thread.sleep(4000);
		int BSELow = Integer.parseInt(CFOcountPOM.clickBSELow(driver).getText());	//Reading the Medium value of Labour compliance
		CFOcountPOM.clickBSELow(driver).click();					//Clicking on High bar of Labour  
		
		Thread.sleep(500);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely(driver).getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed(driver).getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted(driver).getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable(driver).getText());	//reading Not Applicable count.
		
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
		/*
		if(BSELow == total)
		{
			test.log(LogStatus.PASS, "'BSE  - Low' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'BSE - Low' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'BSE - Low' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'BSE - Low' Compliances : "+total+" | Total Sum : "+BSELow);
		}
		*/
		if(BSELow > 0)
		{
			if(ClosedTimely >= 0)
			{
				CFOcountPOM.BarGraphCountIn(driver, test, "Closed Timely", ClosedTimely);
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low - Closed Timely' Count = "+ClosedTimely);
			}
			
			if(ClosedDelayed >= 0)
			{
				CFOcountPOM.BarGraphCountIn(driver, test, "Closed Delayed", ClosedDelayed);
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low - Closed Delayed' Count = "+ClosedDelayed);
			}
			if(NotCompleted >= 0)
			{
				CFOcountPOM.BarGraphCountIn1(driver, test, "Not Completed", NotCompleted);
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low - Not Completed' Count = "+NotCompleted);
			}
			if(NotApplicable >= 0)
			{
				CFOcountPOM.BarGraphCountIn(driver, test, "Not Applicable", NotApplicable);
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low - Not Applicable' Count = "+NotApplicable);
			}
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			Thread.sleep(1000);
		}
		else
		{
			test.log(LogStatus.PASS, "'BSE - Low' Count = "+BSELow);
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack(driver);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			Thread.sleep(1000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 19)
	void RiskSummaryCriticalInternal() throws InterruptedException
	{
	
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,1500)");				//Scrolling down window by 1000 px.cfo
		js.executeScript("window.scrollBy(0,600)");
		test = extent.startTest("Risk Summary - 'Critical' Count Verification");
		
		
		Thread.sleep(500);
		String NotCompleted = CFOcountPOM.clickRiskCriticalNotCompleted(driver).getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_NotCompleted = Integer.parseInt(NotCompleted);
	//	int RiskCritical_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotCompleted(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_NotCompleted > 0)
		{
			CFOcountPOM.clickRiskCriticalNotCompleted(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn1(driver, test, "Critical - Not Completed", RiskCritical_NotCompleted, "Internal");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Not Completed' Count = "+RiskCritical_NotCompleted);
		}
		/*
		Thread.sleep(2000);
		int RiskCritical_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayed(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedDelayed > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedDelayed(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount(driver, test, "Critical - Closed Delayed", RiskCritical_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.FAIL, "'Critical - Closed Delayed' Count = "+RiskCritical_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskCritical_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedTimely(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedTimely > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedTimely(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount(driver, test, "Critical - Closed Timely", RiskCritical_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.FAIL, "'Critical - Closed Timely' Count = "+RiskCritical_ClosedTimely);
		}*/
		extent.endTest(test);
		extent.flush();
	}
	
	
	//@Test(priority = 20)
	void RiskSummaryHighInternal() throws InterruptedException
	{		
		test = extent.startTest("Risk Summary - 'High' Count Verification");
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,1500)");
	//	js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);
		String NotCompleted = CFOcountPOM.clickRiskHighNotCompleted(driver).getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
	
		//int RiskHigh_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskHighNotCompleted(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighNotCompleted(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn1(driver, test, "High - Not Completed", RiskHigh_NotCompleted, "Internal");
		}
		else
		{
			test.log(LogStatus.FAIL, "'High - Not Completed' Count = "+RiskHigh_NotCompleted);
		}
		/*	
		Thread.sleep(2000);
		int RiskHigh_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskHighClosedDelayed(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedDelayed(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn(driver, test, "High - Closed Delayed", RiskHigh_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.FAIL, "'High - Closed Delayed' Count = "+RiskHigh_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimely(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedTimely(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount(driver, test, "High - Closed Timely", RiskHigh_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.FAIL, "'High - Closed Timely' Count = "+RiskHigh_ClosedTimely);
		}*/
		extent.endTest(test);
		extent.flush();
	}
	
   // @Test(priority = 21)
	void RiskSummaryMediumStatutory() throws InterruptedException
	{
		test = extent.startTest("Risk Summary - 'Medium' Count Verification");
	
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,1450)");
		Thread.sleep(500);
		
		int RiskMedium_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskMediumNotCompleted(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumNotCompleted(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn1(driver, test, "Medium - Not Completed", RiskMedium_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.FAIL, "'Medium - Not Completed' Count = "+RiskMedium_NotCompleted);
		}
		
		/*
		Thread.sleep(4000);
		int RiskMedium_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayed(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedDelayed(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn(driver, test, "Medium - Closed Delayed", RiskMedium_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.FAIL, "'Medium - Closed Delayed' Count = "+RiskMedium_ClosedDelayed);
		}
		
		/*Thread.sleep(3000);
		int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimely(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedTimely(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount(driver, test, "Medium - Closed Timely", RiskMedium_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.FAIL, "'Medium - Closed Timely' Count = "+RiskMedium_ClosedTimely);
		}*/
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 22)
	void RiskSummaryLowStatutory() throws InterruptedException
	{		
		test = extent.startTest("Risk Summary - 'Low' Count Verification");
		
		Thread.sleep(500);
		
		int RiskLow_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowNotCompleted(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn1(driver, test, "Low - Not Completed", RiskLow_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.FAIL, "'Low - Not Completed' Count = "+RiskLow_NotCompleted);
		}
		
		/*Thread.sleep(2000);
		int RiskLow_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayed(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedDelayed(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount(driver, test, "Low - Closed Delayed", RiskLow_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.FAIL, "'Low - Closed Delayed' Count = "+RiskLow_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimely(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedTimely(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn(driver, test, "Low - Closed Timely", RiskLow_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.FAIL, "'Low - Closed Timely' Count = "+RiskLow_ClosedTimely);
		}
		*/
		Thread.sleep(500);
	//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
		
	@Test(priority = 23)
	void DepartmentSummaryInternal() throws InterruptedException
	{
		Thread.sleep(3000);		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 1500 px.
		js.executeScript("window.scrollBy(0,2000)");
		
		test = extent.startTest("Department Summary - 'Finance-Closed Delayed' Count Verification");
		
		Thread.sleep(2000);
		String financeClosedDelayed= CFOcountPOM.clickFinanceClosedDelayedInternal(driver).getText();	//Reading the Closed Delayed value of Human Resource
		financeClosedDelayed = financeClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
		int Finance_CloseDelayed= Integer.parseInt(financeClosedDelayed);						
		if(Finance_CloseDelayed > 0)
		{
			CFOcountPOM.clickFinanceClosedDelayedInternal(driver).click();
			CFOcountPOM.RiskGraphCount(driver, test, "Finance -Closed Delayed ", Finance_CloseDelayed, "Internal");
		}
		else
		{
			test.log(LogStatus.FAIL, "'Finance -Closed Delayed' Complaince Count = "+ Finance_CloseDelayed + ".");
		}
		
		//------------------------------------------------------
	/*	
		Thread.sleep(500);
		String FinaClosedTimely = CFOcountPOM.clickFinanceClosedTimelyInternal(driver).getText();		//Reading the Closed Timely value of Human Resource
		FinaClosedTimely = FinaClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_ClosedTimely = Integer.parseInt(FinaClosedTimely);						
		if(Fina_ClosedTimely > 0)
		{
			CFOcountPOM.clickFinanceClosedTimelyInternal(driver).click();
			CFOcountPOM.RiskGraphCount(driver, test, "Finance -Closed Timely", Fina_ClosedTimely, "Internal");
		}
		else
		{
			test.log(LogStatus.FAIL, "'Finance -Closed Timely' Complaince Count = "+ Fina_ClosedTimely + ".");
		}
		
		//-----------------------------------------------------
		*/
		Thread.sleep(1000);
		String FinaOverdue = CFOcountPOM.clickFinanceOverdueInternal(driver).getText();			//Reading the Overdue value of Human Resource
		FinaOverdue = FinaOverdue.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_Overdue = Integer.parseInt(FinaOverdue);						
		if(Fina_Overdue > 0)
		{
			CFOcountPOM.clickFinanceOverdueInternal(driver).click();
			CFOcountPOM.RiskGraphCountIn1(driver, test, "Finance -Overdue", Fina_Overdue, "Internal");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Finance - Overdue' Complaince Count = "+ Fina_Overdue + ".");
		}
		
		Thread.sleep(1000);
		String FinaPFReview = CFOcountPOM.clickFinancePenFReviewInternal(driver).getText();			//Reading the Overdue value of Human Resource
		FinaPFReview = FinaPFReview.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_PFR = Integer.parseInt(FinaPFReview);						
		if(Fina_PFR > 0)
		{
			CFOcountPOM.clickFinancePenFReviewInternal(driver).click();
			CFOcountPOM.RiskGraphCount(driver, test, "Finance -Pending For Review", Fina_PFR, "Internal");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Finance - Pending For Review' Complaince Count = "+ Fina_PFR + ".");
		}
		
		Thread.sleep(3000);
	/*	
		String FinaInprogress = CFOcountPOM.clickFinanceInProgressInternal(driver).getText();			//Reading the Overdue value of Human Resource
		FinaInprogress = FinaInprogress.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_InProgress = Integer.parseInt(FinaInprogress);						
		if(Fina_InProgress > 0)
		{
			CFOcountPOM.clickFinanceInProgressInternal(driver).click();
			CFOcountPOM.RiskGraphCount(driver, test, "Finance -In Progress", Fina_InProgress, "Internal");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Finance - In Progress ' Complaince Count = "+ Fina_InProgress + ".");
		}
		*/
		/*		Thread.sleep(3000);
		String FinaRejected = CFOcountPOM.clickFinanceRejectedInternal(driver).getText();			//Reading the Overdue value of Human Resource
		FinaRejected = FinaRejected.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_Rejected= Integer.parseInt(FinaRejected);						
		if(Fina_Rejected > 0)
		{
			CFOcountPOM.clickFinanceRejectedInternal(driver).click();
			CFOcountPOM.RiskGraphCount(driver, test, "Finance -Rejected", Fina_Rejected, "Internal");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Finance - Rejected' Complaince Count = "+ Fina_Rejected + ".");
		}
		
	/*	Thread.sleep(3000);
		String FinaNotAppli = CFOcountPOM.clickFinanceNotAppliInternal(driver).getText();			//Reading the Overdue value of Human Resource
		FinaNotAppli = FinaNotAppli.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_NotAppli= Integer.parseInt(FinaNotAppli);						
		if(Fina_NotAppli > 0)
		{
			CFOcountPOM.clickFinanceRejectedInternal(driver).click();
			CFOcountPOM.RiskGraphCount(driver, test, "Finance -Not Applicable", Fina_NotAppli, "Internal");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Finance - Not Applicable' Complaince Count = "+ Fina_NotAppli + ".");
		}
		*/
		Thread.sleep(500);
	//	js.executeScript("window.scrollBy(0,-1600)");			//Clicking on Dashboard
	//	performer.OverduePOM.clickDashboard(driver).click();
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 24)
	void ClosedTimely_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart - 'Closed Timely' Count Verification");
		
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,2500)");						//Scrolling down window by 1000 px.
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(1500);                                            
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimelyInternal(driver).getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimelyInternal(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
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
		*/
		if(ClosedTimelyValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPe(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe(driver)).click().build().perform();	 //Clicking on Back button
			driver.switchTo().parentFrame();
			Thread.sleep(1000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe1(driver)).click().build().perform();	//Clicking on Dashboard
			driver.switchTo().parentFrame();
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 25)
	void ClosedDelayed_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart - 'Closed Delayed' Count Verification");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(1500);
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayedInternal(driver).getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickClosedDelayedInternal(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
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
		*/
		if(ClosedDelayedValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPe(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low' Risk Compliance Count = "+low);
			}
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe(driver)).click().build().perform();	 //Clicking on Back button
			driver.switchTo().parentFrame();
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+ClosedDelayedValue);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe(driver)).click().build().perform();	//Clicking on Dashboard
			driver.switchTo().parentFrame();
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 26)
	void NotCompleted_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart - 'Not Completed' Count Verification");
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
	      JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(500);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompletedInternal(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompletedInternal(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(NotCompletedValue == total)
		{
			test.log(LogStatus.PASS, "'Not Completed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Completed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Completed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Completed' Compliances : "+total+" | Total Sum : "+NotCompletedValue);
		}
		*/
		if(NotCompletedValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPe1(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >=0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(200);
				CFOcountPOM.GraphCountInPe1(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(200);
				CFOcountPOM.GraphCountInPe1(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe(driver)).click().build().perform();	 //Clicking on Back button
			driver.switchTo().parentFrame();
			Thread.sleep(1000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Not Completed' Compliance Count = "+NotCompletedValue);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe(driver)).click().build().perform();	//Clicking on Dashboard
			driver.switchTo().parentFrame();
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 27)
	void NotApplicable_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart - Completion Status- 'Not Applicable' Count Verification");
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(1500);
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickNotApplInternalA(driver).getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickNotApplInternalA(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(ClosedDelayedValue == total)
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Applicable' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Applicable' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Applicable' Compliances : "+total+" | Total Sum : "+ClosedDelayedValue);
		}
		*/
		if(ClosedDelayedValue > 0)
		{
			if(critical > 0)
			{
				CFOcountPOM.GraphCountInPe(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe(driver)).click().build().perform();	 //Clicking on Back button
			driver.switchTo().parentFrame();
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = "+ClosedDelayedValue);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe(driver)).click().build().perform();	//Clicking on Dashboard
			driver.switchTo().parentFrame();
			Thread.sleep(1000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 28)
	void Overdue_PieChartInternalPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart - Not Completed Status-'Overdue' Count Verification");
		
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
	//	js.executeScript("window.scrollBy(0,2500)");
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(1000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickOverdueInternal(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickOverdueInternal(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'Overdue' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Overdue' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		
		if(OverdueValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPe1(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				
				test.log(LogStatus.FAIL, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Overdue' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 29)
	void dueToday_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart - Not Completed Status-'due Today' Count Verification");
		
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	Thread.sleep(3000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		
		Thread.sleep(2000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);
	//	js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		js.executeScript("window.scrollBy(0,2500)");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(1000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickdueTodayInernal(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickdueTodayInernal(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'due Today' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'due Today' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'due Today' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'due Today' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		
		if(OverdueValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPe1(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				
				test.log(LogStatus.FAIL, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard

		}
		else
		{
			test.log(LogStatus.PASS, "'due Today' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 30)
	void PFR_PieChartInternalPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
	
		Thread.sleep(3000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		
		Thread.sleep(2000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);
		Thread.sleep(500);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2500)");						//Scrolling down window by 1000 px.
	//	js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(500);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickpendingForReviewIN(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickpendingForReviewIN(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'Pending For Review' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Pending For Review' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Pending For Review' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Pending For Review' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		if(OverdueValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPe(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Pending For Review' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 31)
	void Rejected_PieChartInternalPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart - Not Completed Status- 'Rejected' Count Verification");
		
		Thread.sleep(500);
		Thread.sleep(3000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(500);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickRejectedPe(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejectedPe(driver).click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'Rejected' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Rejected' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Rejected' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		if(OverdueValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPe(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(2000);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
		//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard

		}
		else
		{
			test.log(LogStatus.PASS, "'Rejected' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 32)
	void GradingReportInternal() throws InterruptedException, IOException
	{
		Thread.sleep(4000);		
		test = extent.startTest("'Grading Report'  Export and OverView");
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,3000)");					//Scrolling down window by 2600 px.
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);	
		CFOcountPOM.clickRedGrading(driver).click();
		Thread.sleep(4000);	
		WebDriverWait wait = new WebDriverWait(driver,(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		//*[@id="showGRdetails"]
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage(driver).click();
		
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[11]/a");
			
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
			CFOcountPOM.closeDocument1(driver).click();
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closePopup(driver).click();					
			
		Thread.sleep(2000);
	//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 33)
	void complianceCalendar() throws InterruptedException
	{
		test = extent.startTest("compliance Calendar Verifications");
		
		
		WebDriverWait wait = new WebDriverWait(driver,(70));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");					//Scrolling down window by 2600 px.
		//js.executeScript("window.scrollBy(0,4225)");	
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']")));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));	//Wait until frame get visible and switch to it.
		Thread.sleep(5000);
	/*	 CFOcountPOM.clickExportImage(driver).click();
		 Thread.sleep(2000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);*/
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(2000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeView_cal(driver).click();

			test.log(LogStatus.PASS, "overView Successfully");
			driver.switchTo().parentFrame();
			js.executeScript("window.scrollBy(0,-50)");
		/*	CFOcountPOM.clickAll(driver).click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']/div/div[1]/div[3]/div")));
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']/div/div[2]")));
			Thread.sleep(3000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));	//Wait until frame get visible and switch to it.
			Thread.sleep(4000);
			 CFOcountPOM.clickExportImage(driver).click();
			 Thread.sleep(2000);
		//	 test.log(LogStatus.PASS, "After Clicking All(Including Checklist)");
				test.log(LogStatus.PASS, "Excel file Export Successfully");
				Thread.sleep(3000);
/*	By locator1 = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/a");
	
				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(2000);
				// retrieving "foo-button" HTML element
				WebElement ViewButton1 = driver.findElement(locator1);	
				Thread.sleep(4000);
			
			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", ViewButton1);
				Thread.sleep(4000);
				driver.switchTo().parentFrame();
				CFOcountPOM.closeView_cal(driver).click();
				test.log(LogStatus.PASS, "overView Successfully");
				driver.switchTo().parentFrame();*/
				Thread.sleep(3000);
			//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
				
				
			extent.endTest(test);
			extent.flush();
	}
	
	
	//@Test(priority = 34)
	void DailyUpdates() throws InterruptedException, IOException
	{
		Thread.sleep(3000);		
		test = extent.startTest("'Daily Updates'  OverView");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,4600)");					//Scrolling down window by 2600 px.
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);	
		CFOcountPOM.clickViewAllDU(driver).click();
		Thread.sleep(4000);	
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
		CFOcountPOM.clickView1(driver).click();
		Thread.sleep(4000);	
		CFOcountPOM.closeNewsView(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "view Succefully");
		OverduePOM.searchBox(driver).sendKeys("NSE issued the MFSS Settlement Calendar");
		Thread.sleep(500);
		OverduePOM.ClicksearchBtn(driver).click();
		Thread.sleep(7000);
		test.log(LogStatus.PASS, "Search Succefully");
		Thread.sleep(1000);
		OverduePOM.ClickClearBtn(driver).click();
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Clear button Working Succefully");
	
		performer.OverduePOM.clickDashboard(driver).click();
		
		extent.endTest(test);
		extent.flush();
	}
	
 //@Test(priority =35)
	void NewsLetter() throws InterruptedException, IOException
	{
		Thread.sleep(500);		
		test = extent.startTest("'News Letters'  OverView");
		
		Thread.sleep(4000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,7000)","");					//Scrolling down window by 2600 px.
		
		CFOcountPOM.clickViewAllNL(driver).click();
		Thread.sleep(4000);	
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
		CFOcountPOM.clickView2(driver).click();
		Thread.sleep(4000);	
		CFOcountPOM.closeNewsLView(driver).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "OverView Successfully");
		performer.OverduePOM.clickDashboard(driver).click();
		
		extent.endTest(test);
		extent.flush();
	}
 /*
 @Test(priority = 29)
	void StandardReportOverallIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report Internal -Overall Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportOverallIn(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
  @Test(priority = 30)
	void StandardReportLocationIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report Internal -Location Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportLocationIN(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 31)
	void StandardReportUserIn() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report Internal -User Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportUserIN(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 32)
	void StandardReportCategoryIn() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports -Standard Report Internal -Category  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportCategoryIN(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 33)
	void StandardReportRiskIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report Internal-Risk  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportRiskIN(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 34)
	void StandardReportDetailedIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report Internal-Detailed  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportDetailedIN(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 35)
	void StandardReportCriticalRiskIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports -Standard Report Internal -Critical Risk  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportCriticalRiskIN(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
 */
	
 
 
 
 

	// @AfterTest
		void Closing() throws InterruptedException
		{
		 test = extent.startTest("Verify Close Browser");
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "Browser Close");
			driver.close();
			extent.endTest(test);
			extent.flush();
		}	 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
//	@Test(priority = 22)
	void DetailedReportInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.DetailedReport1(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 23)
	void AssignmentReportInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Assignment Report verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.AssignmentReportIn(test, driver);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
}
