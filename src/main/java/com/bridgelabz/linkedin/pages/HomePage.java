package com.bridgelabz.linkedin.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.linkedin.base.TestBase;

public class HomePage extends TestBase{

	//Page Factory (Object Repository)
	@FindBy(xpath = "//button[contains(@class,'open share')]")
	WebElement post;
	
	@FindBy(xpath = "//p[@class='mentions-texteditor__content']")
	WebElement postText;
	
	@FindBy(xpath = "//button[contains(@class,'s__primary-action')]")
	WebElement postBtn;
	
	@FindBy(xpath = "//button[contains(@class,'')]/child::li-icon[@type='camera-icon']")
	WebElement imgBtn;
	
	@FindBy(xpath = "//span[text()='Next']/parent::button")
	WebElement imgNextBtn;
	
	@FindBy(xpath = "//button[contains(@class,'share-actions__primary')]")
	WebElement postImgBtn;
	
	
	/**
	 * /**
	 * Constructor: To Initialize the WebElements generated from FindBy Annotation
	 */
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	/**Method: To verify Home Page Title
	 * @return String
	 */
	public String verifyHomePageTitle() {
		
		validate = driver.getTitle();
		return validate;
	}
	
	
	/**Method: To Create Text Post on Linkedin Profile
	 * @param text
	 * @throws InterruptedException
	 */
	public void createTextPost(String text) throws InterruptedException {
		
		action = new Actions(driver);
		post.click();
		Thread.sleep(3000);
		postText.sendKeys(text);
		Thread.sleep(600);
		postBtn.click();
		Thread.sleep(1000);
	}
	
	
	/**Method: To Upload Image on Linkedin Profile
	 * @param imgPath
	 * @param text
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void uploadImagePost(String imgPath, String text) throws InterruptedException, AWTException {
		
		robot = new Robot();
		imgBtn.click();
		Thread.sleep(1000);
		
		StringSelection stringSelect = new StringSelection(imgPath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelect, null);
		Thread.sleep(500);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		//Simulate Enter key event
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		imgNextBtn.click();
		Thread.sleep(1000);
		postText.sendKeys(text);
		Thread.sleep(1000);
		postImgBtn.click();
		Thread.sleep(2000);
	}
}
