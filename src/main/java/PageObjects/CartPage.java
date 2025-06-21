package PageObjects;

import Utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseClass {

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //Webelements CartPage
    @FindBy(xpath = "//*[contains(text(),'CHECKOUT')]")
    private WebElement checkouttButton;

    @FindBy(xpath = "//*[@class = 'btn_secondary']")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "//*[contains(text(),'Sauce Labs Bike Light')]")
    private WebElement secondItemText;

    public void clickChecoutButton(){
        click(checkouttButton);
    }

    public void clickContinueShoppingBtn(){
        click(continueShoppingBtn);
    }

    public boolean verifySeconItemText(){
        return secondItemText.isDisplayed();
    }
}
