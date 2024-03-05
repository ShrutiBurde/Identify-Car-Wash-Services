package pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ExcelUtils.ExcelUtils;

public class CarService extends BasePage{
	
	public CarService(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='filter_ul']/li[10]/div/div/span[2]")
	public WebElement allfilters;
	
	@FindBy(xpath="//*[@id='__next']/section/section/div/div[4]/aside/div/div[2]/div/div[1]/div[5]/span[3]")
	public WebElement Scrollto;
	
	@FindBy(xpath="//span[@aria-label='4.0+']")
	public WebElement rating4;
	
	@FindBy(xpath="//button[contains(text(), 'Apply Filters')]")
	public WebElement applyButton;
	
	@FindBy(xpath="//div[@class='jsx-3349e7cd87e12d75 resultbox_title_anchor  line_clamp_1']")
	public List<WebElement> names;
	
	@FindBy(xpath="//div[@class='jsx-3349e7cd87e12d75 button_flare']")
	public List<WebElement> contacts;
	
	@FindBy(xpath="//span[@class='jsx-3349e7cd87e12d75 callcontent']")
	public List<WebElement> number;
	
	@FindBy(xpath="//div[@class='jsx-3349e7cd87e12d75 resultbox_countrate ml-12 mr-12 font14 fw400 color777']")
	public List<WebElement> rating;
	
	public void click() {
		allfilters.click();
	}
	
	public void applyFilter() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",Scrollto);
        rating4.click();
        applyButton.click();    
        
	}
	
	public void getDetails() throws InterruptedException, IOException {
		
		String s = null,p = null, v= null;
		
		  
		  List<String> namesList=new ArrayList<String>();
		  List<String> contactList= new ArrayList<String>();
		  List<String> ratings=new ArrayList<String>();
		  
		  
		  
		  for(int j =0;j<5;j++) {
				namesList.add(names.get(j).getText());
				s=namesList.get(j);
				
				WebElement z=contacts.get(j);
				z.click();
				
				Thread.sleep(2000);
				
				z=number.get(j);
				Thread.sleep(2000);
				
				contactList.add(z.getAttribute("data-href"));
				
				p=contactList.get(j);
				
				
				Thread.sleep(2000);
				ratings.add(rating.get(j).getText());
				v=ratings.get(j);
				v = v.replaceAll("\\D", "");
				int c=Integer.parseInt(v);
				
				if(c>20) {
					//String data = 'Car Wash Service Name: ' 
				System.out.println("Car Wash Service Name: "+s+"; Phone Number: "+p+"; Customer Ratings: "+c);
				
				ExcelUtils.writeExcelData("Sheet1",j+1,0,s);
				ExcelUtils.writeExcelData("Sheet1",j+1,1,p);
				ExcelUtils.writeExcelData1("Sheet1",j+1,2,c);
				
				}
		  
		
		}
		
		
		
		
	}
	
	
	

}
