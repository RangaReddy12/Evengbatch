package StepDefinations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class StepDefination {
WebDriver driver;
@When("^I open OrangeHRMS URL on chromebrowser$")
	public void i_open_OrangeHRMS_URL_on_chromebrowser() throws Throwable {
	 System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get("http://orangehrm.qedgetech.com");
	 driver.manage().window().maximize();
	}

	@When("^I enter  in username$")
	public void i_enter_in_username() throws Throwable {
	  driver.findElement(By.name("txtUsername")).sendKeys("Admin");  
	}

	@When("^I enter  in password$")
	public void i_enter_in_password() throws Throwable {
		driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
	}

	@When("^I click Login Button$")
	public void i_click_Login_Button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		
	}

	@Then("^I Should see Welcome Link on Home Page$")
	public void i_Should_see_Welcome_Link_on_Home_Page() throws Throwable {
	 String text=driver.findElement(By.id("welcome")).getText(); 
	 if(text.contains("Welcome"))
	 {
		 System.out.println("Login success");
	 }
	 else{
		 System.out.println("Login Fail"); 
	 }
	}

	@When("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
	    driver.close();
	}
}
