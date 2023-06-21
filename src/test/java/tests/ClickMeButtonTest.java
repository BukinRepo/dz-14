package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AbstractObjects;

public class ClickMeButtonTest {

    private static final String URL = "https://demoqa.com/elements";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }
    @Test
    @Step("Click Me Button Text Checker Test")
    public void clickMeButtonTextChecker () {
        AbstractObjects objects = new AbstractObjects(driver);
        driver.get(URL);
        objects.clickButton("//*[@id=\"item-4\"]/span");
        objects.clickButton("//*[text()='Click Me']");
        String buttonText = objects.getTextByElementId("dynamicClickMessage");
        Assert.assertEquals(buttonText, "You have done a dynamic click");
        System.out.println(buttonText);
    }

    @AfterMethod
    public void cleanUp(){
        driver.close();
        driver.quit();
    }
}
