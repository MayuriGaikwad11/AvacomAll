package complianceCertificateMgmt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import complianceCertificateOwner.CertificateOwnerPOM;
import complianceCertificateReviewer.ComplianceCertificateReviewerMethod;

public class ComplianceCertificateMgmtMethod {
	public static FileInputStream fis = null;
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;	
private static WebElement Mgmt = null;				//WebElement variable created for 'Categories' click
	
public static WebElement ClickShowAll(WebDriver driver)		//Method for closing Message Popup
{
	Mgmt = driver.findElement(By.xpath("//*[@id='lnkCertificateofficer']"));
	return Mgmt;
}

public static WebElement ClickShowAllClose(WebDriver driver)		//Method for closing Message Popup
{
	Mgmt = driver.findElement(By.xpath("//*[@id='divreports']/div/div/div[1]/button"));
	return Mgmt;
}


public static WebElement ComplianceTech(WebDriver driver)		//Method for closing Message Popup
{
	Mgmt = driver.findElement(By.xpath("(//span[@class='k-in'])[19]"));
	return Mgmt;
}

public static WebElement View1(WebDriver driver)		//Method for closing Message Popup
{
	Mgmt = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[7]/a[1]"));
	return Mgmt;//*[@id="grid"]/div[3]/table/tbody/tr/td[6]/a
}

public static WebElement View2(WebDriver driver)		//Method for closing Message Popup
{
	Mgmt = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/a"));
	return Mgmt;
}

public static WebElement EntitySubEntityLocation(WebDriver driver)		//Method for closing Message Popup
{
	Mgmt = driver.findElement(By.xpath("//*[@id='form1']/div[3]/span[1]/span/span[1]"));
	return Mgmt;
}

public static WebElement EntitySubEntityLocation1(WebDriver driver)		//Method for closing Message Popup
{
	Mgmt = driver.findElement(By.xpath("//*[@id='form1']/div[4]/div[1]/div/span[1]"));
	return Mgmt;
}

public static void ComplianceCertificate(WebDriver driver, ExtentTest test)
		throws InterruptedException, IOException {

	WebDriverWait wait = new WebDriverWait(driver, (40));
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,3600)");					//Scrolling down window by 2600 px.
	Thread.sleep(1000);
	ClickShowAll(driver).click();
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
    Thread.sleep(5000);
	File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

	Thread.sleep(1000);
	CertificateOwnerPOM.ExporttoPDF(driver).click(); // Exporting (Downloading) file

	Thread.sleep(3000);
	File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents.length < allFilesNew.length) {
		test.log(LogStatus.PASS,  "  File downloaded successfully.");
	} else {
		test.log(LogStatus.FAIL, "  File does not downloaded.");
	}
	
	CertificateOwnerPOM.Preview(driver).click();
	Thread.sleep(4000);
	CertificateOwnerPOM.Previewclose(driver).click();
	Thread.sleep(3000);

test.log(LogStatus.PASS,  "Preview successfully. " );

File dir2 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download


CertificateOwnerPOM.DownloadCertificate(driver).click(); // Exporting (Downloading) file


File dir3 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
Thread.sleep(3000);
if (dirContents1.length < allFilesNew1.length) {
	test.log(LogStatus.PASS,  "Download Certificate - File downloaded successfully.");
} else {
	test.log(LogStatus.FAIL, "  File does not downloaded.");
}

EntitySubEntityLocation(driver).click();
Thread.sleep(2000);
ComplianceTech(driver).click();
Thread.sleep(3000);
CertificateOwnerPOM.ReviewerPageClearfilterMain(driver).click();
Thread.sleep(3000);

test.log(LogStatus.PASS,  " Clear Filter Working successfully." );
driver.switchTo().parentFrame();
Thread.sleep(4000);

ClickShowAllClose(driver).click();
Thread.sleep(4000);
performer.OverduePOM.clickDashboard(driver).click();

Thread.sleep(5000);

}

public static void ComplianceCertificateParticularPeriod(WebDriver driver, ExtentTest test)
		throws InterruptedException, IOException {

	WebDriverWait wait = new WebDriverWait(driver, (40));
	Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,3600)");					//Scrolling down window by 2600 px.
	Thread.sleep(1000);
	ClickShowAll(driver).click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
    Thread.sleep(1000);
	CertificateOwnerPOM.View(driver).click();
	
	File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

	
	CertificateOwnerPOM.ClickDownloadAll(driver).click(); // Exporting (Downloading) file

	
	File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents.length < allFilesNew.length) {
		test.log(LogStatus.PASS,  "Download All - File downloaded successfully.");
	} else {
		test.log(LogStatus.FAIL, "  File does not downloaded.");
	}
	
	File dir2 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download

	
	CertificateOwnerPOM.ExporttoPDFPe(driver).click(); // Exporting (Downloading) file

	
	File dir3 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents1.length < allFilesNew1.length) {
		test.log(LogStatus.PASS,  "Export to PDF - File downloaded successfully.");
	} else {
		test.log(LogStatus.FAIL, "  File does not downloaded.");
	}
	
	CertificateOwnerPOM.ClickPreview(driver).click(); 
	Thread.sleep(2000);
	CertificateOwnerPOM.Previewclose(driver).click(); 
	test.log(LogStatus.PASS,  " Preview successfully.");
	
	File dir5 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] dirContents2 = dir5.listFiles(); // Counting number of files in directory before download

	
	CertificateOwnerPOM.DwonloadDoc(driver).click(); // Exporting (Downloading) file

	
	File dir6 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] allFilesNew2 = dir6.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents2.length < allFilesNew2.length) {
		test.log(LogStatus.PASS,  "Dwonload Doc - File downloaded successfully.");
	} else {
		test.log(LogStatus.FAIL, "  File does not downloaded.");
	}
	
	CertificateOwnerPOM.Back(driver).click(); 
	driver.switchTo().parentFrame();
	Thread.sleep(4000);
	ClickShowAllClose(driver).click();
	Thread.sleep(4000);
	performer.OverduePOM.clickDashboard(driver).click();

	Thread.sleep(5000);
}

