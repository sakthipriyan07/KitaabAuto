package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreviewValues {
	
	
@FindBy(xpath = "//div//p[contains(text(),'GSTIN')]" )
public static WebElement FromGSTIN;

@FindBy(xpath = "(//div[@Class='styles_toInfo__hrwcB']//child::p)[2]" )
public static WebElement CustomerName;
	
@FindBy(xpath = "(//div[@Class='styles_toInfo__hrwcB']//child::p)[3]" )
public static WebElement Address;

@FindBy(xpath = "(//div[@Class='styles_toInfo__hrwcB']//child::p)[4]" )
public static WebElement Date;

@FindBy(xpath = "(//div[@class='styles_invoiceData__HkbVp']//child::p)[1]" )
public static WebElement InvoiceIDValue;

@FindBy(xpath = "(//div[@class='styles_invoiceData__HkbVp']//child::p)[2]" )
public static WebElement InvoiceDateValue;

@FindBy(xpath = "(//div[@class='styles_invoiceData__HkbVp']//child::p)[3]" )
public static WebElement DueDateValue;

@FindBy(xpath = "(//div[@class='styles_invoiceData__HkbVp']//child::p)[4]" )
public static WebElement DueAmountValue ;

@FindBy(xpath = "(//table//td)[1]" )
public static WebElement Table1;

@FindBy(xpath = "(//table//td)[2]" )
public static WebElement Table2;

@FindBy(xpath = "(//table//td)[3]" )
public static WebElement Table3;

@FindBy(xpath = "(//table//td)[4]" )
public static WebElement Table4;

@FindBy(xpath = "(//table//td)[5]" )
public static WebElement Table5;

@FindBy(xpath = "(//table//td)[6]" )
public static WebElement Table6;

@FindBy(xpath = "(//table//td)[7]" )
public static WebElement Table7;

@FindBy(xpath = "(//table//td)[8]" )
public static WebElement Table8;

@FindBy(xpath = "(//table//td)[9]" )
public static WebElement Table9;

@FindBy(xpath = "(//table//td)[10]" )
public static WebElement Table10;

@FindBy(xpath = "(//p[@class='styles_item__pGOg_']//child::p)[1]" )
public static WebElement IGSTValue;

@FindBy(xpath = "(//p[@class='styles_item__pGOg_']//child::p)[2]" )
public static WebElement CESSValue;

@FindBy(xpath = "//div[@class='styles_total__DqDxq']//child::p" )
public static WebElement TotalValue;

@FindBy(xpath = "(//div//p[@class='styles_item__pGOg_']//child::p)[1]" )
public static WebElement CGSTValue;

@FindBy(xpath = "(//div//p[@class='styles_item__pGOg_']//child::p)[2]" )
public static WebElement SGSTValue;



}
