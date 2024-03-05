package factory;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;



public class BaseClass {

	static WebDriver driver;
	static Properties p;
	static Logger logger;
	static ChromeOptions options=new ChromeOptions();
	static EdgeOptions options1 = new EdgeOptions();

	public static WebDriver initilizeBrowser() throws IOException {
		
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-blink-features=AutomationControlled");
			options1.addArguments("--disable-blink-features=AutomationControlled");
			
			//os
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
				options.addArguments("--disable-blink-features=AutomationControlled");
			    capabilities.setPlatform(Platform.WIN11);
			} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
				options.addArguments("--disable-blink-features=AutomationControlled");
			    capabilities.setPlatform(Platform.MAC);
			} else {
			    System.out.println("No matching OS..");
			      }
			//browser
			switch (getProperties().getProperty("browser").toLowerCase()) {
			    case "chrome":
			    	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			        capabilities.setBrowserName("chrome");
			        break;
			    case "edge":
			    	capabilities.setCapability(EdgeOptions.CAPABILITY, options1);
			        capabilities.setBrowserName("MicrosoftEdge");
			        break;
			    default:
			        System.out.println("No matching browser");
			     }
	       
	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		
		else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (getProperties().getProperty("browser").toLowerCase()) {
				case "chrome":
					options.addArguments("--disable-blink-features=AutomationControlled");
					driver = new ChromeDriver(options);
					break;
				case "edge":
					options1.addArguments("--disable-blink-features=AutomationControlled");
					driver = new EdgeDriver(options1);
					break;
				default:
					System.out.println("No matching browser");
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static Properties getProperties() throws IOException {
		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");

		p = new Properties();
		p.load(file);
		return p;
	}
	
	public static Logger getlogger()
	{ 
		logger=LogManager.getLogger();
		return logger;
	}
	
	public static void ScreenShots(String fileName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File trg= new File(System.getProperty("user.dir")+"\\Screenshot\\"+ fileName);
		FileUtils.copyFile(src, trg);
	
	}
	
	
	

}