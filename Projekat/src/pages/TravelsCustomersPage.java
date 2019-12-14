package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TravelsCustomersPage extends BasicPage {

	private static final List<WebElement> Select = null;
	private By firstCustomer = By.cssSelector(".xcrud-row.xcrud-row-0");
	private By editBtn = By.cssSelector(".btn.btn-default.btn-xcrud.btn.btn-warning");
	private By firstName = By.name("fname");
	private By lastName = By.name("lname");
	private By customerEmail = By.name("email");
	private By password = By.name("password");
	private By mobileNumber = By.name("mobile");
	private By country = By.className("select2-arrow");
	private By inputCounty = By.className("select2-input");
	private By address1 = By.name("address1");
	private By status = By.name("status");
	private By newsletter = By.className("checkbox");
	private By submitBtn = By.xpath("//*[@id=\"content\"]/form/div/div[3]/button");
	private By search = By.cssSelector(".xcrud-search-toggle.btn.btn-default");
	private By searchInput = By.name("phrase");
	private By table = By.className("xcrud-list-container");

	public TravelsCustomersPage(WebDriver driver) {
		super(driver);
	}

	public void clickEdit() {
		this.driver.findElement(this.firstCustomer);
		this.driver.findElement(this.editBtn).click();
	}

	public void changeFirstName(String firstName) {
		this.driver.findElement(this.firstName).clear();
		this.driver.findElement(this.firstName).sendKeys(firstName);
	}

	public void changeLastName(String lastName) {
		this.driver.findElement(this.lastName).clear();
		this.driver.findElement(this.lastName).sendKeys(lastName);
	}

	public void changeCustomerEmail(String customerEmail) {
		this.driver.findElement(this.customerEmail).clear();
		this.driver.findElement(this.customerEmail).sendKeys(customerEmail);
	}

	public void changePassword(String password) {
		this.driver.findElement(this.password).clear();
		this.driver.findElement(this.password).sendKeys(password);
	}

	public void changeMobile(int mobile) {
		this.driver.findElement(this.mobileNumber).clear();
		this.driver.findElement(this.mobileNumber).sendKeys(Integer.toString(mobile));
	}

	public void getCountry() {
		this.driver.findElement(this.country).click();
	}

	public void chooseCountry(String country) {
		this.driver.findElement(this.inputCounty).sendKeys(country);
	}

	public void changeAddress1(String address1) {
		this.driver.findElement(this.address1).clear();
		this.driver.findElement(this.address1).sendKeys(address1);
	}

	public void chooseStatus(String status) {
		WebElement chooseStatus = driver.findElement(this.status);
		Select selectStatus = new Select(chooseStatus);
		List<WebElement> allOptions = selectStatus.getOptions();
		selectStatus.selectByVisibleText(status);
	}

	public void clickNewsletters() {
		this.driver.findElement(this.newsletter).click();
	}

	public void clickSubmitBtn() {
		WebElement element = driver.findElement(this.submitBtn);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	public void editCustomer(String firstName, String lastName, String address1, int mobile, String customerEmail,
			String password, String country, String status) throws AWTException, InterruptedException {
		this.changeFirstName(firstName);
		this.changeLastName(lastName);
		this.changeCustomerEmail(customerEmail);
		this.changeMobile(mobile);
		this.changePassword(password);
		this.changeAddress1(address1);
		this.getCountry();
		this.chooseCountry(country);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		this.chooseStatus(status);
		Thread.sleep(500);
		this.clickNewsletters();
		this.clickSubmitBtn();
	}

	public void searchInput(String name) throws AWTException {
		this.driver.findElement(this.search).click();
		this.driver.findElement(this.searchInput).sendKeys(name);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public boolean found(String name) {
		boolean found = false;
		System.out.print(this.driver.findElement(this.table).getText());
		if (this.driver.findElement(this.table).getText().contains(name)) {
			found = true;
		}
		return found;

	}

}
