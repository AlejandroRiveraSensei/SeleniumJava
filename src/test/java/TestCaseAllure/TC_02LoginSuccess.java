package TestCaseAllure;

import Utils.GlobalVariables;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02LoginSuccess extends BaseTest{

    @Test
    public void TC02_LoginSuccessTest(){
        login.login(GlobalVariables.STANDARD_USER, GlobalVariables.GLOBAL_PWD);
        Assert.assertTrue(inventoryPage.verifyAddToCartBtn());
    }
}
