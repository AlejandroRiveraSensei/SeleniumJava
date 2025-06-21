package TestCaseAllure;

import Utils.GlobalVariables;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_LoginError extends BaseTest{
    @Test
    public void TC01_LoginErrorTest(){
        //Test Case 01
        login.login(GlobalVariables.STANDARD_USER, "wrongPassword");
        Assert.assertEquals( login.getLoginError(), "Epic sadface: asdfsadfsdaf match any user in this service");
    }

}
