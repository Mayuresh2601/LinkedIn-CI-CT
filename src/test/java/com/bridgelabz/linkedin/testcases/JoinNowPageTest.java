package com.bridgelabz.linkedin.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.linkedin.base.TestBase;
import com.bridgelabz.linkedin.pages.JoinNowPage;

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
		
		init_Driver(properties.getProperty("cromebrowser"));
		joinNow = new JoinNowPage();
	}
	
	
	/**
	 * Method: To validate Registration Page Title
	 */
	@Test
	public void verifyRegisterPageTitleTest() {
		
		validate = joinNow.verifyRegisterPageTitle();
		assertEquals(validate, "Sign Up | LinkedIn");
	}
	
	
	/**
	 * Method: To validate SignIn Page Link is working properly or not
	 */
	@Test
	public void validateSignInPageLinkTest() {
		
		signIn = joinNow.validateSignInPageLink();
	}
	
	
	/**
	 * Method: To Test the Registration Page is working properly or not 
	 * @throws InterruptedException 
	 */
	@Test
	public void registrationPageTest() throws InterruptedException {
		
		homePage = joinNow.registrationPage(properties.getProperty("username"), properties.getProperty("password"), properties.getProperty("firstname"), properties.getProperty("lastname"));
	}
	
	
	/**
	 * Method: To validate change Language Link is working properly or not
	 */
	@Test
	public void validateChangeLanguageLinkTest() {
		
		flag = joinNow.validateChangeLanguageLink();
		assertEquals(flag, true);
	}
	
	
	/**
	 * Method: To Run Terminate method after running each Testcases
	 */
	@AfterMethod
	public void endTest() {
		
		driver.quit();
	}
}
