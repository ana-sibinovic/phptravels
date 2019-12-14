package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TravelsCarsPage;
import pages.TravelsCustomersPage;
import pages.TravelsCarsExtrasPage;
import pages.TravelsLoginPage;
import pages.TravelsMenuPage;

public class TravelsLoginTest extends BasicTest {

	private String baseUrl = "https://www.phptravels.net/admin";

	@Test(priority = 0)
	public void basicLogin() throws InterruptedException {

		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(2000);

		TravelsLoginPage lg = new TravelsLoginPage(driver);
		lg.singIn("admin@phptravels.com", "demoadmin");
		Thread.sleep(2000);

		Assert.assertTrue(lg.getTitle().contains("Dashboard"));
	}
}