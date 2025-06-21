package PageObjects;

import Utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //LoginPage WebElements
    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@data-test = 'error']")
    private WebElement erroMsg;

    public void login(String user, String password){
        sendKeys(userNameInput,user);
        sendKeys(passwordInput,password);
        click(loginBtn);
    }

    public String getLoginError(){
        return getText(erroMsg);
    }

}
