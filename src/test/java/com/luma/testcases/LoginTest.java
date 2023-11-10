package com.luma.testcases;

import com.luma.base.BaseTest;
import com.luma.pages.LoginPage;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Description("the user should be able to login to Luma website successfully")
    @Test (description = "Test the login functionality when we using an valid email and password")
    public void shouldBeAbleToLoginToLumaSuccessfully() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());

        String actualResult = loginPage
                .load()
                .login("test111@example.com" , "Test@1234?")
                .getUserNameAppeared();

        Assert.assertEquals(actualResult , "Welcome, test test!");
        System.out.println("actualResult : " + actualResult);

        Thread.sleep(5000);
    }

    @Description("should not Be Able To Login With Invalid Email and Valid Password")
    @Test (description = "Test the login functionality when we using an Invalid Email and Valid Password" )
    public void shouldNotBeAbleToLoginWithInvalidEmailAndValidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .load()
                .login("test111@example.coom" , "Test@1234?")
                .getUserNameAppeared();

//        Assert.assertEquals(actualResult , "Something wrong");

        Thread.sleep(5000);
    }


    @Description("should Not Be Able To Login With Valid Email and Invalid Password")
    @Test (description = "Test the login functionality when we using an Valid Email and Invalid Password", enabled = false)
    public void shouldNotBeAbleToLoginWithValidEmailAndInvalidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .load()
                .login("test111@example.com" , "Test1234")
                .getUserNameAppeared();

        Thread.sleep(5000);
    }


    @Description("should Not Be Able To Login With InValid Email and Invalid Password")
    @Test (description = "Test the login functionality when we using an InValid Email and Invalid Password" , enabled = false)
    public void shouldNotBeAbleToLoginWithInvalidEmailAndInvalidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        String actualResult = loginPage
                .load()
                .login("test111@example.ccom" , "Test1234")
                .getUserNameAppeared();

        Thread.sleep(5000);
    }


    @Description("Verify The Login When The Field Is Blank and Submit Button Is Clicked")
    @Test (description = "Test the login functionality when The Field Is Blank and Submit Button Is Clicked" , enabled = false)
    public void VerifyTheLoginWhenTheFieldIsBlankAndSubmitButtonIsClicked() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        String actualResult = loginPage
                .load()
                .login("" , "")
                .getUserNameAppeared();

        Thread.sleep(5000);
    }

















//    @Test (description = "Test the login functionality when we using an valid email and password")
//    public void LoginToLumaSuccessfully() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(getDriver());
//
//        loginPage.load();
//        loginPage.login("test111@example.com" , "Test@1234?");
//
//
//        Thread.sleep(5000);
//    }
}
