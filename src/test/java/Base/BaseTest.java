package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public HomePage homepage;
    public LoginPage loginPage;
    public CatsPage catsPage;
    public ManxCatPage manxCatPage;
    public TaillessManxPage taillessManxPage;
    public CartPage cartPage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("C:\\Users\\Korisnik\\Desktop\\PetShop.xlsx");
        homepage = new HomePage(driver, wdwait);
        loginPage = new LoginPage(driver, wdwait);
        catsPage = new CatsPage(driver, wdwait);
        manxCatPage = new ManxCatPage(driver, wdwait);
        taillessManxPage = new TaillessManxPage(driver, wdwait);
        cartPage = new CartPage(driver, wdwait);
    }

    public void visibilityWait(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickabilityWait(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
