package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractObjects {
    protected WebDriver driver;

    public AbstractObjects(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getElements (By by){
        return new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement getElements (By by, int sec){
        return new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> getAllElements (By by){
        return new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitTillAppeared (By by){
        new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public boolean waitTillDisappeared (By by){
        return new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void clickButton(String path){
        driver.findElement(By.xpath(path)).click();
    }

    public String getTextByElementId(String idElement){
        return driver.findElement(By.id(idElement)).getText();
    }

    public String getTextByElementXpath(String path){
        return driver.findElement(By.xpath(path)).getText();
    }

    public void fillFormField(String id, String text){
        driver.findElement(By.xpath(id)).sendKeys(text);
    }

    public void clearField(String path){
        driver.findElement(By.xpath(path)).clear();
    }
}
