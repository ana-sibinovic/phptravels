package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TravelsLoginPage;

public class ExcelLogin extends BasicTest {

	private String baseUrl = "https://www.phptravels.net/admin";

	@Test(priority = 0)
	public void excelLogin() throws InterruptedException, IOException {

		driver.get(baseUrl);

		File file = new File("Username.xlsx");
		FileInputStream fis = new FileInputStream(file);

		Thread.sleep(2000);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		TravelsLoginPage tlp = new TravelsLoginPage(driver);
		tlp.setEmail(sheet.getRow(1).getCell(0).getStringCellValue());
		tlp.setPassword(sheet.getRow(1).getCell(1).getStringCellValue());
		tlp.clickOnLoginBtn();
		wb.close();
		Thread.sleep(2000);

		Assert.assertTrue(tlp.getTitle().contains("Dashboard"));
	}

}