public static void CertificateParticularPeriodCompliance(WebDriver driver, ExtentTest test)
		throws InterruptedException, IOException {

	WebDriverWait wait = new WebDriverWait(driver, (40));
	Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,3600)");					//Scrolling down window by 2600 px.
	Thread.sleep(1000);
	ClickShowAll(driver).click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
    Thread.sleep(1000);
	CertificateOwnerPOM.View(driver).click();
	Thread.sleep(2000);
	CertificateOwnerPOM.PeriodView(driver).click();
	Thread.sleep(2000);
	File dir2 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download

	
	CertificateOwnerPOM.ExporttoPDFPe(driver).click(); // Exporting (Downloading) file
	Thread.sleep(2000);
	
	File dir3 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents1.length < allFilesNew1.length) {
		test.log(LogStatus.PASS,  "Export to PDF - File downloaded successfully.");
	} else {
		test.log(LogStatus.FAIL, "  File does not downloaded.");
	}
	driver.switchTo().parentFrame();
	
	Thread.sleep(4000);
	ClickShowAllClose(driver).click();
	Thread.sleep(4000);
	performer.OverduePOM.clickDashboard(driver).click();

	Thread.sleep(5000);
	
}

public static void CertificateUser(WebDriver driver, ExtentTest test)
		throws InterruptedException, IOException {

	WebDriverWait wait = new WebDriverWait(driver, (40));
	Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,3600)");					//Scrolling down window by 2600 px.
	Thread.sleep(1000);
	ClickShowAll(driver).click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
	CertificateOwnerPOM.View(driver).click();
	Thread.sleep(3000);
	CertificateOwnerPOM.PeriodView(driver).click();
	Thread.sleep(3000);
	
	Thread.sleep(3000);
	By locator = By.xpath("//span[@class='k-icon k-i-eye']");
	
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	
	
	WebElement ViewButton = driver.findElement(locator);	
	
JavascriptExecutor jse=(JavascriptExecutor)driver;
Thread.sleep(2000);
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	//Thread.sleep(2000);
	View1(driver).click();
	Thread.sleep(2000);
	
	View2(driver).click();
	Thread.sleep(3000);
	CertificateOwnerPOM.ReviewerPageView(driver).click();
	Thread.sleep(3000);
	CertificateOwnerPOM.ReviewerPageViewclose(driver).click();
	test.log(LogStatus.PASS,  " - View Successfully");
	
		Thread.sleep(3000);
		ComplianceCertificateReviewerMethod.readCount(driver).click();					//CLicking on Total Pages value to scroll down
		Thread.sleep(500);
		String s1 = ComplianceCertificateReviewerMethod.readCount(driver).getText();	//Reading the total items count in String
		String[] bits = s1.split(" ");								//Splitting the String
		String itomsCount = bits[bits.length - 2];					//Getting the second last word (total number of items)
		int TotalRecords;
		if(itomsCount.equalsIgnoreCase("to"))						//If no records found, it shows 'No items to display'
		{
			test.log(LogStatus.PASS, " does not have any records to download.");
		}
		else
		{
			TotalRecords = Integer.parseInt(itomsCount);				//Reading total number of pages to click next
			
			Thread.sleep(500);
						
			
			File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			CertificateOwnerPOM.ReviewerPageExport(driver).click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);//C://Users//jiya//Downloads//
			File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, "  File downloaded successfully.");	
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
				
				Thread.sleep(500);
				fis = new FileInputStream(lastModifiedFile);	//Provided last modified / latest downloaded file.
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				Row row4 = sheet.getRow(3);						//Selected 3rd index row (Fourth row)
				Cell c1 = row4.createCell(0);					//Selected cell (4th row, 1st column)
				c1.setCellValue("Test");						//Entered temp data at empty row, so that it could make easy to get Last Row Number
				FileOutputStream fos = new FileOutputStream(lastModifiedFile);
				workbook.write(fos);
				fos.close();
				
				int no = sheet.getLastRowNum();
				int SheetRecords = no - 4;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
				
				if(SheetRecords == TotalRecords)
				{
					test.log(LogStatus.PASS, "  No of records displayed = " + TotalRecords + " matches to No of records in excel sheet = "+SheetRecords);
				}
				else
				{
					test.log(LogStatus.FAIL,"  No of records displayed = " + TotalRecords + " doesn't matches to No of records in excel sheet = "+SheetRecords);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "  File does not downloaded.");
			}
		}
		Thread.sleep(3000);
		EntitySubEntityLocation1(driver).click();
		Thread.sleep(3000);
		CertificateOwnerPOM.ReviewerPageClickExpand(driver).click();
		Thread.sleep(3000);
		CertificateOwnerPOM.ReviewerPageCT(driver).click();
		Thread.sleep(3000);
		if(CertificateOwnerPOM.ReviewerPageClearfilterMain(driver).isEnabled()) {
			CertificateOwnerPOM.ReviewerPageClearfilterMain(driver).click();
			test.log(LogStatus.PASS,  "  Clear Filter Working successfully.");
		}else {
			test.log(LogStatus.FAIL,  "  Clear Filter not Working successfully.");
		}	
		driver.switchTo().parentFrame();
		Thread.sleep(500);
		ClickShowAllClose(driver).click();
		Thread.sleep(2000);
		performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		Thread.sleep(1000);

}




}
