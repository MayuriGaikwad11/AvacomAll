package arsProduct;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArsLocators {
	
private static WebElement ars = null;				//WebElement variable created for 'Categories' click
	
	private static List<WebElement> arsList = null;		
	

	public static WebElement clickARS(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='dvbtnAudit']"));
		return ars;
	}
	
	public static WebElement clickMaster(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]/a"));
		return ars;
	}
	
	public static WebElement UnitAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:5']/li[8]/a"));
		return ars;
	}
	
	public static WebElement AddNew(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddComplianceType']"));
		return ars;
	}
	
	public static WebElement SelectCompany(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLegalEntityAuditHeadPopPup_sl']"));
		return ars;
	}
	
	public static WebElement Ahemdabad(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLegalEntityAuditHeadPopPup_0']"));
		return ars;
	}
	
	public static WebElement Ok(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='buttons']/input[1]"));
		return ars;
	}
	
	public static WebElement SelectUser(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlAuditHeadUsers_chosen']/a/span"));
		return ars;
	}
	
	public static WebElement RichaShah(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlAuditHeadUsers_chosen']/div/ul/li[2]"));
		return ars;
	}
	
	public static WebElement SelectProcess(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlProcessAuditHead_sl']"));
		return ars;
	}
	
	public static WebElement ActionProcess(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlProcessAuditHead_1']"));
		return ars;
	}
	
	public static WebElement ProcessOk(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("(//*[@id='buttons']/input[1])[6]"));
		return ars;
	}
	
	public static WebElement Save(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAuditHeadSave']"));
		return ars;
	}
	
	public static WebElement Savemsg(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_AuditHeadValidationSummary']/ul/li"));
		return ars;
	}
	
	public static WebElement close(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnClose']"));
		return ars;
	}
	
	public static WebElement Management(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnTabManagement']"));
		return ars;
	}
	
	public static WebElement SelectUnit(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLegalEntityManagementPopPup_sl']"));
		return ars;
	}
	
	
	public static WebElement AhemdabadMgmt(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLegalEntityManagementPopPup_0']"));
		return ars;
	}
	
	public static WebElement User(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlManagementUsers_chosen']/a"));
		return ars;
	}
	
	public static WebElement PlantHead(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlManagementUsers_chosen']/div/ul/li[2]"));
		return ars;
	}
	
	public static WebElement SelectProcessMgmt(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlProcessManagement_sl']"));
		return ars;
	}
	
	public static WebElement ActionProcessMgmt(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlProcessManagement_1']"));
		return ars;
	}

	public static WebElement SaveMgmt(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnManagementSave']"));
		return ars;
	}

	public static WebElement SaveMgmtMsg(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ManagementValidationSummary']/ul/li"));
		return ars;
	}
	
	public static WebElement CloseMgmt(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCloseManagement']"));
		return ars;
	}
	
	public static WebElement DepartmentHead(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnTabDepartmentHead']"));
		return ars;
	}

	
	public static WebElement SelectUnitDpt(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLegalEntityDepartmentHeadPopPup_sl']"));
		return ars;
	}
	
	public static WebElement AhemdabadDept(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLegalEntityDepartmentHeadPopPup_0']"));
		return ars;
	}

	public static WebElement SelectUserDpt(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartmentHeadUsers_chosen']/a"));
		return ars;
	}
	
	public static WebElement Departmenthead(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartmentHeadUsers_chosen']/div/ul/li[2]"));
		return ars;
	}
	
	public static WebElement SelectDepartment(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartment_sl']"));
		return ars;
	}
	
	public static WebElement AdminDpt(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartment_0']"));
		return ars;
	}
	
	
	public static WebElement SaveDpt(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnDepartmentHeadSave']"));
		return ars;
	}
	
	public static WebElement SaveDptMsg(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_DepartmentHeadValidationSummary']/ul/li"));
		return ars;
	}
	
	public static WebElement CloseDpt(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCloseDepartmentHead']"));
		return ars;
	}
	
	public static WebElement EditUnitAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddComplianceTypeEdit']"));
		return ars;
	}
	
	public static WebElement SelectUnitEdit(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLegalEntityAuditHeadPopPupEdit_sl']"));
		return ars;
	}
	
	public static WebElement Ahemdabad1(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLegalEntityAuditHeadPopPupEdit_0']"));
		return ars;
	}
	
	public static WebElement Ok1(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("(//*[@id='buttons']/input[1])[19]"));
		return ars;
	}

	public static WebElement SelectUser1(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlAuditHeadUsersEdit_chosen']/a"));
		return ars;
	}

	public static WebElement RichaShah1(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlAuditHeadUsersEdit_chosen']/div/ul/li[2]"));
		return ars;
	}

	public static WebElement SelectProcess1(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlProcessAuditHeadEdit_sl']"));
		return ars;
	}
	
	public static WebElement AgroServiceDivision(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlProcessAuditHeadEdit_1']"));
		return ars;
	}
	
	public static WebElement Ok2(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("(//*[@id='buttons']/input[1])[24]"));
		return ars;
	}

	public static WebElement SaveEdit(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAuditHeadSaveEdit']"));
		return ars;
	}
	
	public static WebElement SaveEditMsg(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_AuditHeadValidationSummaryEdit']/ul/li"));
		return ars;
	}
	
	public static WebElement Editclose(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCloseEdit']"));
		return ars;
	}
	
	public static WebElement ManagementEdit(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnTabManagementEdit']"));
		return ars;
	}
	
	public static WebElement SelectUnitEditM(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLegalEntityManagementPopPupEdit_sl']"));
		return ars;
	}
	
	public static WebElement AhemdabadEditM(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLegalEntityManagementPopPupEdit_0']"));
		return ars;
	}

	public static WebElement SelectUser1M(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlManagementUsersEdit_chosen']/a"));
		return ars;
	}
	
	public static WebElement PlantHead1M(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlManagementUsersEdit_chosen']/div/ul/li[2]"));
		return ars;
	}
	
	public static WebElement SelectProcess1M(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlProcessManagementEdit_sl']"));
		return ars;
	}
	
	public static WebElement ActionProcessM(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlProcessManagementEdit_1']"));
		return ars;
	}
	
	public static WebElement SaveME(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnManagementSaveEdit']"));
		return ars;
	}

	public static WebElement SaveMEMsg(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ManagementValidationSummaryEdit']/ul/li"));
		return ars;
	}

	public static WebElement SelectSubUnit(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlSubEntity1ManagementPopPupEdit_sl']"));
		return ars;
	}
	
	public static WebElement gujrat(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlSubEntity1ManagementPopPupEdit_0']"));
		return ars;
	}
	
	public static WebElement OkSubunit(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("(//*[@id='buttons']/input[1])[20]"));
		return ars;
	}

	public static WebElement CloseEditM(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCloseManagementEdit']"));
		return ars;
	}
	
	public static WebElement DepartmentHeadEdit(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnTabDepartmentHeadEdit']"));
		return ars;
	}
	
	public static WebElement SelectUnitDept(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLegalEntityDepartmentHeadPopPupEdit_sl']"));
		return ars;
	}
	
	public static WebElement AhemdabadEditDept(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLegalEntityDepartmentHeadPopPupEdit_0']"));
		return ars;
	}
	
	public static WebElement SelectUser1Dpt(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartmentHeadUsersEdit_chosen']/a"));
		return ars;
	}
	
	public static WebElement DepartmentheadDpt(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartmentHeadUsersEdit_chosen']/div/ul/li[2]"));
		return ars;
	}
	
	public static WebElement SelectDepartmentedit(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartmentEdit_sl']"));
		return ars;
	}
	
	public static WebElement Adminedit(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartmentEdit_0']"));
		return ars;
	}
	
	public static WebElement DptSave(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnDepartmentHeadSaveEdit']"));
		return ars;
	}
	
	public static WebElement DptSaveMsg(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_DepartmentHeadValidationSummaryEdit']/ul/li"));
		return ars;
	}
	
	public static WebElement DptClose(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCloseDepartmentHeadEdit']"));
		return ars;
	}
	
	public static WebElement ReAssign(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnReAssign']"));
		return ars;
	}
	
	public static WebElement ReAssignUser(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlUser_chosen']/a"));
		return ars;
	}
	
	public static WebElement ReAsRichaShahr(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlUser_chosen']/div/ul/li[2]"));
		return ars;
	}
	
	public static WebElement NewUser(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdReassign_ddlGridReAssignUser_0_chosen']/a"));
		return ars;
	}
	
	public static WebElement NewUserRS(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdReassign_ddlGridReAssignUser_0_chosen']/div/ul/li[2]"));
		return ars;
	}
	
	public static WebElement NewUserSave(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnReassignEvent']"));
		return ars;
	}
	
	public static WebElement ReAssignClose(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnReassignClose']"));
		return ars;
	}
	
	public static WebElement NewUserSaveMsg(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_VSReassignSummary']/ul/li"));
		return ars;
	}
	
	public static WebElement DeleteProcess(WebDriver driver)		//Method for closing Message Popup
	{
		ars = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdAssignEntities_lbtDelete_0']/img"));
		return ars;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
