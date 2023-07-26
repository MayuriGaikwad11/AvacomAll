package implementation;

import java.io.FileInputStream;
import java.io.IOException;
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

import companyadmin.CompanyMethods;

public class ImplementCount {
	
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
	
	
	public static String link = "Implementation";  

	public static XSSFSheet ReadExcel() throws IOException
	{
		fis = new FileInputStream("C:\\Users\\Mayuri\\Desktop\\Compliance\\AvacomAll\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(13);					//Retrieving third sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\Mayuri\\Desktop\\Compliance\\AvacomAll\\Reports\\Implementation.html",true);
		test = extent.startTest("Verify OpenBrowser");
		
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
		test = extent.startTest("Loging In - Implementation ");
		test.log(LogStatus.PASS, "Test Passed");
		
		XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
		
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
	/*
	@Test(priority = 2)
	void CustomersCreate() throws InterruptedException, IOException
	{
		test = extent.startTest("Customers Create");
		
		ImplementMethods.CreateCustomers(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void CustomersAssignment() throws InterruptedException, IOException
	{
		test = extent.startTest("Customers Assignment");
		
		ImplementMethods.CustomersAssignment(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 4)
	void SubEntity() throws InterruptedException, IOException
	{
		test = extent.startTest("Sub Entity");
		
		ImplementMethods.SubEntity(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5)
	void Department() throws InterruptedException, IOException
	{
		test = extent.startTest("Department");
		
		ImplementMethods.Department(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6)
	void Users() throws InterruptedException, IOException
	{
		test = extent.startTest("Users");
		
		ImplementMethods.Users(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 7) //not run
	void UsersandBranchUpload() throws InterruptedException, IOException
	{
		test = extent.startTest("Users");
		
		
		ImplementMethods.UserandBranchUpload(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void ProductMapping() throws InterruptedException, IOException
	{
		test = extent.startTest("Product Mapping");
		
		ImplementMethods.productMapping(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 9)
	void ModifyAssignmentsR() throws InterruptedException, IOException
	{
		test = extent.startTest("Modify Assignments - Reassign");
		
		ImplementMethods.modifyAssignmentsReassign(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 10)
	void ModifyAssignmentsExclude() throws InterruptedException, IOException
	{
		test = extent.startTest("Modify Assignments - Exclude");
	
		ImplementMethods.modifyAssignmentsExclude(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	*/
/*	@Test(priority = 11) 
	void ModifyAssignmentsTask() throws InterruptedException, IOException
	{
		test = extent.startTest("Modify Assignments - Task");
		
		ImplementMethods.modifyAssignmentsTask(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}

//	@Test(priority = 12)//not present
	void UsageReportCustomer() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Usage Report Customer");
		
		ImplementMethods.UsageReportCustomer(driver,test,"Usage Report Customer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13)
	void UsageReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Usage Report ");
		
		
		ImplementMethods.UsageReport(driver,test,"Usage Report ");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 14)
	void StatutoryAssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Other Reports - Statutory Assignment Report ");
		
		
		ImplementMethods.StatutoryAssignmentReport(driver,test,"Statutory Assignment Report ");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15)
	void CheckListAssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -  Other Reports  - CheckList Assignment Report  ");
	
		ImplementMethods.CheckListAssignmentReport(driver,test,"CheckList Assignment Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void EventBasedAssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -Other Reports - EventBased Assignment Report   ");
	
		
		ImplementMethods.EventBasedAssignmentReport(driver,test,"EventBased Assignment Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17)
	void InternalAssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -Other Reports - Internal Assignment Report   ");
		
		
		ImplementMethods.InternalAssignmentReport(driver,test,"Internal Assignment Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 18)
	void InternalCheckListAssignment() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -Other Reports - Internal CheckList Assignment Report   ");
		
		ImplementMethods.InternalCheckListAssignment(driver,test,"Internal CheckList Assignment Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 19)
	void StatutoryLabelReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Other Reports - Statutory Label Report ");
		
		
		ImplementMethods.StatutoryLabelReport(driver,test,"Statutory Label Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 20)
	void InternalLabelReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -Other Reports - Internal Label Report ");
		
		
		ImplementMethods.InternalLabelReport(driver,test,"Internal Label Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 21)
	void AllReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - All Report ");
		
		ImplementMethods.AllReport(driver,test,"All Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 22)
	void LogReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - log Report ");
	
		ImplementMethods.LogReport(driver,test,"log Report");
		
		extent.endTest(test);
		extent.flush();
	}
	*/
	
	//@Test(priority = 22) //not present 
	void CompliaceCountReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Compliace Count Report ");
		
		
		ImplementMethods.CompliaceCountReport(driver,test,"Compliace Count Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	//@Test(priority = 23)
	void ComplianceActivation() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances - Compliance Activation -Assign Compliance ");
		
		
		ImplementMethods.AssignCompliance(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 24)
	void IntermediateCompliance() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances - Compliance Activation -Intermediate Compliance ");
		
		
		ImplementMethods.IntermediateCompliance(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 25)
	void ActivateCompliance() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances- Compliance Activation -Activate Compliance  ");
		
		
		ImplementMethods.ActivateCompliance(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 26)
	void AssignCheckList() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances - Compliance Activation -Assign CheckList");
		
		
		ImplementMethods.AssignCheckList(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 27)
	void IntermediateCheckList() throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances - Compliance Activation - Intermediate CheckList ");
	
		ImplementMethods.IntermediateCheckList(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 28)
	void ActivateCheckList() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances - Compliance Activation -Activate CheckList  ");
		
		
		ImplementMethods.ActivateCheckList(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}

	//@Test(priority = 29)
	void ComplianceCategory() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances - Masters - Compliance Category  ");
		
		
		ImplementMethods.ComplianceCategory(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 30)
	void Compliances() throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances - Masters - Compliances");
		
		ImplementMethods.Compliances(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 31)
	void EditCompliances() throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances - Masters - Edit Compliances");
		
		ImplementMethods.EditCompliances(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 32)
	void UploadAssignment() throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances - Upload Utility - Upload Assignment");
		
		ImplementMethods.UploadAssignment(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 32)
	void PreviousInternalComplianceDepartmentMapping () throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances - Upload Utility - Previous Internal Compliance Department Mapping");
		
		ImplementMethods.PreviousInternalComplianceDepartmentMapping(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 33)
	void EntitiesAssignments () throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances -Entities Assignments - Entities Assignments");
		
		ImplementMethods.EntitiesAssignments(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 34)
	void LicenseEntitiesAssignments() throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances -Entities Assignments -License Entities Assignments");
		
		ImplementMethods.LicenseEntitiesAssignments(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 35)
	void MasterCompliances() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Masters - Compliances ");
		
		ImplementMethods.MasterCompliances(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 36)
	void Acts() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Masters - Acts ");
		
		ImplementMethods.Acts(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 37)
	void HolidayMaster() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Masters - Holiday Master ");
		
		ImplementMethods.HolidayMaster(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 38)
	void WidgetMaster() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Masters - Widget Master ");
		
		ImplementMethods.WidgetMaster(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 39)
	void UploadInternalCompliance() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Upload Utility - Upload Internal Compliance");
		
		ImplementMethods.UploadInternalCompliance(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 40)
	void UploadAssignmentUU() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Upload Utility - Upload Assignment");
		
		ImplementMethods.UploadAssignmentUU(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 41)
	void UploadEventBasedComplianceAssignment() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Upload Utility - Upload Event  Based Compliance Assignment");
		
		ImplementMethods.UploadEventBasedComplianceAssignment(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 42)
	void UploadAssignmentAll() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Upload Utility - Upload Assignment All");
		
		ImplementMethods.UploadAssignmentAll(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
/*	@Test(priority = 43)
	void AssignComplianceCA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Compliance Assignment - Assign Compliance");
		
		ImplementMethods.AssignComplianceCA(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 44)
	void IntermediateComplianceCA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Compliance Assignment - Intermediate Compliance");
		
		ImplementMethods.IntermediateComplianceCA(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 45)
	void ActivateComplianceCA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Compliance Assignment - Activate Compliance");
		
		ImplementMethods.ActivateComplianceCA(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 46)
	void AssignCheckListCA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Compliance Assignment -Assign CheckList");
		
		ImplementMethods.AssignCheckListCA(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 47)
	void IntermediateCheckListCA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Compliance Assignment - Intermediate CheckList");
		
		ImplementMethods.IntermediateCheckListCA(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 48)
	void ActivateCheckListCA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Compliance Assignment - Activate CheckList");
		
		ImplementMethods.ActivateCheckListCA(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 49)
	void EntitiesAssignmentsMC() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Entities Assignment - Entities Assignments");
		
		ImplementMethods.EntitiesAssignmentsMC(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 50)
	void LicenseEntitiesAssignmentsMC() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Entities Assignment - License Entities Assignments");
		
		
		ImplementMethods.LicenseEntitiesAssignmentsMC(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 51)
	void DaysBeforeDueDate() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration - Days Before Due Date");
		
		
		ImplementMethods.DaysBeforeDueDate(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 52)
	void ReOpeningofCompliance() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration - Re-Opening of Compliance");
		
		
		ImplementMethods.ReOpeningofCompliance(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 53)
	void BlockScheduleInternal() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration -Block Schedule Internal");
		
		
		ImplementMethods.BlockScheduleInternal(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 54)
	void BlockScheduleStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration - Block Schedule Statutory ");
		
		
		ImplementMethods.BlockScheduleStatutory(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}*/
/*	
	@Test(priority = 55)
	void DocumentMandatoryNonMandatory() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration - Document Mandatory Non Mandatory ");
		
		
		ImplementMethods.DocumentMandatoryNonMandatory(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 56)
	void StartDateChange() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration - Start Date Change ");
		
		
		ImplementMethods.StartDateChange(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 57)
	void ChangeDueDate() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration - Change Due Date");
		
		
		ImplementMethods.ChangeDueDate(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}*/
	
	//@Test(priority = 58)
	void CertificateFrequencyMapping() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration -Certificate Frequency Mapping");
		
		
		ImplementMethods.CertificateFrequencyMapping(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 59)
	void ClientComplianceRiskMapping() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration -Client Compliance Risk Mapping");
		
		
		ImplementMethods.ClientComplianceRiskMapping(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 60)
	void PreviousComplianceDepartmentMapping() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration -Previous  ComplianceDepartment Mapping");
		
		
		ImplementMethods.PreviousComplianceDepartmentMapping(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 61)
	void ClientFrequencyMapping() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration -Client Frequency Mapping");
		
		
		ImplementMethods.ClientFrequencyMapping(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 62)
	void ComplianceCertificate() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Masters -Compliance Certificate");
		
		
		ImplementMethods.ComplianceCertificate(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 63)
	void UsersDeptDisplay() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Masters -Compliance Certificate");
		
		
		ImplementMethods.UsersDeptDisplay(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 64)
	void Uploadeventassignment() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events -Upload event assignment");
		
		
		ImplementMethods.Uploadeventassignment(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 65)
	void Event() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - event ");
		
		
		ImplementMethods.Event(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 66)
	void Compliance() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Compliance ");
		
		
		ImplementMethods.Compliance(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 67)
	void Eventdeactivation() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event deactivation ");
		
		ImplementMethods.Eventdeactivation(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 68)
	void Eventassignments() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments ");
		
		
		ImplementMethods.Eventassignments(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 70)
	void Eventfrequencymapping() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events -Event frequency mapping");
		
		
		ImplementMethods.Eventfrequencymapping(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 71)
	void HideMulticheckchecklist() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - Customer - Add New - Hide Multicheckchecklist");
		
		
		ImplementMethods.HideMulticheckchecklist(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 72)
	void HideMulticheckchecklistEdit() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - Customer -Edit - Hide Multicheckchecklist");
		
		
		ImplementMethods.HideMulticheckchecklistEdit(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 73)
	void EventassignmentsExport() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments - Export");
		
		
		ImplementMethods.EventassignmentsExport(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 74)
	void Eventassignmentexportimport() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event");
		
		
		ImplementMethods.Eventassignmentexportimport(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 75)
	void EventassignmentexportimportD() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event");
		
		
		ImplementMethods.EventassignmentexportimportD(driver,test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 76) //21/06/2023
	void UploadedFilewithOutFile() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event - Import ");
		
		
		ImplementMethods.UploadedFilewithOutFile(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 77)
	void ImportInvalidSheet() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event - Import - Invalid data ");
		
		
		ImplementMethods.ImportInvalidSheet(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 78)
	void UploadedFileisplay() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event - Import  ");
		
		
		ImplementMethods.UploadedFileisplay(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 79)
	void UploadedFileisplayEC() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event Compliance - Import  ");
		
		
		ImplementMethods.UploadedFileisplayEC(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 80)
	void DownloadFileEC() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event Compliance - Export   ");
		
		
		ImplementMethods.DownloadFileEC(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 81)
	void UploadedEC() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event Compliance - Import   ");
		
		
		ImplementMethods.UploadedEC(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 82)
	void InValidSheet() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event Compliance - Import -Upload -Invalid File  ");
		
		
		ImplementMethods.InValidSheet(driver,test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 83)
	void Autoreconciliation() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Auto reconciliation ");
	
		ImplementMethods.Autoreconciliation(driver,test,"Auto reconciliation");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 84)
	void AutoreconciliationWC() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Auto reconciliation -Without Customer selection click on \"Export \" Button ");
	
		ImplementMethods.AutoreconciliationWC(driver,test,"Auto reconciliation");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 85)
	void ReassignmentExcludeReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -Other Reports -Reassignment Exclude Report - Selecting Customer   ");
		
		
		ImplementMethods.ReassignmentExcludeReport(driver,test,"Reassignment Exclude Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 86)
	void ReassignmentExcludeReportL() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -Other Reports -Reassignment Exclude Report - Select Customer And Location  ");
		
		
		ImplementMethods.ReassignmentExcludeReportL(driver,test,"Reassignment Exclude Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 87)
	void ReassignmentExcludeReportWC() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -Other Reports -Reassignment Exclude Report - Without Customer Selection  ");
		
		
		ImplementMethods.ReassignmentExcludeReportWC(driver,test,"Reassignment Exclude Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 88) //22/06/2023
		void Compliancetype() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal Compliances - Masters - Compliance Type  ");
			
			
			ImplementMethods.Compliancetype(driver,test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	
	//	@Test(priority = 89) 
		void Complianceassignments() throws InterruptedException, IOException
		{
			test = extent.startTest("Manage Events - Compliance assignments  ");
			
			
			ImplementMethods.Complianceassignments(driver,test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	
	//	@Test(priority = 90) 
		void Unsubscribe() throws InterruptedException, IOException
		{
			test = extent.startTest("Manage Users - Unsubscribe - with Valid Data ");
			
			
			ImplementMethods.Unsubscribe(driver,test);
			
			extent.endTest(test);
			extent.flush();
		}
	
	//	@Test(priority = 91) 
		void UnsubscribeInvalid() throws InterruptedException, IOException
		{
			test = extent.startTest("Manage Users - Unsubscribe -  with InValid Data ");
			
			
			ImplementMethods.UnsubscribeInvalid(driver,test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 92) 
		void Unsubscribe2() throws InterruptedException, IOException
		{
			test = extent.startTest("Manage Users - Unsubscribe -  Enter Comma Seperated Email Id ");
			
			
			ImplementMethods.Unsubscribe2(driver,test);
			
			extent.endTest(test);
			extent.flush();
		}
	
		
	//	@Test(priority = 93)
		void GroupingofCompliance() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance -Import - Sample Excel Format Downloaded Or not Verification");
			
			ImplementMethods.GroupingofCompliance(driver,test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 94)
		void GroupingofComplianceUploadw() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance - Import - Upload - Without Selecting Customer,ComplianceType and Group type ");
			
			ImplementMethods.GroupingofComplianceUploadw(driver,test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 95)
		void GroupingofComplianceUpload() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance -Import - Upload - Customer level wise Upload Invalid data");
			
			ImplementMethods.GroupingofComplianceUpload(driver,test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 96)
		void GroupingofComplianceUploadLL() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance - Import -Upload - Location  level wise Upload Invalid data");
			
			ImplementMethods.GroupingofComplianceUploadLL(driver,test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 97)
		void GroupingofComplianceExport() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance -Export tab  - Export");
			
			ImplementMethods.GroupingofComplianceExport(driver,test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 98)
		void GroupingofComplianceUploadValidC() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance -Import - Upload - Customer level wise Upload Valid data");
			
			ImplementMethods.GroupingofComplianceUploadValidC(driver,test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 99)
		void GroupingofComplianceUploadValidL() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance - Import -Upload - Location  level wise Upload Valid data");
			
			ImplementMethods.GroupingofComplianceUploadValidL(driver,test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 100)
		void Customerspecificduedateforstatutorycompliance() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Client Specific Configuration - Customerspecificduedateforstatutorycompliance -Sample Excel Format Downloaded Or not Verification");
			
			
			ImplementMethods.Customerspecificduedateforstatutorycompliance(driver,test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 101)
		void GroupingofComplianceUploadValidCL() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance - Import - Upload - Customer level wise Upload Valid data");
			
			ImplementMethods.GroupingofComplianceUploadValidCL(driver,test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 102)
		void GroupingofComplianceUploadValidLL() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance - Import -Upload - Location  level wise Upload Valid data");
			
			
			ImplementMethods.GroupingofComplianceUploadValidLL(driver,test);
			
			extent.endTest(test);
			extent.flush();
		}
	
	//@AfterTest
		void Closing() throws InterruptedException
		{
			Thread.sleep(1000);
			driver.close();
		}	 
	
	

}
