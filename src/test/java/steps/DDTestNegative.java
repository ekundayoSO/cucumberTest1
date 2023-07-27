package steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDTestNegative {

    WebDriver driver;

    @Given("User launches edge browser")
    public void user_launches_edge_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("User navigate to the DemoWebShop login page")
    public void user_navigate_to_the_demo_web_shop_login_page() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
    }

    @When("User clicks login button")
    public void user_clicks_login_button() {

        driver.findElement(By.className("ico-login")).click();
    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String Email, String Password) {
        driver.findElement(By.id("Email")).sendKeys(Email);
        driver.findElement(By.id("Password")).sendKeys(Password);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {

        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }

    @Then("User should see appropriate {string} being displayed")
    public void user_should_see_appropriate_being_displayed(String ErrorMessage) {
        String ActualErrorMessage = driver.findElement(By.cssSelector(".message-error li")).getText();
        Assert.assertEquals(ErrorMessage, ActualErrorMessage);
        System.out.println(ActualErrorMessage);

        driver.quit();
    }

}
