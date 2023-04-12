package arsProduct;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import complianceCertificateOwner.CertificateOwnerPOM;

public class ArsMethod {
	
	
		public static FileInputStream fis = null;	//File input stream variable
		public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
		public static XSSFSheet sheet = null;		//Sheet variable
		
		public static void AuditHead(WebDriver driver, ExtentTest test) throws InterruptedException
			 {
		
			WebDriverWait wait = new WebDriverWait(driver, (40));
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS) ;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]/a"))); 
			Thread.sleep(1000);
			ArsLocators.clickMaster(driver).click();
			Thread.sleep(1000);
			ArsLocators.UnitAssignment(driver).click();
			Thread.sleep(1000);
			ArsLocators.AddNew(driver).click();
			Thread.sleep(1000);
			ArsLocators.SelectCompany(driver).click();
			ArsLocators.Ahemdabad(driver).click();
			Thread.sleep(1000);
			ArsLocators.Ok(driver).click();
			Thread.sleep(1000);
			ArsLocators.SelectUser(driver).click();
			Thread.sleep(1000);
			ArsLocators.RichaShah(driver).click();
			Thread.sleep(1000);
			ArsLocators.SelectProcess(driver).click();
			Thread.sleep(1000);
			ArsLocators.ActionProcess(driver).click();
			Thread.sleep(1000);
			ArsLocators.ProcessOk(driver).click();
			Thread.sleep(1000);
			ArsLocators.Save(driver).click();
			Thread.sleep(1000);
			String msg = ArsLocators.Savemsg(driver).getText();
			if (msg.equalsIgnoreCase("Save successfully.")) {
				test.log(LogStatus.PASS,  "Audit Head -Add New -" +msg);
			} else {
				test.log(LogStatus.FAIL, " Audit Head -Add New -" +msg);
			}
			ArsLocators.close(driver).click();
		}
		
		
		public static void Management(WebDriver driver, ExtentTest test) throws InterruptedException
		 {
	
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS) ;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]/a"))); 
		Thread.sleep(1000);
		ArsLocators.clickMaster(driver).click();
		Thread.sleep(1000);
		ArsLocators.UnitAssignment(driver).click();
		Thread.sleep(1000);
		ArsLocators.AddNew(driver).click();
		Thread.sleep(2000);
		ArsLocators.Management(driver).click();
		Thread.sleep(4000);
		
		ArsLocators.SelectUnit(driver).click();
		Thread.sleep(1000);
		ArsLocators.AhemdabadMgmt(driver).click();
		Thread.sleep(1000);
		ArsLocators.Ok(driver).click();
		Thread.sleep(4000);
		ArsLocators.User(driver).click();
		Thread.sleep(1000);
		ArsLocators.PlantHead(driver).click();
		Thread.sleep(3000);
		ArsLocators.SelectProcessMgmt(driver).click();
		Thread.sleep(1000);
		ArsLocators.ActionProcessMgmt(driver).click();
		Thread.sleep(1000);
		ArsLocators.ProcessOk(driver).click();
		Thread.sleep(4000);
		ArsLocators.SaveMgmt(driver).click();
		Thread.sleep(1000);
		String msg = ArsLocators.SaveMgmtMsg(driver).getText();
		if (msg.equalsIgnoreCase("Save successfully.")) {
			test.log(LogStatus.PASS,  "Management -Add New -" +msg);
		} else {
			test.log(LogStatus.FAIL, " Management -Add New -" +msg);
		}
		ArsLocators.CloseMgmt(driver).click();
	}
	
		
		public static void DepartmentHead(WebDriver driver, ExtentTest test) throws InterruptedException
		 {
	
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS) ;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]/a"))); 
		Thread.sleep(1000);
		ArsLocators.clickMaster(driver).click();
		Thread.sleep(1000);
		ArsLocators.UnitAssignment(driver).click();
		Thread.sleep(1000);
		ArsLocators.AddNew(driver).click();
		Thread.sleep(2000);
		ArsLocators.DepartmentHead(driver).click();
		Thread.sleep(4000);
		
		ArsLocators.SelectUnitDpt(driver).click();
		Thread.sleep(1000);
		ArsLocators.AhemdabadDept(driver).click();
		Thread.sleep(1000);
		ArsLocators.Ok(driver).click();
		Thread.sleep(4000);
		ArsLocators.SelectUserDpt(driver).click();
		Thread.sleep(1000);
		ArsLocators.Departmenthead(driver).click();
		Thread.sleep(3000);
		ArsLocators.SelectDepartment(driver).click();
		Thread.sleep(1000);
		ArsLocators.AdminDpt(driver).click();
		Thread.sleep(1000);
		ArsLocators.ProcessOk(driver).click();
		Thread.sleep(4000);
		ArsLocators.SaveDpt(driver).click();
		Thread.sleep(1000);
		String msg = ArsLocators.SaveDptMsg(driver).getText();
		if (msg.equalsIgnoreCase("Save successfully.")) {
			test.log(LogStatus.PASS,  "Department Head -Add New -" +msg);
		} else {
			test.log(LogStatus.FAIL, " Department Head -Add New -" +msg);
		}
		ArsLocators.CloseDpt(driver).click();
	}
	
		public static void ManagementEdit(WebDriver driver, ExtentTest test) throws InterruptedException
		 {
	
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS) ;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]/a"))); 
		Thread.sleep(1000);
		ArsLocators.clickMaster(driver).click();
		Thread.sleep(1000);
		ArsLocators.UnitAssignment(driver).click();
		Thread.sleep(1000);
		ArsLocators.EditUnitAssignment(driver).click();
		Thread.sleep(1000);
		ArsLocators.ManagementEdit(driver).click();
		Thread.sleep(1000);
		
		ArsLocators.SelectUnitEditM(driver).click();
		ArsLocators.AhemdabadEditM(driver).click();
		Thread.sleep(1000);
		ArsLocators.Ok1(driver).click();
		Thread.sleep(1000);
		ArsLocators.SelectUser1M(driver).click();
		Thread.sleep(1000);
		ArsLocators.PlantHead1M(driver).click();
		Thread.sleep(1000);
		ArsLocators.SelectProcess1M(driver).click();
		Thread.sleep(1000);
		ArsLocators.ActionProcessM(driver).click();
		Thread.sleep(1000);
		ArsLocators.Ok2(driver).click();
		Thread.sleep(1000);
		ArsLocators.SelectSubUnit(driver).click();
		Thread.sleep(1000);
		ArsLocators.gujrat(driver).click();
		Thread.sleep(1000);
		ArsLocators.OkSubunit(driver).click();
		Thread.sleep(1000);
		
		ArsLocators.SaveME(driver).click();
		Thread.sleep(1000);
		String msg = ArsLocators.SaveMEMsg(driver).getText();
		if (msg.equalsIgnoreCase("Save successfully.")) {
			test.log(LogStatus.PASS,  "Management -Edit -" +msg);
		} else {
			test.log(LogStatus.FAIL, "Management -Edit -" +msg);
		}
		ArsLocators.CloseEditM(driver).click();
	}
	
		
		public static void AuditHeadEdit(WebDriver driver, ExtentTest test) throws InterruptedException
		 {
	
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS) ;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]/a"))); 
		Thread.sleep(1000);
		ArsLocators.clickMaster(driver).click();
		Thread.sleep(1000);
		ArsLocators.UnitAssignment(driver).click();
		Thread.sleep(1000);
		ArsLocators.EditUnitAssignment(driver).click();
		Thread.sleep(1000);
		ArsLocators.SelectUnitEdit(driver).click();
		ArsLocators.Ahemdabad1(driver).click();
		Thread.sleep(1000);
		ArsLocators.Ok1(driver).click();
		Thread.sleep(1000);
		ArsLocators.SelectUser1(driver).click();
		Thread.sleep(1000);
		ArsLocators.RichaShah1(driver).click();
		Thread.sleep(1000);
		ArsLocators.SelectProcess1(driver).click();
		Thread.sleep(1000);
		ArsLocators.AgroServiceDivision(driver).click();
		Thread.sleep(1000);
		ArsLocators.Ok2(driver).click();
		Thread.sleep(1000);
		ArsLocators.SaveEdit(driver).click();
		Thread.sleep(1000);
		String msg = ArsLocators.SaveEditMsg(driver).getText();
		if (msg.equalsIgnoreCase("Save successfully.")) {
			test.log(LogStatus.PASS,  "Audit Head -Edit -" +msg);
		} else {
			test.log(LogStatus.FAIL, " Audit Head -Edit -" +msg);
		}
		ArsLocators.Editclose(driver).click();
	}
		
		public static void DepartmentHeadEdit(WebDriver driver, ExtentTest test) throws InterruptedException
		 {
	
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS) ;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]/a"))); 
		Thread.sleep(1000);
		ArsLocators.clickMaster(driver).click();
		Thread.sleep(1000);
		ArsLocators.UnitAssignment(driver).click();
		Thread.sleep(1000);
		ArsLocators.EditUnitAssignment(driver).click();
		Thread.sleep(1000);
		ArsLocators.DepartmentHeadEdit(driver).click();
		Thread.sleep(1000);
		
		ArsLocators.SelectUnitDept(driver).click();
		ArsLocators.AhemdabadEditDept(driver).click();
		Thread.sleep(1000);
		ArsLocators.Ok1(driver).click();
		Thread.sleep(1000);
		ArsLocators.SelectUser1Dpt(driver).click();
		Thread.sleep(1000);
		ArsLocators.DepartmentheadDpt(driver).click();
		Thread.sleep(1000);
		ArsLocators.SelectDepartmentedit(driver).click();
		Thread.sleep(1000);
		ArsLocators.Adminedit(driver).click();
		Thread.sleep(1000);
		ArsLocators.Ok2(driver).click();
		Thread.sleep(1000);
		
		ArsLocators.DptSave(driver).click();
		Thread.sleep(1000);
		String msg = ArsLocators.DptSaveMsg(driver).getText();
		if (msg.equalsIgnoreCase("Save successfully.")) {
			test.log(LogStatus.PASS,  "Management -Edit -" +msg);
		} else {
			test.log(LogStatus.FAIL, "Management -Edit -" +msg);
		}
		ArsLocators.DptClose(driver).click();
	}
	
	
		public static void ReAssign(WebDriver driver, ExtentTest test) throws InterruptedException
		 {
	
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS) ;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]/a"))); 
		Thread.sleep(1000);
		ArsLocators.clickMaster(driver).click();
		Thread.sleep(1000);
		ArsLocators.UnitAssignment(driver).click();
		Thread.sleep(2000);
		ArsLocators.ReAssign(driver).click();
		Thread.sleep(2000);
		ArsLocators.ReAssignUser(driver).click();
		Thread.sleep(1000);
		ArsLocators.ReAsRichaShahr(driver).click();
		Thread.sleep(1000);
		ArsLocators.NewUser(driver).click();
		Thread.sleep(1000);
		ArsLocators.NewUserRS(driver).click();
		Thread.sleep(1000);
		ArsLocators.NewUserSave(driver).click();
		String Msg=driver.switchTo().alert().getText();
		
		test.log(LogStatus.PASS,  "Re-Assign-" +Msg);
		driver.switchTo().alert().accept();
		String Msg1=	ArsLocators.NewUserSaveMsg(driver).getText();
		test.log(LogStatus.PASS,  "Re-Assign-" +Msg1);
		Thread.sleep(1000);
		ArsLocators.ReAssignClose(driver).click();
		Thread.sleep(1000);
		 }
		
		
		public static void DeleteProcess(WebDriver driver, ExtentTest test) throws InterruptedException
		 {
	
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS) ;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]/a"))); 
		Thread.sleep(1000);
		ArsLocators.clickMaster(driver).click();
		Thread.sleep(1000);
		ArsLocators.UnitAssignment(driver).click();
		Thread.sleep(2000);
		ArsLocators.DeleteProcess(driver).click();
		Thread.sleep(2000);
String Msg=driver.switchTo().alert().getText();
		
		test.log(LogStatus.PASS,  "Delete Process" +Msg);
		driver.switchTo().alert().dismiss();
		
		 }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
