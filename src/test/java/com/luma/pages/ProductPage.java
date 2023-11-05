package com.luma.pages;

import com.luma.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@id=\"ui-id-4\"]/span[2]") private WebElement women;

    @FindBy (xpath = "//*[@id=\"ui-id-9\"]") private WebElement womenTops;

    @FindBy (xpath = "//*[@id=\"ui-id-2\"]/li[2]/ul/li[1]/ul/li[1]") private WebElement womenJackets;

    @FindBy (xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img") private WebElement productImg;

    @FindBy (xpath = "//*[@id=\"product-addtocart-button\"]") private WebElement btn_AddProduct;

    @FindBy (xpath = "//*[@id=\"option-label-size-143-item-167\"]") private WebElement productSize;

    @FindBy (xpath = "//*[@id=\"option-label-color-93-item-49\"]") private WebElement productColor;

    @FindBy (xpath = "/html/body/div[1]/header/div[2]/div[1]/a") private WebElement openCart;

    @FindBy (xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a") private WebElement viewAndEditCart;

    @FindBy (xpath = "//*[@id=\"shopping-cart-table\"]/tbody/tr[2]/td/div/a[3]") private WebElement deleteProduct;

    @FindBy (xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[2]/a") private WebElement backToHome;

    @FindBy(className = "logged-in") private WebElement userName ;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div") private WebElement addedProductMessageDisabled;

    public ProductPage load(){
        driver.get("https://magento.softwaretestingboard.com/" + "women/tops-women/jackets-women.html");
        return this;
    }

    public ProductPage chooseSection() throws InterruptedException{
        Actions actions = new Actions(driver);

        Thread.sleep(2000);
        actions.moveToElement(women).perform();
        Thread.sleep(2000);
        actions.moveToElement(womenTops).perform();
        Thread.sleep(2000);

        womenJackets.click();

        //Create an instance of javascript Executor interface
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Scroll down by a specified number of pixels
        js.executeScript("window.scrollBy(0,200)");


        productImg.click();
        Thread.sleep(2000);
        productSize.click();
        Thread.sleep(2000);
        productColor.click();
        Thread.sleep(2000);
        btn_AddProduct.click();

        System.out.println("Thank You , The product added successfully");

        Thread.sleep(6000);
        return this;
    }

    public void chooseSectionRandomly() throws InterruptedException{

        //saved a "DIV Tag" that have a Ul list
        WebElement container = driver.findElement(By.id("store.menu"));
        System.out.println(container);

        //Get Li tag from Ul list and saved it in a List<WebElement>
        List<WebElement> mainMenu = container.findElements(By.tagName("li"));
        List<WebElement> mainMenu2 = container.findElements(By.id("level0"));

        System.out.println("mainMenu2 : " + mainMenu);
        System.out.println("mainMenu2 : " + mainMenu2);

        //generate a random number
        int randomIndex = (int) (Math.random() * mainMenu.size());
        System.out.println(randomIndex);

        //Get a random choose from ul list
        WebElement nestedMenu = mainMenu.get(1);
        nestedMenu.click();
//        System.out.println(nestedMenu);


        /**        Select select = new Select(mainMenu);
//        System.out.println(select.getOptions().size());


//        int dropDownValues = driver.findElements(By.cssSelector("ui-id-2")).size();
//        System.out.println(mainMenu.getSize());

//        Random random = new Random();
//        int index = random.nextInt(dropDownValues);

//        select.selectByIndex(index);

//        Thread.sleep(5000);*/

        /**Actions actions = new Actions(driver);
//
//        Thread.sleep(4000);
//        actions.moveToElement(women).perform();
//        Thread.sleep(4000);
//        actions.moveToElement(womenTops).perform();
//        Thread.sleep(4000);
//
//        womenJackets.click();*/
    }

    public void deleteProductFromCart() throws InterruptedException {
        Thread.sleep(3000);
        openCart.click();
        Thread.sleep(4000);
        viewAndEditCart.click();
        Thread.sleep(3000);
        deleteProduct.click();
        Thread.sleep(6000);
        backToHome.click();


        System.out.println("Thank You , The product DELETED successfully");
    }

    public String getUserNameAppeared(){
        return userName.getText();

    }

    public boolean isMessageDisabled(){
        return addedProductMessageDisabled.isDisplayed();
    }
}
