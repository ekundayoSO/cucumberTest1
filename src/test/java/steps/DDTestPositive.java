package steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DDTestPositive {

    WebDriver driver;

    @Given("User launches chrome browser")
    public void user_launches_chrome_browser() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        driver = new FirefoxDriver(options);
    }

    @When("User navigates to the DemoWebShop login page")
    public void user_navigates_to_the_demo_web_shop_login_page() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
    }

    @When("User clicks login element")
    public void user_clicks_login_element() {

        driver.findElement(By.className("ico-login")).click();
    }

    @When("User enters the {string} and {string}")
    public void user_enters_the_and(String Username, String Password) {
        driver.findElement(By.id("Email")).sendKeys(Username);
        driver.findElement(By.id("Password")).sendKeys(Password);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }

    @When("User should see the user logout page")
    public void user_should_see_the_user_logout_page() {
        String expectedPageContains = "Log out";
        String actualPageContains = driver.findElement(By.className("ico-logout")).getText();
        Assert.assertEquals(actualPageContains, expectedPageContains);

        System.out.println(actualPageContains);
    }

    @Then("User closes the browser")
    public void user_closes_the_browser() {

        driver.manage().deleteAllCookies();
        driver.close();
    }


}
