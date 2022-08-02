package InvoiceCreation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.groovy.parser.antlr4.GroovyParser.CreatedNameContext;
import org.apache.poi.ss.util.WorkbookUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.BusinessPageobject;
import PageFactory.CreateItem;
import PageFactory.CreatePaymentCreation;
import PageFactory.LoginPageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class PaymentCreationExcel3 {

	String[][] data = null

	;

	@DataProvider(name = "itemsdata")
	public String[][] loginDataProvider() throws BiffException, IOException {
		data = getExcelData();

		return data;
	}

	public String[][] getExcelData() throws BiffException, IOException {
		FileInputStream excel = new FileInputStream(
				"C:\\Users\\admin\\eclipse-workspace\\KitaabMSME\\Excel\\Items jxl.xls");
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet = workbook.getSheet(3);
		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();

		String testData[][] = new String[rowCount][columnCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				testData[i][j] = sheet.getCell(j, i).getContents();

			}
		}
		return testData;
	}

	public WebDriver driver;

	@BeforeSuite
	public void Login() throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void Max() {
		driver.manage().window().maximize();
		System.out.println("Test Started");
	}

	@BeforeClass
	public void url() throws InterruptedException, AWTException {
		driver.get("https://qe-kitaab.vakilsearch.com");
		PageFactory.initElements(driver, LoginPageobjects.class);
		LoginPageobjects.Phonenumber.sendKeys("9361079767");
		LoginPageobjects.aggrementCheckbox.click();
		LoginPageobjects.PhoneNumberContinue.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@datainput='1']")));
		// Thread.sleep(2000);
		LoginPageobjects.OTP1.click();
		LoginPageobjects.OTP1.sendKeys("0");
		LoginPageobjects.OTP2.sendKeys("0");
		LoginPageobjects.OTP3.sendKeys("0");
		LoginPageobjects.OTP4.sendKeys("0");
		LoginPageobjects.OTPContinue.click();
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='btn
		// btn-primary mx-1'])[30]")));
		PageFactory.initElements(driver, BusinessPageobject.class);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		// "//button[@class='mantine-Button-filled mantine-Button-root
		// styles_currentSelectedCompany__QkgAK mantine-1grzg0q']")));
		Thread.sleep(2000);
		BusinessPageobject.CompanyList.click();

		// wait.until(ExpectedConditions
		// .visibilityOfElementLocated(By.xpath("(//button[@class='styles_list__Ur99H']//child::h4)[48]")));
		// new Select
		// (driver.findElement(By.xpath("(//button[@class='styles_list__Ur99H']//child::h4)[48]")));
		BusinessPageobject.Businessname.click();
		PageFactory.initElements(driver, BusinessPageobject.class);
		PageFactory.initElements(driver, CreateItem.class);
		Thread.sleep(3000);

	}

	@Test(dataProvider = "itemsdata")
	public void PaymentCreation(String PCName, String PCAmount, String Date, String PaymentID, String vPCName,
			String vPCAmount, String vDate) throws InterruptedException, AWTException, IOException {
		PageFactory.initElements(driver, CreatePaymentCreation.class);

		CreatePaymentCreation.Paymentmenu.click();
		CreatePaymentCreation.Incoming.click();
		CreatePaymentCreation.AddPayment.click();
		Thread.sleep(1500);
		CreatePaymentCreation.SetCustomerName.sendKeys(PCName);
		CreatePaymentCreation.CustomerNamedropdown.click();
		CreatePaymentCreation.Setamount.sendKeys(PCAmount);
		CreatePaymentCreation.SelectDate.sendKeys(Date);
		Thread.sleep(1000);
		CreatePaymentCreation.Save.click();
		Thread.sleep(1000);
		CreatePaymentCreation.SearchPaymentList.sendKeys(PaymentID);
		Thread.sleep(2000);
		CreatePaymentCreation.SelectTable.click();
		Thread.sleep(2000);
		boolean contains = CreatePaymentCreation.VSetCustomerName.getAttribute("value").contains(vPCName);
		System.out.println(contains + PCName);
		boolean contains2 = CreatePaymentCreation.VSetamount.getAttribute("value").contains(vPCAmount);
		System.out.println(contains2);
		boolean contains3 = CreatePaymentCreation.VSelectDate.getAttribute("value").contains(vDate);
		System.out.println(contains3);
		Thread.sleep(3000);
		CreatePaymentCreation.SaveEdit.click();
	}
	@AfterClass
	public void close() {
		// driver.close();
		System.out.println("The close_up process is completed");

	}

	@AfterTest
	public void Report() {

		System.out.println("Test completed");

	}

	@AfterSuite
	public void cleanup() {
		driver.quit();
	}

}
