package cfo;

import java.io.FileInputStream;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import performer.OverduePOM;

public class MgmtAMethod {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	public static List<WebElement> elementsList1 = null;
	
	public static void myTask(WebDriver driver, ExtentTest test,XSSFWorkbook workbook)throws InterruptedException
	{

		
		WebDriverWait wait = new WebDriverWait(driver, (40));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		OverduePOM.ClickBtn(driver).click();
		Thread.sleep(3000);
		CFOcountPOM.clickMyTask(driver).click();
		Thread.sleep(4000);
		int total = Integer.parseInt(OverduePOM.readReminder1(driver).getText());	//Reading total records displayed

	//	wait.until(ExpectedConditions.invisibilityOf(OverduePOM.clickAddNew1(driver)));		//Waiting for Add New button to get invisible. 
		Thread.sleep(3000);
		OverduePOM.clickAddNew1(driver).click();					//Clicking on 'Add New' button
		
		test.log(LogStatus.INFO, "------------- Statutory -------------");
		Thread.sleep(6000);
		OverduePOM.clickActFilter(driver).click();					//Clicking on 'Act Filter' drop down.
		Select drp = new Select(OverduePOM.clickActFilter(driver));
		drp.selectByIndex(2);										//Selecting third Act
		
		Thread.sleep(1000);
	//	wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickComplianceDropDown(driver)));
		OverduePOM.clickComplianceDropDown(driver).click();			//Clicking on 'Compliance' drop down.
		drp = new Select(OverduePOM.clickComplianceDropDown(driver));
		drp.selectByIndex(1);										
		Thread.sleep(500);
   sheet = workbook.getSheetAt(14);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
		Cell c1 = null;
		row0= sheet.getRow(3);
		c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
	OverduePOM.clickTaskTitle(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
	
	row0 = sheet.getRow(4);							//Selected 1st index row (Second row)
	c1 = row0.getCell(1);							//Selected cell (1 row,2 column)
	OverduePOM.clickDescription(driver).sendKeys(c1.getStringCellValue());	//Writing description
	
	row0 = sheet.getRow(5);							//Selected 2nd index row (Third row)
	c1 = row0.getCell(1);							//Selected cell (2 row,2 column)
	int day = (int) c1.getNumericCellValue();
	OverduePOM.clickDueDay(driver).sendKeys(""+day+"");	//Writing Due days
	
  Select taskType=new Select(	OverduePOM.clickTaskType(driver));
  taskType.selectByIndex(1);
  Thread.sleep(1000);

	OverduePOM.clickConditionCheckbox(driver).click();	//Clicking on 'Is Task Conditional' checkbox
	
	js.executeScript("window.scrollBy(0,2000)");
	row0 = sheet.getRow(6);							//Selected 3rd index row (Fourth row)
	c1 = row0.getCell(1);							//Selected cell (3 row,2 column)
	OverduePOM.clickConditionalMessage(driver).sendKeys(c1.getStringCellValue());	//Writing condition message
	
	row0 = sheet.getRow(7);							//Selected 4th index row (Fifth row)
	c1 = row0.getCell(1);							//Selected cell (4 row,2 column)
	OverduePOM.clickYesMsg(driver).sendKeys(c1.getStringCellValue());	//Writing message in 'Yess message' text box
	
	row0 = sheet.getRow(8);							//Selected 5th index row (Sixth row)
	c1 = row0.getCell(1);							//Selected cell (5 row,2 column)
	OverduePOM.clickNoMsg(driver).sendKeys(c1.getStringCellValue());	//Writing message in 'No message' text box
		
	js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
	Thread.sleep(1500);
//	String workingDir = System.getProperty("user.dir");
//	OverduePOM.SampleFormUpload(driver).sendKeys("C:/March2022/PerformerPom/Reports/PerformerResults.html");
	
	Thread.sleep(1000);
	OverduePOM.clickSaveButton(driver).click();		//Clicking on 'Save' Button
	
	Thread.sleep(500);
	String saveMsg = OverduePOM.taskSavedMsg(driver).getText();
	OverduePOM.taskSavedMsg(driver).click();
	
	if(saveMsg.equalsIgnoreCase("Task Saved Successfully."))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Task Saved Successfully'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Task already exist.'");
	}
	
	driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();
	Thread.sleep(3000);
	int total1 = Integer.parseInt(OverduePOM.readReminder1(driver).getText());	//Reading total records displayed
	
	if(total1 > total)
	{
		test.log(LogStatus.PASS, "New Task added and displayed successfully.");
	}
	else
	{
		test.log(LogStatus.FAIL, "New Task doesn't added and displayed.");
	}
	
	//-----------------------------------Edit-----------------------------------------------
	
	OverduePOM.ClickEditBtn(driver).click();
	Thread.sleep(5000);
	OverduePOM.clickStatutoryRB(driver).click();
	Thread.sleep(5000);
	OverduePOM.clickTaskTitle(driver).clear();
	Thread.sleep(1000);
	OverduePOM.clickTaskTitle(driver).sendKeys("Auto1616");
	Thread.sleep(1000);
	OverduePOM.clickDescription(driver).clear();
	Thread.sleep(1000);
	OverduePOM.clickDescription(driver).sendKeys("AutomationTesting1212");
	Thread.sleep(1000);
	Thread.sleep(2000);
	OverduePOM.clickSaveButton(driver).click();		//Clicking on 'Save' Button
	
	Thread.sleep(3000);
	String saveMsg1 = OverduePOM.EditSavedMsg(driver).getText();
	OverduePOM.EditSavedMsg(driver).click();
	Thread.sleep(3000);
	if(saveMsg1.equalsIgnoreCase("Task Updated Successfully."))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Task Updated Successfully.'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Task Updated Successfully.not displayed'");
	}
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='divTaskDetailsDialog']/div/div/div[1]/button")).click();
	Thread.sleep(1000);
	Thread.sleep(500);
				
	Thread.sleep(500);
	
	Thread.sleep(5000);
	//-----------------------------------Show Assignment-----------------------------------------------
	
	OverduePOM.ClickShowAssignmentTask(driver).click();
	Thread.sleep(5000);
	OverduePOM.ComplianceLocationTABCD(driver).click();
	Thread.sleep(1000);
	OverduePOM.LPvtLtd(driver).click();
	Thread.sleep(1000);
	OverduePOM.ComplianceLocationT(driver).click();
	Thread.sleep(1000);
	OverduePOM.ReportingLocation(driver).click();
	Thread.sleep(1000);
	
	OverduePOM.ReportingLocationAB(driver).click();
	Thread.sleep(1000);
	OverduePOM.ReportingLocationA(driver).click();
	Thread.sleep(1000);
	OverduePOM.ComplianceLocationT(driver).click();
	Thread.sleep(2000);
	OverduePOM.Startdate(driver).click();
	Thread.sleep(1000);
	OverduePOM.date18(driver).click();
	Thread.sleep(2000);
	OverduePOM.ComplianceLocationT(driver).click();
	Thread.sleep(3000);
	OverduePOM.TPerformer(driver).click();	
	Thread.sleep(1000);
	
	OverduePOM.TabcExternal(driver).click();	
	Thread.sleep(4000);
	OverduePOM.TReviewer(driver).click();	
	Thread.sleep(1000);

	Thread.sleep(2000);
	OverduePOM.Tabclawyer(driver).click();	
	Thread.sleep(2000);
	OverduePOM.SaveBtn(driver).click();	
	Thread.sleep(2000);
	OverduePOM.CloseTab(driver).click();	
	Thread.sleep(2000);
	
	
	
	
	//-----------------------------------Delete-----------------------------------------------
	OverduePOM.ClickDeleteTask(driver).click();
	Thread.sleep(2000);
	String deleteMsg=driver.switchTo().alert().getText();
	Thread.sleep(1000);
	if(deleteMsg.equalsIgnoreCase("Are you certain you want to delete this Task?"))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Task?'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Task? this msg not show'");
	}
	Thread.sleep(500);
	driver.switchTo().alert().accept();	
	Thread.sleep(2000);
	String DleMsg=OverduePOM.AfterClickDelete(driver).getText();
	if(DleMsg.equalsIgnoreCase("Task can not delete, Task already assigned"))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Task can not delete, Task already assigned'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Task can not delete, Task already assigned this msg not show'");
	}	
		
	}
	
	public static void myTaskSubTask(WebDriver driver, ExtentTest test,XSSFWorkbook workbook)throws InterruptedException
	{

		
		WebDriverWait wait = new WebDriverWait(driver, (40));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(4000);
		//-------------------------------Create Sub Task--------------------------------------
	  
	  	elementsList1 = OverduePOM.clickSubTask(driver);	//Getting all Sub Task elements list
	  	int no = elementsList1.size();

	  	Thread.sleep(2000);
	  	elementsList1.get(3).click();

	  	Thread.sleep(4000);

	  	wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickAddNew2(driver)));	//Wait till 'Add New' button gets visible in Sub Task
	  	OverduePOM.clickAddNew2(driver).click();			//Clicking on 'Add New' in Sub Task.
	  	Thread.sleep(3000);
	  	 sheet = workbook.getSheetAt(14);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
	  		int row = 0;
	  		Thread.sleep(500);
	  		Row row01 = sheet.getRow(row);					//Selected 0th index row (First row)
	  		Cell c11 = null;
	  		row01= sheet.getRow(10);
	  		c11 = row01.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
	  	OverduePOM.clickTaskTitle(driver).sendKeys(c11.getStringCellValue());	//Writing Task title

	  	row01 = sheet.getRow(11);							//Selected 1st index row (Second row)
	  	c11 = row01.getCell(1);							//Selected cell (1 row,2 column)
	  	OverduePOM.clickDescription(driver).sendKeys(c11.getStringCellValue());	//Writing description

	  	row01 = sheet.getRow(12);							//Selected 2nd index row (Third row)
	  	c11 = row01.getCell(1);							//Selected cell (2 row,2 column)
	  	int day1 = (int) c11.getNumericCellValue();
	  	OverduePOM.clickDueDay(driver).sendKeys(""+day1+"");	//Writing Due days

	  	OverduePOM.clickConditionCheckbox(driver).click();	//Clicking on 'Is Task Conditional' checkbox

	  	js.executeScript("window.scrollBy(0,2000)");
	  	row01 = sheet.getRow(13);							//Selected 3rd index row (Fourth row)
	  	c11 = row01.getCell(1);							//Selected cell (3 row,2 column)
	  	OverduePOM.clickConditionalMessage(driver).sendKeys(c11.getStringCellValue());	//Writing condition message

	  	row01 = sheet.getRow(14);							//Selected 4th index row (Fifth row)
	  	c11 = row01.getCell(1);							//Selected cell (4 row,2 column)
	  	OverduePOM.clickYesMsg(driver).sendKeys(c11.getStringCellValue());	//Writing message in 'Yess message' text box

	  	row01 = sheet.getRow(15);							//Selected 5th index row (Sixth row)
	  	c11 = row01.getCell(1);							//Selected cell (5 row,2 column)
	  	OverduePOM.clickNoMsg(driver).sendKeys(c11.getStringCellValue());	//Writing message in 'No message' text box
	  		
	  	js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
	  	Thread.sleep(1500);
	  	//String workingDir = System.getProperty("user.dir");
	 // 	OverduePOM.SampleFormUpload(driver).sendKeys("C:/March2022/PerformerPom/Reports/PerformerResults.html");

	  	Thread.sleep(1000);
	  	OverduePOM.clickSaveButton(driver).click();		//Clicking on 'Save' Button
	  	Thread.sleep(500);
	  	String saveMsg1 = OverduePOM.taskSavedMsg1(driver).getText();	//Msg = Subtask Saved Successfully.

	  	test.log(LogStatus.INFO, "Message displayed - '"+ saveMsg1 +"'");
	  		
	  	driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
	  	try
	  	{
	  		Thread.sleep(700);
	  		if(OverduePOM.checkRecordsTable(driver).isDisplayed())
	  		{
	  			test.log(LogStatus.PASS, "New Sub Task added and displayed successfully.");
	  		}
	  		else
	  		{
	  			test.log(LogStatus.FAIL, "New Sub Task doesn't added and displayed.");
	  		}
	  	}
	  	catch(Exception e)
	  	{
	  		
	  	}
	  	
	  	//----------------------Edit---------------------------------------
	  	
		OverduePOM.SubTaskEdit(driver).click();	
		Thread.sleep(3000);
		OverduePOM.clickTaskTitle(driver).clear();
		Thread.sleep(1000);
		row01= sheet.getRow(16);
  		c11 = row01.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
  	OverduePOM.clickTaskTitle(driver).sendKeys(c11.getStringCellValue());
		
	Thread.sleep(2000);
  	OverduePOM.clickSaveButton(driver).click();		//Clicking on 'Save' Button
  	Thread.sleep(1000);
  	String updateMsg1 = OverduePOM.UpdateMsg(driver).getText();	//Msg = Subtask Saved Successfully.

  	test.log(LogStatus.INFO, "Message displayed - '"+ updateMsg1 +"'");
  		
  	driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
  
	//----------------------Show Assignment---------------------------------------
  	
  	OverduePOM.ClickShowAssignment(driver).click();	
  	Thread.sleep(5000);
	OverduePOM.ComplianceLocationST(driver).click();	
	Thread.sleep(1000);
	OverduePOM.ComplianceLocationACD(driver).click();	
	Thread.sleep(1000);
	OverduePOM.CLLPvt(driver).click();	
	Thread.sleep(1000);
	OverduePOM.ComplianceLocationST(driver).click();	
	Thread.sleep(1000);
	OverduePOM.ReportingLocation(driver).click();	
	Thread.sleep(1000);
	OverduePOM.ReportingLocationAB(driver).click();	
	Thread.sleep(1000);
	OverduePOM.ReportingLocationA(driver).click();	
	Thread.sleep(2000);
	OverduePOM.Startdate(driver).click();	
	Thread.sleep(1000);
	OverduePOM.date18(driver).click();	
	Thread.sleep(2000);
	OverduePOM.STPerformer(driver).click();	
	Thread.sleep(1000);
	//OverduePOM.STPerformerText(driver).sendKeys("abc External");	
	//Thread.sleep(1000);
	OverduePOM.abcExternal(driver).click();	
	Thread.sleep(4000);
	OverduePOM.Reviewer(driver).click();	
	Thread.sleep(1000);
