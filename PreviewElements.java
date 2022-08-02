package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreviewElements {
	@FindBy(xpath = "//div//h3[contains(text(),'FZ ENTERPRISES')]")
	public static WebElement CompanyName;

	@FindBy(xpath = "//div//h4[contains(text(),'Tax Quotation')]")
	public static WebElement TaxInvoice;

	@FindBy(xpath = "//div//p[contains(text(),'From')]")
	public static WebElement From;

	@FindBy(xpath = "//div//p[contains(text(),'Bill to')]")
	public static WebElement Billto;

	@FindBy(xpath = "(//div//span[contains(text(),'Quotation')])[1]")
	public static WebElement Quotation;

	@FindBy(xpath = "(//div//span[contains(text(),'Quotation')])[2]")
	public static WebElement QuotationDate;

	@FindBy(xpath = "//div//span[contains(text(),'Expiry Date:')]")
	public static WebElement ExpiryDate;

	@FindBy(xpath = "//div//th[contains(text(),'S.no')]")
	public static WebElement Sno;

	@FindBy(xpath = "//div//th[contains(text(),'Item/Services')]")
	public static WebElement itemsSerices;

	@FindBy(xpath = "//div//th[contains(text(),'HSN/SAC')]")
	public static WebElement HsnSac;

	@FindBy(xpath = "//div//th[contains(text(),'Price/Unit')]")
	public static WebElement PriceUnit;

	@FindBy(xpath = "//div//th[contains(text(),'Quantity')]")
	public static WebElement Quantity;

	@FindBy(xpath = "//div//th[contains(text(),'Discount')]")
	public static WebElement Discount;

	@FindBy(xpath = "//div//th[contains(text(),'Taxable Value')]")
	public static WebElement Taxablevalue;

	@FindBy(xpath = "//div//th[contains(text(),'GST')]")
	public static WebElement GST;

	@FindBy(xpath = "//div//th[contains(text(),'CESS')]")
	public static WebElement CESS;

	@FindBy(xpath = "//div//th[contains(text(),'Amount')]")
	public static WebElement Amount;

	@FindBy(xpath = "//div//div[contains(text(),'Sub Total')]")
	public static WebElement subtotal;

	@FindBy(xpath = "//div//p[contains(text(),'IGST')]")
	public static WebElement IGSTtotal;

	@FindBy(xpath = "//div//p[contains(text(),'CGST')]")
	public static WebElement CGSTtotal;

	@FindBy(xpath = "//div//p[contains(text(),'CESS')]")
	public static WebElement CESStotal;

	@FindBy(xpath = "//div//p[contains(text(),'Authorized Signature')]")
	public static WebElement AuthorizedSignature;

	@FindBy(xpath = "//div//p[contains(text(),'Thank you for your business')]")
	public static WebElement Thankyourforyourbussiness;

	@FindBy(xpath = "(//div//div[contains(text(),'Total')])[2]")
	public static WebElement Total;

	@FindBy(xpath = "//div[@class='preview_linkContainer__6EOWa']")
	public static WebElement URLlink;

	@FindBy(xpath = "//div//p[contains(text(),'SGST')]")
	public static WebElement SGSTTotal;

}
