package InvoiceCreation;

import static org.testng.Assert.assertEquals;

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
import org.openqa.selenium.JavascriptExecutor;
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
import PageFactory.InvoicePageobject;
import PageFactory.LoginPageobjects;
import PageFactory.PreviewElements;
import PageFactory.PreviewValues;
import PageFactory.QuotationCreation;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class InvoiceCreationExcel {

	public class QuotationCreationExcel {

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
			Sheet sheet = workbook.getSheet(5);
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
			LoginPageobjects.Phonenumber.sendKeys("9791075150");
			LoginPageobjects.aggrementCheckbox.click();
			Thread.sleep(1500);
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
			// BusinessPageobject.CompanyList.click();

			// wait.until(ExpectedConditions
			// .visibilityOfElementLocated(By.xpath("(//button[@class='styles_list__Ur99H']//child::h4)[48]")));
			// new Select
			// (driver.findElement(By.xpath("(//button[@class='styles_list__Ur99H']//child::h4)[48]")));
			// BusinessPageobject.Businessname.click();
			// PageFactory.initElements(driver, BusinessPageobject.class);
			// PageFactory.initElements(driver, CreateItem.class);
			// Thread.sleep(3000);
			PageFactory.initElements(driver, QuotationCreation.class);
			// QuotationCreation.Sales.click();
			// InvoicePageobject.Invoicemenu.click();

		}

		@Test(dataProvider = "itemsdata")
		public void InvoiceCreationWithExcel(String Customername, String salerate, String Discount1, String TotalTax,
				String CGST, String SGST, String IGST, String CESS1, String Total, String Inclusiveorexclusive)
				throws InterruptedException, AWTException, IOException {
			PageFactory.initElements(driver, QuotationCreation.class);
			PageFactory.initElements(driver, PreviewValues.class);
			PageFactory.initElements(driver, PreviewElements.class);
			BusinessPageobject.CreateInvoice.click();
			// CreateItem.AddItem.click();
			Thread.sleep(5000);
			PageFactory.initElements(driver, BusinessPageobject.class);
			PageFactory.initElements(driver, CreateItem.class);
			PageFactory.initElements(driver, InvoicePageobject.class);

			InvoicePageobject.SelectCustomer.click();
			QuotationCreation.Searchcustomerquo.sendKeys(Customername);
			// InvoicePageobject.SelectCustomer.sendKeys(Customername);
			Thread.sleep(4000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ALT);
			Thread.sleep(3000);
			CreateItem.AddItem.click();
			InvoicePageobject.Searchbyitem.sendKeys(Inclusiveorexclusive);
			Thread.sleep(2000);
			CreateItem.addItem1.click();

			// CreateItem.addItem2.click();
			// CreateItem.addItem3.click();
			// CreateItem.addItem4.click();
			CreateItem.addItem.click();
			Thread.sleep(2000);
			InvoicePageobject.Discount.click();
			InvoicePageobject.DiscountName.sendKeys("Offer");
			InvoicePageobject.DiscountAmount.sendKeys(Discount1);
			String text = InvoicePageobject.IGSTValidation.getText();

			String A = text;
			String B = "SGST@";

			if (A.contains(B)) {

				System.out.println("Intra state");
				// InvoicePageobject.Gst.sendKeys(GSTPercent);
				// InvoicePageobject.CESSPercent.sendKeys(CESS);
				boolean contains3 = InvoicePageobject.Taxableamount.getText().contains(TotalTax);
				System.out.println(contains3 + " Totaltax");
				boolean contains4 = InvoicePageobject.CGSTAmount.getText().contains(CGST);
				System.out.println(contains4 + " CGST");
				boolean contains5 = InvoicePageobject.SGSTAmount.getText().contains(SGST);
				System.out.println(contains5 + " SGST");
				boolean contains7 = InvoicePageobject.GSTCessAmount.getText().contains(CESS1);
				System.out.println(contains7 + " CESS");

			} else {
				System.out.println("Inter state");
				// InvoicePageobject.Gst.sendKeys(GSTPercent);
				// InvoicePageobject.CESSPercent.sendKeys(CESS);
				boolean contains3 = InvoicePageobject.Taxableamount.getText().contains(TotalTax);
				System.out.println(contains3 + " Totaltax");

				boolean contains6 = InvoicePageobject.IGSTAmount.getText().contains(IGST);
				System.out.println(contains6 + " Igst");
				boolean contains8 = InvoicePageobject.IGSTCessAmount.getText().contains(CESS1);
				System.out.println(contains8 + " CESS");
			}

//			InvoicePageobject.AddAditionalCharges.click();
//			InvoicePageobject.AddAditionalChargesName.sendKeys("Cover");
//			InvoicePageobject.AddAditionalChargesAmount.sendKeys("5");
//			InvoicePageobject.Discount.click();
//			InvoicePageobject.DiscountName.sendKeys("Offer");
//			InvoicePageobject.DiscountAmount.sendKeys("2.5");
//			InvoicePageobject.DeductTDS.click();
//			InvoicePageobject.DeductTDSAmount.sendKeys("2.5");
//			String text = QuotationCreation.lineamount.getText();
//			System.out.println(text);

			// for (int i = 1; i < text.length(); i++) {

			// char c = text.charAt(i);
			// String s = new StringBuilder().append(c).toString();
			// System.out.println(s);

			// boolean contains = text.contains(s);
			// System.out.println(contains);
			// }

			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			// robot.keyPress(KeyEvent.VK_UP);
			// robot.keyRelease(KeyEvent.VK_UP);
			// robot.keyPress(KeyEvent.VK_UP);
			// robot.keyRelease(KeyEvent.VK_UP);
			Thread.sleep(2000);
			QuotationCreation.SaveQuotation.click();
//			Thread.sleep(2000);
//			Thread.sleep(5000);
//			String text11 = QuotationCreation.QuotationID.getText();
//
//			QuotationCreation.ConvertInvoice.click();
//			Thread.sleep(3000);
//			QuotationCreation.SaveSalesInvoice.click();
//			Thread.sleep(5000);
//			String text22 = QuotationCreation.LinkedQuotation.getText();
//
//			String text33 = QuotationCreation.InvoiceId.getText();
//			Thread.sleep(5000);
//
//			QuotationCreation.ViewInvoice.click();
//			Thread.sleep(5000);
//			String text44 = QuotationCreation.LinkedInvoice.getText();
			Thread.sleep(4000);
//
//			boolean contains = text11.contains(text22);
//			boolean contains2 = text33.contains(text44);
//
//			System.out.println(contains + "Same QUO ID " + contains2 + "Same INV ID");
//			PageFactory.initElements(driver, QuotationCreation.class);
			String text26 = PreviewValues.IGSTValue.getText();
			String m = text26;
			String n = "IGST@";

			if (m.contains(n)) {
				String text2 = PreviewValues.FromGSTIN.getText();
				String text3 = PreviewValues.Address.getText();
				String text4 = PreviewValues.CESSValue.getText();
				String text5 = PreviewValues.CustomerName.getText();
				String text6 = PreviewValues.Date.getText();
				String text7 = PreviewValues.DueAmountValue.getText();
				String text8 = PreviewValues.DueDateValue.getText();
				String text9 = PreviewValues.FromGSTIN.getText();
				String text10 = PreviewValues.IGSTValue.getText();
				String text11 = PreviewValues.InvoiceDateValue.getText();
				String text12 = PreviewValues.InvoiceIDValue.getText();
				String text13 = PreviewValues.Table1.getText();
				String text14 = PreviewValues.Table2.getText();
				String text15 = PreviewValues.Table3.getText();
				String text16 = PreviewValues.Table4.getText();
				String text17 = PreviewValues.Table5.getText();
				String text18 = PreviewValues.Table6.getText();
				String text19 = PreviewValues.Table7.getText();
				String text20 = PreviewValues.Table8.getText();
				String text21 = PreviewValues.Table9.getText();
				String text22 = PreviewValues.Table10.getText();
				String text23 = PreviewValues.TotalValue.getText();
				Thread.sleep(3000);
				String text609 = PreviewElements.URLlink.getText();
				driver.get(text609);
				Thread.sleep(3000);
				boolean contains = PreviewValues.FromGSTIN.getText().contains(text2);
				System.out.println(contains+"     GSTIN");
				boolean contains2 = PreviewValues.Address.getText().contains(text3);
				System.out.println(contains2+"     Address");
				boolean contains3 = PreviewValues.CESSValue.getText().contains(text4);
				System.out.println(contains3+"     CESSValue");
				boolean contains4 = PreviewValues.CustomerName.getText().contains(text5);
				System.out.println(contains4+"     CustomerName");
				boolean contains5 = PreviewValues.Date.getText().contains(text6);
				System.out.println(contains5+"     Date");
				boolean contains6 = PreviewValues.DueAmountValue.getText().contains(text7);
				System.out.println(contains6+"     DueAmountValue");
				boolean contains7 = PreviewValues.DueDateValue.getText().contains(text8);
				System.out.println(contains7+"     DueDateValue");
				boolean contains8 = PreviewValues.FromGSTIN.getText().contains(text9);
				System.out.println(contains8+"     FromGSTIN");
				boolean contains9 = PreviewValues.IGSTValue.getText().contains(text10);
				System.out.println(contains9+"     IGSTValue");
				boolean contains10 = PreviewValues.InvoiceDateValue.getText().contains(text11);
				System.out.println(contains10+"     InvoiceDateValue");
				boolean contains11 = PreviewValues.InvoiceIDValue.getText().contains(text12);
				System.out.println(contains11+"     InvoiceIDValue");
				boolean contains12 = PreviewValues.Table1.getText().contains(text13);
				System.out.println(contains12+"     Table1");
				boolean contains13 = PreviewValues.Table2.getText().contains(text14);
				System.out.println(contains13+"     Table2");
				boolean contains14 = PreviewValues.Table3.getText().contains(text15);
				System.out.println(contains14+"     Table3");
				boolean contains15 = PreviewValues.Table4.getText().contains(text16);
				System.out.println(contains15+"     Table4");
				boolean contains16 = PreviewValues.Table5.getText().contains(text17);
				System.out.println(contains16+"     Table5");
				boolean contains17 = PreviewValues.Table6.getText().contains(text18);
				System.out.println(contains17+"     Table6");
				boolean contains18 = PreviewValues.Table7.getText().contains(text19);
				System.out.println(contains18+"     Table7");
				boolean contains19 = PreviewValues.Table8.getText().contains(text20);
				System.out.println(contains19+"     Table8");
				boolean contains20 = PreviewValues.Table9.getText().contains(text21);
				System.out.println(contains20+"     Table9");
				boolean contains21 = PreviewValues.Table10.getText().contains(text22);
				System.out.println(contains21+"     Table10");
				boolean contains22 = PreviewValues.TotalValue.getText().contains(text23);
				System.out.println(contains22+"     TotalValue");

				PreviewValues.TotalValue.getText();assertEquals(contains21, text23);

				
				Thread.sleep(4000);
				driver.navigate().back();
				Thread.sleep(4000);

			} else {

				String text2 = PreviewValues.FromGSTIN.getText();
				String text3 = PreviewValues.Address.getText();
				String text4 = PreviewValues.CESSValue.getText();
				String text5 = PreviewValues.CustomerName.getText();
				String text6 = PreviewValues.Date.getText();
				String text7 = PreviewValues.DueAmountValue.getText();
				String text8 = PreviewValues.DueDateValue.getText();
				String text9 = PreviewValues.FromGSTIN.getText();
				String text10 = PreviewValues.CGSTValue.getText();
				String text24 = PreviewValues.SGSTValue.getText();
				String text11 = PreviewValues.InvoiceDateValue.getText();
				String text12 = PreviewValues.InvoiceIDValue.getText();
				String text13 = PreviewValues.Table1.getText();
				String text14 = PreviewValues.Table2.getText();
				String text15 = PreviewValues.Table3.getText();
				String text16 = PreviewValues.Table4.getText();
				String text17 = PreviewValues.Table5.getText();
				String text18 = PreviewValues.Table6.getText();
				String text19 = PreviewValues.Table7.getText();
				String text20 = PreviewValues.Table8.getText();
				String text21 = PreviewValues.Table9.getText();
				String text22 = PreviewValues.Table10.getText();
				String text23 = PreviewValues.TotalValue.getText();
				Thread.sleep(3000);
				String text609 = PreviewElements.URLlink.getText();
				driver.get(text609);
				Thread.sleep(3000);
				boolean contains = PreviewValues.FromGSTIN.getText().contains(text2);
				System.out.println(contains+"     FromGSTIN");
				boolean contains2 = PreviewValues.Address.getText().contains(text3);
				System.out.println(contains2+"     Address");
				boolean contains3 = PreviewValues.CESSValue.getText().contains(text4);
				System.out.println(contains3+"     CESSValue");
				boolean contains4 = PreviewValues.CustomerName.getText().contains(text5);
				System.out.println(contains4+"     CustomerName");
				boolean contains5 = PreviewValues.Date.getText().contains(text6);
				System.out.println(contains5+"     Date");
				boolean contains6 = PreviewValues.DueAmountValue.getText().contains(text7);
				System.out.println(contains6+"     DueAmountValue");
				boolean contains7 = PreviewValues.DueDateValue.getText().contains(text8);
				System.out.println(contains7+"     DueDateValue");
				boolean contains8 = PreviewValues.FromGSTIN.getText().contains(text9);
				System.out.println(contains8+"     FromGSTIN");
				boolean contains9 = PreviewValues.CGSTValue.getText().contains(text10);
				System.out.println(contains9+"     CGSTValue");
				boolean contains99 = PreviewValues.SGSTValue.getText().contains(text24);
				System.out.println(contains99+"     SGSTValue");
				boolean contains10 = PreviewValues.InvoiceDateValue.getText().contains(text11);
				System.out.println(contains10+"     InvoiceDateValue");
				boolean contains11 = PreviewValues.InvoiceIDValue.getText().contains(text12);
				System.out.println(contains11+"     InvoiceIDValue");
				boolean contains12 = PreviewValues.Table1.getText().contains(text13);
				System.out.println(contains12+"     Table1");
				boolean contains13 = PreviewValues.Table2.getText().contains(text14);
				System.out.println(contains13+"     Table2");
				boolean contains14 = PreviewValues.Table3.getText().contains(text15);
				System.out.println(contains14+"     Table3");
				boolean contains15 = PreviewValues.Table4.getText().contains(text16);
				System.out.println(contains15+"     Table4");
				boolean contains16 = PreviewValues.Table5.getText().contains(text17);
				System.out.println(contains16+"     Table5");
				boolean contains17 = PreviewValues.Table6.getText().contains(text18);
				System.out.println(contains17+"     Table6");
				boolean contains18 = PreviewValues.Table7.getText().contains(text19);
				System.out.println(contains18+"     Table7");
				boolean contains19 = PreviewValues.Table8.getText().contains(text20);
				System.out.println(contains19+"     Table8");
				boolean contains20 = PreviewValues.Table9.getText().contains(text21);
				System.out.println(contains20+"     Table9");
				boolean contains21 = PreviewValues.Table10.getText().contains(text22);
				System.out.println(contains21+"     Table10");
				boolean contains22 = PreviewValues.TotalValue.getText().contains(text23);
				System.out.println(contains22+"     TotalValue");

				Thread.sleep(4000);
				driver.navigate().back();
				Thread.sleep(4000);
			}
			QuotationCreation.Sales.click();
			InvoicePageobject.Invoicemenu.click();
//			QuotationCreation.CreateQuotation.click();
			// QuotationCreation.Quotationback.click();
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
}
