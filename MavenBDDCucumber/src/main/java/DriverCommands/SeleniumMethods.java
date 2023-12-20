package DriverCommands;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;



public class SeleniumMethods {

	WebDriver driver;
	WebElement element;

	public void test1() {
		
		driver.close();															//to close the current window
		driver.quit();															//to close the entire browser
		
		
		WebElement element = driver.findElement(By.id(""));						//to grab one element
		element.clear();														//to clear the text box
		element.click();
		element.findElement(By.id(""));											//to grab one element inside another element
		List<WebElement> insideElements = element.findElements(By.xpath(""));	//to grab more then one element inside another element
		element.getAttribute("attribute");										//to get the attribute of an element
		element.getCssValue("");												//to get the css value of an element
		int x = element.getLocation().x;										//to get the x and y coordinates
		int h = element.getRect().height;										//to get the height/width of rectangle
		int hSize = element.getSize().getHeight();
		element.getTagName();													//get the name of the tag the element was made with
		element.getText();														//get a text from an element
		element.isDisplayed();													//to check if an element is present or not
		element.isEnabled();													//to check if a button is enabled or not
		element.isSelected();													//to check if a box is selected or not
		element.sendKeys("");													//to type in a text box
		element.submit();														//to click an element without using the click method
		
		
		List<WebElement> elements = driver.findElements(By.xpath(""));			//to grab more then one element
		int s = elements.size();
		
		
		driver.get("http//www.google.com");										//to navigate to the url
		driver.getCurrentUrl();													//to grab current url page
		driver.getPageSource();													//to get the source of a page
		driver.getTitle();														//to get the title of a page
		driver.getWindowHandle();												//to get the parent window
		Set<String> cWin = driver.getWindowHandles();							//to grab all the child windows
		
		
		Options option = driver.manage();										//
		option.deleteAllCookies();												//to handle any cookie related actions
		option.timeouts().implicitlyWait(20, TimeUnit.SECONDS);					//waits for elements to load up to "this" many seconds
		option.timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		option.timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		
		
		Navigation nav = driver.navigate();										//
		nav.back();
		nav.forward();
		nav.refresh();
		nav.to("");
		
		
		TargetLocator tarLoc = driver.switchTo();								//
		tarLoc.frame(x);
		tarLoc.frame("");
		tarLoc.frame(element);
		tarLoc.defaultContent();												//to go back to the parent website
		tarLoc.parentFrame();													//if there is a frame in a frame, and you want to go back to parent frame
		
		
		Alert a = tarLoc.alert();												//window based popup - "if its this case selenium cannot handle it, we will need a 3rd party api, ex: sikulli, autoIT tool, robot api"
		a.accept();																//java script based
		a.dismiss();
		a.sendKeys("");
		a.getText();

	}
	
	
	public void mouseRelatedMethods() {
		
		Actions act = new Actions(driver);
		act.click(element);
		act.build().perform();													//for any mouse related actions you need .build and .perform
		act.clickAndHold(element).build().perform();
		act.contextClick(element).build().perform();							//to right click
		act.doubleClick(element).build().perform();								//to double click
		act.dragAndDrop(element, element).build().perform();					//drag one element and drop on another
		act.dragAndDropBy(element, 100, 150).build().perform();					//drag one element on a set of coordinates
		act.keyDown(element, null).build().perform();
		act.keyDown(Keys.ARROW_DOWN).build().perform();
		act.moveToElement(element).build().perform();							//to hover over
		act.pause(20).release().build().perform();									
		
	}
	
	
	public void multipleFrameHandling(String frameName) {

		List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));

		for (WebElement frame : allFrames) {
			String frameValue = frame.getAttribute("class");

			if (frameValue.equals(frameName)) {
				driver.switchTo().frame(frameName);
			}
		}

	}

	public void deleteExpiredCookie(String cookieName) {

		Set<Cookie> allCookies = driver.manage().getCookies();

		for (Cookie oneCookie : allCookies) {
			String actualCookieName = oneCookie.getName();

			if (actualCookieName.equals(cookieName)) {
				driver.manage().deleteCookieNamed(actualCookieName);
			}

		}

	}

	public void takeScreenShot() throws IOException {

		File fi = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		com.google.common.io.Files.copy(fi, new File("path of the folder where we want to save"));

	}

	public void browserCapabilities() {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("xpi extentions of any add-on");

		ChromeDriver driver = new ChromeDriver(co);

	}
	
	public void multipleWindowHandles() {
		
		String pWin = driver.getWindowHandle();
		
		Actions actions = new Actions(driver);
		actions.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		Set<String> cWin = driver.getWindowHandles();
		 for(String win : cWin) {
			 if(!win.equals(pWin)) {
				 driver.switchTo().window(win);
			 }
		 }
		 
		 driver.switchTo().defaultContent();										//comes back to the parent window
		
	}
	
	 public void javaScriptHandles() {
		 
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 
		 //DOM - document
		 //BOM - window
		 
		 js.executeScript("window.scrollTo(0,1000)");
		 js.executeScript("document.getElementById(\"myCheck\").click();");
		 js.executeScript("document.getElementById(\"textbox_1\").value=text_to_be_inserted;");
		 js.executeScript("arguments[0].click();", element);
		 js.executeScript("window.history.back();");
		 
		 waitForElement(element).click();
		 
	 }
	
	
	public WebElement waitForElement(WebElement ele) {
		
		WebDriverWait wdw = new WebDriverWait(driver, 10);
		
		wdw.until(ExpectedConditions.elementToBeClickable(ele));
		
		return ele;
		
		
	}
	
	public void fluentWait() {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
		
			public WebElement apply(WebDriver driver ) {
				return driver.findElement(By.xpath(""));
			}
		});
		clickseleniumlink.click();
		driver.close() ;
	
	}


	public void fluentWait2() {
		
		Wait wait = new FluentWait(driver)
				.withTimeout(30, TimeUnit.SECONDS)
		
	}
		
		
		
	
	
	
	
	
	
	
	
	
}