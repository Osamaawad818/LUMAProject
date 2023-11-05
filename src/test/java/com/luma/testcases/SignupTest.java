package com.luma.testcases;

import com.luma.base.BaseTest;
import com.luma.pages.SignupPage;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

    @Test(enabled = false)
    public void shouldBeAbleToSignUpSuccessfully() throws InterruptedException {

        SignupPage signupPage = new SignupPage(getDriver());

        signupPage.load();
        signupPage.signUp();

        Thread.sleep(4000);

    }
}
