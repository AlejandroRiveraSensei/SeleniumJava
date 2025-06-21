package TestCasesPOM;

import PageObjects.LoginPage;
import Utils.BaseClass;
import Utils.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC01_Login_Error {

    //Declarar e inicializar el webDriver
    WebDriver driver = BaseClass.setupDriver();

    //PageObjects
    LoginPage loginPage = new LoginPage(driver);

    @BeforeTest
    public void startWebDriver(){
        driver.get(GlobalVariables.HOME_PAGE);
    }

    @Test
    public void TC01(){
        //Step 1 Hacer login
        String username = BaseClass.getJsonValue("TC01","username");
        loginPage.login(username,"wrong_pwd");

        //Validacion del error de login
        Assert.assertEquals(loginPage.getLoginError(),"Epic sadface: Username and password do not match any user in this service");
    }

    @AfterTest
    public void closeDriver(){
        BaseClass.takeScrenshoot(driver, "TestCaseIvan");
        BaseClass.quitDriver(driver);
    }
}
