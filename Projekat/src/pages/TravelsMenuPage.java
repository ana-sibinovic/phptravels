package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsMenuPage extends BasicPage {

	private By dashboard = By.className("fa-desktop");
	private By updates = By.className("fa-refresh");
	private By modules = By.className("fa-cube");
	private By tours = By.className("fa-suitcase");
	private By addNew = By.cssSelector("a[href='https://www.phptravels.net/admin/tours/add']");
	private By cars = By.className("fa-car");
	private By carsCars = By.cssSelector("a[href='https://www.phptravels.net/admin/cars']");
	private By coupons = By.className("fa-asterisk");
	private By newsletter = By.cssSelector("a[href='https://www.phptravels.net/admin/newsletter/']");
	private By bookings = By.cssSelector("a[href='https://www.phptravels.net/admin/bookings/']");
	private By accounts = By.cssSelector("a[href='#ACCOUNTS']");
	private By customers = By.cssSelector("a[href='https://www.phptravels.net/admin/accounts/customers/']");

	public TravelsMenuPage(WebDriver driver) {
		super(driver);
	}

	public void clickDashboard() {
		this.driver.findElement(dashboard).click();
	}

	public void clickUpdates() {
		this.driver.findElement(updates).click();
	}

	public void clickModules() {
		this.driver.findElement(modules).click();
	}

	public void clickTours() {
		this.driver.findElement(tours).click();
	}

	public void clickAddNew() {
		this.driver.findElement(addNew).click();
	}

	public void clickCars() {
		this.driver.findElement(cars).click();
	}

	public void clickCarsCars() {
		this.driver.findElement(carsCars).click();
	}

	public void clickCoupons() {
		this.driver.findElement(coupons).click();
	}

	public void clickNewsletter() {
		this.driver.findElement(newsletter).click();
	}

	public void clickBookings() {
		this.driver.findElement(bookings).click();
	}

	public void clickAccounts() {
		this.driver.findElement(accounts).click();
	}

	public void clickCustomers() {
		this.driver.findElement(customers).click();
	}

	public String getTitle() {
		return this.driver.getTitle();
	}

	public void clickAll() throws InterruptedException {
		this.clickDashboard();
		Thread.sleep(500);
		this.clickUpdates();
		Thread.sleep(500);
		this.clickModules();
		Thread.sleep(500);
		this.clickTours();
		Thread.sleep(500);
		this.clickCars();
		Thread.sleep(500);
		this.clickAddNew();
		Thread.sleep(500);
		this.clickCoupons();
		Thread.sleep(500);
		this.clickNewsletter();
		Thread.sleep(500);
		this.clickBookings();
	}

	public void carsMenuClick() {
		this.clickCars();
		this.clickCarsCars();
	}

}
