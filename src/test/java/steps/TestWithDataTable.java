package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestWithDataTable {
    WebDriver driver;

    @Given("User launches the browser")
    public void user_launches_the_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("User navigates to the homepage")
    public void user_navigates_to_the_homepage() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
    }

    @When("User clicks on the register element")
    public void user_clicks_on_the_register_element() {

        driver.findElement(By.className("ico-register")).click();
    }

    @When("User clicks gender")
    public void user_clicks_gender() {

        driver.findElement(By.id("gender-male")).click();
    }

    @When("User inputs the following details")
    public void user_inputs_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> obj = dataTable.asLists();
        driver.findElement(By.id("FirstName")).sendKeys(obj.get(0).get(0));
        driver.findElement(By.id("LastName")).sendKeys(obj.get(0).get(1));
        String randomEmail = RandomStringUtils.randomAlphabetic(3) + "@gmail.com";
        driver.findElement(By.id("Email")).sendKeys(randomEmail);
        driver.findElement(By.id("Password")).sendKeys(obj.get(0).get(2));
        driver.findElement(By.id("ConfirmPassword")).sendKeys(obj.get(0).get(3));

    }

    @When("User presses the register button")
    public void user_presses_the_register_button() {

        driver.findElement(By.id("register-button")).click();
    }

    @Then("User should see success message your registration completed")
    public void user_should_see_success_message_your_registration_completed() {
        String expectedResult = "Your registration completed";
        String actualResult = driver.findElement(By.className("result")).getText();
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(actualResult);

        driver.quit();
    }



}
