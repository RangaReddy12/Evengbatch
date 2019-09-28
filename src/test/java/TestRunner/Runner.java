package TestRunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles",glue= "StepDefinations",tags= 
{"@login,@branchcreation"},
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Reports/report.html", 
		"html:target/cucumber-reports"}
,monochrome = true)
public class Runner extends AbstractTestNGCucumberTests {

}