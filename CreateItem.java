package PageFactory;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateItem {
	
	@FindBy (xpath = "//div//span[contains(text(),'Add Item')]")
	public static WebElement AddItem ;
	
	@FindBy (xpath = "//*[contains(text(),'Create new item')]")
	public static WebElement CreateNewItem ;
			
	@FindBy (xpath = "//div[contains(text(),'Goods')]")
	public static WebElement GoodsSelection ;
	
	@FindBy (xpath = "//input[@Placeholder='Eg. Pen']")
	public static WebElement Itemname ;
	
	@FindBy (xpath = "(//input[@Placeholder='Set amount'])[1]")
	public static WebElement PricePerUnit ;
	
	@FindBy (xpath = "(//span[contains(text(),'Save')])[2]")
	public static WebElement itemsave ;
	
	@FindBy (xpath = "(//button[@class='mantine-ActionIcon-transparent mantine-ActionIcon-root mantine-v6vv98'])[2]")
	public static WebElement addItem1 ;
	
	@FindBy (xpath = "(//button[@class='mantine-ActionIcon-transparent mantine-ActionIcon-root mantine-v6vv98'])[4]")
	public static WebElement addItem2 ;
	
	@FindBy (xpath = "(//button[@class='mantine-ActionIcon-transparent mantine-ActionIcon-root mantine-v6vv98'])[6]")
	public static WebElement addItem3 ;
	
	@FindBy (xpath = "(//button[@class='mantine-ActionIcon-transparent mantine-ActionIcon-root mantine-v6vv98'])[8]")
	public static WebElement addItem4 ;
	
	@FindBy (xpath = "(//button[@class='mantine-ActionIcon-transparent mantine-ActionIcon-root mantine-v6vv98'])[10]")
	public static WebElement addItem5 ;
	
	@FindBy (xpath = "(//button[@class='mantine-ActionIcon-transparent mantine-ActionIcon-root mantine-v6vv98'])[12]")
	public static WebElement addItem6 ;
	
	@FindBy (xpath = "(//button[@class='mantine-ActionIcon-transparent mantine-ActionIcon-root mantine-v6vv98'])[14]")
	public static WebElement addItem7 ;
	
	@FindBy (xpath = "(//button[@class='mantine-ActionIcon-transparent mantine-ActionIcon-root mantine-v6vv98'])[16]")
	public static WebElement addItem8 ;
	
	@FindBy (xpath = "//div//button[contains(text(),'Add')]")
	public static WebElement addItem ;
}
