package com.ait.qa63.demowebshop;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        clickOnLog_inLink();
        enterUserCredentials();
        clickOnLoginButton();
    }

    @Test
    public void addItemToCart() {
        clickOnAddButton("3");
        clickOnShoppingCartLink();
        Assert.assertTrue(isItemAdded("14.1-inch Laptop"));
    }

}
