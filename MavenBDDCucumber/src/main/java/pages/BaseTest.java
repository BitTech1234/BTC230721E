package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseTest {
	
	WebDriver driver;
	
	public void openBrowser(String data) {
		
		
		if (data.equals("Chrome")) {
		    driver = new ChromeDriver();
			System.out.println("Open Chrome");
		} else if (data.equals("FireFox")) {
			driver = new FirefoxDriver();
			System.out.println("Open FireFox");
		} else if (data.equals("Safari")) {
			driver = new SafariDriver();
			System.out.println("Open Safari");
		} else
			System.out.println("None");
		
	}
	
	public HomePage goToUrl() {
		
		driver.get("https://www.facebook.com/");
		
		return new HomePage(driver);
		
	}
	
	public void hoverOver() {
		
		
	}

}
