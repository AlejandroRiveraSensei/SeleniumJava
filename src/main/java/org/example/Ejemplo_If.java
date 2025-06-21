package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo_If {
    public static void main(String[] args) {

        //Inicializando el chrome
        WebDriver driver = new ChromeDriver();

        //Abrir la pagina de pruebas
        driver.get("https://www.saucedemo.com/v1/");

        //Identificar e interactuar los webElements de la pagina de login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();

        //Ejemplo IF verificar un elemento desplegado
        WebElement errorMsg = driver.findElement(By.className("error-button"));

        if(errorMsg.isDisplayed()){
            System.out.println("Login Fallido");
        }else{
            System.out.println("Login Exitoso");
        }

    }
}
