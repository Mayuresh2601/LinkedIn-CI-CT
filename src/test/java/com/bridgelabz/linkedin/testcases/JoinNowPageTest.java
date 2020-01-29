/******************************************************************************
*  
*  Purpose: To create automation script of Join Now Linkedin Page
*  @class JoinNow Page Test
*  @author  Mayuresh Sunil Sonar
*
******************************************************************************/
package com.bridgelabz.linkedin.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bridgelabz.linkedin.base.TestBase;
import com.bridgelabz.linkedin.pages.JoinNowPage;
import com.bridgelabz.linkedin.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class JoinNowPageTest extends TestBase{
	
	
	/**
	 * Constructor: To Avoid Null Pointer Exception by going to parent class(TestBase) using super()
	 */
	public JoinNowPageTest() {
		
		super();
	}

	
	/**
	 * Method: To Run Initialize method before running each Testcases
	 */
	@BeforeMethod
	public void beginTest() {
		
		init_Driver(properties.getProperty("chromebrowser"));
		joinNow = new JoinNowPage();
	}

	
	/**
	 * Method: To Set the Extent Report in test-output file
	 */
	@BeforeTest
	public void setReport() {
		
		reports = new ExtentReports(System.getProperty("user.dir")+ "/test-output/ExtentReport.html", true);
		reports.addSystemInfo("User Name", "admin1");
		reports.addSystemInfo("Host Name", "admin1-H110M-H");
	}
	
	
	/**
	 * Method: To validate Registration Page Title
	 */
	@Test(priority = 1)
	public void verifyRegisterPageTitleTest() {
		
		extentTest = reports.startTest("verifyRegisterPageTitleTest");
		validate = joinNow.verifyRegisterPageTitle();
		assertEquals(validate, "Sign Up | LinkedIn");
	}
	
	
	/**
	 * Method: To validate SignIn Page Link is working properly or not
	 */
	@Test(priority = 3)
	public void validateSignInPageLinkTest() {
		
		extentTest = reports.startTest("validateSignInPageLinkTest");
		signIn = joinNow.validateSignInPageLink();
	}
	
	
	/**
	 * Method: To Test the Registration Page is working properly or not 
	 * @throws InterruptedException 
	 */
	@Test(priority = 2)
	public void registrationPageTest() throws InterruptedException {
		
		extentTest = reports.startTest("registrationPageTest");
		homePage = joinNow.registrationPage(properties.getProperty("username"), properties.getProperty("password"), properties.getProperty("firstname"), properties.getProperty("lastname"));
	}
	
	
	/**
	 * Method: To validate change Language Link is working properly or not
	 */
	@Test(priority = 4)
	public void validateChangeLanguageLinkTest() {
		
		extentTest = reports.startTest("validateChangeLanguageLinkTest");
		flag = joinNow.validateChangeLanguageLink();
		assertEquals(flag, true);
	}
	
	
	/**
	 * Method: To flush and close the Extent Report
	 */
	@AfterTest
	public void endReport() {
		
		reports.flush();
		reports.close();
	}
	
	
	/**
	 * Method: To Run Terminate method after running each Testcases
	 */
	@AfterMethod
	public void endTest(ITestResult result) {
		
		if (result.getStatus() == (ITestResult.SUCCESS)) {
			
			extentTest.log(LogStatus.PASS, "Passed Test Case is: "+result.getName());
		} 
		else if (result.getStatus() == (ITestResult.FAILURE)) {
			
			extentTest.log(LogStatus.FAIL, "Failed Test Case is: "+result.getName());
			extentTest.log(LogStatus.FAIL, "Failed Test Case error is: "+result.getThrowable());
			String screenshotPath = TestUtil.getScreenShots();
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		}
		else if (result.getStatus() == (ITestResult.SKIP)) {
			
			extentTest.log(LogStatus.SKIP, "Skiped Test Case is: "+result.getName());
		}
		reports.endTest(extentTest);
		driver.quit();
	}
}
