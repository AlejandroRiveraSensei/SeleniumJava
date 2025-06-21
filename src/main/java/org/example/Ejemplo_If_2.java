package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo_If_2 {
    public static void main(String[] args) {

        //Inicializando el chrome
        WebDriver driver = new ChromeDriver();

        //Abrir la pagina de pruebas
        driver.get("https://www.saucedemo.com/v1/");

        //Identificar e interactuar los webElements de la pagina de login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Ejemplo IF verificar un elemento desplegado
        WebElement inventoryItem = driver.findElement(By.className("inventory_item_name"));

        if(inventoryItem.isDisplayed()){
            System.out.println("Elemento desplegado en la pagina");
        }else{
            System.out.println("Elemento NO desplegado en la pagina");
        }

        //Metodos para validar titulo de pagin o URL
        String tituloDePagina = driver.getTitle();
        System.out.println(tituloDePagina);


        String urlDePagina = driver.getCurrentUrl();
        System.out.println(urlDePagina);
    }
}
