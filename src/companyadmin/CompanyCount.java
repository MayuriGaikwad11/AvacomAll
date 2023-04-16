package companyadmin;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
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

public class CompanyCount {

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
	
	
	public static String link = "compayAdmin";  
	
	public static XSSFSheet ReadExcel() throws IOException
	{
		fis = new FileInputStream("C:\\Users\\trainee\\Desktop\\Compliances\\ComplianceAll\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(12);					//Retrieving third sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\trainee\\Desktop\\Compliances\\ComplianceAll\\Reports\\CFOResultsStatotory.html",true);
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
		test = extent.startTest("Loging In - Company Admin");
		test.log(LogStatus.PASS, "Logging into system");
		
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
		WebDriverWait wait = new WebDriverWait(driver, (30));
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id='imgcaldate']"))));
		}
		catch(Exception e)
		{
			
		}
	}
	
//	@Test(priority = 2)
	void Reports() throws InterruptedException, IOException
	{
		test = extent.startTest("Reports");
		
		
		CompanyMethods.Reports(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 3)
	void EventAssignments() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event Assignments");
		
		
		CompanyMethods.EventAssignments(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 4)
	void Eventassignmentexportimport() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event ");
		
		
		CompanyMethods.Eventassignmentexportimport(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 5)
	void EventassignmentexportimportValidation() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event ");
		
		
		CompanyMethods.EventassignmentexportimportValidation(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 6)
	void ImportBlankScript() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event -Import");
		
		
		CompanyMethods.ImportBlankScript(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 7)
	void ImportInvalidSheet() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event -Import");
		
		
		CompanyMethods.ImportInvalidSheet(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 8)
	void ImportValidSheet() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event -Import");
		
		
		CompanyMethods.ImportValidSheet(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 9)
	void UploadedFileisplay() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event -Import");
		
		
		CompanyMethods.UploadedFileisplay(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
/*	
	@Test(priority = 10)
	void UploadedFileisplayEC() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event Compliance ");
		
		
		CompanyMethods.UploadedFileisplayEC(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 11)
	void DownloadEC() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event Compliance ");
		
		
		CompanyMethods.DownloadEC(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 12)
	void InValidSheet() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event Compliance ");
		
		
		CompanyMethods.InValidSheet(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13)
	void ValidSheetEC() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event Compliance ");
		
		
		CompanyMethods.ValidSheetEC(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 14)
	void ValidationEC() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event Compliance ");
		
		
		CompanyMethods.ValidationEC(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	*/
	//@Test(priority = 15)
	void Department() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Department ");
		
		
		CompanyMethods.Department(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 16)
	void User() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - User - Add New  ");
		
		
		CompanyMethods.User(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 17)
	void BlockScheduleStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Block Schedule Statutory  ");
		
		
		CompanyMethods.BlockScheduleStatutory(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 18)
	void BlockScheduleInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Block Schedule Internal  ");
		
		
		CompanyMethods.BlockScheduleInternal(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	// @AfterTest
		void Closing() throws InterruptedException
		{
			Thread.sleep(1000);
			driver.close();
		}	 
	
	
	
	
	
}
