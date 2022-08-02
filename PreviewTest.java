package InvoiceCreation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
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
import PageFactory.QuotationCreation;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class PreviewTest { 

	String[][] data = null; 

	@DataProvider(name = "itemsdata")
	public String[][] loginDataProvider() throws BiffException, IOException {
		data = getExcelData();

		return data;
	}

	public String[][] getExcelData() throws BiffException, IOException {
		FileInputStream excel = new FileInputStream(
				"C:\\Users\\admin\\eclipse-workspace\\KitaabMSME\\Excel\\Items jxl.xls");
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet = workbook.getSheet(6);
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

	}

	@Test(dataProvider = "itemsdata")
	public void Itemcreation100(String Customername, String salerate, String Discount1, String TotalTax, String CGST,
			String SGST, String IGST, String CESS1, String Total, String Inclusiveorexclusive)
			throws InterruptedException, AWTException, IOException {
		PageFactory.initElements(driver, QuotationCreation.class);
		QuotationCreation.Sales.click();
//	String C = QuotationCreation.SelectQuotation.getText();
//	System.out.println(C);
//
//	if (C.contains("Quotations") )
//	
//	{
//	System.out.println("same");
//
//	}else {System.out.println("notsame");
//		QuotationCreation.Sales.click();
//		Thread.sleep(2000);
//		
//	}

		Thread.sleep(2000);
		QuotationCreation.SelectQuotation.click();
		Thread.sleep(2000);
		QuotationCreation.CreateQuotation.click();
		PageFactory.initElements(driver, QuotationCreation.class);
		PageFactory.initElements(driver, PreviewElements.class);
		// CreateItem.AddItem.click();
		Thread.sleep(4000);
		PageFactory.initElements(driver, BusinessPageobject.class);
		PageFactory.initElements(driver, CreateItem.class);
		PageFactory.initElements(driver, InvoicePageobject.class);
		QuotationCreation.Sales.click();
		InvoicePageobject.SelectCustomer.click();
		QuotationCreation.Searchcustomerquo.sendKeys(Customername);
		// InvoicePageobject.SelectCustomer.sendKeys(Customername);
		Thread.sleep(3000);
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
		CreateItem.addItem.click();
		Thread.sleep(3000);
		InvoicePageobject.Discount.click();
		InvoicePageobject.DiscountName.sendKeys("Offer");
		InvoicePageobject.DiscountAmount.sendKeys(Discount1);
		String text = InvoicePageobject.IGSTValidation.getText();

		String A = text;
		String B = "IGST@";

		if (A.contains(B)) {

			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			Thread.sleep(2000);
			QuotationCreation.SaveQuotation.click();
			Thread.sleep(2000);
			Thread.sleep(5000);
			System.out.println("Inter state");

			String text3 = PreviewElements.CompanyName.getText();
			boolean contains = text3.contains("FZ ENTERPRISES");
			System.out.println(text3+"    -     " + contains);

			String text4 = PreviewElements.TaxInvoice.getText();
			boolean contains1 = text4.contains("Tax Quotation");
			System.out.println(text4 +"    -     "+ contains1);

			String text5 = PreviewElements.From.getText();
			boolean contains2 = text5.contains("From");
			System.out.println(text5 +"    -     "+ contains2);

			String text6 = PreviewElements.Billto.getText();
			boolean contains3 = text6.contains("Bill to:");
			System.out.println(text6+"    -     " + contains3);

			String text7 = PreviewElements.Quotation.getText();
			boolean contains4 = text7.contains("Quotation #");
			System.out.println(text7 +"    -     "+ contains4);

			String text8 = PreviewElements.QuotationDate.getText();
			boolean contains5 = text8.contains("Quotation Date:");
			System.out.println(text8 +"    -     "+ contains5);

			String text9 = PreviewElements.ExpiryDate.getText();
			boolean contains6 = text9.contains("Expiry Date");
			System.out.println(text9 +"    -     "+ contains6);

			String text10 = PreviewElements.Sno.getText();
			boolean contains7 = text10.contains("S.no");
			System.out.println(text10+"    -     " + contains7);

			String text11 = PreviewElements.itemsSerices.getText();
			boolean contains8 = text11.contains("Item/Services");
			System.out.println(text11 +"    -     "+ contains8);

			String text12 = PreviewElements.HsnSac.getText();
			boolean contains9 = text12.contains("HSN/SAC");
			System.out.println(text12 +"    -     "+ contains9);

			String text13 = PreviewElements.Quantity.getText();
			boolean contains10 = text13.contains("Quantity");
			System.out.println(text13+"    -     " + contains10);

			String text33 = PreviewElements.PriceUnit.getText();
			boolean contains100 = text33.contains("Price/Unit");
			System.out.println(text33 +"    -     "+ contains100);

			String text114 = PreviewElements.Discount.getText();
			boolean contains111 = text114.contains("Discount");
			System.out.println(text114 +"    -     "+ contains111);

			String text14 = PreviewElements.Taxablevalue.getText();
			boolean contains11 = text14.contains("Taxable Value");
			System.out.println(text14 +"    -     "+ contains11);

			String text15 = PreviewElements.GST.getText();
			boolean contains12 = text15.contains("GST");
			System.out.println(text15 +"    -     "+ contains12);

			String text16 = PreviewElements.CESS.getText();
			boolean contains13 = text16.contains("CESS");
			System.out.println(text16 +"    -     "+ contains13);

			String text17 = PreviewElements.Amount.getText();
			boolean contains15 = text17.contains("Amount");
			System.out.println(text17 +"    -     "+ contains15);

			String text18 = PreviewElements.subtotal.getText();
			boolean contains16 = text18.contains("Sub Total");
			System.out.println(text18 +"    -     "+ contains16);

			String text19 = PreviewElements.IGSTtotal.getText();
			boolean contains17 = text19.contains("IGST");
			System.out.println(text19 +"    -     "+ contains17);

			String text20 = PreviewElements.CESStotal.getText();
			boolean contains18 = text20.contains("CESS");
			System.out.println(text20+"    -     " + contains18);

			String text21 = PreviewElements.Total.getText();
			boolean contains19 = text21.contains("Total");
			System.out.println(text21 +"    -     "+ contains19);

			String text22 = PreviewElements.AuthorizedSignature.getText();
			boolean contains20 = text22.contains("Authorized Signature");
			System.out.println(text22 +"    -     "+ contains20);

			String text23 = PreviewElements.Thankyourforyourbussiness.getText();
			boolean contains21 = text23.contains("Thank you for your business");
			System.out.println(text23 +"    -     "+ contains21);

			String text2 = PreviewElements.URLlink.getText();
			driver.get(text2);

			System.out.println("GotURL");
			boolean contains14 = PreviewElements.CompanyName.getText().contains(text3);System.out.println(contains14);
			
			//PreviewElements.TaxInvoice.getText().contains(text4);
			boolean contains22 = PreviewElements.From.getText().contains(text5);System.out.println(contains22);
			boolean contains23 = PreviewElements.Billto.getText().contains(text6);System.out.println(contains23);
			boolean contains24 = PreviewElements.Quotation.getText().contains(text7);System.out.println(contains24);
			boolean contains25 = PreviewElements.QuotationDate.getText().contains(text8);System.out.println(contains25);
			boolean contains26 = PreviewElements.ExpiryDate.getText().contains(text9);System.out.println(contains26);
			boolean contains27 = PreviewElements.Sno.getText().contains(text10);System.out.println(contains27);
			boolean contains28 = PreviewElements.itemsSerices.getText().contains(text11);System.out.println(contains28);
			boolean contains29 = PreviewElements.HsnSac.getText().contains(text12);System.out.println(contains29);
			boolean contains30 = PreviewElements.Quantity.getText().contains(text13);System.out.println(contains30);
			boolean contains31 = PreviewElements.Taxablevalue.getText().contains(text14);System.out.println(contains31);
			boolean contains32 = PreviewElements.GST.getText().contains(text15);System.out.println(contains32);
			boolean contains33 = PreviewElements.CESS.getText().contains(text16);System.out.println(contains33);
			boolean contains34 = PreviewElements.Amount.getText().contains(text17);System.out.println(contains34);
			boolean contains35 = PreviewElements.subtotal.getText().contains(text18);System.out.println(contains35);
			boolean contains36 = PreviewElements.IGSTtotal.getText().contains(text19);System.out.println(contains36);
			boolean contains37 = PreviewElements.CESStotal.getText().contains(text20);System.out.println(contains37);
			boolean contains38 = PreviewElements.Total.getText().contains(text21);System.out.println(contains38);
			boolean contains39 = PreviewElements.AuthorizedSignature.getText().contains(text22);System.out.println(contains39);
			boolean contains40 = PreviewElements.Thankyourforyourbussiness.getText().contains(text23);System.out.println(contains40);
			Thread.sleep(4000);
			driver.navigate().back();
			Thread.sleep(4000);
		} else {
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			Thread.sleep(2000);
			QuotationCreation.SaveQuotation.click();
			Thread.sleep(2000);
			Thread.sleep(5000);
			System.out.println("Intra state");

			String text3 = PreviewElements.CompanyName.getText();
			boolean contains = text3.contains("FZ ENTERPRISES");
			System.out.println(text3+"    -     " + contains);

			String text4 = PreviewElements.TaxInvoice.getText();
			boolean contains1 = text4.contains("Tax Quotation");
			System.out.println(text4+"    -     " + contains1);

			String text5 = PreviewElements.From.getText();
			boolean contains2 = text5.contains("From");
			System.out.println(text5+"    -     " + contains2);

			String text6 = PreviewElements.Billto.getText();
			boolean contains3 = text6.contains("Bill to");
			System.out.println(text6+"    -     " + contains3);

			String text7 = PreviewElements.Quotation.getText();
			boolean contains4 = text7.contains("Quotation #");
			System.out.println(text7+"    -     " + contains4);

			String text8 = PreviewElements.QuotationDate.getText();
			boolean contains5 = text8.contains("Quotation Date:");
			System.out.println(text8+"    -     " + contains5);

			String text9 = PreviewElements.ExpiryDate.getText();
			boolean contains6 = text9.contains("Expiry Date");
			System.out.println(text9+"    -     " + contains6);

			String text10 = PreviewElements.Sno.getText();
			boolean contains7 = text10.contains("S.no");
			System.out.println(text10+"    -     " + contains7);

			String text11 = PreviewElements.itemsSerices.getText();
			boolean contains8 = text11.contains("Item/Services");
			System.out.println(text11+"    -     " + contains8);

			String text12 = PreviewElements.HsnSac.getText();
			boolean contains9 = text12.contains("HSN/SAC");
			System.out.println(text12+"    -     " + contains9);

			String text13 = PreviewElements.Quantity.getText();
			boolean contains10 = text13.contains("Quantity");
			System.out.println(text13+"    -     " + contains10);

			String text33 = PreviewElements.PriceUnit.getText();
			boolean contains100 = text33.contains("Price/Unit");
			System.out.println(text33+"    -     " + contains100);

			String text114 = PreviewElements.Discount.getText();
			boolean contains111 = text114.contains("Discount");
			System.out.println(text114+"    -     " + contains111);

			String text14 = PreviewElements.Taxablevalue.getText();
			boolean contains11 = text14.contains("Taxable Value");
			System.out.println(text14+"    -     " + contains11);

			String text15 = PreviewElements.GST.getText();
			boolean contains12 = text15.contains("GST");
			System.out.println(text15+"    -     " + contains12);

			String text16 = PreviewElements.CESS.getText();
			boolean contains13 = text16.contains("CESS");
			System.out.println(text16+"    -     " + contains13);

			String text17 = PreviewElements.Amount.getText();
			boolean contains15 = text17.contains("Amount");
			System.out.println(text17+"    -     " + contains15);

			String text18 = PreviewElements.subtotal.getText();
			boolean contains16 = text18.contains("Sub Total");
			System.out.println(text18+"    -     " + contains16);

			String text19 = PreviewElements.CGSTtotal.getText();
			boolean contains17 = text19.contains("CGST");
			System.out.println(text19+"    -     " + contains17);

			String text199 = PreviewElements.SGSTTotal.getText();
			boolean contains177 = text199.contains("SGST");
			System.out.println(text199+"    -     " + contains177);

			String text20 = PreviewElements.CESStotal.getText();
			boolean contains18 = text20.contains("CESS");
			System.out.println(text20+"    -     " + contains18);

			String text21 = PreviewElements.Total.getText();
			boolean contains19 = text21.contains("Total");
			System.out.println(text21+"    -     " + contains19);

			String text22 = PreviewElements.AuthorizedSignature.getText();
			boolean contains20 = text22.contains("Authorized Signature");
			System.out.println(text22+"    -     " + contains20);

			String text23 = PreviewElements.Thankyourforyourbussiness.getText();
			boolean contains21 = text23.contains("Thank you for your business");
			System.out.println(text23+"    -     " + contains21);

			String text2 = PreviewElements.URLlink.getText();
			driver.get(text2);

			boolean contains14 = PreviewElements.CompanyName.getText().contains(text3);
			System.out.println(contains14);
			//PreviewElements.TaxInvoice.getText().contains(text4);
			boolean contains22 = PreviewElements.From.getText().contains(text5);
			System.out.println(contains22);
			boolean contains23 = PreviewElements.Billto.getText().contains(text6);System.out.println(contains23);
			boolean contains24 = PreviewElements.Quotation.getText().contains(text7);System.out.println(contains24);
			boolean contains25 = PreviewElements.QuotationDate.getText().contains(text8);System.out.println(contains25);
			boolean contains26 = PreviewElements.ExpiryDate.getText().contains(text9);System.out.println(contains26);
			boolean contains27 = PreviewElements.Sno.getText().contains(text10);System.out.println(contains27);
			boolean contains28 = PreviewElements.itemsSerices.getText().contains(text11);System.out.println(contains28);
			boolean contains29 = PreviewElements.HsnSac.getText().contains(text12);System.out.println(contains29);
			boolean contains30 = PreviewElements.Quantity.getText().contains(text13);System.out.println(contains30);
			boolean contains31 = PreviewElements.Taxablevalue.getText().contains(text14);System.out.println(contains31);
			boolean contains32 = PreviewElements.GST.getText().contains(text15);System.out.println(contains32);
			boolean contains33 = PreviewElements.CESS.getText().contains(text16);System.out.println(contains33);
			boolean contains34 = PreviewElements.Amount.getText().contains(text17);System.out.println(contains34);
			boolean contains35 = PreviewElements.subtotal.getText().contains(text18);System.out.println(contains35);
			boolean contains36 = PreviewElements.CGSTtotal.getText().contains(text19);System.out.println(contains36);
			boolean contains37 = PreviewElements.SGSTTotal.getText().contains(text199);System.out.println(contains37);
			boolean contains38 = PreviewElements.CESStotal.getText().contains(text20);System.out.println(contains38);
			boolean contains39 = PreviewElements.Total.getText().contains(text21);System.out.println(contains39);
			boolean contains40 = PreviewElements.AuthorizedSignature.getText().contains(text22);System.out.println(contains40);
			boolean contains41 = PreviewElements.Thankyourforyourbussiness.getText().contains(text23);System.out.println(contains41);
			Thread.sleep(4000);

			

		}

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
