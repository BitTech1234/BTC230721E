package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	WebDriver driver;
	@FindBy(xpath = "xpath_of_userID_textbox") WebElement userIDBox;
	
	public HomePage(WebDriver x) {
		driver = x;
		PageFactory.initElements(driver, this);
	}
	
	public void typeUserID(String value) {
		userIDBox.sendKeys(value);
	}
	
	public void typePassword() {
		driver.findElement(By.id("password")).sendKeys("pass");
	}
	
	public ProfilePage clickOnButton() {
		driver.findElement(By.id("loginButton")).click();
		return new ProfilePage();
	}
	
}
