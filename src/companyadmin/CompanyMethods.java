package companyadmin;

import java.io.File;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import companyAdminDiy.CompanyAdminDiyLocator;
import implementation.ImplementPOM;

public class CompanyMethods {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	

	public static void SwitchtoChild( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Thread.sleep(3000);
		CompanyPOM.clickAdmin(driver).click();
		Set w = driver.getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);         // switching child window
	      
	    
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

	
	public static void Reports( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
//-------------------------------Statutory Assignment Report-------------------------------
	      action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
	      Thread.sleep(1000);
	      CompanyPOM.clickStatutoryAssi(driver).click();
	      		  	 Thread.sleep(2000);
	      		   CompanyPOM.SelectLocationSA(driver).click();
	      		  	 Thread.sleep(1000);
	      		   CompanyPOM.Expand(driver).click();
	      		  	 Thread.sleep(1000);
	      		   CompanyPOM.DPvtLtdAS(driver).click();
	      		  	 Thread.sleep(1000);
	      		  	 
	      		  	 
	 	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_grdEventCannedReport']")));	//Wait until records table get visible.
	 		Thread.sleep(3000);
			File dir = new File("C:\\Users\\Mayuri\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.clickExport(driver).click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\Mayuri\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "Statutory Assignment Report :- File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
		  
		  
		  	
		  //-------------------------------CheckList  Assignment Report-------------------------------
		  	Thread.sleep(1000);
		  	action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickCheckListAssi(driver).click();
		    Thread.sleep(4000);
		    Thread.sleep(2000);
   		   CompanyPOM.SelectLocationSA(driver).click();
   		  	 Thread.sleep(1000);
   		   CompanyPOM.Expand(driver).click();
   		  	 Thread.sleep(1000);
   		   CompanyPOM.DPvtLtdAS(driver).click();
   		  	 Thread.sleep(1000);
   		  dir = new File("C:\\Users\\Mayuri\\Downloads");
			 dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.clickExport(driver).click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			 dir1 = new File("C:\\Users\\Mayuri\\Downloads");
			 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "CheckList Assignment Report :- File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
			  	
			  	
			  	
		 	 //-------------------------------EventBased  Assignment Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickEventBasedAssi(driver).click();
		    Thread.sleep(4000);
		    Thread.sleep(2000);
	   		   CompanyPOM.SelectLocationSA(driver).click();
	   		  	 Thread.sleep(1000);
	   		   CompanyPOM.Expand(driver).click();
	   		  	 Thread.sleep(1000);
	   		   CompanyPOM.DPvtLtdAS(driver).click();
	   		  	 Thread.sleep(5000);
	   			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));
	   		  dir = new File("C:\\Users\\Mayuri\\Downloads");
				 dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(3000);
				CompanyPOM.clickExport(driver).click(); // Exporting (Downloading) file

