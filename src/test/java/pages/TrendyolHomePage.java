package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class TrendyolHomePage {

    public TrendyolHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
        closeHomePagePopup();
    }

    /**
     * Trendyol sayfasına gittiğimizde açılan ilk pop-up için locator
     * Bu locator'ı kullanarak açılan pop-up'ı otomatik kapatmaya çalışacağız.
     */
    @FindBy(className = "homepage-popup")
    private WebElement homePagePopup;


    public void closeHomePagePopup(){
        //Eğer pop-up gözüküyorsa çarpıya bas şeklinde method yazdık
        // Bunu ayrıca try-catch ile de yapabiliriz exception alma ihtimalimizi de çözebiliriz.
        if (homePagePopup.isDisplayed()){
            Driver.getDriver().findElement(By.className("modal-close")).click();
        }
    }




    public void navigateLoginPage() throws InterruptedException {
        WebElement element = Driver.getDriver().findElement(By.xpath("//div[@class='link account-user']"));

        Thread.sleep(3000);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();

        WebElement login = Driver.getDriver().findElement(By.xpath("//div[@class='login-button']"));
        login.click();
    }

}
