package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AbstractObjects;

public class WebTablesTest {

    private static final String URL = "https://demoqa.com/webtables";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }
    @Test
    @Step("Add Edit And Delete Form Test")
    public void addAndEditForm () {
        AbstractObjects objects = new AbstractObjects(driver);
        driver.get(URL);
        /*
        Create Field
         */
        objects.clickButton("//*[@id=\"addNewRecordButton\"]");
        objects.fillFormField("//*[@id=\"firstName\"]", "First Name Test");
        objects.fillFormField("//*[@id=\"lastName\"]", "Last Name Test");
        objects.fillFormField("//*[@id=\"userEmail\"]", "test@test.test");
        objects.fillFormField("//*[@id=\"age\"]", "45");
        objects.fillFormField("//*[@id=\"salary\"]", "100500");
        objects.fillFormField("//*[@id=\"department\"]", "Test Department");
        objects.clickButton("//*[@id=\"submit\"]");
        Assert.assertEquals(objects.getTextByElementXpath("//*[text()='test@test.test']"), "test@test.test");
        /*
        Edit Field
         */
        objects.clickButton("//*[text()='test@test.test']/../div[7]//div/span[contains(@id,'edit-record')]");
        objects.clearField("//*[@id=\"userEmail\"]");
        objects.fillFormField("//*[@id=\"userEmail\"]", "test2@test2.test");
        objects.clickButton("//*[@id=\"submit\"]");
        Assert.assertEquals(objects.getTextByElementXpath("//*[text()='test2@test2.test']"), "test2@test2.test");
        /*
        Delete Field
         */
        objects.clickButton("//*[text()='test2@test2.test']/../div[7]//div/span[contains(@id,'delete-record')]");
        Assert.assertTrue(objects.waitTillDisappeared(By.xpath("//*[text()='test2@test2.test']")));
//        Assert.assertFalse(driver.findElement(By.xpath("//*[text()='test2@test2.test']")).isDisplayed());
    }

    @AfterMethod
    public void cleanUp(){
        driver.close();
        driver.quit();
    }
}
