package testrun;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(features= {".//feature/user.feature"},
		glue="Stepdefi",
		plugin= {"pretty","html:reports/myreport.html", "rerun:target/reurn.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
dryRun=false, monochrome=true, publish=true)

public class TestRunner extends AbstractTestNGCucumberTests{

 
}