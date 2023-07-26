package researchReviewer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RRLocators {
	
private static WebElement researchReviewer = null;				//WebElement variable created for 'Categories' click
	
	private static List<WebElement> researchReviewerList = null;		
	
	public static WebElement clickManageCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"));
		return researchReviewer;                        
	}

	public static WebElement MinistryMaster(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[7]/a"));
		return researchReviewer;                        
	}
	
	public static WebElement MinistryMasterAddNew(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddUser']"));
		return researchReviewer;                                         
	}
	
	public static WebElement MinistryName(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_txtFName']"));
		return researchReviewer;               
	}
	
	public static WebElement Save(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return researchReviewer;                        
	}
	
	public static WebElement SaveMsg(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_ctl03']/ul/li"));
		return researchReviewer;                                        
	}
	
	public static WebElement Close(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return researchReviewer;                        
	}
	
	public static WebElement Filter(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return researchReviewer;                        
	}
	
	public static WebElement ClickEdit(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_grdAuditor_LinkButton1_0']/img"));
		return researchReviewer;                     
	}
	
	public static WebElement DeleteMinistryDetails(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_grdAuditor_LinkButton2_0']/img"));
		return researchReviewer;                        
	}
	
	public static WebElement RegulatorMaster(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[8]/a"));
		return researchReviewer;                        
	}
	
	public static WebElement RegulatorName(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_txtFName1']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActDepartmentMaster(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[9]/a"));
		return researchReviewer;                        
	}
	
	public static WebElement Act(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[2]/a"));
		return researchReviewer;                        
	}
	
	
	public static WebElement ActAddNew(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddAct']"));
		return researchReviewer;                        
	}
	
	public static WebElement Name(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_tbxName']"));
		return researchReviewer;                        
	}
	
	public static WebElement Actgroup(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_upAct']/div/div[3]/span[1]/a/span[1]"));
		return researchReviewer;                        
	}
	
	public static WebElement ActDemo(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.linkText("Act Demo1"));
		return researchReviewer;                        
	}
	
	public static WebElement ActApplicabilityRules(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_tbxdescription']"));
		return researchReviewer;                        
	}
	
	public static WebElement ShortForm(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_txtshortform']"));
		return researchReviewer;                        
	}
	
	public static WebElement CompanyType(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_txtCompanyType']"));
		return researchReviewer;                        
	}
	
	
	public static WebElement SelectAll(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_rptCompanyType_CompanyTypeSelectAll']"));
		return researchReviewer;                        
	}
	
	public static WebElement Ok(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_rptCompanyType_btnRepeaterCompanyType']"));
		return researchReviewer;                        
	}
	
	public static WebElement BusinessActivity(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_txtBusinessActivityType']"));
		return researchReviewer;                        
	}
	
	
	public static WebElement SelectAllBA(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_rptBusinessActivityType_BusinessActivityTypeSelectAll']"));
		return researchReviewer;                        
	}
	
	public static WebElement OkBA(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_rptBusinessActivityType_btnBusinessActivityType']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActApplicability(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_txtActApplicability']"));
		return researchReviewer;                        
	}
	
	public static WebElement SelectAllAA(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_rptActApplicability_ActApplicabilitySelectAll']"));
		return researchReviewer;                        
	}
	
	public static WebElement OkAA(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_rptActApplicability_btnActApplicability']"));
		return researchReviewer;                        
	}
	
	public static WebElement Type(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_upAct']/div/div[11]/span[1]/a/span[1]"));
		return researchReviewer;                        
	}
	
	public static WebElement Central(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.linkText("Central"));
		return researchReviewer;                        
	}
	
	public static WebElement Category(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_upAct']/div/div[12]/span[1]/a/span[1]"));
		return researchReviewer;                        
	}
	
	public static WebElement ClientSpecific(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.linkText("Client Specific"));
		return researchReviewer;                        
	}
	
	public static WebElement StartDate(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_tbxStartDate']"));
		return researchReviewer;                        
	}
	
	public static WebElement Industry(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_txtIndustry']"));
		return researchReviewer;                        
	}
	
	public static WebElement Agriculture(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_rptIndustry_chkIndustry_0']"));
		return researchReviewer;                        
	}
	
	public static WebElement AgricultureOk(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_rptIndustry_btnRepeater']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActDocumentType(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_upAct']/div/fieldset/div[1]/span[1]/a/span[1]"));
		return researchReviewer;                        
	}
	
	public static WebElement ActRule(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.linkText("Act / Rules / Regulations"));
		return researchReviewer;                        
	}
	
	public static WebElement File(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_ActFile_upload']"));
		return researchReviewer;                      
	}
	
	public static WebElement SaveAct(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return researchReviewer;                        
	}
	
	public static WebElement SaveActMsg(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return researchReviewer;                        
	}
	
	public static WebElement CloseAct(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return researchReviewer;                        
	}
	
	public static WebElement FilterAct(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActEdit(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_grdAct_lbtEdit_0']/img"));
		return researchReviewer;                        
	}
	
	public static WebElement Country(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_ddlcountry']"));
		return researchReviewer;                        
	}
	
	public static WebElement CountryIndia(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_ddlcountry']/option[36]"));
		return researchReviewer;                        
	}
	
	public static WebElement ClickDownload(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_GrdforFileName_lbkDownload_0']/img"));
		return researchReviewer;                        
	}
	
	public static WebElement ActDelete(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_grdAct_lbtDelete_0']/img"));
		return researchReviewer;                        
	}
	
	public static WebElement ActGroup(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[3]/a"));
		return researchReviewer;                        
	}
	
	public static WebElement ActGroupAdd(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_btnAddEvent']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActGroupName(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_txtName']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActGroupSave(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActGroupFilter(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActGroupText(WebDriver driver)		//Method for closing Message Popup
	{
		researchReviewer = driver.findElement(By.xpath("//*[@id='BodyContent_grdActGroup_Label1_0']"));
		return researchReviewer;                        
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
