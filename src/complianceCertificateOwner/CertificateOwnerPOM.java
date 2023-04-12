package complianceCertificateOwner;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CertificateOwnerPOM {
	
private static WebElement owner = null;				//WebElement variable created for 'Categories' click
	
	private static List<WebElement> ownerList = null;		
	

	public static WebElement clickMyCertificate(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='leftworkspacemenuCer']/a"));
		return owner;//*[@id="leftworkspacemenuCer"]/a
	}
	
	public static WebElement CertificateOwner(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='LiCerOwnerlist']"));
		return owner;
	}
	
	public static WebElement ExporttoPDF(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[1]/div/button"));
		return owner;
	}
	
	public static WebElement View(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[8]/a[1]"));
		return owner;                       
	}
	
	
	public static WebElement CertificateOwnerPage(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='pagetype']"));
		return owner;
	}
	
	public static WebElement PeriodView(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]/a[1]"));
		return owner;
	}
	
	public static WebElement CompliancePageView(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/a"));
		return owner;
	}
	
	public static WebElement ReviewerPageView(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[12]/a"));
		return owner;
	}
	
	public static WebElement ReviewerPageViewclose(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='divOverView1']/div/div/div[1]/button"));
		return owner;
	}
	
	public static WebElement ReviewerPageExport(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='export']"));
		return owner;
	}
	
	
	public static WebElement ReviewerPageLoaction(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div/span[1]"));
		return owner;
	}
	
	public static WebElement ReviewerPageClickExpand(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//span[@class='k-icon k-i-expand']"));
		return owner;
	}
	
	public static WebElement ReviewerPageCT(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[10]"));
		return owner;
	}
	
	public static WebElement ReviewerPageClearfilterMain(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='ClearfilterMain']"));
		return owner;
	}
	
	public static WebElement ClickDownloadAll(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='btnDownloadAll']"));
		return owner;
	}
	
	public static WebElement ExporttoPDFPe(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[1]/div/button"));
		return owner;
	}
	
	public static WebElement ClickPreview(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]/a[2]"));
		return owner;
	}
	
	public static WebElement ClosePreview(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("/html/body/div[9]/div[1]/div/a"));
		return owner;
	}
	public static WebElement DwonloadDoc(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]/a[3]"));
		return owner;
	}
	
	public static WebElement Back(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='btnBack']"));
		return owner;
	}
	
	
	public static WebElement Preview(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[8]/a[2]"));
		return owner;
	}
	
	public static WebElement Previewclose(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']"));
		return owner;
	}
	
	public static WebElement Submit(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='btnSubmit']"));
		return owner;
	}
	
	public static WebElement SubmitMsg(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@class='delete-message']"));
		return owner;
	}
	
	public static WebElement SubmitYes(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.linkText("Yes"));
		return owner;
	}
	
	
	public static WebElement DownloadCertificate(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[8]/a[3]"));
		return owner;
	}
	
	public static WebElement DownloadUploadCertificate(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[8]/a[4]"));
		return owner;
	}
	
	public static WebElement EntitySubEntityLocation(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='childrow']/div/div[2]/span[1]/span/span[3]/span"));
		return owner;
	}
	
	public static WebElement ComplianceTech(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("(//span[@class='k-in'])[20]"));
		return owner;
	}
	
	
	public static WebElement CertificateOwnerview(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[4]/td[8]/a[1]"));
		return owner;
	}
	
	public static WebElement PeriodView1(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]/a[1]"));
		return owner;
	}
	
	public static WebElement PeriodDec22View1(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/a"));
		return owner;
	}
	
	public static WebElement ReopenButton(WebDriver driver)		//Method for closing Message Popup
	{
		owner = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[12]/a[2]"));
		return owner;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
