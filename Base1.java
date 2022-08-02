package PageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Base1{
	
	public void Quotation() {
		WebDriver driver = new ChromeDriver();
		PageFactory.initElements(driver, QuotationCreation.class);
		
		PageFactory.initElements(driver, QuotationCreation.class);
		
		String C = QuotationCreation.SelectQuotation.getText();
		String D1 = "Quotations";
		QuotationCreation.Sales.click();
		
		
		
		if (C.contains(D1)) {
			
		} else {

		} 
	}

	
	
	
}









