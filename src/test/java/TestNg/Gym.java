package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;


import factory.testngBase;
import pageobjects.GymPage;
import pageobjects.HomePage;

public class Gym extends testngBase{
	
	HomePage H;
	GymPage G;
	
	@Test(priority=1,groups = {"smoke","regression"})
	public void Homepage() {
		
		H = new HomePage(testngBase.getDri());
		H.handleADD();
	}
	
	
	@Test(priority=3,groups = {"regression"})
	public void location() {
		H = new HomePage(testngBase.getDri());
	    H.setLocation();
	}


	@Test(priority=4,groups = {"smoke","regression"})
	public void scrollto() {
		H = new HomePage(testngBase.getDri());
		
		H.scrolldown();
	}

	@Test(priority=5,groups = {"smoke","regression"})
	public void click_on_the_gym_button() {
		H = new HomePage(testngBase.getDri());
		
	   H.gymClick();
	}

	@Test(priority=6,groups = {"regression"})
	public void store_the_list_of_submenu_and_display() {
		
	   G = new GymPage(testngBase.getDri());
	   G.submenu();
	}

	@Test(priority=7,groups = {"regression"})
	public void display_all_the_submenu_content() {
		
		G.menuDetails();
	   
	}

}

