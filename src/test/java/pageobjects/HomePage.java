package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[@aria-label='May be later']")
	public WebElement MayBe;
	
	@FindBy(xpath = "//input[@class='input_search font14 fw400 color111']")
	public WebElement input;
	
	@FindBy(xpath = "//li[@id='react-autowhatever-main-auto-suggest--item-0']")
	public WebElement SearchBtn;
	
	@FindBy(xpath = "//a[@class='jsx-781be569fedee8cf floatbutton font14 fw400 colorFFF']")
	public WebElement FreeBtn;
	
	@FindBy(xpath = "//*[@id='mainContent']/div[2]/a[14]")
	public WebElement ScrollGym;
	
	@FindBy(xpath = "//*[@id='mainContent']/div[2]/a[14]/div[2]")
	public WebElement gymBtn;
	
	@FindBy(xpath = "//input[@type = 'text' and @class='input_location font14 fw400 color111']")
	public WebElement location;
	
	@FindBy(xpath = "//*[@class='location_text font14 fw400 color007']")
	public WebElement autoDetect;
	
	
	
	
	
	public void handleADD() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));   
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='May be later']")));
	      MayBe.click();
	
	}
	
	public String Title() {
		String pageTtitle = driver.getTitle();
		return pageTtitle;
	}
	
	public void setLocation() {
		location.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));   
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='location_text font14 fw400 color007']")));
	    autoDetect.click();	
	}
	
	public void Search() {
		input.sendKeys("Car Washing Services");
		SearchBtn.click();
	}
	
	public void FreeClick() {
		FreeBtn.click();
	}
	
	public void scrolldown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ScrollGym);
	}
	
	public void gymClick() {
		gymBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
