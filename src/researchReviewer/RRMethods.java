package researchReviewer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import implementation.ImplementPOM;

public class RRMethods {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	
	public static void MinistryMaster( WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
//-------------------------------Ministry Master - Add New-------------------------------
	      action.moveToElement(RRLocators.clickManageCompliance(driver)).click().build().perform();
	      Thread.sleep(1000);
	      RRLocators.MinistryMaster(driver).click();
	      		  	 Thread.sleep(2000);
	      		  	RRLocators.MinistryMasterAddNew(driver).click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	sheet = workbook.getSheetAt(22); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	      			int row = 0;
	      			Thread.sleep(500);
	      			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	      			Cell c1 = null;
	      			row0 = sheet.getRow(4);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.MinistryName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		 	RRLocators.Save(driver).click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	String saveMsg = RRLocators.SaveMsg(driver).getText();

	      			if (saveMsg.equalsIgnoreCase("Ministry saved successfully")) {
	      				test.log(LogStatus.PASS, "Message displayed -" + saveMsg);
	      			} else {
	      				test.log(LogStatus.FAIL, "Message displayed -" + saveMsg );
	      			}
	      			RRLocators.Close(driver).click();

	      		//-------------------------------Ministry Master -Check Dublication-------------------------------
	      	      
	      	      		  	 Thread.sleep(2000);
	      	      		  	RRLocators.MinistryMasterAddNew(driver).click();
	      	      		  	 Thread.sleep(2000);
	      	      		  	 
	      	      		  
	      	      			row0 = sheet.getRow(5);
	      	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	      			RRLocators.MinistryName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
	      	      			Thread.sleep(4000);
	      	      		 	RRLocators.Save(driver).click();
	      	      		  	 Thread.sleep(2000);
	      	      		  	 
	      	      		  	String saveMsg1 = RRLocators.SaveMsg(driver).getText();

	      	      			
	      	      				test.log(LogStatus.PASS, " Check Dublication Validation Message displayed - " + saveMsg1);
	      	      			
	      	      			RRLocators.Close(driver).click();

	      	      		//-------------------------------Ministry Master -Edit-------------------------------
	      		  	 
	      	      		row0 = sheet.getRow(4);
	      	  		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	  	RRLocators.Filter(driver).sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
	      	  		Thread.sleep(4000);
	      	  	RRLocators.ClickEdit(driver).click();
	      	  Thread.sleep(1000);
	      	  	RRLocators.MinistryName(driver).clear();
	      	  	row0 = sheet.getRow(6);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.MinistryName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		 	RRLocators.Save(driver).click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	String saveMsg2 = RRLocators.SaveMsg(driver).getText();

	      			
	      				test.log(LogStatus.PASS, "  Message displayed -" + saveMsg2);
	      			
	      			RRLocators.Close(driver).click();
	      			 Thread.sleep(2000);
	      		//-------------------------------Ministry Master -Delete-------------------------------
	      			RRLocators.Filter(driver).clear();
	      			 Thread.sleep(2000);
	      			row0 = sheet.getRow(6);
	      	  		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	  	RRLocators.Filter(driver).sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
	      	  		Thread.sleep(4000);
	      			RRLocators.DeleteMinistryDetails(driver).click();
	      			 Thread.sleep(2000);
	      			String DeleteMsg = driver.switchTo().alert().getText();
	      			Thread.sleep(2000);
	      			driver.switchTo().alert().accept();
	      			Thread.sleep(2000);
	      			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg);
	}

	public static void RegulatorMaster( WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
//-------------------------------Regulator Master - Add New-------------------------------
	      action.moveToElement(RRLocators.clickManageCompliance(driver)).click().build().perform();
	      Thread.sleep(1000);
	      RRLocators.RegulatorMaster(driver).click();
	      		  	 Thread.sleep(2000);
	      		  	RRLocators.MinistryMasterAddNew(driver).click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	sheet = workbook.getSheetAt(22); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	      			int row = 0;
	      			Thread.sleep(500);
	      			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	      			Cell c1 = null;
	      			row0 = sheet.getRow(8);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.RegulatorName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		 	RRLocators.Save(driver).click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	String saveMsg = RRLocators.SaveMsg(driver).getText();

	      			if (saveMsg.equalsIgnoreCase("Regulator saved successfully")) {
	      				test.log(LogStatus.PASS, "Message displayed -" + saveMsg);
	      			} else {
	      				test.log(LogStatus.FAIL, "Message displayed -" + saveMsg );
	      			}
	      			RRLocators.Close(driver).click();

	      		//-------------------------------Regulator Master -Check Dublication-------------------------------
	      	      
	      	      		  	 Thread.sleep(2000);
	      	      		  	RRLocators.MinistryMasterAddNew(driver).click();
	      	      		  	 Thread.sleep(2000);
	      	      		  	 
	      	      		  
	      	      			row0 = sheet.getRow(9);
	      	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	      			RRLocators.RegulatorName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
	      	      			Thread.sleep(4000);
	      	      		 	RRLocators.Save(driver).click();
	      	      		  	 Thread.sleep(2000);
	      	      		  	 
	      	      		  	String saveMsg1 = RRLocators.SaveMsg(driver).getText();

	      	      			
	      	      				test.log(LogStatus.PASS, " Check Dublication Validation Message displayed - " + saveMsg1);
	      	      			
	      	      			RRLocators.Close(driver).click();

	      	      		//-------------------------------Regulator Master -Edit-------------------------------
	      		  	 
	      	      		row0 = sheet.getRow(8);
	      	  		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	  	RRLocators.Filter(driver).sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
	      	  		Thread.sleep(4000);
	      	  	RRLocators.ClickEdit(driver).click();
	      	  Thread.sleep(1000);
	      	  	RRLocators.RegulatorName(driver).clear();
	      	  	row0 = sheet.getRow(10);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.RegulatorName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		 	RRLocators.Save(driver).click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	String saveMsg2 = RRLocators.SaveMsg(driver).getText();

	      			
	      				test.log(LogStatus.PASS, "  Message displayed -" + saveMsg2);
	      			
	      			RRLocators.Close(driver).click();
	      			 Thread.sleep(2000);
	      		//-------------------------------Ministry Master -Delete-------------------------------
	      			RRLocators.Filter(driver).clear();
	      			 Thread.sleep(2000);
	      			row0 = sheet.getRow(10);
	      	  		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	  	RRLocators.Filter(driver).sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
	      	  		Thread.sleep(4000);
	      			RRLocators.DeleteMinistryDetails(driver).click();
	      			 Thread.sleep(2000);
	      			String DeleteMsg = driver.switchTo().alert().getText();
	      			Thread.sleep(2000);
	      			driver.switchTo().alert().accept();
	      			Thread.sleep(2000);
	      			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg);
	}

	public static void ActDepartmentMaster( WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
//-------------------------------Department Master - Add New-------------------------------
	      action.moveToElement(RRLocators.clickManageCompliance(driver)).click().build().perform();
	      Thread.sleep(1000);
	      RRLocators.ActDepartmentMaster(driver).click();
	      		  	 Thread.sleep(2000);
	      		  	RRLocators.MinistryMasterAddNew(driver).click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	sheet = workbook.getSheetAt(22); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	      			int row = 0;
	      			Thread.sleep(500);
	      			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	      			Cell c1 = null;
	      			row0 = sheet.getRow(12);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.MinistryName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		 	RRLocators.Save(driver).click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	String saveMsg = RRLocators.SaveMsg(driver).getText();

	      			if (saveMsg.equalsIgnoreCase("Department saved successfully")) {
	      				test.log(LogStatus.PASS, "Message displayed -" + saveMsg);
	      			} else {
	      				test.log(LogStatus.FAIL, "Message displayed -" + saveMsg );
	      			}
	      			RRLocators.Close(driver).click();

	      		//-------------------------------Department Master -Check Dublication-------------------------------
	      	      
	      	      		  	 Thread.sleep(2000);
	      	      		  	RRLocators.MinistryMasterAddNew(driver).click();
	      	      		  	 Thread.sleep(2000);
	      	      		  	 
	      	      		  
	      	      			row0 = sheet.getRow(13);
	      	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	      			RRLocators.MinistryName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
	      	      			Thread.sleep(4000);
	      	      		 	RRLocators.Save(driver).click();
	      	      		  	 Thread.sleep(2000);
	      	      		  	 
	      	      		  	String saveMsg1 = RRLocators.SaveMsg(driver).getText();

	      	      			
	      	      				test.log(LogStatus.PASS, " Check Dublication Validation Message displayed - " + saveMsg1);
	      	      			
	      	      			RRLocators.Close(driver).click();

	      	      		//-------------------------------Department Master -Edit-------------------------------
	      		  	 
	      	      		row0 = sheet.getRow(12);
	      	  		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	  	RRLocators.Filter(driver).sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
	      	  		Thread.sleep(4000);
	      	  	RRLocators.ClickEdit(driver).click();
	      	  Thread.sleep(1000);
	      	  	RRLocators.MinistryName(driver).clear();
	      	  	row0 = sheet.getRow(14);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.MinistryName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		 	RRLocators.Save(driver).click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	String saveMsg2 = RRLocators.SaveMsg(driver).getText();

	      			
	      				test.log(LogStatus.PASS, "  Message displayed -" + saveMsg2);
	      			
	      			RRLocators.Close(driver).click();
	      			 Thread.sleep(2000);
	      		//-------------------------------Department Master -Delete-------------------------------
	      			RRLocators.Filter(driver).clear();
	      			 Thread.sleep(2000);
	      			row0 = sheet.getRow(14);
	      	  		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	  	RRLocators.Filter(driver).sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
	      	  		Thread.sleep(4000);
	      			RRLocators.DeleteMinistryDetails(driver).click();
	      			 Thread.sleep(2000);
	      			String DeleteMsg = driver.switchTo().alert().getText();
	      			Thread.sleep(2000);
	      			driver.switchTo().alert().accept();
	      			Thread.sleep(2000);
	      			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg);
	}

	public static void ActAddNew( WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
//------------------------------- Add New-------------------------------
	      action.moveToElement(RRLocators.clickManageCompliance(driver)).click().build().perform();
	      Thread.sleep(1000);
	      RRLocators.Act(driver).click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.ActAddNew(driver).click();
	      		  	 Thread.sleep(3000);
	      		  	 
	      		  	sheet = workbook.getSheetAt(22); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	      			int row = 0;
	      			Thread.sleep(500);
	      			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	      			Cell c1 = null;
	      			row0 = sheet.getRow(16);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.Name(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		  RRLocators.Actgroup(driver).click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.ActDemo(driver).click();
	      		  	 Thread.sleep(3000);
	      		  	row0 = sheet.getRow(17);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.ActApplicabilityRules(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      			row0 = sheet.getRow(18);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.ShortForm(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		  RRLocators.CompanyType(driver).click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.SelectAll(driver).click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.Ok(driver).click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.BusinessActivity(driver).click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.SelectAllBA(driver).click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.OkBA(driver).click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.ActApplicability(driver).click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.SelectAllAA(driver).click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.OkAA(driver).click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.Type(driver).click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.Central(driver).click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.Category(driver).click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.ClientSpecific(driver).click();
	      		  	 Thread.sleep(3000);
	      		  	
	      			RRLocators.StartDate(driver).sendKeys("23-03-2023"); // Writing Task title
	      			Thread.sleep(4000);
	      			 RRLocators.Industry(driver).click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.Agriculture(driver).click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.AgricultureOk(driver).click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.ActDocumentType(driver).click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.ActRule(driver).click();
	      		  	 Thread.sleep(4000);
	      		  	RRLocators.File(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\Report  (2).xlsx"); // Writing Task title
	      			Thread.sleep(4000);
	      		  RRLocators.SaveAct(driver).click();
	      		  	 Thread.sleep(1000);
	      		String Msg =   RRLocators.SaveActMsg(driver).getText();
	      		  	 Thread.sleep(3000);
	      		  	test.log(LogStatus.PASS, "Message displayed -" + Msg);
	      		  RRLocators.CloseAct(driver).click();
	      		  	 Thread.sleep(1000);
	}
	
	
	public static void Actupdate( WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
//------------------------------- Add New-------------------------------
	      action.moveToElement(RRLocators.clickManageCompliance(driver)).click().build().perform();
	      Thread.sleep(1000);
	      RRLocators.Act(driver).click();
	      		  	 Thread.sleep(3000);
	      			sheet = workbook.getSheetAt(22); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	      			int row = 0;
	      			Thread.sleep(500);
	      			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	      			Cell c1 = null;
	      			row0 = sheet.getRow(16);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.FilterAct(driver).sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
	      			Thread.sleep(4000);
	      			
	      			 RRLocators.ActEdit(driver).click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.Country(driver).click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.CountryIndia(driver).click();
	      		  	
	      		   Thread.sleep(3000);
	      		   RRLocators.ActDocumentType(driver).click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.ActRule(driver).click();
	      		  	 Thread.sleep(4000);
	      		   RRLocators.SaveAct(driver).click();
	      		  	 Thread.sleep(1000);
	      		String Msg =   RRLocators.SaveActMsg(driver).getText();
	      		  	 Thread.sleep(3000);
	      		  	test.log(LogStatus.PASS, "Message displayed -" + Msg);
	      		  	
	      		  File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	      		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

	      		Thread.sleep(500);
	      		RRLocators.ClickDownload(driver).click(); // Exporting (Downloading) file

	      		Thread.sleep(3000);// C://Users//jiya//Downloads//
	      		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	      		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
	      		Thread.sleep(3000);
	      		if (dirContents.length < allFilesNew.length) {
	      			test.log(LogStatus.PASS, "  File downloaded successfully.");
	      		} else {
	      			test.log(LogStatus.FAIL,  "  File does not downloaded.");
	      		}
	      		  	
	      		  RRLocators.CloseAct(driver).click();
	      		  	 Thread.sleep(1000);
	}
	
	
	public static void ActDelete( WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
//------------------------------- Delete-------------------------------
	      action.moveToElement(RRLocators.clickManageCompliance(driver)).click().build().perform();
	      Thread.sleep(1000);
	      RRLocators.Act(driver).click();
	      		  	 Thread.sleep(3000);
	      			sheet = workbook.getSheetAt(22); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	      			int row = 0;
	      			Thread.sleep(500);
	      			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	      			Cell c1 = null;
	      			row0 = sheet.getRow(16);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.FilterAct(driver).sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
	      			Thread.sleep(4000);
	      			
	      			 RRLocators.ActDelete(driver).click();
	      		  	 Thread.sleep(3000);
	      		String Mag=  driver.switchTo().alert().getText();
	      		test.log(LogStatus.PASS, "Message displayed -" + Mag);
	      		 driver.switchTo().alert().accept();
	      		 Thread.sleep(3000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
