package TestCasesPOM;

import PageObjects.InventoryPage;
import PageObjects.LoginPage;
import Utils.BaseClass;
import Utils.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC03_Validar_Boton_Remove {

    //Declarar e inicializar el webDriver
    WebDriver driver = BaseClass.setupDriver();

    //PageObjects
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);

    @BeforeTest
    public void startWebDriver(){
        driver.get(GlobalVariables.HOME_PAGE);
    }

    @Test
    public void TC03(){
        //Step 1: Hacer login
        loginPage.login(GlobalVariables.STANDARD_USER,GlobalVariables.GLOBAL_PWD);

        //Step 2: Click en add to cart
        inventoryPage.clickAddToCartButton();

        //Validacion
        Assert.assertTrue(inventoryPage.verifyRemoveBtn());

        }

    @AfterTest
    public void closeDriver(){
        BaseClass.quitDriver(driver);
    }
}
