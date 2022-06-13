package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement register;
    WebElement usernameBox;
    WebElement passwordBox;
    WebElement loginButton;

    public LoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getRegister() {
        return driver.findElement(By.linkText("Register Now!"));
    }

    public WebElement getUsernameBox() {
        return driver.findElement(By.name("username"));
    }

    public WebElement getPasswordBox() {
        return driver.findElement(By.name("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.name("signon"));
    }

    public void enterUsername (String username) {
        getUsernameBox().clear();
        getUsernameBox().sendKeys(username);
    }

    public void enterPassword (String password) {
        getPasswordBox().clear();
        getPasswordBox().sendKeys(password);
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }
}
