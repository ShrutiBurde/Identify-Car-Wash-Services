package Stepdefi;

import java.io.IOException;

import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FreeListing;
import pageobjects.HomePage;

public class FreelistingSteps {
	HomePage H;
	FreeListing F;

	@Given("user visit on the justdial home page")
	public void user_visit_on_the_justdial_home_page() {
		BaseClass.getlogger().info("*******Navigate to the Justdial homePage*******");
		 H = new HomePage(BaseClass.getDriver());
		 H.handleADD();
	}
	
	@When("Enter the near by location")
	public void enter_the_near_by_location() {
	    H.setLocation();
	}
	
	@When("user click on the Free Listing button")
	public void user_click_on_the_free_listing_button() {
		BaseClass.getlogger().info("*******	Click on the Free Listing*******");
		   H.FreeClick();
	}
	
	@Then("validate the Free Listing webpage")
	public void validate_the_free_listing_webpage() {
		F = new FreeListing(BaseClass.getDriver());
	    String actTitle = "Free Listing - Just Dial - List In Your Business For Free";
	    String ExpTitle = F.freeTitle();
	    Assert.assertEquals(actTitle, ExpTitle);
	}
	
	@When("user enter the wrong number as {string}")
	public void user_enter_the_wrong_number_as(String Phone) throws IOException {
		BaseClass.getlogger().info("*******Enter the Phone Number*******");
		F = new FreeListing(BaseClass.getDriver());
		F.enternumber(Phone);
		BaseClass.ScreenShots("wrongnumber.png");
	    
	}
/*
	@When("user enter the wrong number")
	public void user_enter_the_wrong_number() {
		BaseClass.getlogger().info("*******Enter The wrong number*******");
		F = new FreeListing(BaseClass.getDriver());
		F.enternumber();
	   
	}
*/
	@When("click on the Start now button")
	public void click_on_the_start_now_button() throws IOException {
		BaseClass.getlogger().info("*******Click on the start now button*******");
		F.clickbtn();
		BaseClass.ScreenShots("Invalidnumber.png");
	    
	}

	@Then("validating the error message")
	public void validating_the_error_message() {
		BaseClass.getlogger().info("******Validating the error message******");
		String Expectedmsg = "Please Enter a Valid Mobile Number";
		String ActualMsg = F.getErrorMsg();
		System.out.println(ActualMsg);
		Assert.assertEquals(Expectedmsg, ActualMsg);
	    
	}	
	
	
	
}
