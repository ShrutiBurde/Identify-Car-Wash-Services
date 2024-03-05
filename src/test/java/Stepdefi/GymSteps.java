package Stepdefi;

import java.io.IOException;

import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.GymPage;
import pageobjects.HomePage;

public class GymSteps {
	
	HomePage H;
	GymPage G;
	
	@Given("User visit the justdial home page")
	public void user_visit_the_justdial_home_page() {
		BaseClass.getlogger().info("*******Navigate to the Justdial homePage*******");
		H = new HomePage(BaseClass.getDriver());
		H.handleADD();
	}
	
	@Then("validate the title")
	public void validate_the_title() {
		H = new HomePage(BaseClass.getDriver());
		String expTitle = "Find Businesses Near You on Local Search Engine - Justdial";
	    String actTitle = H.Title();
	    Assert.assertEquals(expTitle, actTitle);
	}
	
	@When("Enter the location")
	public void enter_the_location() {
		H = new HomePage(BaseClass.getDriver());
	    H.setLocation();
	}


	@When("Scroll down to the GYM icon on homepage")
	public void scroll_down_to_the_gym_icon_on_homepage() throws IOException {
		H = new HomePage(BaseClass.getDriver());
		BaseClass.getlogger().info("*******Scroll Down*******");
		H.scrolldown();
		BaseClass.ScreenShots("scrolltogym.png");
	}

	@When("click on the gym button")
	public void click_on_the_gym_button() {
		H = new HomePage(BaseClass.getDriver());
		BaseClass.getlogger().info("*******Click on the Gym*******");
	   H.gymClick();
	}

	@Then("Store the list of submenu and display")
	public void store_the_list_of_submenu_and_display() throws IOException {
		BaseClass.getlogger().info("******Getting the submenu in list*******");
	   G = new GymPage(BaseClass.getDriver());
	   G.submenu();
	   BaseClass.ScreenShots("GymPage.png");
	}

	@Then("Display all the Submenu content")
	public void display_all_the_submenu_content() throws IOException {
		BaseClass.getlogger().info("*******Get the all details from submenu dropdown*******");
		G.menuDetails();
		BaseClass.ScreenShots("submenugym.png");
	   
	}

}