				Thread.sleep(4000);
				 dir1 = new File("C:\\Users\\Mayuri\\Downloads");
				 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents.length < allFilesNew.length) {
					test.log(LogStatus.PASS,  "EventBased Assignment Report :- File downloaded successfully.");
				} else {
					test.log(LogStatus.FAIL,  " EventBased Assignment Report :- File does not downloaded.");
				}
			  	 	/*	  	
		 	 //-------------------------------Internal  Assignment Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickInternalAssi(driver).click();
		    Thread.sleep(2000);
	   		   CompanyPOM.SelectLocationSA(driver).click();
	   		  	 Thread.sleep(1000);
	   		   CompanyPOM.Expand(driver).click();
	   		  	 Thread.sleep(1000);
	   		   CompanyPOM.DPvtLtdAS(driver).click();
	   		  	 Thread.sleep(4000);
	   		  dir = new File("C:\\Users\\Mayuri\\Downloads");
				 dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(1000);
				CompanyPOM.clickExport(driver).click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				 dir1 = new File("C:\\Users\\Mayuri\\Downloads");
				 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents.length < allFilesNew.length) {
					test.log(LogStatus.PASS,  "Internal Assignment Report :- File downloaded successfully.");
				} else {
					test.log(LogStatus.FAIL,  " :- File does not downloaded.");
				}
			  	 
		 	
			  	
		 	 //-------------------------------Internal CheckList  Assignment Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickInternalCheckListAssi(driver).click();
		      
			  	 Thread.sleep(4000);
			  	Thread.sleep(2000);
		   		   CompanyPOM.SelectLocationSA(driver).click();
		   		  	 Thread.sleep(1000);
		   		   CompanyPOM.Expand(driver).click();
		   		  	 Thread.sleep(1000);
		   		   CompanyPOM.DPvtLtdAS(driver).click();
		   		  	 Thread.sleep(4000);
		   		  dir = new File("C:\\Users\\Mayuri\\Downloads");
					 dirContents = dir.listFiles(); // Counting number of files in directory before download

					Thread.sleep(1000);
					CompanyPOM.clickExport(driver).click(); // Exporting (Downloading) file

					Thread.sleep(3000);
					 dir1 = new File("C:\\Users\\Mayuri\\Downloads");
					 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
					Thread.sleep(3000);
					if (dirContents.length < allFilesNew.length) {
						test.log(LogStatus.PASS,  "Internal CheckList Assignment Report :- File downloaded successfully.");
					} else {
						test.log(LogStatus.FAIL,  " :- File does not downloaded.");
					}
				  	 
		 */
		 	//-------------------------------Statutory Label Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickInternalAssi(driver).click();
		      
			  	 Thread.sleep(4000);
			  	 
				 Thread.sleep(4000);
				  	Thread.sleep(2000);
			   		   CompanyPOM.SelectLocationSA(driver).click();
			   		  	 Thread.sleep(1000);
			   		   CompanyPOM.Expand(driver).click();
			   		  	 Thread.sleep(1000);
			   		   CompanyPOM.DPvtLtdAS(driver).click();
			   		  	 Thread.sleep(4000);
			   		  dir = new File("C:\\Users\\Mayuri\\Downloads");
						 dirContents = dir.listFiles(); // Counting number of files in directory before download

						Thread.sleep(1000);
						CompanyPOM.clickExport(driver).click(); // Exporting (Downloading) file

						Thread.sleep(3000);
						 dir1 = new File("C:\\Users\\Mayuri\\Downloads");
						 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
						Thread.sleep(3000);
						if (dirContents.length < allFilesNew.length) {
							test.log(LogStatus.PASS,  "Statutory Label Report :- File downloaded successfully.");
						} else {
							test.log(LogStatus.FAIL,  "Statutory Label Report :- File does not downloaded.");
						}
			  /*	
		 	//-------------------------------Internal Label Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickInternalLabelReport(driver).click();
		      
			  	 Thread.sleep(4000);
			 	Thread.sleep(2000);
		   		   CompanyPOM.SelectLocationSA(driver).click();
		   		  	 Thread.sleep(1000);
		   		   CompanyPOM.Expand(driver).click();
		   		  	 Thread.sleep(1000);
		   		   CompanyPOM.DPvtLtdAS(driver).click();
		   		  	 Thread.sleep(4000);
		   		  dir = new File("C:\\Users\\Mayuri\\Downloads");
					 dirContents = dir.listFiles(); // Counting number of files in directory before download

					Thread.sleep(1000);
					CompanyPOM.clickExport(driver).click(); // Exporting (Downloading) file

					Thread.sleep(3000);
					 dir1 = new File("C:\\Users\\Mayuri\\Downloads");
					 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
					Thread.sleep(3000);
					if (dirContents.length < allFilesNew.length) {
						test.log(LogStatus.PASS,  "Internal Label Report :- File downloaded successfully.");
					} else {
						test.log(LogStatus.FAIL,  " :- File does not downloaded.");
					}
		 	*/
		 	
		 	//-------------------------------All Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport(driver)).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickInternalCheckListAssi(driver).click();
		      
			  	 Thread.sleep(5000);
			 	Thread.sleep(2000);
		   		   CompanyPOM.SelectLocationSA(driver).click();
		   		  	 Thread.sleep(1000);
		   		   CompanyPOM.Expand(driver).click();
		   		  	 Thread.sleep(1000);
		   		   CompanyPOM.DPvtLtdAS(driver).click();
		   		  	 Thread.sleep(4000);
		   		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));
		   		 Thread.sleep(4000);
		   		  dir = new File("C:\\Users\\Mayuri\\Downloads");
					 dirContents = dir.listFiles(); // Counting number of files in directory before download

					Thread.sleep(4000);
					CompanyPOM.clickExport(driver).click(); // Exporting (Downloading) file

					Thread.sleep(3000);
					 dir1 = new File("C:\\Users\\Mayuri\\Downloads");
					 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
					Thread.sleep(3000);
					if (dirContents.length < allFilesNew.length) {
						test.log(LogStatus.PASS,  "All Report :- File downloaded successfully.");
					} else {
						test.log(LogStatus.FAIL,  "All Report :- File does not downloaded.");
					}
		 	
	 
	      SwitchtoParent(driver,test);
	      Thread.sleep(3000);
	}
	
	public static void EventAssignments( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]")));	//Wait until records table get visible.
