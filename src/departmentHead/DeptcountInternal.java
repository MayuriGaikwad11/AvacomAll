package departmentHead;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import auditor.AuditorcountPOM;
import cfo.CFOcountPOM;
import performer.OverduePOM;

public class DeptcountInternal {

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
	
	public static String link = "Department";			//Check link in excel sheet first.
	
	public static XSSFSheet ReadExcel() throws IOException
	{
		fis = new FileInputStream("C:\\Users\\Mayuri\\Desktop\\Compliance\\AvacomAll\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(7);					//Retrieving third sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws Exception
	{
		
		extent = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\Mayuri\\Desktop\\Compliance\\AvacomAll\\Reports\\Department(Internal).html",true);
		test = extent.startTest("Verify OpenBrowser");
		test.log(LogStatus.PASS, "Browser test is initiated");
		
		XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 1)
	void Login() throws InterruptedException, IOException
	{
		test = extent.startTest("Loging In - Department Head (Internal)");
		test.log(LogStatus.PASS, "Logging into system");
		
		XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
		Thread.sleep(700);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		Thread.sleep(3000);
		DeptCountPOM.SelectYear(driver).click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll(driver).click();
		Thread.sleep(3000);
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(1000);
		
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
	void  FilterWiseDepartmentCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count Match Filter Wise by Clicking on 'Depatment' - Compliances");
		test.log(LogStatus.INFO, "Test Initiated");
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String string_Categories =CFOcountPOM.clickCategories(driver).getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
		CFOcountPOM.clickCategories(driver).click();
		Thread.sleep(500);
		
		litigationPerformer.MethodsPOM.progress(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, (140));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[3]/td[4]/div")));
		Thread.sleep(3000);
		CFOcountPOM.SelectLocation(driver).click();
		Thread.sleep(3000);
		CFOcountPOM.ClickIocon(driver).click();
		CFOcountPOM.ClickABCMall(driver).click();
		Thread.sleep(4000);
		WebElement CompCat=	driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[4]/div"));
		int	value = Integer.parseInt(CompCat.getText());
		Thread.sleep(1000);
		CompCat.click();
		Thread.sleep(500);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));	//Wait until frame get visible and switch to it.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-grid-content k-auto-scrollable']")));
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,3000)");				//Scrolling down window by 2000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD(driver).click();
		
		Thread.sleep(1000);
		String item = CFOcountPOM.readTotalItemsD(driver).getText();
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount1 = bits[bits.length - 2];				//Getting the second last word (total number of users)
		
