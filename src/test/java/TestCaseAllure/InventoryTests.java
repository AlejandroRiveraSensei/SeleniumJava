package TestCaseAllure;

import Utils.GlobalVariables;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTests extends BaseTest{

    @Test
    public void TC03_VerifyRemoveButton(){
        //Step 1: Login
        login.login(GlobalVariables.STANDARD_USER,GlobalVariables.GLOBAL_PWD);

        //Step 2: Click en Add to cart
        inventoryPage.clickAddToCartButton();

        //Verificar remove button
        Assert.assertTrue(inventoryPage.verifyRemoveBtn());
    }
}
