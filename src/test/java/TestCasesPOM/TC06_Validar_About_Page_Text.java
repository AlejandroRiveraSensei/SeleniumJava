package TestCasesPOM;

import PageObjects.CartPage;
import PageObjects.InventoryPage;
import PageObjects.LoginPage;
import PageObjects.SauceLabsPage;
import Utils.BaseClass;
import Utils.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC06_Validar_About_Page_Text {

    //Declarar e inicializar el webDriver
    WebDriver driver = BaseClass.setupDriver();

    //PageObjects
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    SauceLabsPage sauceLabsPage = new SauceLabsPage(driver);

    @BeforeTest
    public void startWebDriver(){
        driver.get(GlobalVariables.HOME_PAGE);
    }

    @Test
    public void TC06(){
        //Step 1: Hacer login
        loginPage.login(GlobalVariables.STANDARD_USER,GlobalVariables.GLOBAL_PWD);

        //Step 2: Click en Menu
        inventoryPage.clickMenu();

        //Step 3: Click en About
        inventoryPage.clickAboutMenu();

        //Step 4: Verificar Texto: Build apps users love with AI-driven insights
        Assert.assertTrue(sauceLabsPage.aboutPageTextIsDisplayed());

        }

    @AfterTest
    public void closeDriver(){
        BaseClass.quitDriver(driver);
    }
}
