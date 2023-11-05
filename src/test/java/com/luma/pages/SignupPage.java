package com.luma.pages;

import com.luma.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "/html/body/div[1]/header/div[1]/div/ul/li[3]/a") private WebElement createAccount;

    @FindBy (id = "firstname") private WebElement firstName;

    @FindBy (id = "lastname") private WebElement lastname;

    @FindBy (id = "email_address") private WebElement email_address;

    @FindBy (id = "password") private WebElement password;

    @FindBy (id = "password-confirmation") private WebElement confirmPassword;

    @FindBy (xpath = "//*[@id=\"form-validate\"]/div/div[1]/button") private WebElement btn_CreateAccount;
    public void load(){
        driver.get("https://magento.softwaretestingboard.com/");
    }

    public void signUp() throws InterruptedException {
        createAccount.click();

        Thread.sleep(2000);
        firstName.sendKeys("some");
        lastname.sendKeys("one");
        email_address.sendKeys("someone@example");
        password.sendKeys("some");
        confirmPassword.sendKeys("someone");

    }
}