//	OverduePOM.ReviewerText(driver).sendKeys("abc lawyer");
	Thread.sleep(2000);
	OverduePOM.abclawyer(driver).click();	
	Thread.sleep(2000);
	OverduePOM.SaveBtn(driver).click();	
	Thread.sleep(2000);
String msg=	OverduePOM.TAmsg(driver).getText();	
	Thread.sleep(2000);
	
	test.log(LogStatus.PASS, "Message displayed - "+msg);
	Thread.sleep(2000);
	OverduePOM.CloseTab(driver).click();	
	Thread.sleep(2000);
  	
	//----------------------Delete---------------------------------------
	Thread.sleep(3000);
  	OverduePOM.SubTaskDelete(driver).click();
  	Thread.sleep(1000);
  	String deleteMsg=driver.switchTo().alert().getText();
	Thread.sleep(1000);
	if(deleteMsg.equalsIgnoreCase("Are you certain you want to delete this Sub task?"))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Sub task?'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Sub task? this msg not show'");
	}
	Thread.sleep(500);
	driver.switchTo().alert().accept();	
	Thread.sleep(2000);
	String DleMsg=OverduePOM.STAfterClickDelete(driver).getText();
	if(DleMsg.equalsIgnoreCase("Sub Task can not delete, Sub task already assigned"))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Sub Task can not delete, Sub task already assigned'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Sub Task can not delete, Sub task already assignedthis msg not show'");
	}	
	Thread.sleep(2000);
	OverduePOM.BacktoTask(driver).click();
	Thread.sleep(3000);
	OverduePOM.clickDashboard(driver).click();
	Thread.sleep(4000);
	}
	
	public static void myTaskInternal(WebDriver driver, ExtentTest test,XSSFWorkbook workbook)throws InterruptedException
	{

		
		WebDriverWait wait = new WebDriverWait(driver, (40));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		OverduePOM.ClickBtn(driver).click();
		Thread.sleep(3000);
		CFOcountPOM.clickMyTask(driver).click();
		Thread.sleep(4000);
		int total = Integer.parseInt(OverduePOM.readReminder1(driver).getText());	//Reading total records displayed

		Thread.sleep(3000);
		OverduePOM.clickAddNew1(driver).click();					//Clicking on 'Add New' button
		Thread.sleep(6000);
		test.log(LogStatus.INFO, "------------- Internal -------------");
		
		OverduePOM.clickInternaRadioButton(driver).click();	//Clicking on Radio button of 'Internal' tasks
		Thread.sleep(5000); 
		Select drp = new Select(OverduePOM.clickInternalCompliance(driver));
		drp.selectByIndex(1);
		Thread.sleep(5000);
		
	   sheet = workbook.getSheetAt(14);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
			int row = 0;
			Thread.sleep(500);
			Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
			Cell c1 = null;
			row0= sheet.getRow(3);
			c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
		OverduePOM.clickTaskTitle(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
		Thread.sleep(1000);
		row0 = sheet.getRow(4);							//Selected 1st index row (Second row)
		c1 = row0.getCell(1);							//Selected cell (1 row,2 column)
		OverduePOM.clickDescription(driver).sendKeys(c1.getStringCellValue());	//Writing description
		
		row0 = sheet.getRow(5);							//Selected 2nd index row (Third row)
		c1 = row0.getCell(1);							//Selected cell (2 row,2 column)
		int day = (int) c1.getNumericCellValue();
		OverduePOM.clickDueDay(driver).sendKeys(""+day+"");	//Writing Due days
		
	  Select taskType=new Select(	OverduePOM.clickTaskType(driver));
	  taskType.selectByIndex(1);
	  Thread.sleep(2000);

		OverduePOM.clickConditionCheckbox(driver).click();	//Clicking on 'Is Task Conditional' checkbox
		
		js.executeScript("window.scrollBy(0,2000)");
		row0 = sheet.getRow(6);							//Selected 3rd index row (Fourth row)
		c1 = row0.getCell(1);							//Selected cell (3 row,2 column)
		OverduePOM.clickConditionalMessage(driver).sendKeys(c1.getStringCellValue());	//Writing condition message
		
		row0 = sheet.getRow(7);							//Selected 4th index row (Fifth row)
		c1 = row0.getCell(1);							//Selected cell (4 row,2 column)
		OverduePOM.clickYesMsg(driver).sendKeys(c1.getStringCellValue());	//Writing message in 'Yess message' text box
		
		row0 = sheet.getRow(8);							//Selected 5th index row (Sixth row)
		c1 = row0.getCell(1);							//Selected cell (5 row,2 column)
		OverduePOM.clickNoMsg(driver).sendKeys(c1.getStringCellValue());	//Writing message in 'No message' text box
			
		js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
		Thread.sleep(1500);
	//	String workingDir = System.getProperty("user.dir");
	//	OverduePOM.SampleFormUpload(driver).sendKeys("C:/March2022/PerformerPom/Reports/PerformerResults.html");
		
		Thread.sleep(1000);
		OverduePOM.clickSaveButton(driver).click();		//Clicking on 'Save' Button
		
		Thread.sleep(500);
		String saveMsg = OverduePOM.taskSavedMsg(driver).getText();
		OverduePOM.taskSavedMsg(driver).click();
		
		if(saveMsg.equalsIgnoreCase("Task Saved Successfully."))
		{
			test.log(LogStatus.INFO, "Message displayed - 'Task Saved Successfully'");
		}
		else
		{
			test.log(LogStatus.INFO, "Message displayed - 'Task already exist.'");
		}
		
		driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();
		Thread.sleep(1000);
		
		int total1 = Integer.parseInt(OverduePOM.readReminder1(driver).getText());	//Reading total records displayed
		
		if(total1 > total)
		{
			test.log(LogStatus.PASS, "New Task added and displayed successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Task doesn't added and displayed.");
				
		}
		
		//----------------------Edit Internal---------------------------------------
		OverduePOM.ClickEditBtnIn(driver).click();
		Thread.sleep(1000); 
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickInternaRadioButton(driver)));
		Thread.sleep(500); 
		OverduePOM.clickInternaRadioButton(driver).click();	//Clicking on Radio button of 'Internal' tasks
		Thread.sleep(500); 
		
		OverduePOM.clickTaskTitle(driver).clear();
		Thread.sleep(1000);
		row0= sheet.getRow(17);
		c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
	OverduePOM.clickTaskTitle(driver).sendKeys(c1.getStringCellValue());	//Writing Task title
	
		
		Thread.sleep(3000);
		OverduePOM.clickSaveButton(driver).click();		//Clicking on 'Save' Button
		
		Thread.sleep(4000);
		String saveMsg1 = OverduePOM.EditSavedMsg(driver).getText();
		OverduePOM.EditSavedMsg(driver).click();
		Thread.sleep(3000);
		if(saveMsg1.equalsIgnoreCase("Task Updated Successfully."))
		{
			test.log(LogStatus.PASS, "Message displayed - 'Task Updated Successfully.'");
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed - 'Task Updated Successfully.' not shown");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='divTaskDetailsDialog']/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		
		//-----------------------------------Show Assignment - Internal-----------------------------------------------
		
		OverduePOM.ClickShowAssignmentTaskIn(driver).click();
		Thread.sleep(5000);
		OverduePOM.ComplianceLocationTABCD(driver).click();
		Thread.sleep(1000);
		OverduePOM.BPvtLtd(driver).click();
		Thread.sleep(1000);
		OverduePOM.ComplianceLocationT(driver).click();
		Thread.sleep(1000);
		OverduePOM.ReportingLocation(driver).click();
		Thread.sleep(1000);
		
		OverduePOM.ReportingLocationAB(driver).click();
		Thread.sleep(1000);
		OverduePOM.ReportingLocationA(driver).click();
		Thread.sleep(1000);
		OverduePOM.ComplianceLocationT(driver).click();
		Thread.sleep(4000);
		OverduePOM.Startdate(driver).click();
		Thread.sleep(1000);
		OverduePOM.date18(driver).click();
		Thread.sleep(2000);
		OverduePOM.ComplianceLocationT(driver).click();
		Thread.sleep(3000);
		OverduePOM.TPerformer(driver).click();	
		Thread.sleep(1000);
		
		OverduePOM.TabcExternal(driver).click();	
		Thread.sleep(4000);
		OverduePOM.TReviewer(driver).click();	
		Thread.sleep(1000);

		Thread.sleep(2000);
		OverduePOM.Tabclawyer(driver).click();	
		Thread.sleep(2000);
		OverduePOM.SaveBtn(driver).click();	
		Thread.sleep(2000);
		OverduePOM.CloseTab(driver).click();	
		Thread.sleep(2000);
		
		
		
		
		//-----------------------------------Delete-----------------------------------------------
		OverduePOM.ClickDeleteTaskIn(driver).click();
		Thread.sleep(2000);
		String deleteMsg=driver.switchTo().alert().getText();
		Thread.sleep(1000);
		if(deleteMsg.equalsIgnoreCase("Are you certain you want to delete this Task?"))
		{
			test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Task?'");
		}
		else
		{
			test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Task? this msg not show'");
		}
		Thread.sleep(500);
		driver.switchTo().alert().accept();	
		Thread.sleep(2000);
		String DleMsg=OverduePOM.AfterClickDelete(driver).getText();
		if(DleMsg.equalsIgnoreCase("Task can not delete, Task already assigned"))
		{
			test.log(LogStatus.INFO, "Message displayed - 'Task can not delete, Task already assigned'");
		}
		else
		{
			test.log(LogStatus.INFO, "Message displayed - 'Task can not delete, Task already assigned this msg not show'");
		}	
			

	}
	
	public static void myTaskSubTaskIn(WebDriver driver, ExtentTest test,XSSFWorkbook workbook)throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, (40));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(4000);
		//-------------------------------Create Sub Task--------------------------------------
	  
	  	elementsList1 = OverduePOM.clickSubTask(driver);	//Getting all Sub Task elements list
	  	int no = elementsList1.size();

	  	Thread.sleep(2000);
	  	elementsList1.get(2).click();

	  	Thread.sleep(4000);

	  	wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickAddNew2(driver)));	//Wait till 'Add New' button gets visible in Sub Task
	  	OverduePOM.clickAddNew2(driver).click();			//Clicking on 'Add New' in Sub Task.
	  	Thread.sleep(3000);
	  	 sheet = workbook.getSheetAt(14);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
	  		int row = 0;
	  		Thread.sleep(500);
	  		Row row01 = sheet.getRow(row);					//Selected 0th index row (First row)
	  		Cell c11 = null;
	  		row01= sheet.getRow(10);
	  		c11 = row01.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
	  	OverduePOM.clickTaskTitle(driver).sendKeys(c11.getStringCellValue());	//Writing Task title

	  	row01 = sheet.getRow(11);							//Selected 1st index row (Second row)
	  	c11 = row01.getCell(1);							//Selected cell (1 row,2 column)
	  	OverduePOM.clickDescription(driver).sendKeys(c11.getStringCellValue());	//Writing description

	  	row01 = sheet.getRow(12);							//Selected 2nd index row (Third row)
	  	c11 = row01.getCell(1);							//Selected cell (2 row,2 column)
	  	int day1 = (int) c11.getNumericCellValue();
	  	OverduePOM.clickDueDay(driver).sendKeys(""+day1+"");	//Writing Due days

	  	OverduePOM.clickConditionCheckbox(driver).click();	//Clicking on 'Is Task Conditional' checkbox

	  	js.executeScript("window.scrollBy(0,2000)");
	  	row01 = sheet.getRow(13);							//Selected 3rd index row (Fourth row)
	  	c11 = row01.getCell(1);							//Selected cell (3 row,2 column)
	  	OverduePOM.clickConditionalMessage(driver).sendKeys(c11.getStringCellValue());	//Writing condition message

	  	row01 = sheet.getRow(14);							//Selected 4th index row (Fifth row)
	  	c11 = row01.getCell(1);							//Selected cell (4 row,2 column)
	  	OverduePOM.clickYesMsg(driver).sendKeys(c11.getStringCellValue());	//Writing message in 'Yess message' text box

	  	row01 = sheet.getRow(15);							//Selected 5th index row (Sixth row)
	  	c11 = row01.getCell(1);							//Selected cell (5 row,2 column)
	  	OverduePOM.clickNoMsg(driver).sendKeys(c11.getStringCellValue());	//Writing message in 'No message' text box
	  		
	  	js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
	  	Thread.sleep(1500);
	  	//String workingDir = System.getProperty("user.dir");
	 // 	OverduePOM.SampleFormUpload(driver).sendKeys("C:/March2022/PerformerPom/Reports/PerformerResults.html");

	  	Thread.sleep(1000);
	  	OverduePOM.clickSaveButton(driver).click();		//Clicking on 'Save' Button
	  	Thread.sleep(500);
	  	String saveMsg1 = OverduePOM.taskSavedMsg1(driver).getText();	//Msg = Subtask Saved Successfully.

	  	test.log(LogStatus.INFO, "Message displayed - '"+ saveMsg1 +"'");
	  		
	  	driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
	  	try
	  	{
	  		Thread.sleep(700);
	  		if(OverduePOM.checkRecordsTable(driver).isDisplayed())
	  		{
	  			test.log(LogStatus.PASS, "New Sub Task added and displayed successfully.");
	  		}
	  		else
	  		{
	  			test.log(LogStatus.FAIL, "New Sub Task doesn't added and displayed.");
	  		}
	  	}
	  	catch(Exception e)
	  	{
	  		
	  	}
	  	
	  	//----------------------Edit---------------------------------------
	  	
		OverduePOM.SubTaskEdit(driver).click();	
		Thread.sleep(3000);
		OverduePOM.clickTaskTitle(driver).clear();
		Thread.sleep(1000);
		row01= sheet.getRow(16);
  		c11 = row01.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
  	OverduePOM.clickTaskTitle(driver).sendKeys(c11.getStringCellValue());
		
	Thread.sleep(2000);
  	OverduePOM.clickSaveButton(driver).click();		//Clicking on 'Save' Button
  	Thread.sleep(1000);
  	String updateMsg1 = OverduePOM.UpdateMsg(driver).getText();	//Msg = Subtask Saved Successfully.

  	test.log(LogStatus.INFO, "Message displayed - '"+ updateMsg1 +"'");
  		
  	driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
  
	//----------------------Show Assignment---------------------------------------
  	
  	OverduePOM.ClickShowAssignment(driver).click();	
  	Thread.sleep(5000);
	OverduePOM.ComplianceLocationST(driver).click();	
	Thread.sleep(1000);
	OverduePOM.ComplianceLocationACD(driver).click();	
	Thread.sleep(1000);
	OverduePOM.CLLPvt(driver).click();	
	Thread.sleep(1000);
	OverduePOM.ComplianceLocationST(driver).click();	
	Thread.sleep(1000);
	OverduePOM.ReportingLocation(driver).click();	
	Thread.sleep(1000);
	OverduePOM.ReportingLocationAB(driver).click();	
	Thread.sleep(1000);
	OverduePOM.ReportingLocationA(driver).click();	
	Thread.sleep(2000);
	OverduePOM.Startdate(driver).click();	
	Thread.sleep(1000);
	OverduePOM.date18(driver).click();	
	Thread.sleep(2000);
	OverduePOM.STPerformer(driver).click();	
	Thread.sleep(1000);
	//OverduePOM.STPerformerText(driver).sendKeys("abc External");	
	//Thread.sleep(1000);
	OverduePOM.abcExternal(driver).click();	
	Thread.sleep(4000);
	OverduePOM.Reviewer(driver).click();	
	Thread.sleep(1000);
