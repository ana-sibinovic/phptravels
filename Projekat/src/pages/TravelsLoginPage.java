package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsLoginPage extends BasicPage {

	
	private By email = By.name("email");
	private By password = By.name("password");
	private By rememberBtn = By.name("remember");
	private By forgetPassword = By.id("link-forgot");
	private By loginBtn = By.className("ladda-label");
	
	public TravelsLoginPage(WebDriver driver) {
		super(driver);
	}
	

	public void setEmail(String email) {
		this.driver.findElement(this.email).sendKeys(email);
	}
	
	public void setPassword(String password) {
		this.driver.findElement(this.password).sendKeys(password);
	}
	
	public void clickOnLoginBtn() {
		this.driver.findElement(this.loginBtn).click();
	}
	
	public void singIn(String email, String password) {
		this.setEmail(email);
		this.setPassword(password);
		this.clickOnLoginBtn();
	}
	
	public void clickOnRememberBtn() {
		this.driver.findElement(this.rememberBtn).click();
	}
	
	public void clickOnForgetPassword() {
		this.driver.findElement(this.forgetPassword).click();
	}
	
	public String getTitle() {
		return this.driver.getTitle();
	}
}
