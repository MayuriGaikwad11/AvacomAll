package implementation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImplementPOM {
	
	private static WebElement implement = null;				//WebElement variable created for 'Categories' click
	
	private static List<WebElement> implementList = null;		
	
	public static WebElement clickManageUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"));
		return implement;
	}

	public static WebElement clickCustomers(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[4]/a"));
		return implement;
	}
	
	public static WebElement ClickAddNew(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddCustomer']"));
		return implement;
	}
	
	public static WebElement clickServiceProvider(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_upCustomers']/div[1]/div[3]/span[3]/a/span[1]"));
		return implement;
	}
	
	public static WebElement SelectAvantis (WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='ui-id-21']"));
		return implement;
	}
	
	public static WebElement CustomerName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxName']"));
		return implement;
	}
	
	public static WebElement BuyerName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxBuyerName']"));
		return implement;
	}
	
	public static WebElement BuyerContactNo(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxBuyerContactNo']"));
		return implement;
	}
	
	public static WebElement BuyerEmail(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxBuyerEmail']"));
		return implement;
	}
	
	public static WebElement ClickSave(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_btnSave']"));
		return implement;
	}
	
	public static WebElement CustomerAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[1]/a"));
		return implement;
	}
	
	public static WebElement ClickAddNewCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddWidget']"));
		return implement;
	}
	
	public static WebElement SelectCustomer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtComplince']"));
		return implement;
	}
	
	public static WebElement SelectPerformer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlNewUsers']"));
		return implement;
	}
	
	public static WebElement SelectRT(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlNewUsers']/option[2]"));
		return implement;
	}
	
	public static WebElement SelectReviewer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlReviewerUsers']"));
		return implement;
	}
	
	
	public static WebElement SelectAA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlReviewerUsers']/option[2]"));
		return implement;
	}
	
	public static WebElement SelectIA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlReviewerUsers']/option[3]"));
		return implement;
	}
	
	public static WebElement ClickSaveCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;
	}
	
	public static WebElement FilterCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;
	}
	
	public static WebElement ClickEditCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCustomer_lbtEdit_5']"));
		return implement;
	}
	
	public static WebElement UpdateMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ctl03']/ul/li"));
		return implement;
	}
	
	public static WebElement CloseCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;
	}
	
	public static WebElement DeleteCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCustomer_lbtDelete_5']"));
		return implement;
	}
	
	public static WebElement ClickEditC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCustomer_LinkButton1_5']/img"));
		return implement;
	}
	
	public static WebElement Address(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxAddress']"));
		return implement;
	}
	
	public static WebElement Delete(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCustomer_LinkButton2_5']/img"));
		return implement;
	}
	
	public static WebElement Filter(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;
	}
	
	public static WebElement clickSubEntity(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCustomer']/tbody/tr[8]/td[10]/a"));
		return implement;
	}
	
	public static WebElement SubEntityAddNew(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddCustomerBranch']"));
		return implement;
	}
	
	public static WebElement EnterName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxName']"));
		return implement;
	}
	
	public static WebElement SubEntityType(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upCustomerBranches']/div[1]/div[4]/span[1]/a/span[1]"));
		return implement;
	}
	
	public static WebElement LegalEntity(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Legal Entity (Company)"));
		return implement;
	}//*[@id="ui-id-1661"]
	
	public static WebElement Type(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divCompanyType']/span/a/span[1]"));
		return implement;
	}
	
	public static WebElement DeemedPublicCompany(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Deemed Public Company"));
		return implement;
	}
	
	public static WebElement LLP(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Limited Liability Partnership (LLP)"));
		return implement;
	}
	
	public static WebElement Industry(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtIndustry']"));
		return implement;
	}
	
	public static WebElement ClickCheck(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rptIndustry_chkIndustry_2']"));
		return implement;
	}
	
	public static WebElement AddressLine1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxAddressLine1']"));
		return implement;
	}
	
	public static WebElement State(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divState']/span[1]/input"));
		return implement;
	}
	
	public static WebElement Maharashtra(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Maharashtra"));
		return implement;
	}
	
	public static WebElement City(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upCustomerBranches']/div[1]/div[12]/span[1]/input"));
		return implement;
	}//*[@id="BodyContent_upCustomerBranches"]/div[1]/div[12]/span[1]/input
	
	public static WebElement Anagar(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Ahmednagar"));
		return implement;
	}
	
	public static WebElement ContactPerson(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxContactPerson']"));
		return implement;
	}
	
	public static WebElement ContactEmail(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxEmail']"));
		return implement;
	}
	
	public static WebElement SaveSE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;
	}
	
	public static WebElement FilterSE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;
	}
	
	public static WebElement ClickEditSE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCustomerBranch_LinkButton1_0']/img"));
		return implement;
	}
	
	public static WebElement ClickDeleteSE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCustomerBranch_LinkButton2_0']/img"));
		return implement;
	}
	
	public static WebElement ClickExport(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_lbtnExportExcel']/img"));
		return implement;
	}                                          
	
	public static WebElement ClickDepartment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[2]/a"));
		return implement;                        
	}
	
	public static WebElement SelectCustomerDept(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divCustomerfilter']/div/span/input"));
		return implement;                        
	}
	
	public static WebElement customer123(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("customer123"));
		return implement;                        
	}
	
	public static WebElement AddNewDept(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddUser']"));
		return implement;                     
	}
	
	public static WebElement DepartmentName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtFName']"));
		return implement;                        
	}
	
	public static WebElement DepartmentSave(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                        
	}
	
	public static WebElement DepartmentClose(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                        
	}
	
	public static WebElement DepartmentSaveMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ctl02']/ul/li"));
		return implement;                        
	}
	
	public static WebElement DepartFilter(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;                        
	}
	
	public static WebElement DepartEdit(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdAuditor_LinkButton1_0']/img"));
		return implement;                        
	}
	
	public static WebElement DepartUpdateMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ctl02']/ul/li"));
		return implement;                        
	}
	
	public static WebElement DepartDelete(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdAuditor_LinkButton2_0']/img"));
		return implement;                        
	}
	
	public static WebElement ClickUserandBrach(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[5]/a"));
		return implement;                        
	}
	
	public static WebElement SelectCustomerUB(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomerList']"));
		return implement;                        
	}
	
	public static WebElement ClickUsers(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rdoBtn_User']"));
		return implement;                        
	}
	
	public static WebElement ClickModifyAssignments(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnModifyAssignment_0']"));
		return implement;                        
	}
	
	public static WebElement ModifyAssignmentsClose(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                        
	}
	
	
	public static WebElement DepartmentDropdown(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[8]/td[4]/span/input"));
		return implement;                        
	}
	
	public static WebElement ClickBranches(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rdoBtn_Branch']"));
		return implement;                        
	}
	
	public static WebElement UploadFile(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_MasterFileUpload']"));
		return implement;                        
	}
	
	public static WebElement clickUpload(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnUploadFile']"));
		return implement;                        
	}
	
	public static WebElement clickUsers(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[3]/a"));
		return implement;                        
	}
	
	public static WebElement SelectCustomerUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divCustomerfilter']/div/span/input"));
		return implement;                        
	}
	
	public static WebElement customer123Users(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("ABCD Pvt Ltd"));
		return implement;                        
	}
	
	public static WebElement UsersEmail(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxEmail']"));
		return implement;                        
	}
	
	public static WebElement UsersFirstName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxFirstName']"));
		return implement;                        
	}
	
	public static WebElement UsersLastName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxLastName']"));
		return implement;                        
	}
	
	public static WebElement UsersDesignation(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxDesignation']"));
		return implement;                        
	}
	
	
	public static WebElement UsersMobileNo(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxContactNo']"));
		return implement;                        
	}
	
	public static WebElement UsersDepartment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_txtDepartment']"));
		return implement;                        
	}
	
	public static WebElement DepartmentTech(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_rptDepartment_chkDepartment_1']"));
		return implement;                        
	}
	
	public static WebElement UserComplianceRole(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlRole']"));
		return implement;                        
	}
	
	public static WebElement UserCompanyAdmin(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlRole']/option[3]"));
		return implement;                        
	}
	
	public static WebElement UserMGMt(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlRole']/option[5]"));
		return implement;                        
	}
	
	
	public static WebElement SelectHrRole(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlHRRole']"));
		return implement;                        
	}
	
	public static WebElement HR(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlHRRole']/option[2]"));
		return implement;                        
	}
	
	public static WebElement LoginSSO(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_chkSSOAccess']"));
		return implement;                        
	}
	
	public static WebElement DesktopAccess(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_chkDesktopUserRestricted']"));
		return implement;                        
	}
	
	public static WebElement UserSave(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_btnSave']"));
		return implement;                        
	}
	
	public static WebElement UserEdit(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnEdit_0']/img"));
		return implement;                        
	}
	
	public static WebElement UserDelete(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnDelete_0']/img"));
		return implement;                        
	}
	
	public static WebElement ResetPass(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnReset_0']/img"));
		return implement;                        
	}
	
	public static WebElement SC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlCustomer']"));
		return implement;                        
	}
	
	public static WebElement ABC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlCustomer']/option[3]"));
		return implement;                        
	}
	
	public static WebElement ExportUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnExport']/img"));
		return implement;                        
	}
	
	public static WebElement SelectLocation(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxBranch']"));
		return implement;                       
	}
	
	public static WebElement Location1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tvBranchest1']"));
		return implement;                        
	}
	
	public static WebElement UsersUploadMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_vsUploadUtility']/ul/li"));
		return implement;                                     
	}
	
	public static WebElement ProductMapping(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[6]/a"));
		return implement;                                     
	}
	
	public static WebElement PMCustomer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divCustomer']/span[1]/a"));
		return implement;                                     
	}
	
	public static WebElement PMABCDPvtLtd(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("ABCD Pvt Ltd"));
		return implement;                                     
	}
	
	public static WebElement PMCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Compliance"));
		return implement;                                     
	}
	
	public static WebElement PMAddMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                                     
	}
	
	public static WebElement PMProduct(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divProduct']/span/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement PMSave(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                                     
	}
	
	public static WebElement PMClose(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                                     
	}
	
	public static WebElement PMDelete(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnDelete_0']/img"));
		return implement;                                     
	}
	
	public static WebElement ModifyAssignments(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[9]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectCustomerMA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement SelectABCD(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("ABCD Pvt Ltd"));
		return implement;                                  
	}
	
	public static WebElement SelectBitademopune(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Bitademopune"));
		return implement;                                     
	}
	
	public static WebElement SelectUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"));
		return implement;                                  
	}
	
	public static WebElement SearchUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/input"));
		return implement;                                  
	}
	
	public static WebElement SelectDevanshNew(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Devansh New"));
		return implement;                                     
	}
	
	
	public static WebElement Selectaaa(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("aaa aaa"));
		return implement;                                     
	}
	
	public static WebElement SelectASs(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("A Ss"));
		return implement;                                     
	}
	
	public static WebElement SelectNewPerformerUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement SelectPerformerabcabd(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("abc abd"));
		return implement;                                     
	}
	
	public static WebElement SelectPerformeraaaaa(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("aaa aa"));
		return implement;                                     
	}
	
	
	public static WebElement SelectNewReviewerUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[4]/span/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement Selectaaaaaad(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("aaa aaa"));
		return implement;                                     
	}
	
	public static WebElement SelectASsd(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("A Ss"));
		return implement;                                     
	}
	
	public static WebElement CheckBox0(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.id("BodyContent_grdComplianceInstances_chkCompliances_0"));
		return implement;                                                
	}
	
	public static WebElement CheckBox1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.id("BodyContent_grdComplianceInstances_chkCompliances_1"));
		return implement;                                                
	}
	
	public static WebElement CheckBox2(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceInstances_chkCompliances_2']"));
		return implement;                                    
	}
	
	public static WebElement CheckINBox0(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdInternalComplianceInstances_chkICompliances_0']"));
		return implement;                                   
	}
	
	public static WebElement CheckINBox1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdInternalComplianceInstances_chkICompliances_1']"));
		return implement;                                   
	}
	
	public static WebElement CheckINBox2(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdInternalComplianceInstances_chkICompliances_2']"));
		return implement;                                    
	}
	
	public static WebElement ClicksaveBtn(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSaveAssignment']"));
		return implement;                                     
	}
	
	public static WebElement ClickStaEventBased(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_chkEvent']"));
		return implement;                                  
	}
	
	public static WebElement ClickStaCheckList(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_chkCheckList']"));
		return implement;                                   
	}
	
	public static WebElement ClickInternalRB(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rbtSelectionType_1']"));
		return implement;                                     
	}
	
	public static WebElement ClickExclude(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rbtModifyAction_1']"));
		return implement;                                     
	}
	
	public static WebElement ClickTask(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rbtSelectType_1']"));
		return implement;                                     
	}
	
	public static WebElement ChechBoxInTask0(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdTask_chkTask_0']"));
		return implement;                                           
	}
	
	public static WebElement ChechBoxInTask1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdTask_chkTask_1']"));
		return implement;                                     
	}
	
	public static WebElement ClickReport(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"));
		return implement;                                     
	}
	
	public static WebElement UsageReportCustomer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[1]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectCustomerRe(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_DivCustomer1']/div/div/span[1]"));
		return implement;                                 
	}
	
	public static WebElement SelectABCpvtltd(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[2]"));
		return implement;                                     
	}
	
	public static WebElement FromDate(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Div31']/span/span/span/span"));
		return implement;                                     
	}
	
	public static WebElement January19(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("19"));
		return implement;                                     
	}
	
	public static WebElement ToDate(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Div41']/span/span/span/span"));
		return implement;                                     
	}
	
	public static WebElement January25(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("25"));
		return implement;                                     
	}
	
	public static WebElement ClickExportRe(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='exportReport']"));
		return implement;                                     
	}
	
	public static WebElement ClickClearBtn(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='Clearfilter']"));
		return implement;                                     
	}
	
	public static WebElement ClickUsageReport(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[2]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectCustomerUR(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomer']"));
		return implement;                               //*[@id="BodyContent_ddlCustomer"]      
	}
	public static WebElement SelectBitademopuneRE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomer']/option[2]"));
		return implement;                                    
	}
	
	public static WebElement SelectABitaPharmaCompany(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchest0']"));
		return implement;                                     
	}
	
	public static WebElement FromDateUR(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtStartDate']"));
		return implement;                                     
	}
	
	public static WebElement ToDateUR(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtEndDate']"));
		return implement;                                     
	}
	
	public static WebElement ExportToExcel(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnExportExcel']"));
		return implement;                                     
	}
	
	public static WebElement StatutoryAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[3]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectCustomerSA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlcustomer']"));
		return implement;                                     
	}
	
	public static WebElement SelectBitademopuneSA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlcustomer']/option[2]"));
		return implement;                                     
	}
	
	public static WebElement ClickExportSA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_lbtnExportExcel']/img"));
		return implement;                                     
	}
	
	public static WebElement SelectCustomerAR(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='example']/div[1]/span[1]/span/span[3]/span"));
		return implement;                                     
	}
	
	public static WebElement BitademopuneAR(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("(//*[@class='k-in'])[3]"));
		return implement;                                     
	}
	
	public static WebElement ClickApply(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='Applybtn']"));
		return implement;                                     
	}
	
	public static WebElement ClickExportLR(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='exportAdvanced']"));
		return implement;                                     
	}
	
	public static WebElement ClickClearLR(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='ClearfilterMain']"));
		return implement;                                     
	}
	
	public static WebElement CheckListAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[4]/a"));
		return implement;                                     
	}
	
	public static WebElement EventBasedAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[5]/a"));
		return implement;                                     
	}
	
	public static WebElement InternalAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[6]/a"));
		return implement;                                     
	}
	
	public static WebElement InternalCheckListAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[7]/a"));
		return implement;                                     
	}
	
	public static WebElement StatutoryLabelReport(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[8]/a"));
		return implement;                                     
	}
	
	public static WebElement InternalLabelReport(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[9]/a"));
		return implement;                                     
	}
	
	public static WebElement AllReport(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[10]/a"));
		return implement;                                     
	}
	
	public static WebElement CompliaceCountReport(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[12]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectCategory(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlfilterCatagory']"));
		return implement;                                     
	}
	
	public static WebElement Commercial(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlfilterCatagory']/option[4]"));
		return implement;                                     
	}
	
	public static WebElement SelectType(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlFilterType']"));
		return implement;                                     
	}
	
	public static WebElement Central(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlFilterType']/option[2]"));
		return implement;                                     
	}
	
	public static WebElement InternalCompliances(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"));
		return implement;                                     
	}
	
	public static WebElement ComplianceActivation(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:67']/li[3]/a"));
		return implement;                                     
	}
	
	public static WebElement AssignCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:78']/li[1]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectPerformerCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[2]/td[2]/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement SelectLocationCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilterLocation']"));
		return implement;                                     
	}//*[@id="BodyContent_tvFilterLocationn5CheckBox"]
	
	public static WebElement LocationCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn0']/img"));
		return implement;                                   
	}
	
	public static WebElement ASDAZFTextileA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationt1']"));
		return implement;                                     
	}
	
	public static WebElement ASDAZFTextileACB(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn1CheckBox']"));
		return implement;                                     
	}
	
	public static WebElement ALENAVENTURESLIMITED(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationt5']"));
		return implement;                                     
	}//*[@id="BodyContent_tvFilterLocationt1"]
	
	public static WebElement ALENAVENTURESLIMITEDCB(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn5CheckBox']"));
		return implement;                                     
	}
	
	
	public static WebElement ComplianceCategory(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[3]/td[2]/span[1]/a/span[1]"));
		return implement;                                  
	}
	
	public static WebElement ABCD(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("ABCD"));
		return implement;                                     
	}
	
	public static WebElement FEManager(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("FE Manager"));
		return implement;                                     
	}
	
	public static WebElement FMManager(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("FM Manager"));
		return implement;                                     
	}
	
	public static WebElement SelectReviewerCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[2]/td[4]/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement ClickCheckBox(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_chkAssign_0']"));
		return implement;                                     
	}
	
	public static WebElement ClickSaveBTn(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Button1']"));
		return implement;                                     
	}
	
	public static WebElement IntermediateCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:78']/li[2]/a"));
		return implement;                                     
	}
	
	public static WebElement ClickEdit(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_btnedit_2']"));
		return implement;                                   
	}
	
	public static WebElement ClickEdit1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_btnedit_0']"));
		return implement;                                   
	}
	
	public static WebElement EditUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_ddlUserList_2']"));
		return implement;              //*[@id="BodyContent_grdComplianceRoleMatrix_ddlUserList_0"]                       
	}
	
	public static WebElement EditUser1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath(" //*[@id='BodyContent_grdComplianceRoleMatrix_ddlUserList_0']"));
		return implement;                                    
	}
	
	public static WebElement CheckEdit(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_Label2_2']"));
		return implement;                                     
	}
	
	public static WebElement CheckFilter(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_Label2_0']"));
		return implement;                                     
	}
	
	public static WebElement EditUseraaaaa(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_ddlUserList_2']/option[111]"));
		return implement;                                     
	}
	
	public static WebElement EditUserFE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_ddlUserList_0']/option[106]"));
		return implement;                                  
	}
	
	public static WebElement ClickUpdate(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_btnupdate_2']"));
		return implement;                                     
	}
	
	public static WebElement ClickUpdate1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_btnupdate_0']"));
		return implement;                                     
	}
	
	
	public static WebElement ClickDelete(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_btnDelete_2']"));
		return implement;                                     
	}
	
	public static WebElement ClickDelete1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_btnDelete_0']"));
		return implement;                                     
	}
	
	public static WebElement ActivateCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:78']/li[3]/a"));
		return implement;                                     
	}
	
	public static WebElement select(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnlocation']"));
		return implement;                                     
	}
	
	public static WebElement selectDate(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxStartDate']"));
		return implement;                                     
	}
	

	public static WebElement Date11(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("11"));
		return implement;
	}
	
	public static WebElement Date2(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("2"));
		return implement;
	}
	
	public static WebElement Date4(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("4"));
		return implement;
	}
	
	
	public static WebElement ActivateCheckBox(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_chkActivate_0']"));
		return implement;                                     
	}
	
	public static WebElement ExportActivate(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_lbtnExportExcel']/img"));
		return implement;                                     
	}
	
	public static WebElement AssignCheckList(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:78']/li[4]/a"));
		return implement;                                     
	}
	
	public static WebElement IntermediateCheckList(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:78']/li[5]/a"));
		return implement;                                     
	}
	
	public static WebElement ActivateCheckList(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:78']/li[6]/a"));
		return implement;                                     
	}
		
	public static WebElement Masters(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:67']/li[1]/a"));
		return implement;                                     
	}
		
	public static WebElement MastersComplianceCategory(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:68']/li[2]/a"));
		return implement;                                     
	}
	
	public static WebElement AddNewCC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddIComplianceCategory']"));
		return implement;                                     
	}
	
	public static WebElement Customer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlcustomernew']"));
		return implement;                                     
	}
	
	public static WebElement Bitademopune(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlcustomernew']/option[2]"));
		return implement;                                     
	}
	
	public static WebElement name(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxName']"));
		return implement;                                     
	}
	
	public static WebElement Description(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxDescription']"));
		return implement;                                     
	}
	
	public static WebElement Save(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                                     
	}
	
	public static WebElement FilterM(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;                                     
	}
	
	public static WebElement NameCheck(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;                                     
	}
	
	public static WebElement EditComplianceCategory(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdIComplianceCategory_LinkButton1_0']/img"));
		return implement;                                     
	}
	
	public static WebElement DeleteComplianceCategory(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdIComplianceCategory_LinkButton2_0']/img"));
		return implement;                                     
	}
	
	public static WebElement Compliances(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:68']/li[3]/a"));
		return implement;                                     
	}
	
	public static WebElement AddNewCompliances(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddCompliance']"));
		return implement;                                     
	}
	
	public static WebElement TypeName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div[1]/div[2]/span[1]/input"));
		return implement;                                     
	}
	
	public static WebElement MaharashtraC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Maharashtra"));
		return implement;                                     
	}
	
	public static WebElement  CategoryName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div[1]/div[3]/span[1]/input"));
		return implement;                                 
	}
	
	public static WebElement AnnualMaintenanceContract(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Annual Maintenance Contract"));
		return implement;                                     
	}
	
	public static WebElement ABCDCom(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("ABCD"));
		return implement;                                     
	}
	
	public static WebElement  ShortDescription(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtShortDescription']"));
		return implement;                                     
	}
	
	public static WebElement ShortForm(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtShortForm']"));
		return implement;                                     
	}
	
	public static WebElement DetailedDescription(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtdetaileddescription']"));
		return implement;                                     
	}
	
	public static WebElement Frequency(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divFrequency']/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement Annual(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Annual"));
		return implement;                                     
	}
	
	public static WebElement FiveYearly1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("FiveYearly"));
		return implement;                                     
	}
	
	public static WebElement PriorityType(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div[1]/div[13]/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement Low(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Low"));
		return implement;                                     
	}
	
	public static WebElement SaveCom(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                                     
	}
	
	public static WebElement RecordSavemsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                                     
	}
	
	public static WebElement RecordClose(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                                     
	}
	
	public static WebElement SelectCategoryMC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlComplinceCatagory']"));
		return implement;                                     
	}
	
	public static WebElement ABCDMC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlComplinceCatagory']/option[4]"));
		return implement;                                     
	}
	
	public static WebElement FilterType(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;                                     
	}
	
	public static WebElement EditCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompliances_lbtEdit_0']/img"));
		return implement;                                     
	}
	
	public static WebElement CatName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompliances_Label11_0']"));
		return implement;                                     
	}
	
	public static WebElement DeleteCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompliances_lbtDelete_0']/img"));
		return implement;                                     
	}
	
	public static WebElement DisplayScheduleInformation(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompliances_LinkButton3_0']/img"));
		return implement;                                     
	}
	
	public static WebElement close(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                                     
	}
	
	public static WebElement SaveDsI(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSaveSchedule']"));
		return implement;                                     
	}
	
	public static WebElement DsIMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary2']/ul/li"));
		return implement;                                     
	}
	
	public static WebElement EditCompliances(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:68']/li[4]/a"));
		return implement;                                     
	}
	
	public static WebElement EditCompliancesCN(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlICategory']"));
		return implement;                                     
	}
	
	public static WebElement EditCompliancesCNA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlICategory']/option[4]"));
		return implement;                                     
	}
	
	
	public static WebElement UploadUtility(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:67']/li[2]/a"));
		return implement;                                     
	}
	
	public static WebElement UploadAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:74']/li[1]/a"));
		return implement;                                 
	}
	
	public static WebElement SelectCustomerU(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/span/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement BitademopuneU(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Bitademopune"));
		return implement;                                 
	}
	
	public static WebElement UploadFileU(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_MasterFileUpload']"));
		return implement;                                 
	}
	
	public static WebElement Upload(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnUploadFile']"));
		return implement;                                 
	}
	
	public static WebElement UploadMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                                 
	}
	
	public static WebElement PreviousInternalComplianceDepartmentMapping(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:74']/li[2]/a"));
		return implement;                                 
	}
	
	public static WebElement SelectCustomerPICDM(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlFiltercustomer']"));
		return implement;                               
	}
	
	public static WebElement ABCDPvtLtd(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlFilterCustomer']/option[4]"));
		return implement;                                
	}
	
	public static WebElement  SelectEntityLocation(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilterLocation']"));
		return implement;                              
	}
	
	public static WebElement  ExpandABCDPvtLtd(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn0']/img"));
		return implement;                            
	}
	
	public static WebElement  AWSGFJBitaLimited(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn1CheckBox']"));
		return implement;                                 
	}
	
	public static WebElement  ASDAZFTextile1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn1CheckBox']"));
		return implement;                                 
	}
	
	public static WebElement  Export(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnDownload']"));
		return implement;                                 
	}
	
	public static WebElement  InternalComplianceID(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdClient']/tbody/tr[2]/td[2]"));
		return implement;                                 
	}
	
	public static WebElement  EntitiesAssignments(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:67']/li[4]/a"));
		return implement;                                 
	}
	
	public static WebElement  EntitiesAssignments1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:86']/li[1]/a"));
		return implement;                                 
	}
	
	public static WebElement  AddNew(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddComplianceType']"));
		return implement;                                 
	}
	
	public static WebElement CustomerAE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlcustomer']"));
		return implement;                        
	}
	
	public static WebElement ABCDPvtLtdEA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlcustomer']/option[4]"));
		return implement;                               
	}
	
	public static WebElement Location(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));
		return implement;                            
	}
	
	public static WebElement LocationExpand(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchesn0']/img"));
		return implement;                                 
	}
	
	public static WebElement ASDAZFTextile(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchesn1CheckBox']"));
		return implement;                                 
	}
	
	public static WebElement selectAE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnselect']"));
		return implement;                                 
	}
	
	public static WebElement User(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upCompliance']/div/div[4]/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement User1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlUsers']"));
		return implement;                                 
	}
	
	
	public static WebElement mgmtf(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("mgmt f"));
		return implement;                          
	}
	
	public static WebElement mgmtf1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlUsers']/option[2]"));
		return implement;                          
	}
	
	
	public static WebElement ComplianceCategoryAE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_UpdatePanel2']/div/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement ComplianceCategoryAE1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlComplianceCatagory']"));
		return implement;                                 
	}
	
	public static WebElement JuneCompliance (WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("28 June Compliance Category Name"));
		return implement;                                 
	}
	
	public static WebElement SaveAE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                                 
	}
	
	public static WebElement SelectUserAE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divFilterUsers']/span/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement DeleteEntities(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_LinkButton1']"));
		return implement;                                 
	}
	
	public static WebElement DeleteCustomer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_delddlCustomer']"));
		return implement;                                 
	}
	
	public static WebElement DeleteABCDPvtLtd(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_delddlCustomer']/option[4]"));
		return implement;                                 
	}
	
	public static WebElement DeleteLocation(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_TextBox1']"));
		return implement;                                 
	}
	
	public static WebElement DeleteExpand(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_TreeView1n0']/img"));
		return implement;                                 
	}
	
	public static WebElement DeleteExpand1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_TreeView1n1']/img"));
		return implement;                                 
	}
	
	public static WebElement DeleteTextile(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_TreeView1n1CheckBox']"));
		return implement;                                 
	}
	
	public static WebElement DeleteUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_UpdatePanel3']/div/div[4]/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement DeleteUser1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_delddluser']"));
		return implement;                                 
	}
	
	public static WebElement Deletemgmtf(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_delddluser']/option[2]"));
		return implement;                                 
	}
	
	
	public static WebElement DeleteCategory(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_UpdatePanel5']/div/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement DeleteCategory1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_delddlcomcatagory']"));
		return implement;                                 
	}
	
	public static WebElement DeleteClientSpecific(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_delddlcomcatagory']/option[3]"));
		return implement;                                 
	}
	
	
	public static WebElement DeleteAE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                                 
	}
	
	public static WebElement DeleteClose(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Button3']"));
		return implement;                                 
	}
	
	public static WebElement LicenseEntitiesAssignments(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:86']/li[2]/a"));
		return implement;                                 
	}
	
	public static WebElement LicenseCustomer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divcustomer']/span/a/span[1]"));
		return implement;                            
	}
	
	public static WebElement LicenseCustomerAE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divaddcustomer']/span[1]/a/span[1]"));
		return implement;                                 
	}//*[@id="BodyContent_divaddcustomer"]/span[1]/a/span[1]
	
	public static WebElement LicenseLocation(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));
		return implement;                                 
	}//*[@id="BodyContent_TextBox1"]
	
	public static WebElement LicenseExpand(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchesn0']/img"));
		return implement;                                 
	}
	
	public static WebElement ABitaPharmaCompany(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchesn1CheckBox']"));
		return implement;                                 
	}
	
	public static WebElement selectAe(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnlocationpop']"));
		return implement;                                 
	}
	
	public static WebElement  Licenseuser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_UpdatePanel1']/div[3]/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  CFOFinance(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("CFO Finance"));
		return implement;                               
	}
	
	public static WebElement  LicenseType(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_UpdatePanel1']/div[4]/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  aaaaaa(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("aaaaaa"));
		return implement;                                 
	}
	
	public static WebElement  LicenseDeleteEntities(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btndeleteComplianceType']"));
		return implement;                                
	}
	
	public static WebElement  LicenseDeleteEntities1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Delete entities"));
		return implement;                                
	}
	
	
	public static WebElement  LicenseDeleteC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divdelcustomer']/span/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  LicenseDeleteLoc(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_TextBox1']"));
		return implement;                                 
	}
	
	public static WebElement  LicenseDeleteLocExpand(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_TreeView1n1']/img"));
		return implement;                                 
	}
	
	public static WebElement  LicenseDeleteABitPharmaCompany(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_TreeView1t2']"));
		return implement;                                 
	}
	
	public static WebElement  LicenseDeleteUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_UpdatePanel3']/div/div[4]/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	
	public static WebElement  LicenseDeleteType(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_UpdatePanel3']/div/div[5]/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  LicenseDelete(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnDelete']"));
		return implement;                                 
	}
	
	public static WebElement  LicenseDelete1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                                 
	}
	
	public static WebElement  ManageCompliances(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"));
		return implement;                                 
	}
	
	public static WebElement  MastersMC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:15']/li[1]/a"));
		return implement;                                 
	}
	
	public static WebElement  CompliancesMC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:16']/li[1]/a"));
		return implement;                                 
	}
	
	public static WebElement  ComplianceCatagory(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upCompliancesList']/table/tbody/tr[1]/td[1]/span/a/span[1]"));
		return implement;                                
	}
	
	public static WebElement  ClientSpecific(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Client Specific"));
		return implement;                                 
	}
	
	public static WebElement  ClientSpecific1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlComplianceCatagory']/option[3]"));
		return implement;                                 
	}
	
	public static WebElement  ActGroup(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upCompliancesList']/table/tbody/tr[2]/td[1]/span/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  ActDemo1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Act Demo1"));
		return implement;                                 
	}
	
	public static WebElement  CompliancesType(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upCompliancesList']/table/tbody/tr[1]/td[2]/span/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  CentralMC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Central"));
		return implement;                                 
	}
	
	public static WebElement  DisplaySchedule(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompliances_LinkButton3_0']"));
		return implement;            //*[@id="BodyContent_grdCompliances_LinkButton3_0"]                     
	}
	
	public static WebElement  DisplayScheduleClose(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                                 
	}
	
	public static WebElement  idMatch(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompliances']/tbody/tr[2]/td[1]"));
		return implement;                                 
	}
	
	public static WebElement  Acts(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:16']/li[2]/a"));
		return implement;                                 
	}
	
	public static WebElement  ActsCatrgory(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upActList']/table/tbody/tr/td[1]/span/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  ActsType(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upActList']/table/tbody/tr/td[2]/span/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  idCheck(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdAct']/tbody/tr[2]/td[1]"));
		return implement;                                 
	}
	
	public static WebElement  EditComplianceMC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompliances_lbtEdit_0']"));
		return implement;                                 
	}
	
	public static WebElement  EditComplianceClose(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                                 
	}
	
	public static WebElement  ComplianceDetails(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Compliance Details"));
		return implement;                          
	}
	
	public static WebElement  EditAct(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdAct_lbtEdit_0']"));
		return implement;                                 
	}
	
	public static WebElement  Act(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Act"));
		return implement;                                 
	}
	
	public static WebElement  EditActClose(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                                 
	}
	
	public static WebElement  HolidayMaster(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:16']/li[3]/a"));
		return implement;                              
	}
	
	public static WebElement SelectComplianceType(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlFilterComplianceType']"));
		return implement;                              
	}
	
	public static WebElement ComplianceTypeCentral(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlFilterComplianceType']/option[2]"));
		return implement;                              
	}
	
	public static WebElement AddNewHM(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddHoliday']"));
		return implement;                              
	}
	
	public static WebElement Name(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxName']"));
		return implement;                              
	}
	
	public static WebElement TypeHM(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upHoliday']/div/div[3]/span[1]/a/span[1]"));
		return implement;                              
	}
	
	public static WebElement Date(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxDate']"));
		return implement;                              
	}
	
	public static WebElement  Date15(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("15"));
		return implement;                                 
	}
	
	public static WebElement  Date16(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("16"));
		return implement;                                 
	}
	
	public static WebElement save(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                              
	}
	
	public static WebElement savemsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ctl02']/ul/li"));
		return implement;                             
	}
	
	public static WebElement Close(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                              
	}
	
	public static WebElement namecheck(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdHoliday']/tbody/tr[2]/td[2]/div/span"));
		return implement;                              
	}
	
	public static WebElement EditHoliday(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdHoliday_lbtEdit_0']/img"));
		return implement;                              
	}
	
	public static WebElement DeleteHM(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdHoliday_lbtDelete_0']/img"));
		return implement;                              
	}
	
	public static WebElement WidgetMaster(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:16']/li[4]/a"));
		return implement;                              
	}
	
	public static WebElement WidgetAddNew(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddWidget']"));
		return implement;                              
	}
	
	public static WebElement WidgetCustomer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomerNew']"));
		return implement;                              
	}
	
	public static WebElement WidgetABCDPvtLtd(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomerNew']/option[4]"));
		return implement;                              
	}
	
	public static WebElement WidgetLocation(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));
		return implement;                              
	}
	
	public static WebElement AWSGFJBitaLimited1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchest1']"));
		return implement;                              
	}
	
	public static WebElement WidgetName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxName']"));
		return implement;                              
	}
	
	public static WebElement WidgetAct(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtACTName']"));
		return implement;                              
	}
	
	public static WebElement WidgetActCheckBox(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rptActs_chkACT_0']"));
		return implement;                              
	}
	
	public static WebElement WidgetOk(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rptActs_btnRepeater']"));
		return implement;                              
	}
	
	public static WebElement WidgetCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtComplince']"));
		return implement;                              
	}
	
	public static WebElement WidgetCompliancecheck(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rptCompliances_chkcompliance_0']"));
		return implement;                              
	}
	
	public static WebElement WidgetComplianceOk(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_rptCompliances_btnRepeatersub']"));
		return implement;                              
	}
	
	public static WebElement WidgetSave(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                              
	}
	
	public static WebElement WidgetSavemsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ctl04']/ul/li"));
		return implement;                              
	}
	
   public static WebElement WidgetClose(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                              
	}
	
   public static WebElement WidgetNameCheck(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdWidget']/tbody/tr[2]/td[3]/div/span"));
  		return implement;                              
  	}
   
   public static WebElement WidgetEdit(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdWidget_lbtEdit_0']/img"));
 		return implement;                              
 	}
  	
   public static WebElement WidgetDeletet(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdWidget_lbtEdit_0']/img"));
		return implement;                              
	}
	
   public static WebElement WidgeC(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_customerdiv']"));
 		return implement;                              
 	}
   
   public static WebElement ABCDPvtLtd1(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//option[@value='29']"));
  		return implement;                              
  	}
 	
   public static WebElement UploadUtilityMC(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:15']/li[3]/a"));
 		return implement;                              
 	}
	
   public static WebElement UploadInternalCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:28']/li[1]/a"));
		return implement;                              
	}
	
   public static WebElement CustomerMC(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"));
 		return implement;         //*[@id="BodyContent_checklistcustomer"]/span[1]/a/span[1]                     
 	}
 
   public static WebElement checklistcustomer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath(" //*[@id='BodyContent_checklistcustomer']/span[1]/a/span[1]"));
		return implement;                            
	}
   
   public static WebElement UploadFileCM(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_MasterFileUpload']"));
		return implement;                              
	}
   
   public static WebElement CheckListFileUpload(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_MasterCheckListFileUpload']"));
 		return implement;                              
 	}
 	
   public static WebElement UploadMC(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnUploadFile']"));
  		return implement;                              
  	}
   
   public static WebElement ChecklistUploadFile(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnChecklistUploadFile']"));
 		return implement;                              
 	}
   	
   public static WebElement AddChecklist(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Tab3']"));
 		return implement;                              
 	}
	
   public static WebElement ReadMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                            
	}
   
   public static WebElement ReadMsg1(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary2']/ul/li"));
  		return implement;                              
  	}
   
   public static WebElement UploadAssignmentMC(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:27']/li[2]/a"));
 		return implement;                              
 	}
 
   public static WebElement UploadEventBasedComplianceAssignment(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:27']/li[3]/a"));
		return implement;                              
	}//*[@id="CMPMenuBar:submenu:27"]/li[3]/a
   
   public static WebElement UploadAssignmentAll(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:27']/li[4]/a"));
		return implement;                              
	}
	
   public static WebElement SelectCustomerUA(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/table/tbody/tr/td/table/tbody/tr[1]/td[2]/span/a/span[1]"));
  		return implement;                              
  	}
  	
   public static WebElement SelectCustomerUE(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomerList']"));
 		return implement;                              
 	}
   
   public static WebElement BitademopuneUE(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomerList']/option[2]"));
  		return implement;                              
  	}
   
   public static WebElement ComplianceAssignment(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:15']/li[4]/a"));
 		return implement;                              
 	}
 	
   public static WebElement AssignComplianceCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:34']/li[1]/a"));
		return implement;                              
	}
  
   public static WebElement ComplianceType(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[3]/td[4]/span[1]/a/span[1]"));
  		return implement;                              
  	}
   
   public static WebElement IntermediateComplianceCA(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:34']/li[2]/a"));
 		return implement;                              
 	}
   
   public static WebElement ActivateComplianceCA(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:34']/li[3]/a"));
		return implement;                              
	}
  
   public static WebElement AssignCheckListCA(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:34']/li[4]/a"));
  		return implement;                              
  	}
   
   public static WebElement IntermediateCheckListCA(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:34']/li[5]/a"));
 		return implement;                              
 	}

   public static WebElement ActivateCheckListCA(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:34']/li[6]/a"));
  		return implement;                              
  	}
   
   public static WebElement EntitiesAssignmentsMC(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:15']/li[5]/a"));
 		return implement;                              
 	}

   public static WebElement EntitiesAssignmentsMC1(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:42']/li[1]/a"));
  		return implement;                              
  	}
   
   public static WebElement LicenseEntitiesAssignments1(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:42']/li[2]/a"));
 		return implement;                              
 	}
   
   public static WebElement ClientSpecificConfiguration(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:15']/li[6]/a"));
		return implement;                              
	}
   
   public static WebElement DaysBeforeDueDate(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:46']/li[14]/a"));
		return implement;                              
	}
  
   public static WebElement CustomerDB(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='ImplementationProjectPopup']/div[1]/div/span/span/span[3]/span"));
  		return implement;                              
  	}
   
   public static WebElement test1(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("(//span[@class='k-in'])[19]"));
 		return implement;                              
 	}
	
   public static WebElement Monthly(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[2]/span"));
  		return implement;                              
  	}
   
   public static WebElement Quarterly(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[2]/td[2]/span"));
 		return implement;                              
 	}
	
   public static WebElement HalfYearly(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[3]/td[2]/span"));
		return implement;                              
	}
	
   public static WebElement Annual1(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[4]/td[2]/span"));
  		return implement;                              
  	}
	
   public static WebElement FourMonthly(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[5]/td[2]/span"));
 		return implement;                              
 	}
	
   public static WebElement TwoYearly(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[6]/td[2]/span"));
		return implement;                              
	}
   
   public static WebElement SevenYearly(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[7]/td[2]/span"));
		return implement;                              
	}
   
   public static WebElement ThreeYearly(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[8]/td[2]/span"));
  		return implement;                              
  	}
   
   public static WebElement FiveYearly(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[9]/td[2]/span"));
 		return implement;                              
 	}
   
   public static WebElement Fortnightly(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[10]/td[2]/span"));
		return implement;                              
	}
	
   public static WebElement SaveBtn(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='dvsubmit']"));
		return implement;                              
	}
   
   public static WebElement Text1(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[2]/input"));
  		return implement;                              
  	}
   
   public static WebElement Text2(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[2]/td[2]/input"));
 		return implement;                              
 	}
   
   public static WebElement Text3(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[3]/td[2]/input"));
  		return implement;                              
  	}
   
   public static WebElement Text4(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[4]/td[2]/input"));
 		return implement;                              
 	}
	
   public static WebElement Text5(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[5]/td[2]/input"));
		return implement;                              
	}
   
   public static WebElement Text6(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[6]/td[2]/input"));
		return implement;                              
	}
	
   public static WebElement Text7(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[7]/td[2]/input"));
  		return implement;                              
  	}
	
   public static WebElement Text8(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[8]/td[2]/input"));
 		return implement;                              
 	}
	
   public static WebElement Text9(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[9]/td[2]/input"));
		return implement;                              
	}
   
   public static WebElement Text10(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[10]/td[2]/input"));
		return implement;                              
	}
   
   public static WebElement ReOpeningofCompliance(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:46']/li[13]/a"));
 		return implement;                              
 	}
   
   public static WebElement CustomerReopen(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='form1']/div[3]/table/tbody/tr[3]/td/div/div[1]/span/span/span[2]/span"));
		return implement;                              
	}
	
   public static WebElement AvantisTest1(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='dropdownlistCustomer_listbox']/li[48]"));
  		return implement;                              
  	}
   
   public static WebElement ApproverCB(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='chkApprover']"));
 		return implement;                              
 	}
  	
   public static WebElement AuditorCB(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='chkAuditor']"));
  		return implement;                              
  	}
   	
   public static WebElement SaveREOpen(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='btnSave']"));
 		return implement;                              
 	}
  	
   public static WebElement BlockScheduleInternal(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:46']/li[11]/a"));
		return implement;                              
	}
 	
   public static WebElement CustomerBSI(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divc']/span[1]/a/span[1]"));
		return implement;                              
	}
   
   public static WebElement ComplianceCategoryBSI(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[2]/td[2]/span[1]/a/span[1]"));
  		return implement;                             
  	}
   
   public static WebElement DescriptionBSI(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxdescription']"));
		return implement;                              
	}
	
   public static WebElement BlockDate(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxStartDate']"));
		return implement;                              
	}
   
   public static WebElement Date14(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.linkText("7"));
 		return implement;                              
 	}
	
   public static WebElement BlockCheckBox(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_chkActivate_0']"));
		return implement;                              
	}
  
   public static WebElement keep(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Button1']"));
		return implement;                              
	}
 
   public static WebElement BlockDelete(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                              
	}
 
   public static WebElement BlockScheduleStatutory(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:46']/li[10]/a"));
  		return implement;                              
  	}
   
   public static WebElement DocumentMandatoryNonMandatory(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:46']/li[9]/a"));
 		return implement;                              
 	}
  
   public static WebElement DocumentCustomer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/table/tbody/tr[1]/td[1]/span[1]/a/span[1]"));
		return implement;                                
	}
 
   public static WebElement ExportBtn(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnDownload']"));
		return implement;                              
	}
 
   public static WebElement StartDateChange(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:46']/li[8]/a"));
  		return implement;                              
  	}
   
   public static WebElement StartDateCustomer(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upAct']/table[1]/tbody/tr[1]/td[2]/span[1]/a/span[1]"));
 		return implement;                              
 	}
	
   public static WebElement ActName(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upAct']/table[1]/tbody/tr[3]/td[2]/span[1]/a/span[1]"));
		return implement;                              
	}
	
   public static WebElement ActName1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Act as on 19052022"));
		return implement;                              
	}
   
   public static WebElement Compliance(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upAct']/table[1]/tbody/tr[4]/td[2]/span[1]/a/span[1]"));
  		return implement;                              
  	}
   
   public static WebElement Compliance1(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.linkText("Compliance as on 19052022_1"));
  		return implement;                              
  	}
	
   public static WebElement StartDateMsg(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ctl01']/ul/li"));
 		return implement;                              
 	}
  
   public static WebElement DeleteStart(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btndelete']"));
		return implement;                              
	}
 
   public static WebElement ChangeDueDate(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:46']/li[7]/a"));
 		return implement;                              
 	}
   
   public static WebElement AddNew1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddFrequency']"));
		return implement;                              
	}
   
   public static WebElement CustomerName1(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div/div[2]/span[1]/a/span[1]"));
 		return implement;                            
 	}
   
   public static WebElement ActNameDueDate(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div/div[3]/span[1]/input"));
		return implement;                              
	}
   
   public static WebElement ActNameDueDateLatest(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.linkText("Act 19122022 Latest"));
 		return implement;                              
 	}
   
   public static WebElement ShortDescription1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div/div[4]/span[1]/a/span[1]"));
		return implement;                              
	}
   
   public static WebElement ShortDescription12(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Checklist compliance as on 26122022_123"));
		return implement;                              
	}
   
   public static WebElement DueDate(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div/div[5]/span[1]/a/span[1]"));
  		return implement;                              
  	}
   
   public static WebElement DueDateSave(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
 		return implement;                              
 	}
 
   public static WebElement DueDateSaveMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_vsLicenseListPage']/ul/li"));
		return implement;                       
	}
   
   public static WebElement DueDateClose(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                              
	}

   public static WebElement ActNameText(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdClient']/tbody/tr[2]/td[3]/div/span"));
  		return implement;                              
  	}
   
   public static WebElement Edit(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdClient_lbtEdit_0']/img"));
 		return implement;                              
 	}
  
   public static WebElement DisplayScheduleInformation1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdClient_LinkButton3_0']/img"));
		return implement;                              
	}
 
   public static WebElement DisplayScheduleInformationSave(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSaveSchedule']"));
		return implement;                              
	}

   public static WebElement Choose(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_FU_Upload']"));
  		return implement;                              
  	}
   
   public static WebElement Upload1(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnUploadSave']"));
 		return implement;                              
 	}

   public static WebElement Uploadmsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_VSCompliance']/ul/li"));
		return implement;                              
	}

   public static WebElement CertificateFrequencyMapping(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:46']/li[6]/a"));
  		return implement;                              
  	}

   public static WebElement AddNewC(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddAct']"));
 		return implement;                              
 	}
   
   public static WebElement CustomerCertificate(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upAct']/div/div[2]/span[1]/a/span[1]"));
		return implement;                              
	}
   
   public static WebElement FrequencyCertificate(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlFrequency']"));
		return implement;                              
	}
  
   public static WebElement QuarterlyCertificate(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlFrequency']/option[3]"));
  		return implement;                              
  	}
    
   public static WebElement DueDateCertificate(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlDueDate']"));
 		return implement;                              
 	}
   
   public static WebElement DueDateCertificate3(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlDueDate']/option[3]"));
		return implement;                              
	}
   
   public static WebElement SaveCertificate3(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
  		return implement;                              
  	}
   
   public static WebElement CloseCertificate3(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
 		return implement;                              
 	}
   
   public static WebElement CertificateMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ctl02']/ul/li"));
		return implement;                              
	}

   public static WebElement CertificateEdit(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCertificateFrequency_lbtEdit_0']/img"));
  		return implement;                              
  	}
   
   public static WebElement graceperiod(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ChkGracePeriodTwo']"));
 		return implement;                              
 	}
   
   public static WebElement ClientComplianceRiskMapping(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:46']/li[5]/a"));
		return implement;                              
	}
   
   public static WebElement ClientCustomer(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"));
  		return implement;                              
  	}//*[@id="BodyContent_upComplianceTypeList"]/table/tbody/tr[1]/td[1]/span[1]/a/span[1]
   
   public static WebElement SelectComplianceTypeC(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlComplinceType']"));
 		return implement;                              
 	}
  
   public static WebElement Statutory(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlComplinceType']/option[2]"));
  		return implement;                              
  	}
   
   public static WebElement ClientRisk(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompliances_ddlrisk_0']"));
 		return implement;                              
 	}
   
   public static WebElement ClientRiskMedium(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompliances_ddlrisk_0']/option[3]"));
		return implement;                              
	}
   
   public static WebElement ClientCheckBox(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompliances_Chkselection_0']"));
 		return implement;                              
 	}
   
   public static WebElement ClientSave(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                              
	}
   
   public static WebElement ClientSaveMsg(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
  		return implement;                              
  	}
    
   public static WebElement ExportClient(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnExport']/img"));
 		return implement;                              
 	}
   
   public static WebElement PreviousComplianceDepartmentMapping(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:46']/li[4]/a"));
		return implement;                              
	}
   
   public static WebElement PreviousExport(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnDownload']"));
  		return implement;                              
  	}
   
   public static WebElement ClientFrequencyMapping(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:46']/li[3]/a"));
 		return implement;                              
 	}
   
   public static WebElement AddNewCF(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddFrequency']"));
		return implement;                              
	}
   
   public static WebElement ClientFrequency(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div/div[6]/span[1]/a/span[1]"));
 		return implement;                              
 	}
   
   public static WebElement ClientFrequencyEdit(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdClient_lbtEdit_0']/img"));
		return implement;                              
	}
  
   public static WebElement ClientFrequencyDelete(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdClient_lbtDelete_0']/img"));
  		return implement;                              
  	}
   
   public static WebElement SampleFormatCF(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/table/tbody/tr[2]/td[4]/u/a"));
 		return implement;                              
 	}
   
   public static WebElement UploadMeg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ctl01']/ul/li"));
		return implement;                              
	}
   
   public static WebElement TemplateMsg(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ctl02']/ul/li"));
  		return implement;                              
  	}

   public static WebElement ComplianceCertificate(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:16']/li[5]/a"));
 		return implement;                              
 	}
    
   public static WebElement CustomerCC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomerFilter']"));
		return implement;                              
	}
   
   public static WebElement BitaConsultingPvtLtd(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomerFilter']/option[2]"));
 		return implement;                              
 	}
    
   public static WebElement CCAddNew(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddAct']"));
		return implement;                              
	}
   
   public static WebElement TemplateField(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlContractTemplate']"));
  		return implement;                              
  	}
   
   public static WebElement CompliedStatutoryChecklist(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlContractTemplate']/option[2]"));
 		return implement;                              
 	}
   
   public static WebElement FromDateCC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFromDate']"));
		return implement;                              
	}
    
   public static WebElement EndDateCC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxEndDate']"));
		return implement;                              
	}
   
   public static WebElement SaveCC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                              
	}
   
   public static WebElement DownloadCC(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_Button1']"));
  		return implement;                              
  	}
   
   public static WebElement CloseCC(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='form1']/div[5]/div[1]/button/span[1]"));
 		return implement;                              
 	}
     
   public static WebElement EditCC(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdTemplate_lbtEdit_0']/img"));
		return implement;                              
	}
   
   public static WebElement BranchName(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlContractTemplate']/option[2]"));
  		return implement;                              
  	}
   
   public static WebElement DeleteCC(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdTemplate_lbtDelete_0']/img"));
 		return implement;                              
 	}
      
   public static WebElement ManageEvents(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]"));
		return implement;                              
	}
     
   public static WebElement Uploadeventassignment(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:106']/li[1]/a"));
  		return implement;                              
  	}
       
   public static WebElement SelectCustomerEvent(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomerList']"));
 		return implement;                              
 	}
      
   public static WebElement EventABCDPvtLtd(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomerList']/option[4]"));
		return implement;                              
	}
     
   public static WebElement UploadFileEvent(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_MasterFileUpload']"));
  		return implement;                              
  	}
   
   public static WebElement UploadEvent(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnUploadFile']"));
 		return implement;                              
 	}
   
   public static WebElement UploadEventMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                              
	}
  
   public static WebElement Event(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:106']/li[2]/a"));
  		return implement;                              
  	}
   
   public static WebElement EditEvent(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdEventList_lbtEdit_0']/img"));
 		return implement;                              
 	}
   
   public static WebElement DescriptionEvent(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_txtDescription']"));
		return implement;                              
	}
   
   public static WebElement EventSave(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
  		return implement;                              
  	}
     
   public static WebElement EventClose(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
 		return implement;                              
 	}
    
   public static WebElement DeleteEvent(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdEventList_lbtDelete_0']/img"));
		return implement;                              
	}
   
   public static WebElement DeleteEventMsg(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_updivSubEventDelete']/div[2]"));
  		return implement;                              
  	}
   
   
   public static WebElement DeleteEventClose(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnCloseSubEvent']"));
 		return implement;                              
 	}
  
   public static WebElement ComplianceEvent(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:106']/li[3]/a"));
		return implement;                              
	}
 
   public static WebElement ComplianceCategoryEvent(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upCompliancesList']/table/tbody/tr[1]/td[1]/span/a/span[1]"));
  		return implement;                              
  	}
   
   public static WebElement CommercialEvent(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.linkText("Commercial"));
 		return implement;                              
 	} 
   
   public static WebElement EditCompliance1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCompliances_lbtEdit_0']/img"));
		return implement;                              
	} 
   
   public static WebElement StartDate(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxStartDate']"));
  		return implement;                              
  	} 
     
   public static WebElement CloseCompliance1(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
 		return implement;                              
 	} 
    
   public static WebElement Eventdeactivation(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:106']/li[4]/a"));
		return implement;                              
	} 
   
   public static WebElement Customerdeactivation(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upEvent']/table[1]/tbody/tr[1]/td[2]/span[1]/a"));
  		return implement;                              
  	} 
     
   public static WebElement SelectLocationdea(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilterLocation']"));
 		return implement;                            
 	} 
    
   public static WebElement ExpandABCDPvtLtd1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn0']/img"));
		return implement;                              
	} 
   
   public static WebElement ABCDAurangabadPvt(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationt4']"));
  		return implement;                              
  	} 
   
   public static WebElement EventName(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upEvent']/table[1]/tbody/tr[3]/td[2]/span[1]/a/span[1]"));
 		return implement;                              
 	} 
   
   public static WebElement Amendmentfactorylicense(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Amendment in factory license"));
		return implement;                              
	} 
   
   public static WebElement EventNature(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upEvent']/table[1]/tbody/tr[4]/td[2]/span[1]/a/span[1]"));
  		return implement;                              
  	} 
   
   public static WebElement Licenseeventtest(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.linkText("License event test"));
 		return implement;                              
 	} 
  
   public static WebElement keep1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnKeep']"));
		return implement;                              
	} 
 
   public static WebElement Delete1(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btndelete']"));
  		return implement;                              
  	} 
   
   public static WebElement Eventassignments(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:106']/li[5]/a"));
 		return implement;                              
 	} 
   
   public static WebElement AddNewEvent(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAssigncompliances']"));
		return implement;                              
	} 
   
   public static WebElement EventClassification(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_UpdatePanel1']/div[1]/span[1]/a/span[1]"));
  		return implement;                            
  	} 
   
   public static WebElement Secretarial(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.linkText("Secretarial"));
 		return implement;                              
 	} 
  
   public static WebElement CustomerAssignE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomerNew']"));
		return implement;                            
	} 
   
   public static WebElement CustomerABCD(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomerNew']/option[4]"));
  		return implement;                              
  	} 
     
   public static WebElement LocationAssignE(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));
 		return implement;                              
 	} 
   
   public static WebElement ExpandABCDPvtLtdAE(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchesn0']/img"));
		return implement;                              
	} 
   
   public static WebElement APvtltd(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchest1']"));
		return implement;                              
	} 
   
   public static WebElement SelectEventPerformer(WebDriver driver)		//Method for closing Message Popup
  	{
  		implement = driver.findElement(By.xpath("//*[@id='BodyContent_UpdatePanel1']/div[4]/span/input"));
  		return implement;                              
  	} 
   
   public static WebElement PerfomUser(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.linkText("Perfom User"));
 		return implement;                              
 	} 
   
   public static WebElement SelectEventReviewer(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_divEvReviewer']/span/input"));
 		return implement;                              
 	} 
  
  public static WebElement ReviewerUser(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Reviewer User"));
		return implement;                              
	} 
  
  public static WebElement eventcheckbox(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdEventInstance_chkEvent_0']"));
		return implement;                              
	} 
   
  public static WebElement SaveEvent(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                              
	} 
   
  public static WebElement AssignCompliance1(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnComplianceList']"));
 		return implement;                              
 	} 
    
  public static WebElement AssignComplianceReviewer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upCompliance']/table/tbody/tr[2]/td[2]/span[1]/input"));
		return implement;                              
	} 
   
  public static WebElement AssignCompliancePerformer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upCompliance']/table/tbody/tr[1]/td[4]/span[1]/input"));
		return implement;                              
	} 
   
  public static WebElement AssignComplianceCheckBox(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_gvComplianceListAssign_chkComplianceCheck']"));
 		return implement;                              
 	} 
   
  public static WebElement AssignComplianceSave(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_SaveComplianceList']"));
		return implement;                              
	} 
 
  public static WebElement Complianceassignments(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:106']/li[6]/a"));
 		return implement;                              
 	} 
  
  public static WebElement Eventfrequencymapping(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:106']/li[7]/a"));
		return implement;                              
	} 
   
  public static WebElement AddNewEFM(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddEFM']"));
 		return implement;                              
 	} 
   
  public static WebElement CustomerEFM(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upEFM_Dialog']/div[1]/div[2]/span[1]/a/span[1]"));
		return implement;                              
	} 
 
  public static WebElement EventClassification1(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlEventClassification']"));
 		return implement;                              
 	} 
   
  public static WebElement Secretarial1(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlEventClassification']/option[3]"));
		return implement;                              
	} 
  
  public static WebElement EventNameEFM(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_upEFM_Dialog']/div[1]/div[4]/span[1]/a/span[1]"));
 		return implement;                              
 	} 
   
  public static WebElement AlterationinArticle(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.linkText("Alteration in Articles (Public Company)"));
		return implement;                              
	} 
  
  public static WebElement FrequencyEFM(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlFrequency']"));
		return implement;                              
	} 

  public static WebElement QuarterlyEFM(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlFrequency']/option[3]"));
 		return implement;                              
 	} 
  
  public static WebElement MonthlyEFm(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlFrequency']/option[2]"));
		return implement;                              
	} 

  public static WebElement SaveMsg(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                              
	} 

  public static WebElement EditConfiguration(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdEventFrequencyMap_lbtEdit_0']/img"));
		return implement;                              
	} 

  public static WebElement DeleteConfiguration(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdEventFrequencyMap_lbtDelete_0']/img"));
 		return implement;                              
 	} 
  
  public static WebElement DisplayScheduleInformationEFM(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdEventFrequencyMap_lbtShowShedule_0']/img"));
		return implement;                              
	} 

  public static WebElement DSIEditConfiguration(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grvEFM_Schedule_lbtEdit_0']/img"));
		return implement;                              
	} 
  
  public static WebElement ScheduleDate(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grvEFM_Schedule_tbxDueDate_0']"));
 		return implement;                              
 	} 
  
  public static WebElement UpdateConfiguration(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grvEFM_Schedule_lbtUpdate_0']/img"));
		return implement;                              
	} 

  public static WebElement CancelConfiguration(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grvEFM_Schedule_lbtCancel_0']/img"));
 		return implement;                              
 	} 
  
  public static WebElement DisplayScheduleInformationEFMClopse(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='form1']/div[6]/div[1]/button/span[1]"));
 		return implement;                              
 	} 
  
  public static WebElement ChooseFile(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_FU_Upload']"));
		return implement;                              
	} 

  public static WebElement UploadEFM(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnUpload']"));
 		return implement;                              
 	} 
  
  public static WebElement selectCustomer(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomerFilter']"));
		return implement;                              
	} 

  public static WebElement ABCDPvtLtdEFM(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ddlCustomerFilter']/option[3]"));
 		return implement;                              
 	} 

  public static WebElement UploadMsgEFM(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_ctl01']/ul/li"));
		return implement;                              
	} 

  public static WebElement SampleFormat(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_up_EFM']/table/tbody/tr/td[5]/u/a"));
		return implement;                              
	} 
  
  public static WebElement HideMulticheckchecklist(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlChecklistHide']"));
 		return implement;                              
 	} 
   
  public static WebElement HideMulticheckchecklistYes(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlChecklistHide']/option[1]"));
		return implement;                              
	} 
 
  public static WebElement HideMulticheckchecklistNo(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlChecklistHide']/option[2]"));
 		return implement;                              
 	} 
  
  public static WebElement HideMulticheckchecklistEdit(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='BodyContent_grdCustomer_LinkButton1_0']/img"));
		return implement;                              
	} 

  public static WebElement DownloadExcelFormat(WebDriver driver)		//Method for closing Message Popup
 	{
 		implement = driver.findElement(By.xpath("//*[@id='BodyContent_btnExcelFormat']"));
 		return implement;                              
 	} 

  public static WebElement LogReport(WebDriver driver)		//Method for closing Message Popup
	{
		implement = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:90']/li[4]/a"));
		return implement;                           
	} 

   
   
   
	
	
	
	
	
	
	
	
	
	
}
