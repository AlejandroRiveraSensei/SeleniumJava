package TestCaseAllure;

import PageObjects.CartPage;
import PageObjects.CheckoutCompletePage;
import PageObjects.InventoryPage;
import PageObjects.LoginPage;
import Utils.DriverFactory;
import Utils.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class BaseTest {

    private WebDriver driver;
    LoginPage login;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutCompletePage checkoutCompletePage;

    public WebDriver getDriver() {return driver;}

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.initializeDriver();
        login = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);

        DriverFactory.launchURL(GlobalVariables.HOME_PAGE);
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }


}
