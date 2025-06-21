package Utils;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver setupDriver(){
        ChromeOptions options = new ChromeOptions();
        Map prefs = new HashMap();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        prefs.put("profile.password_manager_leak_detection",false);

        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments();
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void click(WebElement element){
        element.click();
    }

    public static void sendKeys(WebElement element, String textToSend){
        element.sendKeys(textToSend);
    }

    public static String getText(WebElement element){
        return element.getText();
    }

    public static void quitDriver(WebDriver driver){
        driver.quit();
    }

    public static boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public static String getJsonValue(String jsonFileObj, String jsonKey){
        try {
            InputStream inputStream = new FileInputStream("./src/main/resources/" + jsonFileObj + ".json");//Usando la ruta obtenemos el archivo Json
            JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream)); //Convertimos el archivo a un objeto de Java

            //Obtener el datos
            return jsonObject.getJSONObject(jsonFileObj).getString(jsonKey);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void takeScrenshoot(WebDriver webDriver, String testCaseName){
        //Toma el screenshot de la pagina sin formato
        File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);

        //La ruta donde se va a guardar el screenshot
        String screenshotPath = "./test-output/ExecutionResults";

        FileHandler.createDir(new File(screenshotPath));
        try {
            FileHandler.copy(scrFile, new File(screenshotPath + File.separator + testCaseName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
