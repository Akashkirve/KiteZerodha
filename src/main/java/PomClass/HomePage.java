package PomClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClass.UtilClass1;


public class HomePage extends UtilClass1{
	WebDriver driver;
	
	
	@FindBy(xpath="//span[text()='Abhijeet']")
	private WebElement hitext;
	
	@FindBy(xpath="//span[text()='Funds']")
	private WebElement ClickonFundbutton;
	
	@FindBy(xpath="//button[@type='button']")
	private WebElement AddFunds;
	
	
	
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	public String UserlandedonHP() 
	{
		String gettex = hitext.getText();
		return gettex;
	}
	
	public void clickonfund() 
	{
		ClickonFundbutton.click();
	}
	
	public boolean Clickonaddfunds() throws InterruptedException 
	{
		AddFunds.isEnabled();
		AddFunds.click();
		Thread.sleep(2000);
		List<String> address = ShifttoWindow(driver);
		driver.switchTo().window(address.get(1));

		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
