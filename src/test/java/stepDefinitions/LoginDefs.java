package stepDefinitions;

import com.beust.ah.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebUtils;

import java.time.Duration;

public class LoginDefs {

    static WebDriver driver;

    @Given("User on the trendyol website")
    public void user_on_the_trendyol_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.trendyol.com/");
    }
    @When("user navigate login page")
    public void user_navigate_login_page() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//div[@class='link account-user']"));

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        WebElement login = driver.findElement(By.xpath("//div[@class='login-button']"));
        login.click();
    }
    @When("user enter username and password")
    public void user_enter_username_and_password() {
        login();
    }

    private void login() {
        WebElement email = driver.findElement(By.id("login-email"));
        WebElement password = driver.findElement(By.id("login-password-input"));
        email.sendKeys("email@e.com");
        password.sendKeys("password");

        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        WebUtils.waitForClick(driver,submitBtn);
        submitBtn.click();
    }

    @Then("verify that unsuccessful login")
    public void verify_that_unsuccessful_login() throws InterruptedException {
        WebElement errorMsg = driver.findElement(By.xpath("//span[@class='message']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        Assertions.assertTrue(errorMsg.isDisplayed());
    }


}
