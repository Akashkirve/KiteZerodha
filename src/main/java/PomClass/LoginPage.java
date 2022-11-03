package PomClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClass.UtilClass1;

public class LoginPage extends UtilClass1{
	WebDriver driver;
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement userid;	
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;	
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginbutton;
	


	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void getuserid() throws IOException 
	{
		userid.sendKeys(getconfigData("id"));
	}
	
	public void enterpassword() throws IOException 
	{
		password.sendKeys(getconfigData("pass"));
	}
	
	public void clickonloginbutton() 
	{
		loginbutton.click();
	}
	

}
