package pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ExcelUtils.ExcelUtils;

public class GymPage extends BasePage {
	
	public GymPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='filter_ul']/li")
	public List<WebElement> subMenu;
	
	
	@FindBy(xpath="//*[@class = 'jsx-6ab5af3a8693e5db animlabel']")
	public List<WebElement> drpDown;
	
	public void submenu() {

		
		System.out.println("----------------ALL THE SUBMENU ON GYM PAGE-------------------------");
		for(int k = 0;k<subMenu.size();k++) {
			String s = subMenu.get(k).getText();
			System.out.println(s);
			
		}
	}
	
	public void menuDetails() {
		
		for (int i = 0; i < subMenu.size(); i++) {
            String Text = subMenu.get(i).getText();
            if (Text.contains("Sort")) {
            	System.out.println("-------------Sort By Dropdown----------");
            	subMenu.get(i).click();
                for(int j =0; j<drpDown.size(); j++) {
                		String s = drpDown.get(j).getText();
                		System.out.println(s);
                		try {
							ExcelUtils.writeExcelData("Sheet1",j+1,7,s);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                }
                
            }
            if (Text.contains("Amenities")) {
            	System.out.println("-------------Amentities Dropdown----------");
            	subMenu.get(i).click();
                for(int j =0; j<drpDown.size(); j++) {
                		String s = drpDown.get(j).getText();
                		System.out.println(s);
                		try {
							ExcelUtils.writeExcelData("Sheet1",j+1,8,s);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                }
                
            }
            if (Text.contains("Ratings")) {
            	System.out.println("-------------Ratings Dropdown----------");
            	subMenu.get(i).click();
                for(int j =0; j<drpDown.size(); j++) {
                		String s = drpDown.get(j).getText();
                		System.out.println(s);
                		try {
							ExcelUtils.writeExcelData("Sheet1",j+1,9,s);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                }
            }
		
		}
		
	}

	
	
	
	
}
