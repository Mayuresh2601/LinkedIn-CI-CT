package com.bridgelabz.linkedin.testcases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bridgelabz.linkedin.base.TestBase;
import com.bridgelabz.linkedin.pages.SignInPage;
import com.bridgelabz.linkedin.util.TestUtil;

public class HomePageTest extends TestBase{
	
	
	/**
	 * Constructor: To Avoid Null Pointer Exception by going to parent class(TestBase) using super()
	 */
//	public HomePageTest() {
//		
//		super();
//	}
	
	
	/**Method: To Run Initialize method before running each Testcases
	 * @throws InterruptedException
	 */
	@BeforeMethod
	public void beginTest() throws InterruptedException {
		
		init_Driver(properties.getProperty("chromebrowser"));
		signIn = new SignInPage();
		homePage = signIn.signIn(properties.getProperty("emailId"), properties.getProperty("passWord"));
	}
	
	
	/**
	 * Method: To create the Text Description Page on Linkedin Profile
	 * @throws InterruptedException 
	 */
	@Test
	public void verifyHomePageTitleTest() {
		
		validate = homePage.verifyHomePageTitle();
		assertEquals(validate, "(1) LinkedIn");
	}
	
	
	/**
	 * Method: To Take Text Description Data form Xlsx File
	 * @return Data in Object form 
	 */
	@DataProvider
	public Object[][] getTextPostData() {
		
		Object[][] data = TestUtil.getData(properties.getProperty("textPostSheet"));
		return data;
	}
	
	
	/**
	 * Method: To create the Text Description Page on Linkedin Profile
	 * @param text
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "getTextPostData")
	public void createTextPostTest(String text) throws InterruptedException {
		
		homePage.createTextPost(text);
		Thread.sleep(2000);
	}
	
	
	/**
	 * Method: To Take Image Text Description Data form Xlsx File
	 * @return Data in Object form 
	 */
	@DataProvider
	public Object[][] getImgTextPostData() {
		
		Object[][] data = TestUtil.getData(properties.getProperty("imagePostSheet"));
		return data;
	}
	
	
	/**Method: To create the Upload Text Description Page on Linkedin Profile
	 * @param imgPath
	 * @param text
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "getImgTextPostData")
	public void uploadImagePostTest(String imgPath, String text) throws InterruptedException, AWTException {
		
		homePage.uploadImagePost(imgPath, text);
		Thread.sleep(2000);
	}
	
	
	/**
	 * Method: To Run Terminate method after running each Testcases
	 */
	@AfterMethod
	public void endTest() {
		
		driver.quit();
	}
}
