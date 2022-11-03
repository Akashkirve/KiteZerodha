package TestClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClass.BaseClass1;
import PomClass.AddFund;
import PomClass.HomePage;
import PomClass.LoginPage;
import UtilClass.UtilClass1;

public class TestClass1 {
	static WebDriver driver;
	LoginPage lp;
	HomePage hp;
	AddFund fp;
	ExtentHtmlReporter htmlreporter;
	ExtentReports reports;
	ExtentTest extentTest;
	
	@BeforeClass()
	public void beforeclass() 
	{
		htmlreporter = BaseClass1.htmlreporter();
		reports = BaseClass1.getextentreports();
		extentTest = BaseClass1.gettest("Test1");
		driver=BaseClass1.getDriver();
	}
	
	@BeforeMethod()
	public void beforemethod() 
	{
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		fp = new AddFund(driver);
	}
	
	@Test(priority = 1)
	public void test1() throws IOException, InterruptedException 
	{
	lp.getuserid();
	lp.enterpassword();
	lp.clickonloginbutton();
	Thread.sleep(3000);
	String gettext = hp.UserlandedonHP();
	Assert.assertEquals(gettext, "Abhijeet", "User is on home page");
	}
	@Test(priority = 2)
	public void Verifyusercanclickonfund() throws InterruptedException 
	{
		hp.clickonfund();
		Assert.assertTrue(hp.Clickonaddfunds());
	}
	
	@Test(priority =3)
	public void Verifyuseronfundpage() throws InterruptedException 
	{
		String text1 = fp.Usercandepositefund();
		Assert.assertEquals(text1, "Deposit funds", "User can add payment details");
	}
	
	@Test(priority =4)
	public void Useraddpayment() 
	{
		fp.fillpaymentdetails();
		Assert.assertTrue(fp.usercompletethepayment());
		
	}
	
	
	@AfterMethod()
	public void Aftermethod(ITestResult result) throws IOException 
	{
		if(result.getStatus()==ITestResult.SUCCESS) 
		{
			extentTest.log(Status.PASS, "Test :"+result.getName());
		}else if(result.getStatus()==ITestResult.FAILURE) 
		{
			String path = UtilClass1.getscreenshot(driver, result.getName());
			extentTest.log(Status.FAIL, "Test:"+result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}else if(result.getStatus()==ITestResult.SKIP)
		{
			extentTest.log(Status.SKIP, "Test:"+result.getName());
		}
	}
	@AfterClass()
	public void Afterclass() 
	{
		reports.flush();
	}

}
