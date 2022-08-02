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

import PageFactory.LoginPageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ItemCreationExcel {

	String[][] data = null

	;

	@DataProvider(name = "itemsdata")
	public String[][] loginDataProvider() throws BiffException, IOException {
		data = getExcelData();

		return data; 
	}

	public String[][] getExcelData() throws BiffException, IOException {
		FileInputStream excel = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\KitaabMSME\\Excel\\Items jxl.xls");
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet = workbook.getSheet(0);
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
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				//"//button[@class='mantine-Button-filled mantine-Button-root styles_currentSelectedCompany__QkgAK mantine-1grzg0q']")));
		Thread.sleep(2000);
		BusinessPageobject.CompanyList.click();

		//wait.until(ExpectedConditions
			//	.visibilityOfElementLocated(By.xpath("(//button[@class='styles_list__Ur99H']//child::h4)[48]")));
		// new Select
		// (driver.findElement(By.xpath("(//button[@class='styles_list__Ur99H']//child::h4)[48]")));
		BusinessPageobject.Businessname.click();
		PageFactory.initElements(driver, BusinessPageobject.class);
		PageFactory.initElements(driver, CreateItem.class);
		Thread.sleep(3000);

		BusinessPageobject.CreateInvoice.click();

		CreateItem.AddItem.click();

	}

	@Test(dataProvider = "itemsdata")
	public void Itemcreation100(String Items,String rate) throws InterruptedException, AWTException, IOException {

		Thread.sleep(3000);
		CreateItem.CreateNewItem.click();	
		CreateItem.GoodsSelection.click();
		CreateItem.Itemname.sendKeys(Items);
		CreateItem.PricePerUnit.sendKeys(rate);
		CreateItem.itemsave.click();
		Thread.sleep(3000);

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
