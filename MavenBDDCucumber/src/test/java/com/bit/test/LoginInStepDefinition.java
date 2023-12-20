package com.bit.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BaseTest;
import pages.HomePage;
import pages.ProfilePage;

public class LoginInStepDefinition {
	
	WebDriver driver;
	BaseTest b = new BaseTest();
	HomePage hp;
	ProfilePage pp;
	
	@Before
	public void start() {
		System.out.println("Run before every scenario.");
	}
	
	@After
	public void end() {
		System.out.println("Run after ever scenario.");
	}
	
	//Customized Hooks
	@Before("@Smoke")
	public void start2() {
		System.out.println("Run before every scenario.");
	}
	
	@After("@Regression")
	public void end2() {
		System.out.println("Run after ever scenario.");
	}
	
	@Given("^open browser$")
	public void open_browser(DataTable a) throws Throwable {
		List<List<String>> datas = a.asLists(String.class);
		String data = datas.get(0).get(0);
		b.openBrowser(data);
		
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@Given("^go to facebook$")
	public void go_to_facebook() throws Throwable {
		hp = b.goToUrl();
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^user type user ID in email box$")
	public void user_type_user_ID_in_email_box(DataTable d) throws Throwable {
		List<java.util.Map<String, String>> datas = d.asMaps(String.class, String.class);
		String value = datas.get(1).get("UserID");
		hp.typeUserID(value);
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^user type password in password box$")
	public void user_type_password_in_password_box() throws Throwable {
		hp.typePassword();
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^user click in login butoon$")
	public void user_click_in_login_butoon() throws Throwable {
		pp = hp.clickOnButton();
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^user should see his profile page$")
	public void user_should_see_his_profile_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^user type \"([^\"]*)\" in email box$")
	public void user_type_in_email_box(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^user type \"([^\"]*)\" in password box$")
	public void user_type_in_password_box(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^user should not see his profile page$")
	public void user_should_not_see_his_profile_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}


}
