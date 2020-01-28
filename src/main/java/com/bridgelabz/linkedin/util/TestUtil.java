package com.bridgelabz.linkedin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.bridgelabz.linkedin.base.TestBase;

public class TestUtil extends TestBase{
	
	public final static long PAGE_LOAD_TIMEOUT = 30;
	public final static long IMPLICITLY_WAIT = 30;
	
	
	/**Method: To get SignIn Data form Xlsx file
	 * @return Data in Object Form
	 */
	public static Object[][] getData(String sheetName) {
		
		try {
			file = new FileInputStream("/home/admin1/eclipse-workspace/Mayuresh/LinkedinCI-CT/src/main/java/com/bridgelabz/linkedin/testdata/LinkedInTestData.xlsx");
			workBook = WorkbookFactory.create(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = workBook.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				
				data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}
	
	public static String getScreenShots() {
		
		Date date = new Date();
    	SimpleDateFormat formatter = new SimpleDateFormat(" DD/MM/yyyy hh:mm:ss");
    	String actualDate = formatter.format(date);
    	
    	TakesScreenshot screenshot1 = (TakesScreenshot) driver;
    	
    	//To get the Source File and store it in file.io
    	File srcFile1 = screenshot1.getScreenshotAs(OutputType.FILE);
    	
    	//To store the screenshot in the destination file
    	String destination = System.getProperty("user.dir") + "/FailedScreenshots/" + "Linkedin" +actualDate + ".png";
    	File destFile = new File(destination);
    	
    	try {
    		FileUtils.copyFile(srcFile1, destFile);
    		Thread.sleep(2000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	return destination;
	}
	
	
}
