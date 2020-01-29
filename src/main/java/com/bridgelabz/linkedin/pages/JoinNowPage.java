/******************************************************************************
*  
*  Purpose: To Implement Join Now web Page Functionalities
*  @class Sign In Page Class
*  @author  Mayuresh Sunil Sonar
*
******************************************************************************/
package com.bridgelabz.linkedin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.linkedin.base.TestBase;

public class JoinNowPage extends TestBase{

	//Page Factories (Object Repository)
	@FindBy(linkText = "Join now")
	WebElement joinNow;
	
	@FindBy(xpath = "//input[contains(@name,'email')]")
	WebElement emailId;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement joinBtn;
	
	@FindBy(name = "first-name")
	WebElement firstName;
	
	@FindBy(name = "last-name")
	WebElement lastName;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueBtn;
	
	@FindBy(linkText = "Sign in")
	WebElement signInLink;
	
	@FindBy(xpath = "//label[contains(@class,'label-more')]")
	WebElement changeLanguage;
	
	
	/**
	 * Constructor: To Initialize the WebElements generated from FindBy Annotation
	 */
	public JoinNowPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	/**Method: To verify Registration Page Title
	 * @return String
	 */
	public String verifyRegisterPageTitle() {
		
		joinNow.click();
		return driver.getTitle();
	}
	
	
	/**Method: To validate SignIn Page Link present on Webpage
	 * @return true
	 */
	public SignInPage validateSignInPageLink() {
		
		joinNow.click();
		signInLink.click();
		return new SignInPage();
	}
	
	
	/**Method: To validate change Language Link present on Webpage
	 * @return true
	 */
	public boolean validateChangeLanguageLink() {
		
		joinNow.click();
		return changeLanguage.isDisplayed();
	}
	
	
	/**Method: To Register a user from properties file data
	 * @param un
	 * @param pwd
	 * @param fname
	 * @param lname
	 * @return Homepage Object
	 * @throws InterruptedException 
	 */
	public HomePage registrationPage(String un, String pwd, String fname, String lname) throws InterruptedException {
		
		joinNow.click();
		emailId.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(2000);
		joinBtn.click();
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		Thread.sleep(2000);
		continueBtn.click();
		return new HomePage();
	}
}