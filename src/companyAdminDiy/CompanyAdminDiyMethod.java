package companyAdminDiy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import companyadmin.CompanyPOM;
import implementation.ImplementPOM;

public class CompanyAdminDiyMethod {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	public static void SwitchtoChild( WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Thread.sleep(3000);
		CompanyPOM.clickAdmin(driver).click();
		Set w = driver.getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	      
	      sheet = workbook.getSheetAt(21); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
			int row = 0;
			Thread.sleep(500);
			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
			Cell c1 = null;
			row0 = sheet.getRow(3);
			c1 = row0.getCell(1);
			String URL1 = c1.getStringCellValue();

			driver.get(URL1);
			Thread.sleep(1000);
	      
	  
	}
	
	public static void SwitchtoParent( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Thread.sleep(3000);
		
		Set w = driver.getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      driver.close();
	      Thread.sleep(3000);
	      driver.switchTo().window(pw);         // switching child window
	      
	    
	  
	}

	public static void User( WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		SwitchtoChild(driver,test,workbook);
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a")));	//Wait until records table get visible.
//-------------------------------Statutory Assignment Report-------------------------------
	      action.moveToElement(CompanyAdminDiyLocator.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
	      CompanyAdminDiyLocator.Users(driver).click();
	      		  	 Thread.sleep(2000);
	      		   CompanyAdminDiyLocator.ModifyAssignmentsLink(driver).click();
	      		  	 Thread.sleep(2000);
	      		  	if(CompanyAdminDiyLocator.DepartmentDropdown(driver).isDisplayed()) {
	      				
	      				test.log(LogStatus.PASS, " Department Dropdown is Displayed  ");
	      				
	      			}else {
	      				test.log(LogStatus.FAIL, " Department Dropdown is not Displayed  ");
	      			}
	      			
	      			JavascriptExecutor js = (JavascriptExecutor) driver;
	      			js.executeScript("window.scrollBy(0,500)");	
	      			Thread.sleep(4000);
	      			
	      			CompanyAdminDiyLocator.ModifyAssignmentsClose(driver).click();
	      			Thread.sleep(4000);
	      			SwitchtoParent(driver,test);
	}

	
	public static void ModifyAssignments( WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		SwitchtoChild(driver,test,workbook);
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a")));	//Wait until records table get visible.
//-------------------------------Statutory Assignment Report-------------------------------
	      action.moveToElement(CompanyAdminDiyLocator.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
	      CompanyAdminDiyLocator.ModifyAssignments(driver).click();
	      		  	 Thread.sleep(2000);
	      		  
	      		  	if(CompanyAdminDiyLocator.DepartmentDropdownMA(driver).isDisplayed()) {
	      				
	      				test.log(LogStatus.PASS, " Department Dropdown is Displayed  ");
	      				
	      			}else {
	      				test.log(LogStatus.FAIL, " Department Dropdown is not Displayed  ");
	      			}
	      			
	      			
	      			Thread.sleep(4000);
	      			
	      			
	      			SwitchtoParent(driver,test);
	}
	
	public static void ReopeningofCompliance( WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		SwitchtoChild(driver,test,workbook);
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a")));	//Wait until records table get visible.

	      action.moveToElement(CompanyAdminDiyLocator.ManageCompliances(driver)).click().build().perform();
	      Thread.sleep(1000);
	      CompanyAdminDiyLocator.ReopeningofCompliance(driver).click();
	      		  	 Thread.sleep(2000);
	      		  	CompanyAdminDiyLocator.ReopeninCheckBox(driver).click();
	      		  	 Thread.sleep(2000);
	      			CompanyAdminDiyLocator.ReopeninSave(driver).click();
	      		  	 Thread.sleep(2000);  
	      		  	 
	      		  	 driver.switchTo().alert().accept();
	      		   Thread.sleep(1000);  
	      	String Msg=	 driver.switchTo().alert().getText();
	      	 driver.switchTo().alert().accept();
	      	test.log(LogStatus.PASS, Msg);
	      	Thread.sleep(4000);
  			
  			
  			SwitchtoParent(driver,test);
	}

	
}
