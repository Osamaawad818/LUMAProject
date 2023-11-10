package com.luma.testcases;

import com.luma.base.BaseTest;
import com.luma.pages.LoginPage;
import com.luma.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test
    public void shouldBeAbleToBuyProduct() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());

        Boolean isMessageDisplayed = loginPage
                .load()
                .login("test111@example.com","Test@1234?")
                .chooseSection()
                .isMessageDisabled();

        Assert.assertTrue(isMessageDisplayed);

        Thread.sleep(6000);
    }

    @Test (enabled = false)
    public void shouldBeAbleToDeleteProduct() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());

        ProductPage productPage = new ProductPage(getDriver());

        loginPage.load();
        loginPage.loginToHome();
        productPage.chooseSection();
        Thread.sleep(4000);
        productPage.deleteProductFromCart();

        Thread.sleep(6000);
    }


    @Test
    public void shouldBeAbleToAddProductToTheCart() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());

        Boolean isMessageDisplayed = loginPage
                .load()
                .login("test111@example.com","Test@1234?")
                .chooseSection()
                .isMessageDisabled();

        Assert.assertTrue(isMessageDisplayed);

        Thread.sleep(6000);
    }
}
