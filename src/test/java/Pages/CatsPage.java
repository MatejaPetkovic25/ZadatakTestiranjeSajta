package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatsPage {
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement manxCat;
    WebElement persianCat;

    public CatsPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getManxCat() {
        return driver.findElement(By.linkText("FL-DSH-01"));
    }

    public WebElement getPersianCat() {
        return driver.findElement(By.linkText("FL-DLH-02"));
    }

    public void clickOnManxCat() {
        getManxCat().click();
    }

    public void clickOnPersianCat() {
        getPersianCat().click();
    }
}
