package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class CommonPage {


    public CommonPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//ul[@class='main-nav']//li[@class='tab-link']/a")
    public List<WebElement> categories;

    public void navigateCategory(String categoryName){
        for (WebElement category : categories) {
            if (category.getText().equalsIgnoreCase(categoryName)){
                Actions actions = new Actions(Driver.getDriver());
                actions.moveToElement(category).perform();
                try {
                    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.elementToBeClickable(category)).click();
                }catch (Exception e){}
                break;
            }
        }
    }


    /**
     * Yukarıda kategoriler arasında gezip tıklayacak bir method yazdık.
     * Bu method içerisinde de kategoriler arasında gezip tıklamadan açılan menüden alt-kategori seçmeye çalışacağız.
     * @param categoryName
     * @param subCategory
     */
    public void navigateCategory(String categoryName,String subCategory){
        for (WebElement category : categories) {
            if (category.getText().equalsIgnoreCase(categoryName)){
                Actions actions = new Actions(Driver.getDriver());
                actions.moveToElement(category).perform();
                WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='"+ categoryName +"']/..//a[.='"+ subCategory +"']"))).click();
                break;
            }
        }
    }

}
