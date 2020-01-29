/******************************************************************************
*  
*  Purpose: To create automation script of Sign In Linkedin Page
*  @class Sign In Page Test
*  @author  Mayuresh Sunil Sonar
*
******************************************************************************/
package com.bridgelabz.linkedin.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bridgelabz.linkedin.base.TestBase;
import com.bridgelabz.linkedin.pages.SignInPage;
import com.bridgelabz.linkedin.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class SignInPageTest extends TestBase{
	
	
	/**
	 * Constructor: To Avoid Null Pointer Exception by going to parent class(TestBase) using super()
	 */
	public SignInPageTest() {
		
		super();
	}
	
	
	/**
	 * Method: To Run Initialize method before running each Testcases
	 */
	@BeforeMethod
	public void beginTest() {
		
		init_Driver(properties.getProperty("chromebrowser"));
		signIn = new SignInPage();
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
	 * Method: To Test the Sign In Page is working properly or not using properties file
	 * @throws InterruptedException 
	 */
	@Test
	public void SignInTest() throws InterruptedException {
		
		extentTest = reports.startTest("SignInTest");
		homePage = signIn.signIn(properties.getProperty("emailId"), properties.getProperty("passWord"));
	}
	
	
	/**
	 * Method: To validate Forget Password Link present on Webpage or not
	 * @throws InterruptedException 
	 */
	@Test
	public void validateForgetPasswordLinkTest() throws InterruptedException {
		
		extentTest = reports.startTest("validateForgetPasswordLinkTest");
		flag = signIn.validateForgetPasswordLink(properties.getProperty("username"));
		assertEquals(flag, true);
	}
	
	
	/**
	 * Method: To validate Sign In Page Title
	 */
	@Test
	public void verifySignInPageTitleTest() {
		
		extentTest = reports.startTest("verifySignInPageTitleTest");
		validate = signIn.verifySignInPageTitle();
		Assert.assertEquals(validate, "LinkedIn Login, Sign in | LinkedIn");
	}
	
	
	/**
	 * Method: To validate Show Password Button present on Webpage or not
	 */
	@Test
	public void validateShowPasswordTest() {
		
		extentTest = reports.startTest("validateShowPasswordTest");
		flag = signIn.validateShowPassword(properties.getProperty("username") ,properties.getProperty("password"));
		assertEquals(flag, true);
	}
	
	
	/**
	 * Method: To Test Join Now Link is working properly or not
	 */
	@Test
	public void validateJoinNowLinkTest() {
		
		extentTest = reports.startTest("validateJoinNowLinkTest");
		joinNow = signIn.validateJoinNowLink();
	}
	
	
	/**
	 * Method: To validate Hide Password Button present on Webpage or not
	 */
	@Test
	public void validateHidePasswordTest() {
		
		extentTest = reports.startTest("validateHidePasswordTest");
		flag = signIn.validateHidePassword(properties.getProperty("username") ,properties.getProperty("password"));
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