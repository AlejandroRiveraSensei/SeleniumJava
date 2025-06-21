package Resueltos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC03_Validar_Remove_Button {

    @Test
    public void TC03(){
        //Inicializar el driver del navegador
        WebDriver driver = new ChromeDriver();

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

        //Validar que el text Add to Cart este presente en la pagina
        boolean addtoCartDisplayed = driver.findElement(By.xpath("//*[contains(text(), 'REMOVE')]")).isDisplayed();
        Assert.assertTrue(addtoCartDisplayed);

        //Cerrar Navegador
        driver.quit();

    }
}
