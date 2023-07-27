package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTestParam {

    WebDriver driver;

    @Given("I launch firefox browser")
    public void i_launch_firefox_browser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @When("I navigate to the Demo Web Shop login page")
    public void i_navigate_to_the_demo_web_shop_login_page() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

    }

    @When("I click login element")
    public void i_click_login_element() {

        driver.findElement(By.className("ico-login")).click();

    }

    @When("I input the username as {string} and password as {string}")
    public void i_input_the_username_as_and_password_as(String username, String password) {
        driver.findElement(By.id("Email")).sendKeys(username);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

    }

    @When("I should see the user logout page")
    public void i_should_see_the_user_logout_page() {
        String expectedPageContains = "Log out";
        String actualPageContains = driver.findElement(By.className("ico-logout")).getText();
        Assert.assertEquals(actualPageContains, expectedPageContains);

        System.out.println(actualPageContains);
    }

    @Then("I quit the browser")
    public void i_quit_the_browser() {

        driver.close();
    }

}
