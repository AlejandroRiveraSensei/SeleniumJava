package TestCasesPOM;

import PageObjects.CartPage;
import PageObjects.InventoryPage;
import PageObjects.LoginPage;
import Utils.BaseClass;
import Utils.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC05_Validar_Second_Item_Text {

    //Declarar e inicializar el webDriver
    WebDriver driver = BaseClass.setupDriver();

    //PageObjects
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage = new CartPage(driver);

    @BeforeTest
    public void startWebDriver(){
        driver.get(GlobalVariables.HOME_PAGE);
    }

    @Test
    public void TC05(){
        //Step 1: Hacer login
        loginPage.login(GlobalVariables.STANDARD_USER,GlobalVariables.GLOBAL_PWD);

        //Step 2: Click en add to cart
        inventoryPage.clickAddToCartButton();

        //Step 3: Ir al carrito de compras y hacer en click en Continue Shopping
        inventoryPage.clickShoppingCart();
        cartPage.clickContinueShoppingBtn();

        //Step 4: agregar un segundo Item
        inventoryPage.clickAddToCartButton();

        //Step 5: Verificar text del segundo Item (pueden usar el xpath con texto)
        inventoryPage.clickShoppingCart();
        Assert.assertTrue(cartPage.verifySeconItemText());
        }

    @AfterTest
    public void closeDriver(){
        BaseClass.quitDriver(driver);
    }
}
