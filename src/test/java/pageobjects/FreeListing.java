package pageobjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FreeListing extends BasePage {
	
	public FreeListing(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='1' and @class='entermobilenumber_input__eCrdc input fw500']")
	public WebElement inputbox;
	
	@FindBy(xpath="//*[@id='listyourbusiness']/div[1]/form/button")
	public WebElement Searchbtn;
	
	@FindBy(xpath="//*[@class='undefined entermobilenumber_error__text__uPM09']")
	public WebElement error ;
	
	
	
	public String freeTitle() {
		String pTtitle = driver.getTitle();
		return pTtitle;
	}
	
	
	public void enternumber(String num) {
		
	    long convertedValue = Long.parseLong(num);
	       inputbox.sendKeys(Long.toString(convertedValue));
	
	}
	
	public void enternumberr() {
		String generatedString = RandomStringUtils.randomNumeric(9);
	    long convertedValue = Long.parseLong(generatedString);
	       inputbox.sendKeys(Long.toString(convertedValue));
		
	}
	
	public void clickbtn() {
		Searchbtn.click();
	}
	
	
	public String getErrorMsg() {
		String errormsg = error.getText();
		return errormsg;
	}
	
	
	
	
	
	
	
	
	
	

}
