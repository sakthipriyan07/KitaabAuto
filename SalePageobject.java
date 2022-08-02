package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalePageobject {
	
	
	@FindBy(xpath = "(//a[@class='cursor-pointer '])[4]" )
	public static WebElement sale;

	@FindBy(xpath = "(//a[text()=' Invoices'])[1]")
	public static WebElement invoice ;
	
	@FindBy(xpath = "//a[@href='https://staging-kitaab.vakilsearch.com/paymentsreceived/index']" )
	public static WebElement paymentsreceived;

	@FindBy(xpath = "//a[@href='https://staging-kitaab.vakilsearch.com/creditnote/index']" )
	public static WebElement creditnotes;

	
}
