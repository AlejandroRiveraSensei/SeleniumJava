package PageObjects;

import Utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BaseClass {

    public InventoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //WebElements de InventoryPage
    @FindBy(xpath = "//*[contains(text(),'ADD TO CART')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[contains(text(),'REMOVE')]")
    private WebElement removeButton;

    @FindBy(xpath = "//*[@class = 'shopping_cart_link fa-layers fa-fw']")
    private WebElement shoppingCartIcon;

    @FindBy(xpath = "//*[contains(text(),'Open Menu')]")
    private WebElement menuBtn;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutMenu;

    //Metodos de InventoryPage
    public boolean verifyAddToCartBtn(){
        return isDisplayed(addToCartButton);
    }

    public void clickAddToCartButton(){
        click(addToCartButton);
    }

    public boolean verifyRemoveBtn(){
        return isDisplayed(removeButton);
    }

    public void clickShoppingCart(){
        click(shoppingCartIcon);
    }

    public void clickMenu(){
        click(menuBtn);
    }

    public void clickAboutMenu(){
        click(aboutMenu);
    }

}
