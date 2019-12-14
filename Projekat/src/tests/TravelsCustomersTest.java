package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;
import pages.TravelsCarsPage;
import pages.TravelsCustomersPage;
import pages.TravelsLoginPage;
import pages.TravelsMenuPage;

public class TravelsCustomersTest extends BasicTest {
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
	public void editCustomer() throws InterruptedException, AWTException {

		TravelsMenuPage tmp = new TravelsMenuPage(driver);
		Thread.sleep(500);
		tmp.clickAccounts();
		Thread.sleep(1000);
		tmp.clickCustomers();

		TravelsCustomersPage tcp = new TravelsCustomersPage(driver);
		Thread.sleep(2000);
		tcp.clickEdit();
		tcp.editCustomer("Pera", "Peric", "Sremska", 123456, "pera@peric.com", "pera123", "Algeria", "Disabled");
		tcp.searchInput("Pera");
		Assert.assertTrue(tcp.found("Pera"));

	}

}
