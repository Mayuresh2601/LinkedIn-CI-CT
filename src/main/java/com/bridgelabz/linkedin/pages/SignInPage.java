/******************************************************************************
*  
*  Purpose: To Implement Sign In web Page Functionalities
*  @class Sign In Page Class
*  @author  Mayuresh Sunil Sonar
*
******************************************************************************/
package com.bridgelabz.linkedin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.linkedin.base.TestBase;

public class SignInPage extends TestBase{

	//Page Factory (Object Repository)
	@FindBy(linkText = "Sign in")
	WebElement signIn;
	
	@FindBy(id = "username")
	WebElement emailId;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath = "//span[text()='Show']")
	WebElement showPassword;
	
	@FindBy(xpath = "//span[text()='Show']")
	WebElement hidePassword;
	
	@FindBy(xpath = "//a[text()='Forgot password?']")
	WebElement forgetPassword;
	
	@FindBy(name = "userName")
	WebElement username;
	
	@FindBy(xpath = "//button[text()='Find account']")
	WebElement findAccount;
	
	@FindBy(linkText = "Join now")
	WebElement joinNowLink;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement signInBtn;
	
	
	/**
	 * Constructor: To Initialize the WebElements generated from FindBy Annotation
	 */
	public SignInPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	/**Method: To verify Sign In Page Title
	 * @return String
	 */
	public String verifySignInPageTitle() {
	
		signIn.click();
		return driver.getTitle();
	}
	
	
	/**Method: To validate Forget Password Link present on Webpage
	 * @return true
	 * @throws InterruptedException 
	 */
	public boolean validateForgetPasswordLink(String email) throws InterruptedException {
		
		signIn.click();
		forgetPassword.click();
		Thread.sleep(1000);
		username.sendKeys(email);
		findAccount.click();
		Thread.sleep(2000);
		driver.navigate().to(properties.getProperty("url"));
		Thread.sleep(2000);
		return forgetPassword.isDisplayed();
	}
	
	
	/**Method: To validate Show Password Button present on Webpage
	 * @return true
	 */
	public boolean validateShowPassword(String email, String pwd) {
		
		signIn.click();
		emailId.sendKeys(email);
		password.sendKeys(pwd);
		showPassword.click();
		signInBtn.click();
		return showPassword.isDisplayed();
	}
	
	
	/**Method: To validate Hide Password Button present on Webpage
	 * @return true
	 */
	public boolean validateHidePassword(String email, String pwd) {
		
		signIn.click();
		emailId.sendKeys(email);
		password.sendKeys(pwd);
		hidePassword.click();
		signInBtn.click();
		return hidePassword.isDisplayed();
	}
	
	
	/**Method: To Test Join Now Link is working properly or not
	 * @return JoinNowPage Object
	 */
	public JoinNowPage validateJoinNowLink() {
		
		signIn.click();
		joinNowLink.click();
		return new JoinNowPage();
	}
	
	
	/**Method: To SignIn a user from properties file data
	 * @param email
	 * @param pwd
	 * @return HomePage Object
	 * @throws InterruptedException 
	 */
	public HomePage signIn(String email, String pwd) throws InterruptedException {
		
		signIn.click();
		emailId.sendKeys(email);
		password.sendKeys(pwd);
		signInBtn.click();
		Thread.sleep(4000);
		return new HomePage();
	}
}