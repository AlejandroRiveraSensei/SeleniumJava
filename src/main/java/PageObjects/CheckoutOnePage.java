package PageObjects;

import Utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOnePage extends BaseClass {

    public CheckoutOnePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //WebElements de ChackoutOnePage
    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalcodeInput;

    @FindBy(xpath = "//*[@value = 'CONTINUE']")
    private WebElement continueButton;

    //Metodos de CheckuotPage
    public void fillCheckoutData(String firstName, String lastName, String postalCode){
        sendKeys(firstNameInput,firstName);
        sendKeys(lastNameInput,lastName);
        sendKeys(postalcodeInput,postalCode);
    }

    public void clickContinueButton(){
        click(continueButton);
    }

}
