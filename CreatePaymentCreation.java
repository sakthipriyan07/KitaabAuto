package PageFactory;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;


public class CreatePaymentCreation {
	
	@FindBy (xpath = " (//h3[@class='__mantine-ref-itemTitle mantine-oih4rj mantine-Accordion-itemTitle'])[3]")
    public static WebElement Paymentmenu ;
	
    @FindBy (xpath = "(//p[@class='styles_navBarItems__yK8N5'])[7]")
    public static WebElement Incoming ;
	
	@FindBy (xpath = "//span[@class='style_btnContent__eD4lq']")
	public static WebElement AddPayment ;
			
	@FindBy (xpath = "//input[@class='mantine-TextInput-defaultVariant styles_input__flCxX mantine-TextInput-input mantine-g773hu']")
	public static WebElement SetCustomerName;
	
	@FindBy (xpath = "//input[@class='mantine-TextInput-defaultVariant styles_input__mdIft mantine-TextInput-input mantine-TextInput-disabled mantine-2e65le']")
	public static WebElement VSetCustomerName;
	
	@FindBy (xpath = "//input[@class='mantine-NumberInput-defaultVariant styles_input__flCxX mantine-NumberInput-input mantine-NumberInput-withIcon mantine-vw7gp8']")
	public static WebElement Setamount ;
	
	@FindBy (xpath = "//input[@class='mantine-NumberInput-defaultVariant styles_input__mdIft mantine-NumberInput-input mantine-NumberInput-withIcon mantine-1hpm6se']")
	public static WebElement VSetamount ;
	
	@FindBy (xpath = "//input[@class='mantine-DatePicker-defaultVariant styles_input__flCxX mantine-DatePicker-input __mantine-ref-freeInput mantine-DatePicker-freeInput styles_input__flCxX mantine-DatePicker-input mantine-1dhkkkk']")
	public static WebElement SelectDate;
	
	@FindBy (xpath = "//input[@class='mantine-DatePicker-defaultVariant styles_input__mdIft mantine-DatePicker-input __mantine-ref-freeInput mantine-DatePicker-freeInput styles_input__mdIft mantine-DatePicker-input mantine-1dhkkkk']")
	public static WebElement VSelectDate;
	
	@FindBy (xpath = "//button[@class='styles_saveBtn__LlJKq']")
	public static WebElement Save ;
	
	@FindBy (xpath = "//button[@class='styles_saveBtn__Sl2v5 primary-button']")
	public static WebElement SaveEdit ;
	
	@FindBy (xpath = "//input[@placeholder='Search in Table']")
	public static WebElement SearchPaymentList ;	
	
	@FindBy (xpath = "//td[@class='styles_invoiceNumber__qMUO4']//child::p")
	public static WebElement SelectTable ;
	
	@FindBy (xpath = "//ul[@class='styles_dropDown__Ca5AM']")
	public static WebElement CustomerNamedropdown ;

}
