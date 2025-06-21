package TestCasesLineales;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC01_Validar_Mensaje_Error_Login {

    @Test
    public void TC01(){
        //Inicializar el driver del navegador
        WebDriver driver = new ChromeDriver();

        //Abrir la pagina de pruebas
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));





        //Step 1: Llenar campo de usuerio
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");

        //Step 2: Llenar el campo de Password
        driver.findElement(By.xpath("//*[@data-test = 'password']")).sendKeys("wrongPwd");

        //Step 3: Hacer click en Login
        driver.findElement(By.xpath("//*[@id = 'login-button']")).click();

        //Validar el mensaje de error
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualMessage = driver.findElement(By.xpath("//*[@data-test= 'error']")).getText();

        Assert.assertEquals(actualMessage, expectedMessage);

        String expectedEpicSadface = "Something went wrong";
        boolean isTrue = actualMessage.contains(expectedEpicSadface);
        Assert.assertFalse(isTrue);

        driver.quit(); //Cierra todas las ventanas y/o pestañas que abrio el driver
        //driver.close(); //Solo cierrta la ultima ventana o pestaña con la que el webdriver
    }
}
