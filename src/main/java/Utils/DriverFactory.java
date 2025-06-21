package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initializeDriver(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        prefs.put("profile.password_manager_leak_detection",false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments();

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static void launchURL(String url){
        driver.get(url);
    }
}
