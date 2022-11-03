package UtilClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilClass1 {
	
	
	
	public static String getconfigData(String key) throws IOException 
	{
		FileInputStream file = new FileInputStream("Configuration\\config.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}
	
	public static String getscreenshot(WebDriver driver,String methodname) throws IOException 
	{
		String path = methodname + ".png";
		File Resource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileHandler.copy(Resource, dest);
		return path;
	}
	
	public List<String> ShifttoWindow(WebDriver driver) 
	{
		List<String>paymentwindow= new ArrayList<String>(driver.getWindowHandles());
		return paymentwindow;
	}
	
}
