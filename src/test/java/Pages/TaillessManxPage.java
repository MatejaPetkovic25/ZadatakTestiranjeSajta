package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaillessManxPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement addToCart;

    public TaillessManxPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getAddToCart() {
        return driver.findElement(By.className("Button"));
    }

    public void taillessManxAddToCart() {
        getAddToCart().click();
    }
}
