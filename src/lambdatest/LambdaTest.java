package lambdatest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LambdaTest {

	
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;	
	 public String username = "mayuritlregtech";
	    public String accesskey = "i48C6wJResBKSYZkyfFojFicJxAgYKVckIpCsNBOi100Hxe34Q";
	    public static WebDriver driver = null;
	    public String gridURL = "@hub.lambdatest.com/wd/hub";
	    boolean status = false;
	    public static String link = "mgmt";  
	    
	    public static XSSFSheet ReadExcel() throws IOException
		{
			fis = new FileInputStream("C:/March2022/PerformerPom/TestData/ComplianceSheet.xlsx");
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(11);					//Retrieving third sheet of Workbook
			return sheet;
		}
	    
	    @BeforeClass
	    public void setUp() throws Exception {
	       DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("browserName", "chrome");
	        capabilities.setCapability("version", "70.0");
	        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
	        capabilities.setCapability("build", "LambdaTest");
	        capabilities.setCapability("name", "LambdaTestJavaSample");
	        try {
	            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
	        } catch (MalformedURLException e) {
	            System.out.println("Invalid grid URL");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	  
		
		@Test(priority = 1)
		void Login() throws InterruptedException, IOException
		{
			
			extent = new com.relevantcodes.extentreports.ExtentReports("C:/March2022/PerformerPom/Reports/CFOResultsStatotory.html",true);
			test = extent.startTest("Verify OpenBrowser");
			test.log(LogStatus.INFO, "Browser test is initiated");
			
			XSSFSheet sheet = ReadExcel();
			Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
			Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
			
			login.Login.BrowserSetup(URL);	
			
			
		//	XSSFSheet sheet = ReadExcel();
			Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
			Cell c2 = row1.getCell(1);						//Selected cell (1 row,1 column)
			String uname = c2.getStringCellValue();			//Got the URL stored at position 1,1
			
			Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
			Cell c3 = row2.getCell(1);						//Selected cell (2 row,1 column)
			String password = c3.getStringCellValue();		//Got the URL stored at position 2,1
			
			driver= login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
			
				
			test.log(LogStatus.PASS, "Test Passed.");
			extent.endTest(test);
			extent.flush();
		}
		
	    
	   
	  
		 @AfterClass
		    public void tearDown() throws Exception {
		       if (driver != null) {
		          //  ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
		            driver.quit();
		        }
		    }
		
	    
	    
	
}
