package TestCaseAllure;

import Utils.GlobalVariables;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test
    public void TC01_LoginError(){
        //Test Case 01
        login.login(GlobalVariables.STANDARD_USER, "wrongPassword");
        Assert.assertEquals( login.getLoginError(), "Epic sadface: asdfsadfsdaf match any user in this service");
    }

    @Test
    public void TC02_LoginSuccess(){
        login.login(GlobalVariables.STANDARD_USER, GlobalVariables.GLOBAL_PWD);
        Assert.assertTrue(inventoryPage.verifyAddToCartBtn());
    }
}
