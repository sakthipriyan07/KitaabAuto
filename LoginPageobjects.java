package PageFactory;


 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;





public class LoginPageobjects {
   
@FindBy(xpath = "//input[@class='styles_numberInput__PiVGE']" )
	public static WebElement Phonenumber;
	
@FindBy(xpath = "//span[@class='styles_checkmark__FVEKk']" )
public static WebElement aggrementCheckbox;
	
@FindBy(xpath = "//input[@datainput='1']" )
public static WebElement OTP1;

@FindBy(xpath = "//input[@datainput='2']" )
public static WebElement OTP2;
	
@FindBy(xpath = "//input[@datainput='3']" )
public static WebElement OTP3;	
	
@FindBy(xpath = "//input[@datainput='4']" )
public static WebElement OTP4;		

@FindBy(xpath = "//button[@class='styles_continueBtn__e8nQA styles_valid__1g8cl']" )
public static WebElement PhoneNumberContinue ;

@FindBy(xpath = "//button[@class='styles_continueBtn__e8nQA styles_valid__1g8cl']" )
public static WebElement OTPContinue ;
}
