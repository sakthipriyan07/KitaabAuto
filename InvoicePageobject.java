package PageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class InvoicePageobject {
	
	@FindBy(xpath = "//input[@placeholder='hsn/sac']" )
	public static WebElement Itemhscsac;
	
	@FindBy(xpath = "(//div[@class='mantine-yxyjyg mantine-Autocomplete-icon']//child::*)[4]//following::input[1]" )
	public static WebElement SelectCustomer;
	
	@FindBy(xpath = "//button[@class='mantine-Button-filled mantine-Button-root primary-button mantine-1grzg0q']//child::div" )
	public static WebElement SaveInvoice;
	
	@FindBy(xpath = "//img[@src='/arrow-left.svg']" )
	public static WebElement BackInvoice;
	
	@FindBy(xpath = "//p[@class='styles_dueAmount__P6cec']" )
	public static WebElement PreviewTotalDueamount;
	
	@FindBy(xpath = "(//input[@Class='mantine-Input-filledVariant mantine-Input-input mantine-Input-withIcon mantine-w5np30'])[4]" )
	public static WebElement Gst;
	
	@FindBy(xpath = "//div//span[contains(text(),'+ Add additional Charges')]" )
	public static WebElement AddAditionalCharges;
	
	@FindBy(xpath = "//input[@placeholder='additionalCharges name']" )
	public static WebElement AddAditionalChargesName;
	
	@FindBy(xpath = "(//input[@class='mantine-TextInput-defaultVariant mantine-TextInput-input mantine-TextInput-withIcon mantine-1lp14sr'])[1]" )
	public static WebElement AddAditionalChargesAmount;
	
	@FindBy(xpath = "//div//span[contains(text(),'+ Add Discount')]" )
	public static WebElement Discount;
	
	@FindBy(xpath = "//input[@placeholder='discount name']" )
	public static WebElement DiscountName;
	
	@FindBy(xpath = "(//input[@class='mantine-TextInput-defaultVariant mantine-TextInput-input mantine-TextInput-withIcon mantine-1lp14sr'])" )
	public static WebElement DiscountAmount;
	
	@FindBy(xpath = "//div//span[contains(text(),'+ Deduct TDS')]" )
	public static WebElement DeductTDS;
	
	@FindBy(xpath = "(//input[@class='mantine-TextInput-defaultVariant mantine-TextInput-input mantine-TextInput-withIcon mantine-1lp14sr'])[3]" )
	public static WebElement DeductTDSAmount;
	
	@FindBy(xpath = "(//div//button[contains(text(),'+ Add Customer')])[5]" )
	public static WebElement addcustomer;
	
	@FindBy(xpath = "//button[@class='mantine-Button-filled mantine-Button-root secondary-button mantine-1bd46bx']" )
	public static WebElement Edit;
	
	@FindBy(xpath = "(//div[@class='styles_itemIcon__x5K_I'])[1]" )
	public static WebElement Invoicemenu;
	
	@FindBy(xpath = "(//input[@class='mantine-Input-filledVariant mantine-Input-input mantine-Input-withIcon mantine-w5np30'])[2]" )
	public static WebElement Discountrate;
	
	@FindBy(xpath = "(//input[@Class='mantine-Input-filledVariant mantine-Input-input mantine-Input-withIcon mantine-w5np30'])[5]" )
	public static WebElement CESSPercent;
	
	@FindBy(xpath = "(//div[@class='styles_flexItem__AER3F']//child::div)[2]" )
	public static WebElement Taxableamount;
	
	@FindBy(xpath = "(//div[@class='styles_flexItem__AER3F']//child::div)[4]" )
	public static WebElement SGSTAmount;
	
	@FindBy(xpath = "(//div[@class='styles_flexItem__AER3F']//child::div)[6]" )
	public static WebElement CGSTAmount;
	
	@FindBy(xpath = "(//div[@class='styles_flexItem__AER3F']//child::div)[4]" )
	public static WebElement IGSTAmount;
	
	@FindBy(xpath = "(//div[@class='styles_flexItem__AER3F']//child::div)[6]" )
	public static WebElement IGSTCessAmount;
	
	@FindBy(xpath = "(//div[@class='styles_flexItem__AER3F']//child::div)[8]" )
	public static WebElement GSTCessAmount;
	
	@FindBy(xpath = "(//div[@class='styles_flexItem__AER3F']//child::div)[3]" )
	public static WebElement SGSTValidation;
	
	@FindBy(xpath = "(//div[@class='styles_flexItem__AER3F']//child::div)[3]" )
	public static WebElement IGSTValidation;
	
	@FindBy(xpath = "//input[@placeholder='Search by item name']" )
	public static WebElement Searchbyitem;
}

	