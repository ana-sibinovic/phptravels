package pages;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsCarsPage extends BasicPage {

	private By rowCarList = By.xpath("/*[@id=\"content\"]/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]");
	private By carList = By.className("xcrud-row");
	private By inputOrder = By.cssSelector(".form-control.input-sm");
	private By hyundaiGallery = By
			.cssSelector("a[href='https://www.phptravels.net/admin/cars/gallery/Hyundai-i10-or-similar']");
	private By addPhotos = By.cssSelector("a[href='#UploadPhotos']");
	private By drop = By.cssSelector(".well.well-sm");

	public TravelsCarsPage(WebDriver driver) {
		super(driver);
	}

	public List<WebElement> getRowCarList() {
		return this.driver.findElements(rowCarList);
	}

	public List<WebElement> getCarList() {
		return this.driver.findElements(this.carList);
	}

	public List<WebElement> getInputOrder() {
		return this.driver.findElements(this.inputOrder);
	}

	public int sizeInputOrders() {
		return getInputOrder().size();
	}

	public int carListCount() {
		return getCarList().size();
	}

	public String getTextHyndai() {
		return this.driver.findElement(this.hyundaiGallery).getText();
	}

	public void getHyundaiGallery() {
		this.driver.findElement(this.hyundaiGallery).click();
	}

	public void addPhotos() {
		this.driver.findElement(this.addPhotos).click();
	}

	public void dropPhotos() {
		this.driver.findElement(this.drop).click();
	}

	public boolean isTenCars() throws ParseException {
		boolean found = false;
		for (int i = 1; i < carListCount(); i++) {
			String s = "//*[@id=\"content\"]/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[" + (i + 1) + "]/td[5]";
			String text = driver.findElement(By.xpath(s)).getText();
			if (text.contains("10")) {
				found = true;
			}
		}
		return found;
	}

	public boolean moreThen50() throws ParseException {
		int order = 0;
		boolean found = false;
		for (int i = 0; i < this.sizeInputOrders(); i++) {
			WebElement element = this.getInputOrder().get(i);
			String numOrder = element.getAttribute("value");
			order += Integer.parseInt(numOrder);
		}
//		
		if (order > 50) {
			found = true;
		}
		return found;
	}

}
