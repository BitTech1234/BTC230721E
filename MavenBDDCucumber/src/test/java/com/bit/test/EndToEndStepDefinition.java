package com.bit.test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BaseTest;

public class EndToEndStepDefinition {

	BaseTest bt = new BaseTest();
	
	WebDriver driver;
	
	@Given("^Open browser$")
	public void open_browser(DataTable arg1) throws Throwable {

		List<List<String>> browsers = arg1.asLists(String.class);
		String browser = browsers.get(0).get(0);

		if (browser.equals("Chrome")) {
		    driver = new ChromeDriver();
			System.out.println("Open Chrome");
		} else if (browser.equals("FireFox")) {
			driver = new FirefoxDriver();
			System.out.println("Open FireFox");
		} else if (browser.equals("Safari")) {
			driver = new SafariDriver();
			System.out.println("Open Safari");
		} else
			System.out.println("None");
		
		
		List<Map<String, String>> bs = arg1.asMaps(String.class, String.class);
		String b = bs.get(0).get("browser");
		
		bt.openBrowser(null);
		
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
	}

	@Given("^go to url$")
	public void go_to_url() throws Throwable {
		bt.goToUrl();
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^user hover over Men munu$")
	public void user_hover_over_Men_munu() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^user click new Arrivals Submenu$")
	public void user_click_new_Arrivals_Submenu() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^user click shirt product$")
	public void user_click_shirt_product() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^user click shirt size$")
	public void user_click_shirt_size() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^user click add to cart$")
	public void user_click_add_to_cart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^user click checkout cart$")
	public void user_click_checkout_cart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^user input shipping and billing info$")
	public void user_input_shipping_and_billing_info() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^user click order product$")
	public void user_click_order_product() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^user should see item ordered$")
	public void user_should_see_item_ordered() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

}
