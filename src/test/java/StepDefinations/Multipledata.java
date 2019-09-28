package StepDefinations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Multipledata {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	@When("^I open OrangeHRMS URL on \"([^\"]*)\"$")
	public void i_open_OrangeHRMS_URL_on(String browser) throws Throwable {
		reports=new ExtentReports("./Orange/Login.html");
	 if(browser.equalsIgnoreCase("chrome"))
	 {
	System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("http://orangehrm.qedgetech.com");
	driver.manage().window().maximize();
	 }
	 else if(browser.equalsIgnoreCase("firefox"))
	 {
		 System.setProperty("webdriver.gecko.driver", "E://geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get("http://orangehrm.qedgetech.com");	 
	 }
	 else{
		 System.out.println("Browser not matching");
	 }
	}

	@When("^I enter \"([^\"]*)\" in usernameField$")
	public void i_enter_in_usernameField(String username) throws Throwable {
	    driver.findElement(By.name("txtUsername")).sendKeys(username);
	}

	@When("^I enter \"([^\"]*)\" in passwordField$")
	public void i_enter_in_passwordField(String password) throws Throwable {
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		
	}
	@When("^Iam clicking Login Button$")
	public void iam_clicking_Login_Button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
	}
	@Then("^I Should see dashboard in my url$")
	public void i_Should_see_dashboard_in_my_url() throws Throwable {
		test=reports.startTest("Multiple Test");
    if(driver.getCurrentUrl().contains("dash"))
		{
    	test.log(LogStatus.PASS, "Login Success");
		System.out.println("Login Success");
		}
		else{
		String message=driver.findElement(By.id("spanMessage")).getText();
		System.out.println(message);
		test.log(LogStatus.FAIL, message);
			} 
    	}
	@When("^Iam  closing the browser$")
	public void iam_closing_the_browser() throws Throwable {
		reports.endTest(test);
	    reports.flush();
	    driver.close();
	}
}
