package TestCasesPOM;

import PageObjects.*;
import Utils.BaseClass;
import Utils.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC04_Validar_Thank_You_For_Your_Order {

    //Declarar e inicializar el webDriver
    WebDriver driver = BaseClass.setupDriver();

    //PageObjects
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);
    CheckoutTwoPage checkoutTwoPage = new CheckoutTwoPage(driver);
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

    @BeforeTest
    public void startWebDriver(){
        driver.get(GlobalVariables.HOME_PAGE);
    }

    @Test
    public void TC04(){
        //Step 1: Hacer login
        loginPage.login(GlobalVariables.STANDARD_USER,GlobalVariables.GLOBAL_PWD);

        //Step 2: Click en add to cart
        inventoryPage.clickAddToCartButton();

        //Step 3: Click en el carrito de compras
        inventoryPage.clickShoppingCart();

        //Step 4: Hacer click en Checkout
        cartPage.clickChecoutButton();

        //Step 5: Llenar el formulario de Checkout y hace click en continue
        checkoutOnePage.fillCheckoutData("Alejandro", "Sensei","90210");
        checkoutOnePage.clickContinueButton();

        //Step 6 Hacer click en Finish
        checkoutTwoPage.clickFinishButton();

        //Validar el texto de "THANK YOU FOR YOUR ORDER"
        checkoutCompletePage.getThankYouMessage();
        Assert.assertEquals(checkoutCompletePage.getThankYouMessage(), "THANK YOU FOR YOUR ORDER");
        }

    @AfterTest
    public void closeDriver(){
        BaseClass.quitDriver(driver);
    }
}
