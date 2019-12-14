package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;
import pages.TravelsCarsPage;
import pages.TravelsLoginPage;
import pages.TravelsMenuPage;

public class TravelsCarsTest extends BasicTest {

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
	public void countCars() throws ParseException {
		TravelsMenuPage tmp = new TravelsMenuPage(driver);
		tmp.carsMenuClick();

		TravelsCarsPage tcp = new TravelsCarsPage(driver);
		tcp.isTenCars();
		Assert.assertTrue(tcp.isTenCars());
	}

	@Test(priority = 10)
	public void moreThen50() throws ParseException {
		TravelsMenuPage tmp = new TravelsMenuPage(driver);
		tmp.carsMenuClick();

		TravelsCarsPage tcp = new TravelsCarsPage(driver);
		tcp.moreThen50();
		Assert.assertTrue(tcp.moreThen50());
	}

	@Test(priority = 15)
	public void addPhoto() throws AWTException, InterruptedException {
		TravelsMenuPage tmp = new TravelsMenuPage(driver);
		tmp.carsMenuClick();
		TravelsCarsPage tcp = new TravelsCarsPage(driver);

		String test = tcp.getTextHyndai();
		tcp.getHyundaiGallery();
		Thread.sleep(1000);
		tcp.addPhotos();

		tcp.dropPhotos();
		StringSelection ss = new StringSelection("C:\\Users\\Ana\\eclipse\\Projekat\\images\\hyundai.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot1 = new Robot();
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(1000);
		tmp.carsMenuClick();;

		Assert.assertNotSame(tcp.getTextHyndai(), test);
	}
}