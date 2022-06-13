package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManxCatPage {
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement taillessCat;
    WebElement taillesCatCartButton;
    WebElement withTailCat;
    WebElement withTailCatCartButton;

    public ManxCatPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getTaillessCat() {
        return driver.findElement(By.linkText("EST-14"));
    }

    public WebElement getTaillesCatCartButton() {
        return driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a"));
    }

    public WebElement getWithTailCat() {
        return driver.findElement(By.linkText("EST-15"));
    }

    public WebElement getWithTailCatCartButton() {
        return driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[3]/td[5]/a"));
    }

    //----------------------------------------------

    public void goToTaillessManxCatPage() {
        getTaillessCat().click();
    }

    public void goToWithTailManxCatPage() {
        getWithTailCat().click();
    }

    public void taillesManxCatAddToCart() {
        getTaillesCatCartButton().click();
    }

    public void withTailManxCatAddToCart() {
        getWithTailCatCartButton().click();
    }
}
