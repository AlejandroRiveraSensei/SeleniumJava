package listener;

import TestCaseAllure.BaseTest;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        if(testClass instanceof BaseTest) {
            WebDriver driver = ((BaseTest) testClass).getDriver();
            if(driver != null){
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                //Este es el metodo clave para que Allure veo el scneenshot como PNG y nombre el archivo correctamoe
                Allure.getLifecycle().addAttachment("Scrennshot on failure","image/png", "png", screenshot);
                System.out.println("Screenshot registrado correctamente con tipo PNG.");
            }
        }


    }
}
