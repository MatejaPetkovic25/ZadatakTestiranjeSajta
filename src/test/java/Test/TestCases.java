package Test;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases extends BaseTest {

    String URL;
    String validUsername;
    String validPassword;
    String invalidUsername;
    String invalidPassword;
    WebElement welcomeMessage;
    WebElement myAccountButton;
    WebElement unsuccessfulLoginMessage;
    WebElement newOrder;
    WebElement confirmButtonForBuying;
    WebElement buyingMessage;
    String expectedMessage;
    String expectedMessageAfterBuying;
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        URL = excelReader.getStringData("URLs", 1, 0);
        driver.navigate().to(URL);
        validUsername = excelReader.getStringData("SignIn", 1, 0);
        validPassword = excelReader.getStringData("SignIn", 1, 1);
        invalidUsername = excelReader.getStringData("SignIn", 1, 2);
        invalidPassword = excelReader.getStringData("SignIn", 1, 3);
        expectedMessage = excelReader.getStringData("Messages", 1, 0);
        expectedMessageAfterBuying = excelReader.getStringData("Messages", 1, 1);
    }

    @Test (priority = 10)
    public void successfulLoginTest() {
        homepage.goToSignInPage();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();
        welcomeMessage = driver.findElement(By.id("WelcomeContent"));
        myAccountButton = driver.findElement(By.linkText("My Account"));
        Assert.assertTrue(welcomeMessage.isDisplayed());
        Assert.assertTrue(myAccountButton.isDisplayed());
        //myAccountButton.click();
    }

    public void logIn() {
        homepage.goToSignInPage();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();
    }

    @Test (priority = 20)
    public void unsuccessfulLoginWithInvalidUsername(){
        homepage.goToSignInPage();
        loginPage.enterUsername(invalidUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        unsuccessfulLoginMessage = driver.findElement(By.xpath("/html/body/div[2]/ul/li"));
        boolean check = false;
        try {
            check = driver.findElement(By.id("WelcomeContent")).isDisplayed();
        } catch (Exception e) {
        }

        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(unsuccessfulLoginMessage.getText(), expectedMessage);
        Assert.assertFalse(check);
    }

    @Test (priority = 30)
    public void unsuccessfulLoginWithInvalidPassword() {
        homepage.goToSignInPage();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickOnLoginButton();

        unsuccessfulLoginMessage = driver.findElement(By.xpath("/html/body/div[2]/ul/li"));
        boolean check = false;
        try {
            check = driver.findElement(By.id("WelcomeContent")).isDisplayed();
        } catch (Exception e) {
        }

        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(unsuccessfulLoginMessage.getText(), expectedMessage);
        Assert.assertFalse(check);
    }

    @Test (priority = 40)
    public void unsuccessfulLoginWithInvalidUsernameAndPassword() {
        homepage.goToSignInPage();
        loginPage.enterUsername(invalidUsername);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickOnLoginButton();

        unsuccessfulLoginMessage = driver.findElement(By.xpath("/html/body/div[2]/ul/li"));
        boolean check = false;
        try {
            check = driver.findElement(By.id("WelcomeContent")).isDisplayed();
        } catch (Exception e) {
        }

        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertEquals(unsuccessfulLoginMessage.getText(), expectedMessage);
        Assert.assertFalse(check);

    }

    @Test (priority = 50)
    public void unsuccessfulLoginWithBlankUsernameAndBlankPassword() {
        homepage.goToSignInPage();
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickOnLoginButton();

        boolean check = false;
        try {
            check = driver.findElement(By.id("WelcomeContent")).isDisplayed();
        } catch (Exception e) {

        }

        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        Assert.assertFalse(check);
    }

    @Test (priority = 60)
    public void buyingCatFromCatalog() {
        logIn();
        homepage.goToCatsCatalog();
        catsPage.clickOnManxCat();
        manxCatPage.withTailManxCatAddToCart();
        cartPage.clickOnProceedToCheckoutButton();
        newOrder = driver.findElement(By.name("newOrder"));
        newOrder.click();
        confirmButtonForBuying = driver.findElement(By.className("Button"));
        confirmButtonForBuying.click();
        buyingMessage = driver.findElement(By.xpath("//*[@id=\"Content\"]/ul/li"));

        Assert.assertTrue(buyingMessage.isDisplayed());
        Assert.assertEquals(buyingMessage.getText(), expectedMessageAfterBuying);
    }
    public void finishBuying() {
        newOrder = driver.findElement(By.name("newOrder"));
        newOrder.click();
        confirmButtonForBuying = driver.findElement(By.className("Button"));
        confirmButtonForBuying.click();
        buyingMessage = driver.findElement(By.xpath("//*[@id=\"Content\"]/ul/li"));
    }
    @Test (priority = 70)
    public void buyingMultipleDifferentProductsTest() {
        logIn();
        homepage.goToCatsCatalog();
        catsPage.clickOnManxCat();
        manxCatPage.withTailManxCatAddToCart();
        cartPage.returnToMainMenu();
        homepage.goToCatsCatalog();
        catsPage.clickOnManxCat();
        manxCatPage.goToTaillessManxCatPage();
        taillessManxPage.taillessManxAddToCart();
        cartPage.clickOnProceedToCheckoutButton();
        finishBuying();

        Assert.assertTrue(buyingMessage.isDisplayed());
        Assert.assertEquals(buyingMessage.getText(), expectedMessageAfterBuying);

    }

    @Test (priority = 80)
    public void cartQuantityUpdateTest() {
        logIn();
        homepage.goToCatsCatalog();
        catsPage.clickOnManxCat();
        manxCatPage.withTailManxCatAddToCart();
        cartPage.updateWithTailManxQuantity("3");
        cartPage.clickOnUpdateCartButton();
        cartPage.clickOnProceedToCheckoutButton();
        finishBuying();

    }

    @Test (priority = 90)
    public void proceedingWithoutUpdatingCartTest() {
        logIn();
        homepage.goToCatsCatalog();
        catsPage.clickOnManxCat();
        manxCatPage.withTailManxCatAddToCart();
        cartPage.updateWithTailManxQuantity("3");
        cartPage.clickOnProceedToCheckoutButton();
        finishBuying();
    }

    @Test (priority = 100)
    public void updatingCartWithZeroToMakeItEmptyTest() {
        logIn();
        homepage.goToCatsCatalog();
        catsPage.clickOnManxCat();
        manxCatPage.withTailManxCatAddToCart();
        cartPage.updateWithTailManxQuantity("0");
        cartPage.clickOnUpdateCartButton();
    }

    @AfterMethod
    public void deleteCookies() throws InterruptedException {
        Thread.sleep(2000);
        driver.manage().deleteAllCookies();
    }
}
