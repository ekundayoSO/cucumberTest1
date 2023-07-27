package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestSteps {

    WebDriver driver;

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @When("I navigate to the demo web shop login page")
    public void i_navigate_to_the_demo_web_shop_login_page() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

    }

    @When("I click login button")
    public void i_click_login_button() {

        driver.findElement(By.className("ico-login")).click();

    }

    @When("I enter the username and password")
    public void i_enter_the_username_and_password() {
        driver.findElement(By.id("Email")).sendKeys("sfvf@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Abc@123");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

    }

    @When("I should see the user log out page")
    public void i_should_see_the_user_log_out_page() {
        String expectedPageContains = "Log out";
        String actualPageContains = driver.findElement(By.className("ico-logout")).getText();
        Assert.assertEquals(actualPageContains, expectedPageContains);

        System.out.println(actualPageContains);
    }

    @Then("I close the browser")
    public void i_close_the_browser() {

        driver.manage().deleteAllCookies();
        driver.quit();

    }

}
