package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

import factory.testngBase;

import pageobjects.FreeListing;
import pageobjects.HomePage;

public class FreelistingScenario extends testngBase {
	HomePage H;
	FreeListing F;

	@Test(priority=1,groups = {"smoke","regression"})
	public void user_visit_on_the_justdial_home_page() {
		
		 H = new HomePage(testngBase.getDri());
		 H.handleADD();
	}
	
	@Test(priority=2,groups = {"regression"})
	public void enter_the_near_by_location() {
	    H.setLocation();
	}
	
	@Test(priority=3,groups = {"smoke","regression"})
	public void user_click_on_the_free_listing_button() {
		
		   H.FreeClick();
	}
	
	@Test(priority=4,groups = {"smoke"})
	public void validate_the_free_listing_webpage() {
		F = new FreeListing(testngBase.getDri());
	    String actTitle = "Free Listing - Just Dial - List In Your Business For Free";
	    String ExpTitle = F.freeTitle();
	    Assert.assertEquals(actTitle, ExpTitle);
	}

	@Test(priority=5,groups = {"regression"})
	public void user_enter_the_wrong_number() {
		
		F = new FreeListing(testngBase.getDri());
		F.enternumberr();
	   
	}

	@Test(priority=6,groups = {"regression"})
	public void click_on_the_start_now_button() {
		
		F.clickbtn();
	    
	}

	@Test(priority=7,groups = {"regression"})
	public void validating_the_error_message() {
		
		String Expectedmsg = "Please Enter a Valid Mobile Number";
		String ActualMsg = F.getErrorMsg();
		System.out.println(ActualMsg);
		Assert.assertEquals(Expectedmsg, ActualMsg);
	    
	}	
	
	
	
}

