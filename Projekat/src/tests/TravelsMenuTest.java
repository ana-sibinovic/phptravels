package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.TravelsLoginPage;
import pages.TravelsMenuPage;

public class TravelsMenuTest extends BasicTest {

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

	@Test(priority = 0)
	public void checkFunctionality() throws InterruptedException {
		TravelsMenuPage tmp = new TravelsMenuPage(driver);
		tmp.clickAll();
		Assert.assertTrue(tmp.getTitle().contains("Booking"));
	}
}
