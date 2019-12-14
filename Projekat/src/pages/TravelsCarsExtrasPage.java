package pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TravelsCarsExtrasPage extends BasicPage {

	private By extras = By.cssSelector("a[href='https://www.phptravels.net/admin/cars/extras']");
	private By add = By.cssSelector(".btn.btn-success.xcrud-action");
	private By addImage = By.cssSelector(".xcrud-add-file.btn.btn-success");
	private By name = By.name("cHRfZXh0cmFzLmV4dHJhc190aXRsZQ--");
	private By status = By.name("cHRfZXh0cmFzLmV4dHJhc19zdGF0dXM-");
	private By price = By.name("cHRfZXh0cmFzLmV4dHJhc19iYXNpY19wcmljZQ--");
	private By saveBtn = By.cssSelector(".btn.btn-primary.xcrud-action");

	public TravelsCarsExtrasPage(WebDriver driver) {
		super(driver);
	}

	public void clickExtras() {
		this.driver.findElement(this.extras).click();
	}

	public void clickAdd() {
		this.driver.findElement(this.add).click();
	}

	public void getImage() {
		this.driver.findElement(this.addImage).click();
		;
	}

	public void setName(String name) {
		this.driver.findElement(this.name).sendKeys(name);
	}

	public void chooseStatus(String status) {
		WebElement chooseStatus = driver.findElement(this.status);
		Select selectStatus = new Select(chooseStatus);
		List<WebElement> allOptions = selectStatus.getOptions();
		selectStatus.selectByVisibleText(status);
	}

	public void getPrice() {
		this.driver.findElement(this.price).click();
	}

	public void setPrice(int i) {
		this.driver.findElement(this.price).sendKeys(Integer.toString(i));
	}

	public void setPriceCaps(String price) {
		this.driver.findElement(this.price).sendKeys(price);
	}

	public void clickSaveBtn() {
		this.driver.findElement(this.saveBtn).click();
	}

	public void add() throws InterruptedException {
		this.clickExtras();
		this.clickAdd();
		Thread.sleep(2000);
	}

	public void addCar(String name, String status, int i) {
		setName(name);
		chooseStatus(status);
		setPrice(i);
	}

	public void addCarCaps(String name, String status, String price) {
		setName(name);
		chooseStatus(status);
		setPriceCaps(price);
	}

	public String getTitle() {
		return this.driver.getTitle();
	}
}
