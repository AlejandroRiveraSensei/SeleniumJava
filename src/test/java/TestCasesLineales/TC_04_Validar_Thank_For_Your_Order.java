package TestCasesLineales;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TC_04_Validar_Thank_For_Your_Order {

    @Test
    public void TC04(){
        //Inicializar el driver del navegador
        ChromeOptions options = new ChromeOptions();
        Map prefs = new HashMap();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        prefs.put("profile.password_manager_leak_detection",false);

        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments();
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);

        //Abrir la pagina de pruebas
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Step 1: Login
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@data-test = 'password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id = 'login-button']")).click();

        //Step 2: Hacer Click en Add to Cart
        driver.findElement(By.xpath("//*[contains(text(), 'ADD TO CART')]")).click();

        //Step 3: Click en el carrito de compras
        driver.findElement(By.xpath("//*[@class = 'shopping_cart_link fa-layers fa-fw']")).click();

        //Step 4: Hacer click en Checkout
        driver.findElement(By.xpath("//*[@class = 'btn_action checkout_button']")).click();

        //Step 5: Llenar el formulario de Checkout y hace click en continue
        driver.findElement(By.id("first-name")).sendKeys("Alejandro");
        driver.findElement(By.id("last-name")).sendKeys("SenseiTech");
        driver.findElement(By.id("postal-code")).sendKeys("90210");
        driver.findElement(By.xpath("//*[@value = 'CONTINUE']")).click();

        //Step 6 Hacer click en Finish
        driver.findElement(By.xpath("//*[contains(text(), 'FINISH')]")).click();

        //Validar el texto de "THANK YOU FOR YOUR ORDER"
        String expectedMessage = "THANK YOU FOR YOUR ORDER";
        String actualMessage = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);

        //Cerrar el navedagor
        driver.quit();

    }
}
