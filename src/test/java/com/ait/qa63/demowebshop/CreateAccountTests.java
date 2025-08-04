package com.ait.qa63.demowebshop;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
        clickOnRegisterLink();
        fillRegisterForm();
        clickOnRegisterButton();
        Assert.assertTrue(isSuccessMessagePresent());
    }

}
