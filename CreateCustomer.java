package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCustomer {
	
	@FindBy (xpath = "//input[@Placeholder='Enter Business’ trade Name']")
	public static WebElement Customername ;
	
	@FindBy (xpath = "(//input[@class='mantine-TextInput-defaultVariant mantine-TextInput-input mantine-g773hu'])[4]")
	public static WebElement Phonenumber ;
			
	@FindBy (xpath = "(//input[@class='mantine-TextInput-defaultVariant mantine-TextInput-input mantine-g773hu'])[5]")
	public static WebElement Emailaddress;
	
	@FindBy (xpath = "(//input[@class='mantine-TextInput-defaultVariant mantine-TextInput-input mantine-g773hu'])[3]")
	public static WebElement LegalName ;
	
	@FindBy (xpath = "//div//input[@class='mantine-TextInput-defaultVariant mantine-TextInput-input mantine-z8b1bz']")
	public static WebElement GSTIN;
	
	@FindBy (xpath = "//input[@class='mantine-Select-defaultVariant styles_currencyInput__a1OXh mantine-Select-input mantine-Select-withIcon mantine-31uwbi']")
	public static WebElement Currency ;
	
	@FindBy (xpath = "(//div[@class='mantine-3xbgk5 mantine-Button-inner'])[11]")
	public static WebElement Save ;
	
	@FindBy (xpath = "//button[@class='mantine-Button-filled mantine-Button-root styles_saveBtn__ZjXZc mantine-1grzg0q']")
	public static WebElement SaveEdit ;

}
