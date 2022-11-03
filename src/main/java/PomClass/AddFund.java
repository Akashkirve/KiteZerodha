package PomClass;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClass.UtilClass1;

public class AddFund extends UtilClass1{
	WebDriver driver;
	
	@FindBy(xpath="//h1[text()='Deposit funds']")
	private WebElement Useronaddfundpage;
	
	@FindBy(xpath="//input[@id='addfunds_amount']")
	private WebElement Enteramounttoadd;
	
	@FindBy(xpath="//button[@id='addfunds_submit']")
	private WebElement Clickoncontinue;
	
	@FindBy(xpath="//p[@class='upi-inst']")
	private WebElement Paymentmsg;
	
	
	public AddFund(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public String Usercandepositefund() throws InterruptedException 
	{
		String textdepositefund = Useronaddfundpage.getText();
		return textdepositefund;
	}
	
	public void fillpaymentdetails() 
	{
		
		Enteramounttoadd.sendKeys("10");
		Clickoncontinue.click();
		
	}
	
	public boolean usercompletethepayment() 
	{
		Paymentmsg.getText();
		return true;
	}
	
	

}
