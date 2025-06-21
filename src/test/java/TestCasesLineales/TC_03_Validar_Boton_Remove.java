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

public class TC_03_Validar_Boton_Remove {

    @Test
    public void TC03(){
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

        //Verificar el boton de Remove
        boolean removeBtnDisplayed = driver.findElement(By.xpath("//*[contains(text(), 'REMOVE')]")).isDisplayed();
        Assert.assertTrue(removeBtnDisplayed);

        //Cerrar el navedagor
        driver.quit();

    }
}
