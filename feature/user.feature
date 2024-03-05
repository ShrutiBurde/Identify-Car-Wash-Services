Feature: Car wash

  Scenario: Getting the car washing services provider
    Given visit on the justdial page
    Then validate the title of the webpage
    When Enter the nearest location
    And give the proper data and search
    When Click on the apply filter button
    And applying the filter as per description
    Then Getting the all car washing service provider details
    
    
	Scenario Outline: Free Listing
		Given user visit on the justdial home page
		When Enter the near by location
		And user click on the Free Listing button
		Then validate the Free Listing webpage
		When user enter the wrong number as "<Phone>"
		And click on the Start now button
		Then validating the error message
		
		
		Examples:
			| Phone            |
			| 172382822        |
			| 272382822        |
		
		
		
		
	Scenario: Gym
		Given User visit the justdial home page
		#Then validate the title of the webpage
		When Enter the location
		When Scroll down to the GYM icon on homepage
		And click on the gym button
		Then Store the list of submenu and display
		And Display all the Submenu content
    
    
   
