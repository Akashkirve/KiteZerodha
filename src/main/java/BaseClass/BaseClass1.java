package BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {

	static WebDriver driver;
	static ExtentHtmlReporter htmlreporter;
	static ExtentReports reports;
	static ExtentTest extenttest;
	
	public static WebDriver getDriver() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	} 
	
	public static ExtentHtmlReporter htmlreporter() 
	{
		if(htmlreporter==null) 
		{
			htmlreporter = new ExtentHtmlReporter("reports.html");
		}
		return htmlreporter;
	}
	
	public static ExtentReports getextentreports() 
	{
		
		if(reports==null) 
		{
			reports = new ExtentReports();
			reports.attachReporter(htmlreporter);
		}
		return reports;
	}
	
	public static ExtentTest gettest(String TestName) 
	{
		extenttest = reports.createTest(TestName);
		return extenttest;
	}
	
	
	
	
	
	
	
	
	
	
	
}
