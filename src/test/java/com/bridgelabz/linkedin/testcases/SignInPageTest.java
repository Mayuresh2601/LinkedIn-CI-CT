package com.bridgelabz.linkedin.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bridgelabz.linkedin.base.TestBase;
import com.bridgelabz.linkedin.pages.SignInPage;
import com.bridgelabz.linkedin.util.TestUtil;

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
		
		init_Driver(properties.getProperty("cromebrowser"));
		signIn = new SignInPage();
	}
	
	
	/**
	 * Method: To Test the Sign In Page is working properly or not using properties file
	 * @throws InterruptedException 
	 */
	@Test
	public void SignInTest() throws InterruptedException {
		
		homePage = signIn.signIn(properties.getProperty("emailId"), properties.getProperty("passWord"));
	}
	
	
	/**
	 * Method: To Take SignIn Data form Xlsx File
	 * @return Data in Object form 
	 */
	@DataProvider
	public Object[][] getSignInTestData() {
		
		Object[][] data = TestUtil.getData(properties.getProperty("SigninSheet"));
		return data;
	}
	
	
	/**
	 * Method: To Test the Sign In Page is working properly or not using properties file
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "getSignInTestData")
	public void SignInTest(String userName, String password) throws InterruptedException {
		
		homePage = signIn.signIn(userName, password);
	}
	
	
	/**
	 * Method: To validate Forget Password Link present on Webpage or not
	 * @throws InterruptedException 
	 */
	@Test
	public void validateForgetPasswordLinkTest() throws InterruptedException {
		
		flag = signIn.validateForgetPasswordLink(properties.getProperty("username"));
		assertEquals(flag, true);
	}
	
	
	/**
	 * Method: To validate Sign In Page Title
	 */
	@Test
	public void verifySignInPageTitleTest() {
		
		validate = signIn.verifySignInPageTitle();
		assertEquals(validate, "LinkedIn Login, Sign in | LinkedIn");
	}
	
	
	/**
	 * Method: To validate Show Password Button present on Webpage or not
	 */
	@Test
	public void validateShowPasswordTest() {
		
		flag = signIn.validateShowPassword(properties.getProperty("username") ,properties.getProperty("password"));
		assertEquals(flag, true);
	}
	
	
	/**
	 * Method: To Test Join Now Link is working properly or not
	 */
	@Test
	public void validateJoinNowLinkTest() {
		
		joinNow = signIn.validateJoinNowLink();
	}
	
	
	/**
	 * Method: To validate Hide Password Button present on Webpage or not
	 */
	@Test
	public void validateHidePasswordTest() {
		
		flag = signIn.validateHidePassword(properties.getProperty("username") ,properties.getProperty("password"));
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