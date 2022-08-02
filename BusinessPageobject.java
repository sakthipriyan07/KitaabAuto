package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusinessPageobject {
	
	@FindBy(xpath = "(//button[@class='mantine-Button-filled mantine-Button-root styles_currentSelectedCompany__QkgAK mantine-1grzg0q']//child::div)[1]" )
	public static WebElement CompanyList;

	@FindBy(xpath = "(//button[@class='styles_list__Ur99H']//child::h4)[6]" )
	public static WebElement Businessname;
		
	@FindBy(xpath = "//span//*[contains(text(),'Create Invoice')]" )
	public static WebElement CreateInvoice;
}
