package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement updateCartButton;
    WebElement removeButton;
    WebElement proceedToCheckoutButton;
    WebElement returnToMainMenuButton;
    WebElement withTailManxCatQuantityBox;

    public CartPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getUpdateCartButton() {
        return driver.findElement(By.name("updateCartQuantities"));
    }

    public WebElement getReturnToMainMenuButton() {
        return driver.findElement(By.linkText("Return to Main Menu"));
    }

    public WebElement getWithTailManxCatQuantityBox() {
        return driver.findElement(By.name("EST-15"));
    }

    //    public List<WebElement> getElements() {
    //        return driver.findElements(By.className("text"));
    //    }

    public List<WebElement> getElements() {
        return driver.findElements(By.className("Button"));
    }

    public void clickOnRemoveButton() {
        for(int i = 0; i < getElements().size(); i++) {
            if(getElements().get(i).getText().equals("Remove")) {
                getElements().get(i).click();
                break;
            }
        }
    }
    public void clickOnProceedToCheckoutButton() {
        for(int i = 0; i < getElements().size(); i++) {
            if(getElements().get(i).getText().equals("Proceed to Checkout")) {
                getElements().get(i).click();
                break;
            }
        }
    }

    public void clickOnUpdateCartButton() {
        getUpdateCartButton().click();
    }

    public void returnToMainMenu() {
        getReturnToMainMenuButton().click();
    }

    public void updateWithTailManxQuantity(String number) {
        getWithTailManxCatQuantityBox().clear();
        getWithTailManxCatQuantityBox().sendKeys(number);
    }
}
