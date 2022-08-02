package PageFactory;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuotationCreation {
	
	@FindBy (xpath = "(//p[@class='styles_navBarItems__yK8N5'])[2]")
	public static WebElement SelectQuotation ;
	
	@FindBy (xpath = "//span[@class='styles_btnContent__2KD0X']")
	public static WebElement CreateQuotation ;
			
	@FindBy (xpath = "(//span[@class='mantine-qo1k2 mantine-Button-label'])[2]")
	public static WebElement SaveQuotation ;
	//
	@FindBy (xpath = "//div//button[contains(text(),'Convert to Invoice')]")
	public static WebElement ConvertInvoice ;
	
	@FindBy (xpath = "//div//span[contains(text(),'Save Sales Invoice')]")
	public static WebElement SaveSalesInvoice ;
	
	@FindBy (xpath = "(//p//span[contains(text(),'')])[2]")
	public static WebElement QuotationID ;
	
	@FindBy (xpath = "//div//p[contains(text(),'QTN-')]")
	public static WebElement LinkedQuotation ;
	
	@FindBy (xpath = "//p//span[contains(text(),'INV-')]")
	public static WebElement InvoiceId ;
	
	@FindBy (xpath = "//div//p[contains(text(),'INV-')]")
	public static WebElement LinkedInvoice ;
	
	@FindBy (xpath = "//button[contains(text(),'View')]")
	public static WebElement ViewInvoice ;
	
	@FindBy (xpath = "(//div[@class='__mantine-ref-icon mantine-Accordion-icon mantine-17nqw07'])[1]")
	public static WebElement Sales ;
	
	@FindBy (xpath = "//td[@class='styles_amount__Qi6Ek']//child::p")
	public static WebElement lineamount ;
	
	@FindBy (xpath = "//input[@type='search']")
	public static WebElement Searchcustomerquo ;
	
	@FindBy (xpath = "//*[@id=\"__next\"]/div[1]/div/main/div/div[1]/div[1]/button/img")
	public static WebElement Quotationback ;
}
