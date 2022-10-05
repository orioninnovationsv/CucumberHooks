package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Driver;

import java.time.Duration;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("Before method");
        Driver.initDriver();
    }

    @After
    public void tearDown(){
        Driver.getDriver().quit();
    }
}
