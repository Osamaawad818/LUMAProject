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


    /** Code Workflow - add Product -:
     Open the website. (Load function)
     Randomly select an item from the navigation bar ("Woman," "Men," "Gear").

     Hover over on the product then RANDOMLY choose the products, sizes, and colors
     then finally add the selected products to the shopping cart.
     This process is repeated 4 times on the website.*/

    @Test (invocationCount = 4)
    public void shouldBeAbleToAddProductToTheCart() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());

//        Boolean isMessageDisplayed = loginPage
//                .load()
//                .login("test111@example.com","Test@1234?")
//                .chooseSection()
//                .isMessageDisabled();
//
//        Assert.assertTrue(isMessageDisplayed);

        Thread.sleep(3000);
        ProductPage productPage = new ProductPage(getDriver());
        productPage.load();
        productPage.chooseSectionRandomly_SimpleWay();

        Thread.sleep(6000);
    }
}
