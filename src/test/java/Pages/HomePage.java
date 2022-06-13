package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement logo;
    WebElement searchBar;
    WebElement searchButton;
    WebElement signInButton;
    WebElement cart;
    WebElement catsCatalogButton;


    public HomePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getLogo() {
        return driver.findElement(By.id("logo"));
    }

    public WebElement getSearchBar() {
        return driver.findElement(By.name("keyword"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.name("searchProducts"));
    }

    public WebElement getSignInButton() {
        return driver.findElement(By.linkText("Sign In"));
    }

    public WebElement getCart() {
        return driver.findElement(By.name("img_cart"));
    }

    public WebElement getCatsCatalogButton() {
        return driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[3]/img"));
    }

    public void typeInSearch (String searchElement) {
        getSearchBar().sendKeys(searchElement);
    }

    public void clickOnSearchButton () {
        getSearchButton().click();
    }

    public void goToSignInPage() {
        getSignInButton().click();
    }

    public void goToCart() {
        getCart().click();
    }

    public void goToCatsCatalog() {
        getCatsCatalogButton().click();
    }

}
