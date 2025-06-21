package PageObjects;

import Utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BaseClass {

    public CheckoutCompletePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //WebElements de ChackoutOnePage
    @FindBy(className = "complete-header")
    private WebElement correctMessage;


    //Metodos de CheckuotPage
    public String getThankYouMessage(){
        return getText(correctMessage);
    }

}
