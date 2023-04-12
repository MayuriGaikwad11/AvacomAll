package complianceCertificateOwner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import implementation.ImplementPOM;

public class CertificateOwnerMethod {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	public static void CertificateOwner(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		Thread.sleep(1000);
		CertificateOwnerPOM.clickMyCertificate(driver).click();
		Thread.sleep(1000);
		CertificateOwnerPOM.CertificateOwner(driver).click();
		Thread.sleep(3000);
	String text=	CertificateOwnerPOM.CertificateOwnerPage(driver).getText();
	test.log(LogStatus.PASS,  "Page Open - " +text);
	
	    Thread.sleep(1000);
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
	
	
	File dir5 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] dirContents2 = dir5.listFiles(); // Counting number of files in directory before download

	
	CertificateOwnerPOM.DownloadUploadCertificate(driver).click(); // Exporting (Downloading) file

	
	File dir6 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] allFilesNew2 = dir6.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents2.length < allFilesNew2.length) {
		test.log(LogStatus.PASS,  "Download Upload Certificate - File downloaded successfully.");
	} else {
		test.log(LogStatus.FAIL, "  File does not downloaded.");
	}
		
	CertificateOwnerPOM.EntitySubEntityLocation(driver).click();
	Thread.sleep(1000);
	CertificateOwnerPOM.ComplianceTech(driver).click();
	Thread.sleep(3000);
	CertificateOwnerPOM.ReviewerPageClearfilterMain(driver).click();
	Thread.sleep(3000);

test.log(LogStatus.PASS,  " Clear Filter Working successfully." );
		
	
	
	}
	
	public static void CertificateOwnerReviewer(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate(driver).click();
		
		CertificateOwnerPOM.CertificateOwner(driver).click();
		
		CertificateOwnerPOM.View(driver).click();
		
		CertificateOwnerPOM.PeriodView(driver).click();
		Thread.sleep(3000);
		CertificateOwnerPOM.CompliancePageView(driver).click();
		
		CertificateOwnerPOM.ReviewerPageView(driver).click();
		CertificateOwnerPOM.ReviewerPageViewclose(driver).click();
		test.log(LogStatus.PASS,  "Reviewer - Reviewer User - View Successfully");
		
		
			File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			
			CertificateOwnerPOM.ReviewerPageExport(driver).click(); // Exporting (Downloading) file

			
			File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "  File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL, "  File does not downloaded.");
			}
		
			CertificateOwnerPOM.ReviewerPageLoaction(driver).click();
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
			performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
			Thread.sleep(1000);
	
	}
	
	public static void CertificateOwnerParticularPeriod(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate(driver).click();
		
		CertificateOwnerPOM.CertificateOwner(driver).click();
		Thread.sleep(3000);
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
		/*Thread.sleep(2000);
		CertificateOwnerPOM.Submit(driver).click(); 
		Thread.sleep(2000);
		
		String text=	CertificateOwnerPOM.SubmitMsg(driver).getText();
		test.log(LogStatus.PASS,  "Message Display " +text);
		Thread.sleep(2000);
		CertificateOwnerPOM.SubmitYes(driver).click(); 
		Thread.sleep(2000);
	String Msg=	driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();
	test.log(LogStatus.PASS,  "Message Display " +Msg);
	Thread.sleep(2000);
		*/
		CertificateOwnerPOM.Back(driver).click(); 
	}
	
	public static void CertificateOwnerParticularPeriodCompliance(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate(driver).click();
		
		CertificateOwnerPOM.CertificateOwner(driver).click();
		Thread.sleep(3000);
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
		
		
	}
	
	public static void CertificateOwnerReopen(WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait(driver, (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		Thread.sleep(1000);
		CertificateOwnerPOM.clickMyCertificate(driver).click();
		Thread.sleep(1000);
		CertificateOwnerPOM.CertificateOwner(driver).click();
		Thread.sleep(3000);
		
		CertificateOwnerPOM.CertificateOwnerview(driver).click();
		Thread.sleep(2000);
		CertificateOwnerPOM.PeriodView1(driver).click();
		Thread.sleep(3000);
		CertificateOwnerPOM.PeriodDec22View1(driver).click();
		Thread.sleep(3000);
		try {
		CertificateOwnerPOM.ReopenButton(driver).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews4"));	//Wait until frame get visible and switch to it.
		Thread.sleep(500);
		CFOcountPOM.EnterRemark(driver).sendKeys("remark");
		Thread.sleep(1000);
		CFOcountPOM.ReOpen(driver).click();
		Thread.sleep(8000);
		String msg =driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Message Display : - " +msg);
       Thread.sleep(1000);
      driver.switchTo().parentFrame();
     Thread.sleep(5000);
}catch(Exception e) {
	
	test.log(LogStatus.PASS, "ReOpen Button Not present ");
	
}
		performer.OverduePOM.clickDashboard(driver).click();			//Clicking on Dashboard
		Thread.sleep(1000);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
