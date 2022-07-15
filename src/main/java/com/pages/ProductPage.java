package com.pages;

import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
////div[class='productinfo text-center'] a[data-product-id='2']

    @FindBy(xpath = "//h2[contains(.,'All Products')]")
    WebElement allProductsText;

    @FindBy(css = "div[class='productinfo text-center'] a[data-product-id='2']")
    WebElement secondAddToCartButton;

    @FindBy(css = ".btn-success")
    WebElement secondContinueShoppinButton;

    @FindBy(css = "p[class='text-center'] > a")
    WebElement viewCart;

    //p[class='text-center'] > a

    @FindBy(css ="input[id='search_product']")
    WebElement productSearchBar;

 //The products list is visible
    public  void getAllProductNames() {

       // List<WebElement> allMenus = driver.findElements(By.cssSelector("div[class='productinfo text-center'] p"));
        List<WebElement> allMenus = driver.findElements(By.cssSelector("div[class='productinfo text-center'] p"));

        // Printing all app names Without stream
        for (WebElement menu : allMenus) {
           // System.out.println(menu.getText());
            menu.getText();
        }
    }
    public  void selectFirstProduct(){

        List<WebElement> allMenus = driver.findElements(By.cssSelector("a[href*='product_details']"));
        allMenus.get(0).click();
       }

    public  void selectFirstAddtToCartButton(){

        List<WebElement> addToCartButton = driver.findElements(By.cssSelector("a[class*='btn-default add-to-cart']"));
        addToCartButton.get(0).click();
    }
    public  void selectFirstContinueShopping(){

        List<WebElement> allContinueButton = driver.findElements(By.xpath("//button[contains(.,'Continue Shopping')]"));
        allContinueButton.get(0).click();
    }
    public  void selectSecondAddtToCartButton(){

        //List<WebElement> addToCartButton1 = driver.findElements(By.cssSelector("a[class*='btn-default add-to-cart']"));
       // addToCartButton1.get(1).click();
        secondAddToCartButton.click();
    }


   public  void selectSecondContinueShoppingButton(){

       // List<WebElement> allContinueButton2 = driver.findElements(By.xpath("//button[contains(.,'Continue Shopping')]"));
      //  allContinueButton2.get(1).click();
       secondContinueShoppinButton.click();
    }

    public void clickViewCart(){
        viewCart.click();
    }

  public void typeProductNameInSearchBar(String nameOfProduct){
      productSearchBar.sendKeys(nameOfProduct);
  }



    }