//	OverduePOM.ReviewerText(driver).sendKeys("abc lawyer");
	Thread.sleep(2000);
	OverduePOM.abclawyer(driver).click();	
	Thread.sleep(2000);
	OverduePOM.SaveBtn(driver).click();	
	Thread.sleep(2000);
String msg=	OverduePOM.TAmsg(driver).getText();	
	Thread.sleep(2000);
	
	test.log(LogStatus.PASS, "Message displayed - "+msg);
	Thread.sleep(2000);
	OverduePOM.CloseTab(driver).click();	
	Thread.sleep(2000);
  	
	//----------------------Delete---------------------------------------
	Thread.sleep(3000);
  	OverduePOM.SubTaskDelete(driver).click();
  	Thread.sleep(1000);
  	String deleteMsg=driver.switchTo().alert().getText();
	Thread.sleep(1000);
	if(deleteMsg.equalsIgnoreCase("Are you certain you want to delete this Sub task?"))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Sub task?'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Sub task? this msg not show'");
	}
	Thread.sleep(500);
	driver.switchTo().alert().accept();	
	Thread.sleep(2000);
	String DleMsg=OverduePOM.STAfterClickDelete(driver).getText();
	if(DleMsg.equalsIgnoreCase("Sub Task can not delete, Sub task already assigned"))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Sub Task can not delete, Sub task already assigned'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Sub Task can not delete, Sub task already assignedthis msg not show'");
	}	
	Thread.sleep(2000);
	OverduePOM.BacktoTask(driver).click();
	Thread.sleep(3000);
	OverduePOM.clickDashboard(driver).click();
	Thread.sleep(4000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
