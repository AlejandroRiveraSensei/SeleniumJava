package TestCasesLineales;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC02_Validar_AddToCart_Text {

    @Test
    public void TC02() throws InterruptedException {
        //Inicializar el driver del navegador
        WebDriver driver = new ChromeDriver();

        //Abrir la pagina de pruebas
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Step 1: Llenar campo de usuerio
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");

        //Step 2: Llenar el campo de Password
        driver.findElement(By.xpath("//*[@data-test = 'password']")).sendKeys("secret_sauce");

        //Step 3: Hacer click en Login
        driver.findElement(By.xpath("//*[@id = 'login-button']")).click();

        //Validar que el text Add to Cart este presente en la pagina
        boolean addtoCartDisplayed = driver.findElement(By.xpath("//*[contains(text(), 'ADD TO CART')]")).isDisplayed();
        Assert.assertTrue(addtoCartDisplayed);

        WebElement addtoCartButton = new WebDriverWait(driver,Duration.ofSeconds(60)).
                                    until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'btn_primary btn_inventory']")));

        driver.quit();

    }
}