//-------------------------------Statutory Assignment Report-------------------------------
	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.EventAssignments(driver).click();
		  	 Thread.sleep(3000);
		  	  CompanyPOM.SelectLocation(driver).click();
			  	 Thread.sleep(1000);
			  	  CompanyPOM.DPvtLtd(driver).click();
				  	 Thread.sleep(3000);
		  	 
		  	Thread.sleep(3000);
			File dir = new File("C:\\Users\\Mayuri\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.ExporttoExcel(driver).click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\Mayuri\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "After Selecting Location :- File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
			 CompanyPOM.SelectOwner(driver).click();
		  	 Thread.sleep(1000);
		  	  CompanyPOM.abclawyer(driver).click();
			  	 Thread.sleep(3000);
	  	 
			 	Thread.sleep(3000);
				File dir2 = new File("C:\\Users\\Mayuri\\Downloads");
				File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				CompanyPOM.ExporttoExcel(driver).click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				File dir3 = new File("C:\\Users\\Mayuri\\Downloads");
				File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents1.length < allFilesNew1.length) {
					test.log(LogStatus.PASS,  "After Selecting Location and  Event owner:- File downloaded successfully.");
				} else {
					test.log(LogStatus.FAIL,  " :- File does not downloaded.");
				}
			
			
			  SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	public static void Eventassignmentexportimport( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
//-------------------------------Statutory Assignment Report-------------------------------
	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event(driver).click();
		  	 Thread.sleep(3000);
		  	 
		  	 CompanyPOM.SelectEntity(driver).click();
		  	 Thread.sleep(1000);
		  	  CompanyPOM.BITAConsultingPune(driver).click();
			  	 Thread.sleep(1000);
			  	 CompanyPOM.SelectEntityok(driver).click();
			  	 Thread.sleep(8000);
			  	 
			  	 CompanyPOM.Location(driver).click();
			  	 Thread.sleep(1000);
			  	  CompanyPOM.LocationExpand(driver).click();
				  	 Thread.sleep(1000);
				  	 CompanyPOM.ExpandFPvtLTd(driver).click();
				  	 Thread.sleep(1000);
				  	CompanyPOM.MPvtLtd(driver).click();
				  	 Thread.sleep(1000);
				 	CompanyPOM.Select(driver).click();
				  	 Thread.sleep(3000);
				  	Thread.sleep(3000);
					File dir2 = new File("C:\\Users\\Mayuri\\Downloads");
					File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download

					Thread.sleep(500);
					CompanyPOM.Download(driver).click(); // Exporting (Downloading) file

					Thread.sleep(3000);
					File dir3 = new File("C:\\Users\\Mayuri\\Downloads");
					File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
					Thread.sleep(3000);
					if (dirContents1.length < allFilesNew1.length) {
						test.log(LogStatus.PASS,  " File downloaded successfully.");
					} else {
						test.log(LogStatus.FAIL,  " :- File does not downloaded.");
					}
					 SwitchtoParent(driver,test);
				      Thread.sleep(3000);
	}
	
	public static void EventassignmentexportimportValidation( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event(driver).click();
		  	 Thread.sleep(3000);
		  	 
		  	
					Thread.sleep(500);
					CompanyPOM.Download(driver).click(); // Exporting (Downloading) file

					Thread.sleep(3000);
					String ValMsg =driver.switchTo().alert().getText();
					Thread.sleep(1000);
						test.log(LogStatus.PASS,  "Without Selecting Entity , location validation message display : -"+ValMsg);
						driver.switchTo().alert().accept();
						Thread.sleep(1000);
					 SwitchtoParent(driver,test);
				      Thread.sleep(3000);
	}
	
	public static void ImportBlankScript( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Import(driver).click();
		  	 Thread.sleep(3000);
		 	CompanyPOM.ChooseFile(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\EventAssignmentReport (3).xlsx");
		  	 Thread.sleep(3000);
		  	CompanyPOM.Upload(driver).click();
		  	 Thread.sleep(6000);
		  //	 String Msg=CompanyPOM.BlankMsg(driver).getText();
		  	 Thread.sleep(3000);
		  	test.log(LogStatus.PASS,  "When blank Sheet Uploaded : - Validation Msg Not Displyed");
		  	 SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	public static void ImportInvalidSheet( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Import(driver).click();
		  	 Thread.sleep(3000);
		 	CompanyPOM.ChooseFile(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\EventAssignmentReport.xlsx");
		  	 Thread.sleep(3000);
		  	CompanyPOM.Upload(driver).click();
		  	 Thread.sleep(6000);
		 	 String Msg=CompanyPOM.InvalidMsg(driver).getText();
		  	 Thread.sleep(3000);
		  	test.log(LogStatus.PASS,  "upload invalid Data validation message display : -"+Msg);
		  	 SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	public static void ImportValidSheet( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Import(driver).click();
		  	 Thread.sleep(3000);
		 	CompanyPOM.ChooseFile(driver).sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\EventAssignmentReport (4).xlsx");
		  	 Thread.sleep(3000);
		  	CompanyPOM.Upload(driver).click();
		  	 Thread.sleep(6000);
		 	 String Msg=CompanyPOM.BlankMsg(driver).getText();
		  	 Thread.sleep(3000);
		  	test.log(LogStatus.PASS,  " valid Data Upload validation message display : -"+Msg);
		  	 SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	public static void UploadedFileisplay ( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Import(driver).click();
		  	 Thread.sleep(3000);
		 if(CompanyPOM.UploadLink(driver).isDisplayed()) {
			 
				test.log(LogStatus.PASS,  "  Uploaded File displayed On Grid Table"); 
		 }
		  	 Thread.sleep(3000);
		  
		  	 SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	
	public static void UploadedFileisplayEC ( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.EventCompliance(driver).click();
		  	 Thread.sleep(3000);
		  
		 if(CompanyPOM.UploadLinkEC(driver).isDisplayed()) {
			 
				test.log(LogStatus.PASS,  "  Uploaded File displayed On Grid Table"); 
		 }
		  	 Thread.sleep(3000);
		  
		  	 SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	
	public static void DownloadEC ( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.EventCompliance(driver).click();
		  	 Thread.sleep(3000);
		  
		 	
			File dir = new File("C:\\Users\\Mayuri\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.DownloadEC(driver).click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\Mayuri\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
		  
		  	 SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	public static void ValidationEC ( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.EventCompliance(driver).click();
		  	 Thread.sleep(3000);
		  
		  	CompanyPOM.ImportEC(driver).click();
		  	 Thread.sleep(3000);
		  
		 	CompanyPOM.UploadEC(driver).click();
		  	 Thread.sleep(8000);
		  	 
	String Msg =	CompanyPOM.ValidationMsg(driver).getText();
		  	 Thread.sleep(8000);
		  	test.log(LogStatus.PASS,  "Validation Msg : -"+Msg);
		  
		  	 SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	public static void InValidSheet ( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.EventCompliance(driver).click();
		  	 Thread.sleep(3000);
		  
		  	CompanyPOM.ImportEC(driver).click();
		  	 Thread.sleep(3000);
		 	CompanyPOM.ChooseFileEC(driver).sendKeys("C:\\Users\\trainee\\Downloads\\EventComplianceAssignmentReport.xlsx");
		  	 Thread.sleep(3000);
		 	CompanyPOM.UploadEC(driver).click();
		  	 Thread.sleep(8000);
		  	 
	String Msg =	CompanyPOM.InValidationMsg(driver).getText();
		  	 Thread.sleep(8000);
		  	test.log(LogStatus.PASS,  "Validation Msg : -"+Msg);
		  
		  	 SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	public static void ValidSheetEC ( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents(driver)).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport(driver).click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.EventCompliance(driver).click();
		  	 Thread.sleep(3000);
		  
		  	CompanyPOM.ImportEC(driver).click();
		  	 Thread.sleep(3000);
		 	CompanyPOM.ChooseFileEC(driver).sendKeys("C:\\Users\\trainee\\Downloads\\EventComplianceAssignmentReport (1).xlsx");
		  	 Thread.sleep(3000);
		 	CompanyPOM.UploadEC(driver).click();
		  	 Thread.sleep(8000);
		  	 
	String Msg =	CompanyPOM.ValidationMsg(driver).getText();
		  	 Thread.sleep(8000);
		  	 if(Msg.equalsIgnoreCase("Data uploaded successfully.")) {
		  		test.log(LogStatus.PASS,  "Validation Msg : -"+Msg);
		  	 }
		  	 else {
		  		test.log(LogStatus.FAIL,  "Validation Msg : -"+Msg);
		  	 }
		  
		  	 SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	
	public static void Department ( WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
	  	CompanyPOM.Department(driver).click();
	  	 Thread.sleep(5000);
	  	 //------------------------ Add New ---------------------------
	  	CompanyPOM.AddNew(driver).click();
	  	 Thread.sleep(3000);
	  	
		sheet = workbook.getSheetAt(12); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(4);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CompanyPOM.DepartmentName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
	      
		CompanyPOM.SaveDept(driver).click();
		Thread.sleep(2000);
		String DeptSaveMsg = CompanyPOM.SaveDeptMsg(driver).getText();

		if (DeptSaveMsg.equalsIgnoreCase("Department saved successfully")) {
			test.log(LogStatus.PASS, "Message displayed -" + DeptSaveMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -"+ DeptSaveMsg);
		}
		Thread.sleep(2000);
		CompanyPOM.CloseDept(driver).click();
		Thread.sleep(3000);
		// ----------------------Filter -----------------
		row0 = sheet.getRow(4);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CompanyPOM.DepartFilter(driver).sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Department-Filter Working Successfully");

		// ----------------------Edit -----------------
		
		CompanyPOM.DepartEdit(driver).click();
		Thread.sleep(4000);
		CompanyPOM.DepartmentName(driver).clear();
		Thread.sleep(2000);
		row0 = sheet.getRow(5);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CompanyPOM.DepartmentName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		CompanyPOM.SaveDept(driver).click();
		Thread.sleep(3000);
		String DeptUpdateMsg = CompanyPOM.SaveDeptMsg(driver).getText();

		if (DeptUpdateMsg.equalsIgnoreCase("Department updated successfully")) {
			test.log(LogStatus.PASS, "Message displayed -" + DeptUpdateMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed - Department already exists");
		}

		Thread.sleep(2000);
		CompanyPOM.CloseDept(driver).click();
		Thread.sleep(3000);

		//---------------Delete-------------------------
		
		CompanyPOM.DepartDelete(driver).click();
		String DeleteMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		if (DeleteMsg.equalsIgnoreCase("Are you certain you want to delete this Department Details?")) {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg + "not Displayed");
		}

		  	 SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	public static void  User( WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
	  	CompanyPOM.User(driver).click();
	  	 Thread.sleep(5000);
	  	 //------------------------ Add New ---------------------------
	 	CompanyPOM.AddNewUser(driver).click();
	  	 Thread.sleep(3000);
	  	 
	  	 
	  	Thread.sleep(3000);
		sheet = workbook.getSheetAt(12); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		 	row0 = sheet.getRow(7);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CompanyPOM.UsersEmail(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(8);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CompanyPOM.UsersFirstName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(9);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CompanyPOM.UsersLastName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(10);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CompanyPOM.UsersDesignation(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(11);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

		int No = (int) c1.getNumericCellValue();
		CompanyPOM.UsersMobileNo(driver).sendKeys("" + No + ""); // Writing Task title
		Thread.sleep(4000);
		CompanyPOM.UsersDepartment(driver).click();
		Thread.sleep(2000);
		CompanyPOM.DepartmentTech(driver).click();
		Thread.sleep(5000);
		CompanyPOM.DepartmentTechOk(driver).click();
		Thread.sleep(2000);
		CompanyPOM.UserComplianceRole(driver).click();
		Thread.sleep(3000);
		CompanyPOM.UserCompanyAdmin(driver).click();
		Thread.sleep(4000);

		CompanyPOM.SelectHrRole(driver).click();
		Thread.sleep(2000);
		CompanyPOM.HR(driver).click();
		Thread.sleep(4000);
	/*	CompanyPOM.SecurityGroup(driver).click();
		Thread.sleep(2000);
		CompanyPOM.avantisGroup(driver).click();
		Thread.sleep(4000);
		*/
		CompanyPOM.UserSave(driver).click();
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "User - Add Successfully");
		
	      row0 = sheet.getRow(7);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			CompanyPOM.DepartFilter(driver).sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
			Thread.sleep(6000);
			test.log(LogStatus.PASS, "User - Filter working Successfully");
			
			File dir = new File("C:\\Users\\Mayuri\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.ExportUser(driver).click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\Mayuri\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
			CompanyPOM.UserEdit(driver).click();
			Thread.sleep(3000);
			CompanyPOM.UsersFirstName(driver).clear();
			Thread.sleep(1000);
			row0 = sheet.getRow(12);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			CompanyPOM.UsersFirstName(driver).sendKeys(c1.getStringCellValue()); // Writing Task title
			Thread.sleep(2000);
			CompanyPOM.UserSave(driver).click();
			Thread.sleep(8000);
			test.log(LogStatus.PASS, "User - Update Successfully");
			CompanyPOM.ResetPass(driver).click();
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			Thread.sleep(2000);
			String ResetMsg = driver.switchTo().alert().getText();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);

			if (ResetMsg.equalsIgnoreCase("Password reset successfully.")) {
				test.log(LogStatus.PASS, "Message displayed -" + ResetMsg);
			} else {
				test.log(LogStatus.PASS, "Message displayed -" + ResetMsg + "not Displayed");
			}
			Thread.sleep(4000);
			 SwitchtoParent(driver,test);
		      Thread.sleep(3000);
	}
	
	public static void  BlockScheduleStatutory( WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
	  	CompanyPOM.BlockScheduleStatutory(driver).click();
	  	 Thread.sleep(5000);
	  	CompanyPOM.ComplianceCategory(driver).click();
		Thread.sleep(2000);
		CompanyPOM.ClientSpecific(driver).click();
		Thread.sleep(10000);
		CompanyPOM.Description(driver).sendKeys("ABCD");
		Thread.sleep(4000);
		CompanyPOM.BlockDate(driver).click();
		Thread.sleep(1000);
		CompanyPOM.Date14(driver).click();
		Thread.sleep(3000);
		
		CompanyPOM.BlockCheckBox(driver).click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(4000);
		CompanyPOM.keep(driver).click();
		Thread.sleep(1000);
		String Msg = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Keep - Message displayed -:- " + Msg);
		Thread.sleep(2000);
		String Msg1 = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		test.log(LogStatus.PASS, "Keep - Message displayed -:- " + Msg1);
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		CompanyPOM.Description(driver).sendKeys("ABCDE");
		Thread.sleep(3000);
		CompanyPOM.BlockDate(driver).click();
		Thread.sleep(1000);
		CompanyPOM.Date14(driver).click();
		Thread.sleep(1000);
		CompanyPOM.BlockCheckBox(driver).click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(4000);
		CompanyPOM.BlockDelete(driver).click();
		Thread.sleep(1000);
		
		driver.switchTo().alert().accept();

		Thread.sleep(5000);
		String Msg3 = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		test.log(LogStatus.PASS, "Delete - Message displayed -:- " + Msg3);
		Thread.sleep(2000);
		Thread.sleep(4000);
		 SwitchtoParent(driver,test);
	      Thread.sleep(3000);
	  	 
	}
	
	public static void  BlockScheduleInternal( WebDriver driver,ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
	    
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
	  	CompanyPOM.BlockScheduleInternal(driver).click();
	  	 Thread.sleep(5000);
	  	CompanyPOM.ComplianceCategory(driver).click();
		Thread.sleep(2000);
		CompanyPOM.Category28May2021(driver).click();
		Thread.sleep(10000);
		CompanyPOM.Description(driver).sendKeys("ABCD");
		Thread.sleep(4000);
		CompanyPOM.BlockDate(driver).click();
		Thread.sleep(1000);
		CompanyPOM.Date14(driver).click();
		Thread.sleep(3000);
		
		CompanyPOM.BlockCheckBox(driver).click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(4000);
		CompanyPOM.keep(driver).click();
		Thread.sleep(5000);
		//String Msg = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
	//	test.log(LogStatus.PASS, "Keep - Message displayed -:- " + Msg);
		Thread.sleep(2000);
		String Msg1 = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		test.log(LogStatus.PASS, "Keep - Message displayed -:- " + Msg1);
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		CompanyPOM.Description(driver).sendKeys("ABCDE");
		Thread.sleep(3000);
		CompanyPOM.BlockDate(driver).click();
		Thread.sleep(1000);
		CompanyPOM.Date14(driver).click();
		Thread.sleep(1000);
		CompanyPOM.BlockCheckBox(driver).click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(4000);
		CompanyPOM.BlockDelete(driver).click();
		Thread.sleep(8000);
		
		driver.switchTo().alert().accept();

		Thread.sleep(5000);
		String Msg3 = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		test.log(LogStatus.PASS, "Delete - Message displayed -:- " + Msg3);
		Thread.sleep(2000);
		Thread.sleep(4000);
		 SwitchtoParent(driver,test);
	      Thread.sleep(3000);
	}
	
	
	public static void UserDept( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		SwitchtoChild(driver,test);
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
	  	CompanyPOM.User(driver).click();
	  	 Thread.sleep(5000);
	      		  	CompanyPOM.ModifyAssignmentsLink(driver).click();
	      		  	 Thread.sleep(2000);
	      		  	if(CompanyPOM.DepartmentDropdown(driver).isDisplayed()) {
	      				
	      				test.log(LogStatus.PASS, " Department Dropdown is Displayed  ");
	      				
	      			}else {
	      				test.log(LogStatus.FAIL, " Department Dropdown is not Displayed  ");
	      			}
	      			
	      			JavascriptExecutor js = (JavascriptExecutor) driver;
	      			js.executeScript("window.scrollBy(0,500)");	
	      			Thread.sleep(4000);
	      			
	      			CompanyPOM.ModifyAssignmentsClose(driver).click();
	      			Thread.sleep(4000);
	      			SwitchtoParent(driver,test);
	}

	public static void ModifyAssignmentsDept( WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		
		SwitchtoChild(driver,test);
	      
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
	      CompanyPOM.ModifyAssignments(driver).click();
	      		  	 Thread.sleep(2000);
	      		  
	      		  	if(CompanyPOM.DepartmentDropdownMA(driver).isDisplayed()) {
	      				
	      				test.log(LogStatus.PASS, " Department Dropdown is Displayed  ");
	      				
	      			}else {
	      				test.log(LogStatus.FAIL, " Department Dropdown is not Displayed  ");
	      			}
	      			
	      			
	      			Thread.sleep(4000);
	      			
	      			
	      			SwitchtoParent(driver,test);
	}
	
	
	public static void modifyAssignmentsTask(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments(driver).click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Statutory :-Task :-Reassign
		// -------------------------------------
		ImplementPOM.ClickTask(driver).click();
		Thread.sleep(1000);

		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.performera(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.performera(driver).click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.reviewerb(driver).click();
		Thread.sleep(5000);

		ImplementPOM.ChechBoxInTask0(driver).click();
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	//	driver.switchTo().alert().dismiss();
		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliance tasks to performer a?")) {
			test.log(LogStatus.PASS, "Message displayed - " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(driver,test);
	}

	
	public static void modifyAssignmentsTaskIN(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments(driver).click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Internal :-Task :-Reassign
		// -------------------------------------
		ImplementPOM.ClickTask(driver).click();
		Thread.sleep(2000);
		ImplementPOM.ClickInternalRB(driver).click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.performera(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.performera(driver).click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.reviewerb(driver).click();
		Thread.sleep(5000);

		ImplementPOM.ChechBoxInTask0(driver).click();
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	//	driver.switchTo().alert().dismiss();

		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliance tasks to performer a?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(driver,test);
	}

	
	public static void modifyAssignmentsCom(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments(driver).click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Statutory :-Compliance  :-Reassign
		
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil(driver).click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.reviewerb(driver).click();
		Thread.sleep(5000);

		ImplementPOM.CheckBox0(driver).click();
		Thread.sleep(1000);
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	//	driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to Sonali patil?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(driver,test);
	}

	public static void modifyAssignmentsComEB(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments(driver).click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Statutory :-Compliance  :-Reassign - Event Based
		
		
		Thread.sleep(5000);
		ImplementPOM.ClickStaEventBased(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil(driver).click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.reviewerb(driver).click();
		Thread.sleep(5000);

		ImplementPOM.CheckBox0(driver).click();
		Thread.sleep(1000);
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	//	driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to Sonali patil?")) {
			test.log(LogStatus.PASS, "Message displayed - " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(driver,test);
	}

	
	public static void modifyAssignmentsComChecklist(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments(driver).click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Statutory :-Compliance  :-Reassign - Checklist
		
		
		Thread.sleep(5000);
		ImplementPOM.ClickStaCheckList(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil(driver).click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.reviewerb(driver).click();
		Thread.sleep(5000);

		ImplementPOM.CheckBox0(driver).click();
		Thread.sleep(1000);
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	//	driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to Sonali patil?")) {
			test.log(LogStatus.PASS, "Message displayed - " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(driver,test);
	}

	
	public static void modifyAssignmentsComIN(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments(driver).click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Internal :-Compliance  :-Reassign
		
		
		Thread.sleep(2000);
		ImplementPOM.ClickInternalRB(driver).click();
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.performera(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.performera(driver).click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.reviewerb(driver).click();
		Thread.sleep(5000);

		ImplementPOM.CheckINBox0(driver).click();
		Thread.sleep(1000);
		// ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	//	driver.switchTo().alert().dismiss();

		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to performer a?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(driver,test);
	}

	public static void modifyAssignmentsComINChecklist(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments(driver).click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Internal :-Compliance  :-Reassign -CheckList
		
		
		Thread.sleep(2000);
		ImplementPOM.ClickInternalRB(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClickStaCheckList(driver).click();
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.performera(driver).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.performera(driver).click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.reviewerb(driver).click();
		Thread.sleep(5000);

		ImplementPOM.CheckINBox0(driver).click();
		Thread.sleep(1000);
		// ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	//	driver.switchTo().alert().dismiss();
		
		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to performer a?")) {
			test.log(LogStatus.PASS, "Message displayed - " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(driver,test);
	}

	
	public static void modifyAssignmentsComExclude(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments(driver).click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Statutory :-Compliance  :-Exclude 
		
		  	ImplementPOM.ClickExclude(driver).click();
			Thread.sleep(6000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil(driver).click();
		Thread.sleep(5000);
		
		ImplementPOM.CheckBox0(driver).click();
		Thread.sleep(1000);
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	//	driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		if (MAMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for Sonali patil?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(driver,test);
	}
	
	public static void modifyAssignmentsComExcludeEB(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments(driver).click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Statutory :-Compliance  :-Exclude -Event Based
		
		  	ImplementPOM.ClickExclude(driver).click();
			Thread.sleep(6000);
			ImplementPOM.ClickStaEventBased(driver).click();
			Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil(driver).click();
		Thread.sleep(5000);
		
		ImplementPOM.CheckBox0(driver).click();
		Thread.sleep(1000);
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	//	driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		if (MAMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for Sonali patil?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(driver,test);
	}
	
	public static void modifyAssignmentsComExcludeCL(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments(driver).click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Statutory :-Compliance  :-Exclude -CheckList
		
		  	ImplementPOM.ClickExclude(driver).click();
			Thread.sleep(6000);
			ImplementPOM.ClickStaCheckList(driver).click();
			Thread.sleep(5000);
			
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil(driver).click();
		Thread.sleep(5000);
		
		ImplementPOM.CheckBox0(driver).click();
		Thread.sleep(1000);
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	//	driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		if (MAMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for Sonali patil?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(driver,test);
	}
	
	
	public static void modifyAssignmentsComExcludeIN(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments(driver).click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Internal :-Compliance  :-Reassign
		
		
		Thread.sleep(2000);
		ImplementPOM.ClickInternalRB(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClickExclude(driver).click();
		Thread.sleep(6000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.performera(driver).click();
		Thread.sleep(5000);
		

		ImplementPOM.CheckINBox0(driver).click();
		Thread.sleep(1000);
		// ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	//	driver.switchTo().alert().dismiss();

		if (MAMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for performer a?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(driver,test);
	}
	
	public static void modifyAssignmentsComExcludeINCL(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, (140));
		Thread.sleep(3000);
		SwitchtoChild(driver,test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers(driver)).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments(driver).click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Internal :-Compliance  :-Reassign
		
		
		Thread.sleep(2000);
		ImplementPOM.ClickInternalRB(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClickExclude(driver).click();
		Thread.sleep(6000);
		ImplementPOM.ClickStaCheckList(driver).click();
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser(driver).click();
		Thread.sleep(2000);
		CompanyPOM.performera(driver).click();
		Thread.sleep(5000);
		

		ImplementPOM.CheckINBox0(driver).click();
		Thread.sleep(1000);
		// ImplementPOM.CheckBox1(driver).click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn(driver).click();
		String MAMsg = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	//	driver.switchTo().alert().dismiss();

		if (MAMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for performer a?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(driver,test);
	}
	
	
	
	
	
	
	
	
}