	int	count1 = Integer.parseInt(compliancesCount1);
		
		
		if(value == count1)
		{
			test.log(LogStatus.PASS, "Compliances count matches. Clicked value = " + value+ ", Grid Records = "+count1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Compliances count does not matches. Clicked value = "+value+", Grid Records = "+count1);
		}
		
		driver.switchTo().parentFrame();	//Switching back to parent frame.
		Thread.sleep(500);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", CFOcountPOM.closeCategories_Compliances(driver));
	//	CFOcountPOM.closeCategories_Compliances(driver).click();		//Closing the 'Compliances' pup up.
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ClearfilterMain']")).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Clear Button is working");
		js.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
			
		Thread.sleep(4000);
		CFOcountPOM.closeCategories(driver).click();
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
		
	
//	@Test(priority = 2)
	void clickCategoriesInternal() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Department'");
		
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String string_Categories =CFOcountPOM.clickCategories(driver).getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
		CFOcountPOM.clickCategories(driver).click();
		Thread.sleep(6000);
		
		litigationPerformer.MethodsPOM.progress(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,(70));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[3]/td[4]/div")));
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD(driver).click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD(driver).getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		/*
		elementsList1 = CFOcountPOM.readCompliancesList(driver);
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
	
		
		elementsList1 = CFOcountPOM.readUserList1(driver);
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
			String[] bits2 = item2.split(" ");								//Splitting the String
			String userCount2 = bits2[bits2.length - 2];				//Getting the second last word (total number of users)
			
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
			test.log(LogStatus.PASS, "No of Department in the grid = "+CatcountGrid+" | Dashboard Department  Count = "+CategoriesCountDas);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "Number of Categories does not matches to Dashboard Categories  Count.");
			test.log(LogStatus.FAIL, "No of Department in the grid = "+CatcountGrid+" | Dashboard Department  Count = "+CategoriesCountDas);
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
	
	
//	@Test(priority = 3)
	void ClickCompliancesInternal() throws InterruptedException
	{
		test = extent.startTest("'Complainces' Count by Clicking on 'Compliances'");
		
		Thread.sleep(1500);
		WebDriverWait wait1 = new WebDriverWait(driver, (30));
		wait1.until(ExpectedConditions.visibilityOf(CFOcountPOM.readCompliancesInternal(driver)));
		int valueCompliances = Integer.parseInt(CFOcountPOM.readCompliancesInternal(driver).getText());	//Storing value of 'Compliances' as a String to compare.
		
		driver.findElement(By.xpath("(//*[@class = 'titleMD'])[4]")).click();
		//CFOcountPOM.readCompliancesInternal(driver).click();					//Clicking on 'Compliances'.
		
		Thread.sleep(4000);
		litigationPerformer.MethodsPOM.progress(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, (10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
		
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage(driver).click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
	/*	CFOcountPOM.clickLocationIn(driver).click();
		Thread.sleep(500);
		CFOcountPOM.clickExpand1(driver).click();
		Thread.sleep(500);
		CFOcountPOM.clickAR(driver).click();
		Thread.sleep(2000);
		CFOcountPOM.clickClear(driver).click();
		Thread.sleep(2000);*/
		test.log(LogStatus.PASS, "Clear Button is working");
		
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
		Thread.sleep(3000);
		CFOcountPOM.closeCategories(driver).click();					//Closing the 'Compliance' window.
		Thread.sleep(3000);
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
		
		
		Thread.sleep(500);
		if(OverduePOM.closeMessage(driver).isDisplayed())				//If Compliance Updation message popped up,
		{
			OverduePOM.closeMessage(driver).click();					//then close the message.
		}
		
		Thread.sleep(1500);
		int valueUsers = Integer.parseInt(CFOcountPOM.clickUsersCount(driver).getText());	//Storing value of 'Users' as a String to compare.
		Thread.sleep(500);
		CFOcountPOM.clickUsersCount(driver).click();					//Clicking on 'Users'. 
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		Thread.sleep(2000);
		CFOcountPOM.clickExportImage(driver).click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD(driver).click();
		
		String getCount = CFOcountPOM.readTotalItemsD(driver).getText();	//Storing no of Items 'Users' count as string.
		String[] bits = getCount.split(" ");							//Splitting the String
		String usersCount = bits[bits.length - 2];						//Getting the second last word (total number of users)
		if(usersCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2500);
			getCount = CFOcountPOM.readTotalItemsD(driver).getText();
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
		
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
	
		Thread.sleep(3000);
		if(CFOcountPOM.ClickShowAllIn(driver).isEnabled()) {
			CFOcountPOM.ClickShowAllIn(driver).click();        //Clicking on Show All
			Thread.sleep(3000);
			test.log(LogStatus.PASS, " 'Show All ' link Clickable Successfully");
			}
		litigationPerformer.MethodsPOM.progress(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	WebElement farme=	driver.findElement(By.xpath("//*[@id='showdetails']"));
      driver.switchTo().frame(farme);
      Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
		 Thread.sleep(3000); 
		 js.executeScript("window.scrollBy(0,550)");	
		 Thread.sleep(2000);
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[10]/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButtons = driver.findElement(locator);							
			ViewButtons.click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument(driver).click();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			CFOcountPOM.closeCategories(driver).click();
			Thread.sleep(3000);
		extent.endTest(test);
		extent.flush();			
		
	}
	
//	@Test(priority = 6)
	void ClosedTimely_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - 'Closed Timely' Count Verification");
	
		Actions action = new Actions(driver);
		
		Thread.sleep(3000);
		DeptCountPOM.SelectYear(driver).click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll(driver).click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply(driver).click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2500);
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
		}*/
		
		if(ClosedTimelyValue > 0)
		{
			if(critical >= 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(3000);
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
		test = extent.startTest("Pie Chart - 'Closed Delayed' Count Verification");
		
		Actions action = new Actions(driver);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
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
		}*/
		
		if(ClosedDelayedValue > 0)
		{
			if(critical >= 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+ClosedDelayedValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	}
	
	
	//@Test(priority = 8)
	void NotCompleted_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - 'Not Completed' Count Verification");
		
		Thread.sleep(3000);
		Actions action = new Actions(driver);
	   //  JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(500);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompletedInternalA(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompletedInternalA(driver).click();									//CLicking on 'Not Completed' count
		
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
				DeptCountPOM.GraphCountIn(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				DeptCountPOM.GraphCountIn(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				DeptCountPOM.GraphCountIn(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				DeptCountPOM.GraphCountIn(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
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
		test = extent.startTest("Pie Chart - 'Not Applicable' Count Verification");
		
		Actions action = new Actions(driver);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickNotApplicableInternal(driver).getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickNotApplicableInternal(driver).click();								//CLicking on 'Not Completed' count
		
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
		}*/
		
		if(ClosedDelayedValue > 0)
		{
			if(critical >= 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = "+ClosedDelayedValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	}
	
	
		
	//@Test(priority = 10)
	void Overdue_PieChartInternal() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - 'Overdue' Count Verification");
		
		Thread.sleep(1000);
		Actions action = new Actions(driver);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
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
				DeptCountPOM.GraphCountIn(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				DeptCountPOM.GraphCountIn(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				DeptCountPOM.GraphCountIn(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				DeptCountPOM.GraphCountIn(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Overdue' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 11)
	void PFR_PieChartInternal() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - Not Completed Status- 'Pending For Review' Count Verification");
		
		Thread.sleep(4000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		Thread.sleep(3000);
		DeptCountPOM.SelectYear(driver).click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll(driver).click();
		Thread.sleep(3000);
		
		Thread.sleep(2000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);
		Thread.sleep(500);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickpendingForReviewIND(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickpendingForReviewIND(driver).click();									//CLicking on 'Not Completed' count
		
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
			if(critical > 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
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
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 12)
	void inProgress_PieChartInternal() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - Not Completed Status- 'In Progress' Count Verification");
		
		Thread.sleep(4000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		Thread.sleep(3000);
		DeptCountPOM.SelectYear(driver).click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll(driver).click();
		Thread.sleep(3000);
		
		Thread.sleep(2000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);
		Thread.sleep(500);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickInProgressDept(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickInProgressDept(driver).click();									//CLicking on 'Not Completed' count
		
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
			if(critical > 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
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
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
	
//	@Test(priority = 12)
	void Rejected_PieChartInternal() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - Not Completed Status- ' Rejected' Count Verification");
		
		Thread.sleep(500);
		Thread.sleep(2000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		Thread.sleep(3000);
		DeptCountPOM.SelectYear(driver).click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll(driver).click();
		Thread.sleep(3000);
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(500);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickRejectedIn(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejectedIn(driver).click();									//CLicking on 'Not Completed' count
		
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
		}*/
		
		if(OverdueValue > 0)
		{
			if(critical > 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCountIn1(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
		performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Rejected' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
		//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13)
	void DepartmentSummaryInternal() throws InterruptedException
	{
		Thread.sleep(500);		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 1500 px.
	js.executeScript("window.scrollBy(0,1000)");
		
		test = extent.startTest("Department Summary - 'Account' Count Verification");
		
		Thread.sleep(500);
		String financeClosedDelayed= CFOcountPOM.clickAccountClosedDelayedInternal(driver).getText();	//Reading the Closed Delayed value of Human Resource
		financeClosedDelayed = financeClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
		int Finance_CloseDelayed= Integer.parseInt(financeClosedDelayed);						
		if(Finance_CloseDelayed > 0)
		{
			CFOcountPOM.clickAccountClosedDelayedInternal(driver).click();
			DeptCountPOM.RiskGraphCountIn(driver, test, "Account -Closed Delayed ", Finance_CloseDelayed, "Internal");
		}
		else
		{
			test.log(LogStatus.PASS, "'Account -Closed Delayed' Complaince Count = "+ Finance_CloseDelayed + ".");
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
			CFOcountPOM.RiskGraphCount(driver, test, "Account -Closed Timely", Fina_ClosedTimely, "Internal");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Account -Closed Timely' Complaince Count = "+ Fina_ClosedTimely + ".");
		}
		
		//-----------------------------------------------------
		*/
		Thread.sleep(500);
		String FinaOverdue = CFOcountPOM.clickAccountOverdueInternalD(driver).getText();			//Reading the Overdue value of Human Resource
		FinaOverdue = FinaOverdue.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_Overdue = Integer.parseInt(FinaOverdue);						
		if(Fina_Overdue > 0)
		{
			CFOcountPOM.clickAccountOverdueInternalD(driver).click();
			DeptCountPOM.RiskGraphCount1In(driver, test, "Account -Overdue", Fina_Overdue, "Internal");
		}
		else
		{
			test.log(LogStatus.PASS, "'Account - Overdue' Complaince Count = "+ Fina_Overdue + ".");
		}
		
		Thread.sleep(500);
		String FinaPFReview = CFOcountPOM.clickAccountPenFReviewInternalD(driver).getText();			//Reading the Overdue value of Human Resource
		FinaPFReview = FinaPFReview.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_PFR = Integer.parseInt(FinaPFReview);						
		if(Fina_PFR > 0)
		{
			CFOcountPOM.clickAccountPenFReviewInternalD(driver).click();
			DeptCountPOM.RiskGraphCountIn(driver, test, "Account -Pending For Review", Fina_PFR, "Internal");
		}
		else
		{
			test.log(LogStatus.PASS, "'Account - Pending For Review' Complaince Count = "+ Fina_PFR + ".");
		}
		
		Thread.sleep(3000);
	/*	
		String FinaInprogress = CFOcountPOM.clickFinanceInProgressInternal(driver).getText();			//Reading the Overdue value of Human Resource
		FinaInprogress = FinaInprogress.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_InProgress = Integer.parseInt(FinaInprogress);						
		if(Fina_InProgress > 0)
		{
			CFOcountPOM.clickFinanceInProgressInternal(driver).click();
			CFOcountPOM.RiskGraphCount(driver, test, "Account -In Progress", Fina_InProgress, "Internal");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Account - In Progress ' Complaince Count = "+ Fina_InProgress + ".");
		}
		
		Thread.sleep(3000);
		String FinaRejected = CFOcountPOM.clickFinanceRejectedInternal(driver).getText();			//Reading the Overdue value of Human Resource
		FinaRejected = FinaRejected.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_Rejected= Integer.parseInt(FinaRejected);						
		if(Fina_Rejected > 0)
		{
			CFOcountPOM.clickFinanceRejectedInternal(driver).click();
			CFOcountPOM.RiskGraphCount(driver, test, "Account -Rejected", Fina_Rejected, "Internal");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Account - Rejected' Complaince Count = "+ Fina_Rejected + ".");
		}
		
	/*	Thread.sleep(3000);
		String FinaNotAppli = CFOcountPOM.clickFinanceNotAppliInternal(driver).getText();			//Reading the Overdue value of Human Resource
		FinaNotAppli = FinaNotAppli.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_NotAppli= Integer.parseInt(FinaNotAppli);						
		if(Fina_NotAppli > 0)
		{
			CFOcountPOM.clickFinanceRejectedInternal(driver).click();
			CFOcountPOM.RiskGraphCount(driver, test, "Account -Not Applicable", Fina_NotAppli, "Internal");
		}
		else
		{
			test.log(LogStatus.SKIP, "'Account - Not Applicable' Complaince Count = "+ Fina_NotAppli + ".");
		}
		*/
		Thread.sleep(3000);
	//	js.executeScript("window.scrollBy(0,-1600)");			//Clicking on Dashboard
	//	performer.OverduePOM.clickDashboard(driver).click();
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 14)
	void RiskSummaryHighInternal() throws InterruptedException
	{		
		test = extent.startTest("Risk Summary - 'High' Count Verification");
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,1500)");
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);
		String NotCompleted = CFOcountPOM.clickRiskHighNotCompletedDIn(driver).getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
	
		//int RiskHigh_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskHighNotCompleted(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighNotCompletedDIn(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			DeptCountPOM.RiskGraphCount1In(driver, test, "High - Not Completed", RiskHigh_NotCompleted, "Internal");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Not Completed' Count = "+RiskHigh_NotCompleted);
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
		int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimelyIN(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedTimelyIN(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			DeptCountPOM.RiskGraphCountIn(driver, test, "High - Closed Timely", RiskHigh_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Closed Timely' Count = "+RiskHigh_ClosedTimely);
		}*/
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15)
	void RiskSummaryMediumInternal() throws InterruptedException
	{		
		test = extent.startTest("Risk Summary - 'Medium' Count Verification");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,1500)");
	//	js.executeScript("window.scrollBy(0,1400)");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskMediumNotCompletedDIn(driver).getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
	
		//int RiskHigh_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskHighNotCompleted(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumNotCompletedDIn(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			DeptCountPOM.RiskGraphCount1In(driver, test, "Medium - Not Completed", RiskHigh_NotCompleted, "Internal");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Not Completed' Count = "+RiskHigh_NotCompleted);
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
		int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimelyIN(driver).getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedTimelyIN(driver).click();			//Clicking on Not Completed compliances bar of High risk.  
			
			DeptCountPOM.RiskGraphCountIn(driver, test, "High - Closed Timely", RiskHigh_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Closed Timely' Count = "+RiskHigh_ClosedTimely);
		}*/
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 16)
	void ClosedTimely_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Timely' Count Verification");
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");						//Scrolling down window by 1000 px.
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(3000);
		AuditorcountPOM.DateText(driver).click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear(driver).click();	
		Thread.sleep(1000);
		AuditorcountPOM.Year(driver).click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth(driver).click();	
		Thread.sleep(1000);
		AuditorcountPOM.Month(driver).click();	
		Thread.sleep(3000);
		AuditorcountPOM.Date(driver).click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply(driver).click();	
		Thread.sleep(5000);
		
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimelyInternalP(driver).getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimelyInternalP(driver).click();								//CLicking on 'Not Completed' count
		
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
				DeptCountPOM.GraphCountInPe3(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe3(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe3(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe3(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(1000);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	
	}
	
	@Test(priority = 17)
	void ClosedDelayed_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		Thread.sleep(3000);
		Actions action = new Actions(driver);
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,2500)");						//Scrolling down window by 1000 px.
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(3000);
		
		Thread.sleep(1500);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedDelayedInternal(driver).getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedDelayedInternal(driver).click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(ClosedTimelyValue == total)
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Closed Delayed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Closed Delayed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Closed Delayed' Compliances : "+total+" | Total Sum : "+ClosedTimelyValue);
		}
		*/
		if(ClosedTimelyValue > 0)
		{
			if(critical >= 0)
			{
				DeptCountPOM.GraphCountInPe3(driver, test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe3(driver, test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe3(driver, test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe3(driver, test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(3000);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
			Thread.sleep(3000);
			driver.switchTo().parentFrame();
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+ClosedTimelyValue);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
		
	}
	
	@Test(priority = 18)
	void NotCompleted_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart - 'Not Completed' Count Verification");
	
		Thread.sleep(500);
		Thread.sleep(3000);
	/*	Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		
		Thread.sleep(2000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);*/
		Actions action = new Actions(driver);
	   //   JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,1600)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(500);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompletedInternalA(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompletedInternalA(driver).click();									//CLicking on 'Not Completed' count
		
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
			if(critical > 0)
			{
				DeptCountPOM.GraphCountInPe2(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(200);
				DeptCountPOM.GraphCountInPe2(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(200);
				DeptCountPOM.GraphCountInPe2(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(200);
				DeptCountPOM.GraphCountInPe2(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe(driver)).click().build().perform();	 //Clicking on Back button
			driver.switchTo().parentFrame();
			Thread.sleep(2000);
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
	
	@Test(priority = 19)
		void NotApplicable_PieChartPeriod() throws InterruptedException
		{
			test = extent.startTest("Period-Pie Chart -Completion Status- 'Not Applicable' Count Verification");
			
			
			Actions action = new Actions(driver);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
		//	js.executeScript("window.scrollBy(0,2500)");						//Scrolling down window by 1000 px.
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, (30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(3000);
			try{
			Thread.sleep(1500);
			int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickNotApplicableInternal(driver).getText());	//Reading value of 'After Due Date'
			CFOcountPOM.clickNotApplicableInternal(driver).click();								//CLicking on 'Not Completed' count
			
			Thread.sleep(500);
			int critical = Integer.parseInt(CFOcountPOM.readCritical(driver).getText());	//Reading Critical risk count.
			int high = Integer.parseInt(CFOcountPOM.readHigh(driver).getText());		//reading High risk count.
			int medium = Integer.parseInt(CFOcountPOM.readMedium(driver).getText());	//reading Medium risk count.
			int low = Integer.parseInt(CFOcountPOM.readLow(driver).getText());			//reading Low risk count.
			
			int total = critical + high + medium + low;
			/*
			if(ClosedTimelyValue == total)
			{
				test.log(LogStatus.PASS, "'Not Applicable' Compliance Count matches to sum of all risked compliances.");
				test.log(LogStatus.INFO, "Total 'Not Applicable' Compliances : "+total);
			}
			else
			{
				test.log(LogStatus.FAIL, "'Not Applicable' Compliance Count doesn't matches to sum of all risked compliances.");
				test.log(LogStatus.INFO, "Total 'Not Applicable' Compliances : "+total+" | Total Sum : "+ClosedTimelyValue);
			}
			*/
			if(ClosedTimelyValue > 0)
			{
				if(critical >= 0)
				{
					DeptCountPOM.GraphCountInPe3(driver, test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3(driver, test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium > 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3(driver, test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3(driver, test, "Low", low, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
				}
				Thread.sleep(3000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	 //Clicking on Back button
				driver.switchTo().parentFrame();
				Thread.sleep(3000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = "+ClosedTimelyValue);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1(driver)).click().build().perform();	//Clicking on Dashboard
			}
			extent.endTest(test);
			extent.flush();
			}catch(NumberFormatException ex){
				ex.printStackTrace();
			}
		}
		
	
	@Test(priority = 20)
	void Overdue_PieChartInternalPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart - 'Overdue' Count Verification");
		
		Thread.sleep(500);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
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
			test.log(LogStatus.PASS, "Total 'Not Completed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Overdue' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Completed' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		if(OverdueValue > 0)
		{
			if(critical > 0)
			{
				DeptCountPOM.GraphCountInPe2(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe2(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe2(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe2(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(4000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Overdue' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 21)
	void PFR_PieChartInternalPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart - 'PFR' Count Verification");
	
		Thread.sleep(6000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		
		Thread.sleep(2000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);
		Thread.sleep(500);
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2600)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(500);
		Thread.sleep(3000);
		AuditorcountPOM.DateText(driver).click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear(driver).click();	
		Thread.sleep(1000);
		AuditorcountPOM.Year(driver).click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth(driver).click();	
		Thread.sleep(1000);
		AuditorcountPOM.Month(driver).click();	
		Thread.sleep(3000);
		AuditorcountPOM.Date(driver).click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply(driver).click();	
		Thread.sleep(5000);
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
			test.log(LogStatus.PASS, "'Overdue' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Completed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Overdue' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Completed' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		if(OverdueValue > 0)
		{
			if(critical > 0)
			{
				DeptCountPOM.GraphCountInPe3(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCountInPe3(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountInPe3(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCountInPe3(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(8000);
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
	
	@Test(priority = 22)
	void Rejected_PieChartInternalPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart - 'Rejected' Count Verification");
	
		Thread.sleep(8000);
		Thread.sleep(2000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply(driver).click();
		Thread.sleep(4000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(500);
		Thread.sleep(3000);
		AuditorcountPOM.DateText(driver).click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear(driver).click();	
		Thread.sleep(1000);
		AuditorcountPOM.Year(driver).click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth(driver).click();	
		Thread.sleep(1000);
		AuditorcountPOM.Month(driver).click();	
		Thread.sleep(3000);
		AuditorcountPOM.Date(driver).click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply(driver).click();	
		Thread.sleep(5000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickRejectedPe1(driver).getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejectedPe1(driver).click();									//CLicking on 'Not Completed' count
		
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
			test.log(LogStatus.PASS, "Total 'Not Completed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Overdue' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Completed' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		if(OverdueValue > 0)
		{
			if(critical > 0)
			{
				DeptCountPOM.GraphCountInPe3(driver, test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCountInPe3(driver, test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountInPe3(driver, test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCountInPe3(driver, test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2(driver)).click().build().perform();	 //Clicking on Back button
		//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard

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
	
	@Test(priority = 23)
	void GradingReportInternal() throws InterruptedException, IOException
	{
		Thread.sleep(3000);		
		test = extent.startTest("'Grading Report'  Export and OverView");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,3100)");					//Scrolling down window by 2600 px.
	js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);	
		CFOcountPOM.clickRedGrading(driver).click();
		Thread.sleep(4000);	
		WebDriverWait wait = new WebDriverWait(driver, (180));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[12]/a");

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
			Thread.sleep(4000);
			 CFOcountPOM.clickExportImage(driver).click();
			
				test.log(LogStatus.PASS, "Excel file Export Successfully");
				Thread.sleep(3000);
			driver.switchTo().parentFrame();
			CFOcountPOM.closeCategories(driver).click();					
			
		Thread.sleep(1000);
	//	performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 24)
	void DailyUpdatesInternal() throws InterruptedException, IOException
	{
		Thread.sleep(500);		
		test = extent.startTest("'Daily Updates'  OverView");
	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,4600)");					//Scrolling down window by 2600 px.
		js.executeScript("window.scrollBy(0,1700)");
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
		Thread.sleep(4000);
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 25)
	void NewsLetterInternal() throws InterruptedException, IOException
	{
		Thread.sleep(500);		
		test = extent.startTest("'News Letters'  OverView");
		
		Thread.sleep(3000);
		Select drp = new Select(CFOcountPOM.selectInternal(driver));
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply(driver).click();
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,10000)","");					//Scrolling down window by 2600 px.
		
		CFOcountPOM.clickViewAllNL(driver).click();
		
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
	
	
	
	
	
	
}
