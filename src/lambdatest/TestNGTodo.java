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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestNGTodo {
	public static WebDriver driver1 = null;	
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;	
	 public String username = "mayuritlregtech";
	    public String accesskey = "i48C6wJResBKSYZkyfFojFicJxAgYKVckIpCsNBOi100Hxe34Q";
	    public static RemoteWebDriver driver = null;
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
	    
		
	    @Test
	    public void testSimple() throws Exception {
	       try {//Change it to production page
	            driver.get("https://lambdatest.github.io/sample-todo-app/");
	              //Let's mark done first two items in the list.
	              driver.findElement(By.name("li1")).click();
	            driver.findElement(By.name("li2")).click();
	             // Let's add an item in the list.
	              driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
	            driver.findElement(By.id("addbutton")).click();
	              // Let's check that the item we added is added in the list.
	            String enteredText = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText();
	            if (enteredText.equals("Yey, Let's add it to list")) {
	                status = true;
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    @AfterClass
	    public void tearDown() throws Exception {
	       if (driver != null) {
	            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
	            driver.quit();
	        }
	    }
	    
}
