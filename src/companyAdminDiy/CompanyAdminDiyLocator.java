package companyAdminDiy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompanyAdminDiyLocator {

	private static WebElement admin = null;				//WebElement variable created for 'Categories' click
	
	private static List<WebElement> adminList = null;		
	
	public static WebElement ManageUsers(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"));
		return admin;
	}
	
	public static WebElement Users(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:14']/li[2]/a"));
		return admin;
	}
	
	public static WebElement ModifyAssignmentsLink(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnModifyAssignment_0']"));
		return admin;
	}
	
	public static WebElement DepartmentDropdown(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[8]/td[4]/span/input"));
		return admin;
	}
	
	public static WebElement ModifyAssignmentsClose(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return admin;
	}
	
	public static WebElement ModifyAssignments(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:14']/li[4]/a"));
		return admin;
	}
	
	
	public static WebElement DepartmentDropdownMA(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[4]/span/input"));
		return admin;
	}
	
	public static WebElement ManageCompliances(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"));
		return admin;
	}
	
	public static WebElement ReopeningofCompliance(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:26']/li[12]/a"));
		return admin;
	}
	
	public static WebElement ReopeninCheckBox(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='chkApprover']"));
		return admin;
	}
	
	public static WebElement ReopeninSave(WebDriver driver)		//Method for closing Message Popup
	{
		admin = driver.findElement(By.xpath("//*[@id='btnSave']"));
		return admin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
