import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Network;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Tvpurchasesteps {
	static WebDriver driver;
	@Given("User needs to login amazon")
	public void user_needs_to_login_amazon() {
		
		WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
		 driver.get("https://www.amazon.in/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	}
    String name;
	@When("user can search tv")
	public void user_can_search_tv() {
		name = "sony tv";
		WebElement mobilesearch = driver.findElement(By.xpath("//input[@type='text']"));
		mobilesearch.sendKeys(name);	   
	    
	}

	@And("user can choose the mobile")
	public void user_can_choose_the_mobile() {
		WebElement button = driver.findElement(By.xpath("//input[@type='submit']"));
		button.click();
		   
	}

	@And("user validate another option")
	public void user_validate_another_option() {
		
	    driver.navigate().back();
	}

	@Then("user receives confirmation information")
	public void user_receives_confirmation_information() {
		System.out.println("------");
	driver.quit();
	    
	}
	@When("user can search tv with one dim list")
	public void user_can_search_tv_with_one_dim_list(DataTable dataTable) {
		List <String> tvname = dataTable.asList(); 
		name = tvname.get(1);
		WebElement mobilesearch1 = driver.findElement(By.xpath("//input[@type='text']"));
		
		mobilesearch1.sendKeys(name);
		driver.findElement(By.xpath("//input[@type='submit']")).click(); 
		driver.navigate().back();
	}

	@When("user can search tv with one dim map")
	public void user_can_search_tv_with_one_dim_map(io.cucumber.datatable.DataTable dataTable) {
		Map <String,String> mp =dataTable.asMap(String.class, String.class); 
		String tv1 = mp.get("tv1");
		WebElement mobilesearch1 = driver.findElement(By.xpath("//input[@type='text']"));
		
		mobilesearch1.sendKeys(tv1);
		driver.findElement(By.xpath("//input[@type='submit']")).click(); 
		driver.navigate().back();
	}

	@Given("User needs to login amazon {string}")
	public void user_needs_to_login_amazon(String string) {
		name = string;
		WebElement mobilesearch = driver.findElement(By.xpath("//input[@type='text']"));
		mobilesearch.sendKeys(name);	 
	
	}

	
}
