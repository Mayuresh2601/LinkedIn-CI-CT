/******************************************************************************
*  
*  Purpose: To Implement Object Repository for Linkedin Web Application
*  @class Test Base
*  @author  Mayuresh Sunil Sonar
*
******************************************************************************/
package com.bridgelabz.linkedin.base;

import java.awt.Robot;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.bridgelabz.linkedin.pages.HomePage;
import com.bridgelabz.linkedin.pages.JoinNowPage;
import com.bridgelabz.linkedin.pages.SignInPage;
import com.bridgelabz.linkedin.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;
	public static Workbook workBook;
	public static Sheet sheet;
	public static FileInputStream file;
	public static Actions action;
	public static Alert alert;
	public static Robot robot;
	public static JoinNowPage joinNow;
	public static SignInPage signIn;
	public static HomePage homePage;
	public static TestUtil utility;
	public static String validate;
	public static boolean flag;
	public static ExtentReports reports;
	public static ExtentTest extentTest;

	/**
	 * Constructor: To Load the Properties file in file.io
	 */
	public TestBase() {
		try {
			
			properties = new Properties();
			file = new FileInputStream("/home/admin1/eclipse-workspace/Mayuresh/Selenium/Linkedin/src/main/java/com/bridgelabz/linkedin/config/config.properties");
			properties.load(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Method: To Initialize the WebDriver 
	 */
	public static void init_Driver(String browserName) {
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/admin1/eclipse-workspace/Mayuresh/LinkedinCI-CT/src/main/java/com/bridgelabz/linkedin/repository/LinkedInTestData.xlsx");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		
		driver.get(properties.getProperty("url"));
	}
}