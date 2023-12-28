package com.luma.pages;

import com.luma.base.BasePage;
import com.luma.base.BaseUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a") private  WebElement singInButton;

    @FindBy(className = "showcart") private  WebElement showCart;

    @FindBy(id = "top-cart-btn-checkout") private  WebElement checkOutTheCart;

    public ProductPage load(){
        driver.get("https://magento.softwaretestingboard.com/");

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


    public void choosingRandomProductFromTheList() throws InterruptedException {


        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");


        WebElement container = driver.findElement(By.className("products wrapper grid products-grid"));
        List<WebElement> listItems = container.findElements(By.className("product-item-link"));

        for(WebElement item : listItems)
            System.out.println("Item : " + item.getText());


//        List<WebElement> ProductSize = driver.findElements(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[2]/div[1]/div"));
//        for(WebElement chooseProductSize : ProductSize)
//            System.out.println("/n" + chooseProductSize.getText() + ",,," + "--------------------------------");
////
//        List<WebElement> ProductColor = driver.findElements(By.className("swatch-option color"));
//        for(WebElement chooseProductColor : ProductColor)
//            System.out.println(chooseProductColor.getText() + ",,,");
    }

    public void chooseSectionRandomly() throws InterruptedException{
        Actions actions = new Actions(driver);
        Random random = new Random();

        //Store the First List ID's in an array
        WebElement[] productList = {
                driver.findElement(By.id("ui-id-3")),
                driver.findElement(By.id("ui-id-4")),
                driver.findElement(By.id("ui-id-5")),
                driver.findElement(By.id("ui-id-6")),
                driver.findElement(By.id("ui-id-7")),
                driver.findElement(By.id("ui-id-8")),
        };


        //Generate a random index to choose an option between First 6 Options
        int randomIndex = random.nextInt(productList.length);
        WebElement selectProduct = productList[randomIndex];
        System.out.println(selectProduct.getText());
        String selectedProduct = selectProduct.getText();

        actions.moveToElement(selectProduct).perform();
        Thread.sleep(7000);

//        switch (selectedProduct){
//            case "What's New" :
//            case "Training" :
//            case "Sale" :
//                selectProduct.click();
//                break;
//
//            case "Woman":
//                WebElement[] womanProductList = {
//                        driver.findElement(By.id("ui-id-9")),
//                        driver.findElement(By.id("ui-id-10"))
//                };
//
//                int randomIndex_FromWomanList = random.nextInt(womanProductList.length);
//                WebElement chooseFrom_WomanList = womanProductList[randomIndex_FromWomanList];
//
//                String selectedWomanType = chooseFrom_WomanList.getText();
//                actions.moveToElement(chooseFrom_WomanList).perform();
//                Thread.sleep(5000);
//
//                if(selectedWomanType.equals("Tops")) {
//                    WebElement[] womanTopsList = {
//                            driver.findElement(By.id("ui-id-11")),
//                            driver.findElement(By.id("ui-id-12")),
//                            driver.findElement(By.id("ui-id-13")),
//                            driver.findElement(By.id("ui-id-14"))
//                    };
//
//                    int randomIndex_womanTops = random.nextInt(womanTopsList.length);
//                    WebElement chooseFrom_WomanTopsList = womanTopsList[randomIndex_womanTops];
//
//                    Thread.sleep(3000);
//                    actions.moveToElement(chooseFrom_WomanTopsList).perform();
//                    chooseFrom_WomanTopsList.click();
//
//                }
//                else if (selectedWomanType.equals("Bottoms")){
//                    WebElement[] womanBottomsList = {
//                            driver.findElement(By.id("ui-id-15")),
//                            driver.findElement(By.id("ui-id-16"))
//                    };
//
//                    int randomIndex_womanBottoms = random.nextInt(womanBottomsList.length);
//                    WebElement chooseFrom_WomanBottomsList = womanBottomsList[randomIndex_womanBottoms];
//
//                    Thread.sleep(3000);
//                    actions.moveToElement(chooseFrom_WomanBottomsList).perform();
//                    chooseFrom_WomanBottomsList.click();
//                }
//                else {
//                    System.out.println("SOMETHING WRONG !!!");
//                }
//                break;
//
//            case "Men" :
//                WebElement[] menList ={
//                        driver.findElement(By.id("ui-id-17")),
//                        driver.findElement(By.id("ui-id-18"))
//                };
//
////            for(WebElement element : menList)
////                System.out.println("Element : " +  element.getText());
//
//                int randomIndex_FromMenList = random.nextInt(menList.length);
//                WebElement chooseFrom_MenList = menList[randomIndex_FromMenList];
//
//                String selectedMenType = chooseFrom_MenList.getText();
//                actions.moveToElement(chooseFrom_MenList).perform();
//                Thread.sleep(5000);
//
//                if(selectedMenType.equals("Tops")){
//                    WebElement[] menTopsList = {
//                            driver.findElement(By.id("ui-id-19")),
//                            driver.findElement(By.id("ui-id-20")),
//                            driver.findElement(By.id("ui-id-21")),
//                            driver.findElement(By.id("ui-id-22")),
//                    };
//
//                    int randomIndex_FromMenTops = random.nextInt(menList.length);
//                    WebElement chooseFrom_MenTopsList = menTopsList[randomIndex_FromMenTops];
//
//                    actions.moveToElement(chooseFrom_MenTopsList).perform();
//                    Thread.sleep(1000);
//                    chooseFrom_MenTopsList.click();
//                    Thread.sleep(4000);
//
//                }
//                else if(selectedMenType.equals("Bottoms")) {
//
//                    WebElement[] menBottomsList = {
//                            driver.findElement(By.id("ui-id-23")),
//                            driver.findElement(By.id("ui-id-24"))
//                    };
//
//                    int randomIndex_MenBottoms = random.nextInt(menBottomsList.length);
//                    WebElement chooseFrom_MenBottomsList = menBottomsList[randomIndex_MenBottoms];
//
//
//                    actions.moveToElement(chooseFrom_MenBottomsList).perform();
//                    Thread.sleep(1000);
//                    chooseFrom_MenBottomsList.click();
//                    Thread.sleep(4000);
//                }
//                else {
//                    System.out.println("Something WRONG");
//                }
//                break;
//
//            case "Gear" :
//                WebElement[] gearList = {
//                        driver.findElement(By.id("ui-id-25")),
//                        driver.findElement(By.id("ui-id-26")),
//                        driver.findElement(By.id("ui-id-27"))
//                };
//
//                int randomIndex_gear = random.nextInt(gearList.length);
//                WebElement chooseFrom_GearList = gearList[randomIndex_gear];
//
//                actions.moveToElement(chooseFrom_GearList).perform();
//                chooseFrom_GearList.click();
//                Thread.sleep(4000);
//                break;
//
//            default:
//                System.out.println("Please Try Again Later");
//        }

        if(selectedProduct.equals("What's New") || selectedProduct.equals("Training") || selectedProduct.equals("Sale")){
            selectProduct.click();
        }

        else if (selectedProduct.equals("Woman")){
            WebElement[] womanProductList = {
                    driver.findElement(By.id("ui-id-9")),
                    driver.findElement(By.id("ui-id-10"))
            };

            int randomIndex_FromWomanList = random.nextInt(womanProductList.length);
            WebElement chooseFrom_WomanList = womanProductList[randomIndex_FromWomanList];

            String selectedWomanType = chooseFrom_WomanList.getText();
            actions.moveToElement(chooseFrom_WomanList).perform();
            Thread.sleep(5000);

            if(selectedWomanType.equals("Tops")) {
                WebElement[] womanTopsList = {
                        driver.findElement(By.id("ui-id-11")),
                        driver.findElement(By.id("ui-id-12")),
                        driver.findElement(By.id("ui-id-13")),
                        driver.findElement(By.id("ui-id-14"))
                };

                int randomIndex_womanTops = random.nextInt(womanTopsList.length);
                WebElement chooseFrom_WomanTopsList = womanTopsList[randomIndex_womanTops];

                Thread.sleep(3000);
                actions.moveToElement(chooseFrom_WomanTopsList).perform();
                chooseFrom_WomanTopsList.click();

            }
            else if (selectedWomanType.equals("Bottoms")){
                WebElement[] womanBottomsList = {
                        driver.findElement(By.id("ui-id-15")),
                        driver.findElement(By.id("ui-id-16"))
                };

                int randomIndex_womanBottoms = random.nextInt(womanBottomsList.length);
                WebElement chooseFrom_WomanBottomsList = womanBottomsList[randomIndex_womanBottoms];

                Thread.sleep(3000);
                actions.moveToElement(chooseFrom_WomanBottomsList).perform();
                chooseFrom_WomanBottomsList.click();
            }
            else {
                System.out.println("SOMETHING WRONG !!!");
            }

            choosingRandomProductFromTheList();

        }

        else if (selectedProduct.equals("Men")){

            WebElement[] menList ={
                    driver.findElement(By.id("ui-id-17")),
                    driver.findElement(By.id("ui-id-18"))
            };

//            for(WebElement element : menList)
//                System.out.println("Element : " +  element.getText());

            int randomIndex_FromMenList = random.nextInt(menList.length);
            WebElement chooseFrom_MenList = menList[randomIndex_FromMenList];

            String selectedMenType = chooseFrom_MenList.getText();
            actions.moveToElement(chooseFrom_MenList).perform();
            Thread.sleep(5000);

            if(selectedMenType.equals("Tops")){
                WebElement[] menTopsList = {
                        driver.findElement(By.id("ui-id-19")),
                        driver.findElement(By.id("ui-id-20")),
                        driver.findElement(By.id("ui-id-21")),
                        driver.findElement(By.id("ui-id-22")),
                };

                int randomIndex_FromMenTops = random.nextInt(menTopsList.length);
                WebElement chooseFrom_MenTopsList = menTopsList[randomIndex_FromMenTops];

                actions.moveToElement(chooseFrom_MenTopsList).perform();
                Thread.sleep(1000);
                chooseFrom_MenTopsList.click();
                Thread.sleep(4000);

            }
            else if(selectedMenType.equals("Bottoms")) {

                WebElement[] menBottomsList = {
                        driver.findElement(By.id("ui-id-23")),
                        driver.findElement(By.id("ui-id-24"))
                };

                int randomIndex_MenBottoms = random.nextInt(menBottomsList.length);
                WebElement chooseFrom_MenBottomsList = menBottomsList[randomIndex_MenBottoms];


                actions.moveToElement(chooseFrom_MenBottomsList).perform();
                Thread.sleep(1000);
                chooseFrom_MenBottomsList.click();
                Thread.sleep(4000);
            }
            else {
                System.out.println("Something WRONG");
            }

            choosingRandomProductFromTheList();
        }

        else if (selectedProduct.equals("Gear")){

            WebElement[] gearList = {
                    driver.findElement(By.id("ui-id-25")),
                    driver.findElement(By.id("ui-id-26")),
                    driver.findElement(By.id("ui-id-27"))
            };

            int randomIndex_gear = random.nextInt(gearList.length);
            WebElement chooseFrom_GearList = gearList[randomIndex_gear];

            actions.moveToElement(chooseFrom_GearList).perform();
            chooseFrom_GearList.click();
            Thread.sleep(3000);

            choosingRandomProductFromTheList();
        }

        else {
            System.out.println("Please Try Again Later");
        }
    }

    public void chooseSectionRandomly_SimpleWay() throws InterruptedException{
        Actions actions = new Actions(driver);
        Random random = new Random();

        //Store 3 ID's of the website options (Woman , Men , Gear) in a list to choose a random option
        WebElement[] productList = {
                driver.findElement(By.id("ui-id-4")),
                driver.findElement(By.id("ui-id-5")),
                driver.findElement(By.id("ui-id-6"))
        };

        //Generate a random index to choose an random option from productList
        int randomIndex = random.nextInt(productList.length);
        WebElement selectOption = productList[randomIndex];
        System.out.println(selectOption.getText());
        String selectedOption = selectOption.getText();

        selectOption.click();
        Thread.sleep(3000);

        //Here I'm checking if selected option is Gear || Men || Woman
        if(selectedOption.equals("Gear")){
            //I used try & catch to handling errors if the condition is not met OR the driver didn't find the element
            try {

                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                //Store every tag have a className(item) to choose a randomlly Option from this List
                WebElement options = driver.findElement(By.id("narrow-by-list2"));
                List<WebElement> gearOption = options.findElements(By.className("item"));

                int randomIndexFromGear = random.nextInt(gearOption.size());
                WebElement selectedProductFromGear = gearOption.get(randomIndexFromGear);
                System.out.println(selectedProductFromGear.getText());
                selectedProductFromGear.click();

                try {
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    WebElement container =  driver.findElement(By.className("product-items"));
                    List<WebElement> myItem = container.findElements(By.tagName("li"));

                    int randomItem = random.nextInt(myItem.size());
                    WebElement addedItem = myItem.get(randomItem);
                    actions.moveToElement(addedItem).perform();

                    Thread.sleep(5000);
                    WebElement addToCart = container.findElement(By.className("tocart"));

//                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    Thread.sleep(3000);
                    addToCart.click();


                } catch (NoSuchElementException e){
                    System.out.println("Element Not Found" + e.getMessage());
                }
            } catch (NoSuchElementException e){
                System.out.println("Element Not Found" + e.getMessage());
            }

            //After I finished and chose the product I clicked on the show card button and check if I added it correctly
            Thread.sleep(5000);
            showCart.click();
            Thread.sleep(3000);
            checkOutTheCart.click();
            /** -------------------------------------------------------------------------------------------*/
        } else {

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            try {
                WebElement option = driver.findElement(By.className("categories-menu"));
                List<WebElement> menOrWomanOption = option.findElements(By.tagName("a"));


                int randomIndexFormMenOrWoman = random.nextInt((menOrWomanOption.size()));
                System.out.println(randomIndexFormMenOrWoman);
                WebElement selectedProductFromMenOrWoman = menOrWomanOption.get(randomIndexFormMenOrWoman);
                System.out.println(selectedProductFromMenOrWoman.getText());
                selectedProductFromMenOrWoman.click();
                Thread.sleep(5000);

                try {
                    WebElement container = driver.findElement(By.className("products-grid"));
                    List <WebElement> item = container.findElements(By.className("product-item"));
                    int randomItem = random.nextInt(item.size());

                    WebElement addedItem = item.get(randomItem);

                    actions.moveToElement(addedItem).perform();

                    WebElement sizeContainer = container.findElement(By.className("size"));
                    //Select a random size from Men or Woman Product
                    List <WebElement> productSize = sizeContainer.findElements(By.className("text"));
                    productSize.get(random.nextInt(productSize.size())).click();

                    /** -----------------------------------*/

                    WebElement colorContainer = container.findElement(By.className("color"));
                    //Select a random color from Men or Woman Product
                    List <WebElement> productColor = colorContainer.findElements(By.className("color"));
                    productColor.get(random.nextInt(productColor.size())).click();

                    //Click on AddToCart button
                    WebElement addToCart = container.findElement(By.className("tocart"));
                    addToCart.click();

                } catch (NoSuchElementException e){
                    System.out.println("Element Not Found" + e.getMessage());
                }

            } catch (NoSuchElementException e){
                System.out.println("Element Not Found" + e.getMessage());
            }
        }

        Thread.sleep(5000);
        showCart.click();
        Thread.sleep(3000);
        checkOutTheCart.click();
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

        try{
            Thread.sleep(2000);
            String user = singInButton.getText();
//            String actualUser = userName.getText();

            if (user.equals("test test!"))
                return userName.getText();
            else
                return "Test Completed successfully";
        } catch (InterruptedException e){
            return "InterruptedException occurred";
        }
    }

    public boolean isMessageDisabled(){
        return addedProductMessageDisabled.isDisplayed();
    }
}
