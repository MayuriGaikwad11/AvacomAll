package companyadmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompanyPOM {
	

	private static WebElement admin = null;				//WebElement variable created for 'Categories' click
					
	private static List<WebElement> adminList = null;		
	
	public static WebElement clickAdmin(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='leftApprovermenu']"));
		return admin;
	}
	
	public static WebElement clickReport(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"));
		return admin;
	}
	
	public static WebElement SelectLocationSA(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilterLocation']"));
		return admin;
	}
	
	public static WebElement Expand(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn1']/img"));
		return admin;
	}
	
	public static WebElement  DPvtLtdAS(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationt2']"));
		return admin;
	}

	public static WebElement clickStatutoryAssi(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[1]/a"));
		return admin;
	}
	
	public static WebElement clickCheckListAssi(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[2]/a"));
		return admin;
	}
	
	public static WebElement clickEventBasedAssi(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[3]/a"));
		return admin;
	}
	
	public static WebElement clickInternalAssi(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[4]/a"));
		return admin;
	}
	
	public static WebElement clickInternalCheckListAssi(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[5]/a"));
		return admin;
	}
	
	public static WebElement clickStatutoryLabelReport(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[6]/a"));
		return admin;
	}
	
	public static WebElement clickInternalLabelReport(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[7]/a"));
		return admin;
	}
	
	public static WebElement clickAllReport(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:3']/li[8]/a"));
		return admin;
	}
	
	public static WebElement clickExport(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_lbtnExportExcel']/img"));
		return admin;
	}
	
	public static WebElement ManageEvents(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[6]"));
		return admin;
	}
	
	public static WebElement EventAssignments(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:90']/li[3]"));
		return admin;
	}
	
	public static WebElement SelectLocation(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilterLocation']"));
		return admin;
	}
	
	public static WebElement  DPvtLtd(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationt2']"));
		return admin;
	}
	
	public static WebElement  ExporttoExcel(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_btnExport']/img"));
		return admin;
	}
	
	public static WebElement  SelectOwner(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_divFilterUsers']/span/a/span[1]"));
		return admin;
	}
	
	public static WebElement  abclawyer(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='ui-id-14']/li[3]"));
		return admin;
	}
	
	public static WebElement  Eventassignmentexportimport(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:90']/li[6]"));
		return admin;
	}
	
	public static WebElement  Event(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tbEvent']"));
		return admin;
	}
	
	public static WebElement  SelectEntity(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_txtEntity']"));
		return admin;
	}
	
	public static WebElement FPvtLTd(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_rptEntity_chkEntity_2']"));
		return admin;
	}
	
	public static WebElement  SelectEntityok(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_rptEntity_btnRepeater']"));
		return admin;
	}
	
	public static WebElement  Location(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));
		return admin;
	}
	
	public static WebElement  LocationExpand(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchesn0']/img"));
		return admin;
	}
	
	
	public static WebElement  ExpandFPvtLTd(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchesn1']/img"));
		return admin;
	}
	
	public static WebElement  MPvtLtd(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchesn2CheckBox']"));
		return admin;
	}
	
	public static WebElement  Select(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_btnselect']"));
		return admin;
	}
	
	public static WebElement  Download(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_BtnDownloadEvent']"));
		return admin;
	}
	
	public static WebElement  Import(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_Imp']"));
		return admin;
	}
	
	public static WebElement  ChooseFile(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_MasterFileUpload']"));
		return admin;
	}
	
	
	public static WebElement  Upload(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_btnEventUploadFile']"));
		return admin;
	}
	
	public static WebElement  BlankMsg(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return admin;
	}
	
	public static WebElement  InvalidMsg(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li/ol"));
		return admin;
	}
	
	public static WebElement  UploadLink(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_grdEventUpData_lnkDownload_0']"));
		return admin;
	}
	
	public static WebElement  EventCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tbEventCompliance']"));
		return admin;
	}
	
	public static WebElement  ImportEC(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_EventCompImp']"));
		return admin;
	}
	
	public static WebElement  UploadLinkEC(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompExData_lnkDownload_0']"));
		return admin;
	}

	public static WebElement  DownloadEC(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompExData_lnkCompDownload_1']"));
		return admin;
	}

	public static WebElement  UploadEC(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_btnEventComplianceUpload']"));
		return admin;
	}

	public static WebElement  ChooseFileEC(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_FUEventCompliance']"));
		return admin;
	}

	public static WebElement  ValidationMsg(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummaryECI']/ul/li"));
		return admin;
	}

	
	public static WebElement  InValidationMsg(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummaryECI']/ul/li/ol"));
		return admin;
	}

	
	public static WebElement  ManageUsers(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]"));
		return admin;
	}

	public static WebElement  Department(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:15']/li[1]/a"));
		return admin;
	}

	
	public static WebElement  AddNew(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddUser']"));
		return admin;
	}

	public static WebElement  DepartmentName(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_txtFName']"));
		return admin;
	}

	public static WebElement  SaveDept(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return admin;
	}
	
	public static WebElement  SaveDeptMsg(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_ctl02']/ul/li"));
		return admin;
	}
	
	public static WebElement  CloseDept(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return admin;
	}
	
	public static WebElement  DepartFilter(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return admin;
	}
	
	public static WebElement  DepartEdit(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_grdAuditor_LinkButton1_0']/img"));
		return admin;
	}
	
	public static WebElement  DepartDelete(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_grdAuditor_LinkButton2_0']/img"));
		return admin;
	}
	
	public static WebElement  User(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:15']/li[2]/a"));
		return admin;
	}
	
	public static WebElement  AddNewUser(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddUser']"));
		return admin;
	}
	
	public static WebElement  UsersEmail(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxEmail']"));
		return admin;
	}
	
	public static WebElement  UsersFirstName(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxFirstName']"));
		return admin;
	}
	
	public static WebElement  UsersLastName(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxLastName']"));
		return admin;
	}
	
	public static WebElement  UsersDesignation(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxDesignation']"));
		return admin;
	}
	
	public static WebElement  UsersMobileNo(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxContactNo']"));
		return admin;
	}
	
	public static WebElement  UsersDepartment(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_txtDepartment']"));
		return admin;
	}
	
	public static WebElement  DepartmentTech(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_rptDepartment_chkDepartment_0']"));
		return admin;
	}
	
	public static WebElement  DepartmentTechOk(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_rptDepartment_btnRepeater']"));
		return admin;
	}
	
	public static WebElement  UserComplianceRole(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlRole']"));
		return admin;
	}
	
	
	public static WebElement  UserCompanyAdmin(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlRole']/option[3]"));
		return admin;
	}
	
	public static WebElement  SelectHrRole(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlHRRole']"));
		return admin;
	}
	
	public static WebElement  HR(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlHRRole']/option[3]"));
		return admin;
	}
	
	public static WebElement  SecurityGroup(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_rptUserGroup']"));
		return admin;
	}
	
	public static WebElement  avantisGroup(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_rptUserGroup']/option[2]"));
		return admin;
	}
	
	
	public static WebElement  UserSave(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_btnSave']"));
		return admin;
	}
	
	public static WebElement  ExportUser(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_btnExport']/img"));
		return admin;
	}
	
	public static WebElement  UserEdit(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnEdit_0']/img"));
		return admin;
	}
	
	public static WebElement  ResetPass(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnReset_0']/img"));
		return admin;
	}
	
	public static WebElement  BlockScheduleStatutory(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:15']/li[8]/a"));
		return admin;
	}
	
	
	public static WebElement  ComplianceCategory(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[2]/td[2]/span[1]/a/span[1]"));
		return admin;
	}
	
	public static WebElement  ClientSpecific(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.linkText("Client Specific"));
		return admin;
	}
	
	public static WebElement   Category28May2021(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.linkText("Category 28 May 2021"));
		return admin;
	}
	
	
	public static WebElement  Description(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.id("BodyContent_tbxdescription"));
		return admin;
	}
	
	public static WebElement  BlockDate(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_tbxStartDate']"));
		return admin;
	}
	
	public static WebElement  Date14(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.linkText("14"));
		return admin;
	}
	
	public static WebElement  BlockCheckBox(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_chkActivate_0']"));
		return admin;
	}
	
	public static WebElement  keep(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_Button1']"));
		return admin;
	}
	
	public static WebElement  BlockDelete(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return admin;
	}
	
	public static WebElement  BlockScheduleInternal(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:15']/li[9]/a"));
		return admin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
