package PageObjects;

import Utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLabsPage extends BaseClass {

    public SauceLabsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //WebElements de SauceLabsPage
    @FindBy(xpath = "//*[contains(text(),'Build apps users love with AI-driven insights')]")
    private WebElement aboutPageText;


    //Metodos de SauceLabsPage
    public boolean aboutPageTextIsDisplayed(){
        return isDisplayed(aboutPageText);
    }

}
