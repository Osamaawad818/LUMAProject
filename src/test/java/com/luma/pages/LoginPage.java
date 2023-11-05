package com.luma.pages;

import com.luma.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a") private WebElement login;

    @FindBy(id = "email") private WebElement emailText;

    @FindBy(id = "pass") private WebElement passText;

    @FindBy(id = "send2") private WebElement btn_Login;

    @FindBy(xpath = "/html/body/div[1]/header/div[2]/a/img") private WebElement homePage;

    @FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/div[4]/div[2]/a") private WebElement forgetPassword;




    public LoginPage load(){
        driver.get("https://magento.softwaretestingboard.com/");
        return this;
    }

    public ProductPage login(String email , String password) throws InterruptedException {
        Thread.sleep(15000);
        login.click();
        Thread.sleep(8000);
        emailText.sendKeys(email);
        Thread.sleep(8000);
        passText.sendKeys(password);
        Thread.sleep(2000);

        btn_Login.click();
        Thread.sleep(6000);

//        homePage.click();
        return new ProductPage(driver);

    }

    public void loginToHome() throws InterruptedException {
        login.click();
        Thread.sleep(2000);
        emailText.sendKeys("test111@example.com");
        Thread.sleep(2000);
        passText.sendKeys("Test@1234?");
        Thread.sleep(2000);

        btn_Login.click();

        homePage.click();
    }

    public void forgetPassword(){

    }

}

