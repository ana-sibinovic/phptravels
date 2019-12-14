package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.TravelsCarsExtrasPage;
import pages.TravelsLoginPage;
import pages.TravelsMenuPage;

public class TravelsCarsExtrasTest extends BasicTest {

	private String baseUrl = "https://www.phptravels.net/admin";

	@BeforeTest
	public void logInForMainTest() throws InterruptedException {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(2000);

		TravelsLoginPage lg = new TravelsLoginPage(driver);
		lg.singIn("admin@phptravels.com", "demoadmin");
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void addCar() throws InterruptedException, AWTException {
		TravelsMenuPage tmp = new TravelsMenuPage(driver);
		tmp.clickCars();
		TravelsCarsExtrasPage tcep = new TravelsCarsExtrasPage(driver);
		Thread.sleep(3000);
		tcep.add();
		tcep.addCar("Mini Cooper", "Yes", 7500);
		tcep.getImage();

		StringSelection ss = new StringSelection("C:\\Users\\Ana\\eclipse\\Projekat\\images\\MiniCooper.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		tcep.clickSaveBtn();

		Assert.assertTrue(tcep.getTitle().contains("Extras"));
	}

	@Test(priority = 10)

	public void addCarCapsPrice() throws InterruptedException, AWTException {
		TravelsMenuPage tmp = new TravelsMenuPage(driver);
		tmp.clickCars();
		TravelsCarsExtrasPage tcep = new TravelsCarsExtrasPage(driver);
		tcep.add();
		tcep.addCarCaps("audi", "Yes", "one hundred");
		tcep.clickSaveBtn();

		Assert.assertTrue(tcep.getTitle().contains("Extras"));
	}

}
