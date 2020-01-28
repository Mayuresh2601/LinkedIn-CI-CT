package com.bridgelabz.linkedin.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;

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
}
