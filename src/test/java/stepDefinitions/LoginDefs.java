package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pages.CommonPage;
import pages.LoginPage;
import pages.TrendyolHomePage;
import utils.Driver;

public class LoginDefs {



    @Given("User on the trendyol website")
    public void user_on_the_trendyol_website() {
        Driver.getDriver().get("https://www.trendyol.com/");
    }
    @When("user navigate login page")
    public void user_navigate_login_page() throws InterruptedException {
        TrendyolHomePage homePAge = new TrendyolHomePage();
        homePAge.navigateLoginPage();
    }
    @When("user enter username and password")
    public void user_enter_username_and_password() {
        LoginPage loginPAge = new LoginPage();
        loginPAge.login();
    }

    @Then("verify that unsuccessful login")
    public void verify_that_unsuccessful_login() throws InterruptedException {
        LoginPage loginPAge = new LoginPage();
        Assertions.assertTrue(loginPAge.checkErrorMsg());
    }

    @When("user navigate {string}")
    public void userNavigate(String categoryName) throws InterruptedException {
        TrendyolHomePage homePage = new TrendyolHomePage();
        CommonPage commonPage = new CommonPage();
        commonPage.navigateCategory(categoryName);
        Thread.sleep(3000);

        System.out.println(Driver.getDriver().getCurrentUrl());
    }

    @When("user navigate {string} from {string}")
    public void userNavigateFrom(String subcategoryName, String categoryName) {
        TrendyolHomePage homePage = new TrendyolHomePage();
        CommonPage commonPage = new CommonPage();
        commonPage.navigateCategory(categoryName,subcategoryName);
    }
}
