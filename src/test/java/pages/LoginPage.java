package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import utils.WebUtils;

import java.time.Duration;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void login() {
        WebElement email = Driver.getDriver().findElement(By.id("login-email"));
        WebElement password = Driver.getDriver().findElement(By.id("login-password-input"));
        email.sendKeys("email@e.com");
        password.sendKeys("password");

        WebElement submitBtn = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        WebUtils.waitForClick(Driver.getDriver(),submitBtn);
        submitBtn.click();
    }

    @FindBy(xpath = "//span[@class='message']")
    public WebElement errorMsg;

    public boolean checkErrorMsg(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        return errorMsg.isDisplayed();
    }

}
