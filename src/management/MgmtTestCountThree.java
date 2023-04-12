package management;

import java.io.File;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import performer.MethodsPOM;
import performer.OverduePOM;

public class MgmtTestCountThree {

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
	
	public static XSSFSheet ReadExcel() throws IOException
	{
		//String workingDir = System.getProperty("webdriver.chrome.driver","C:/March2022/PerformerPom/Driver/chromedriver.exe");
		fis = new FileInputStream("C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(15);					//Retrieving third sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
	//	String workingDir = System.getProperty("webdriver.chrome.driver","C:/March2022/PerformerPom/Driver/chromedriver.exe");
		extent = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\Reports\\LitigationPerformer.html",true);
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
	void StandardReportOverall() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report -Overall Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportOverall(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void StandardReportLocation() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report -Location Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportLocation(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 4)
	void StandardReportUser() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report -User Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportUser(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5)
	void StandardReportCategory() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report -Category  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportCategory(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6)
	void StandardReportRisk() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report -Risk  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportRisk(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 7)
	void StandardReportDetailed() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report -Detailed  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportDetailed(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void StandardReportCriticalRisk() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report -Critical Risk  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportCriticalRisk(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	/*
	@Test(priority = 9)
	void StandardReportOverallIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report Internal -Overall Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportOverallIn(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
     @Test(priority = 10)
	void StandardReportLocationIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report Internal -Location Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportLocationIN(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 11)
	void StandardReportUserIn() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report Internal -User Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportUserIN(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 12)
	void StandardReportCategoryIn() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports -Standard Report Internal -Category  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportCategoryIN(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13)
	void StandardReportRiskIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report Internal-Risk  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportRiskIN(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 14)
	void StandardReportDetailedIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report Internal-Detailed  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportDetailedIN(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15)
	void StandardReportCriticalRiskIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports -Standard Report Internal -Critical Risk  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportCriticalRiskIN(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	*/
	@Test(priority = 16)
	void DetailedReport() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Detailed Report Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.DetailedReport1(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17) 
	void DetailedReportIn() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Detailed Report -Internal Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.DetailedReportIn(test, driver, "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 18)
	void AssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Assignment Report verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.AssignmentReport(test, driver);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 19)
	void UsageReport() throws InterruptedException
	{
		test = extent.startTest("My Reports - Usage Report verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(1000);
		CFOcountPOM.clickReports(driver).click();				//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickUsageReport(driver).click();			//Clicking on 'Usage Reports'
		
		Thread.sleep(5000);
		CFOcountPOM.clickStartDate(driver).click();				//CLicking on Start Date input box
		Thread.sleep(3000);
		performer.OverduePOM.selectDate(driver).click();		//Method to click on date at second row and fourth column
		Thread.sleep(1000);
		Thread.sleep(500);
		CFOcountPOM.clickEndDate(driver).click();				//CLicking on Start Date input box
		Thread.sleep(4000);
		performer.OverduePOM.selectDate(driver).click();		//Method to click on date at second row and fourth column
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles();					//Counting number of files in directory before download
		
		Thread.sleep(500);
		CFOcountPOM.clickExport(driver).click();				//CLicking on 'Export to Excel' button
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents1 = dir1.listFiles();					//Counting number of files in directory after download
		
		if(dirContents.length < dirContents1.length)
		{
			test.log(LogStatus.PASS, "File downloaded successfully.");	
		}
		else
		{
			test.log(LogStatus.FAIL, "File does not downloaded.");
		}
		
		Thread.sleep(500);
		performer.OverduePOM.clickDashboard(driver).click();
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 20)
	void AuditReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Audit Report verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.AuditReport(test, driver);
		
		extent.endTest(test);
		extent.flush();
	}
		
	@Test(priority = 20)
	void ActRepository() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Act Repository  verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.ActRepository(test,driver);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 21)
	void ComplianceDocuments() throws InterruptedException, IOException
	{
		test = extent.startTest("My Documents - Compliance Documents  verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.ComplianceDocuments(test,driver);
		
				extent.endTest(test);
				extent.flush();
	}
	
//	@Test(priority = 22)
	void ComplianceDocumentsIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Documents - Compliance Documents-Internal  verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.complianceDocumentIn(test,driver);
		
				extent.endTest(test);
				extent.flush();
	}

	@Test(priority = 23) //	pass	
	void CriticalDocuments() throws InterruptedException, IOException
	{
		test = extent.startTest("My Documents Critical Document Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		OverduePOM.CriticalDocuments(driver, test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 24)
	void ActDocuments() throws InterruptedException, IOException
	{
		test = extent.startTest("My Documents -Act Documents  verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.ActDocuments(test,driver);
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 25) // pass
	void MyReminderStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder - Statutory Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		OverduePOM.MyReminder(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}

	
//	@Test(priority = 26) // pass
	void MyEscalation() throws InterruptedException, IOException
	{
		test = extent.startTest("My  Escalation - Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		WebDriverWait wait = new WebDriverWait(driver,(30));
		CFOcountPOM.clickMyEscalation(driver).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));	//Wait till records table gets visible
		Thread.sleep(1000);
		List<WebElement> CheckBox=	driver.findElements(By.xpath("//*[@class='k-checkbox-label k-no-text']"));
	CheckBox.get(2).click();
	Thread.sleep(500);
	List<WebElement> Actions=	driver.findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[13]/a"));
	Actions.get(5).click();
	Thread.sleep(4000);//*[@id="grid"]/div[3]/table/tbody/tr[1]/td[13]/a
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	performer.OverduePOM.clickDashboard(driver).click();
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 27) // pass
	void MyNotifications() throws InterruptedException, IOException
	{
		test = extent.startTest("My Notifications - Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		WebDriverWait wait = new WebDriverWait(driver, (30));
		Thread.sleep(8000);
		CFOcountPOM.clickMyNotifications(driver).click();
		Thread.sleep(4000);
		CFOcountPOM.clickViewBtnNO(driver).click();
		Thread.sleep(4000);
		CFOcountPOM.CloseViewNO(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "View Successfully");	
		driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_GridNotifications_chkCompliances_0']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_GridNotifications_chkCompliances_1']")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2100 px.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnMarkasRead']")).click();
		test.log(LogStatus.PASS, "Read Successfully");	
		Thread.sleep(1000);
		performer.OverduePOM.clickDashboard(driver).click();
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 28) // pass
	void MessageCenter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Message Center - Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		WebDriverWait wait = new WebDriverWait(driver, (30));
		Thread.sleep(8000);
		CFOcountPOM.clickMessageCenter(driver).click();
		Thread.sleep(4000);
		CFOcountPOM.clickViewMsg(driver).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "View Button is clickable");
		Thread.sleep(1000);
		performer.OverduePOM.clickDashboard(driver).click();
		extent.endTest(test);
		extent.flush();
	}
	
    @Test(priority = 29)
		void InternalMsg() throws InterruptedException, IOException
		{
			Thread.sleep(500);		
			test = extent.startTest("'Internal Msg  '  Verification");
			test.log(LogStatus.PASS, "Test Initiated");
				Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, (40));
			Thread.sleep(500);
			OverduePOM.ClickInternalMsg(driver).click();
			Thread.sleep(4000);
			OverduePOM.ClickTo(driver).sendKeys("mayuri@tlregtech.in");
			Thread.sleep(500);
			OverduePOM.ClickSub(driver).sendKeys("Automation");
			Thread.sleep(1000);
			OverduePOM.TypeMsg(driver).sendKeys("Automation testing");
			Thread.sleep(1000);
			OverduePOM.choosefile(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\Report .xlsx");
			Thread.sleep(1000);
			//OverduePOM.send(driver).click();
			By locator = By.xpath("//*[@id='btnsendmailNew']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Internal Message working Succefully");
			Thread.sleep(1000);
			extent.endTest(test);
			extent.flush();
		}
		
		 @Test(priority = 30)
			void SupportTicket() throws InterruptedException, IOException
			{
				Thread.sleep(1000);		
				test = extent.startTest("'Support Ticket  '  Verification");
				test.log(LogStatus.PASS, "Test Initiated");
				
				MethodsPOM.SupportTicket(test,driver);
				
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
