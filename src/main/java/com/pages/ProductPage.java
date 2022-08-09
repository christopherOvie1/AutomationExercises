package com.pages;

import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
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

    @FindBy(css = ".product-image-wrapper > .choose > .nav.nav-justified.nav-pills  a")
    List<WebElement> viewProductButton;

//div[class='productinfo text-center'] p

    @FindBy(css ="input[id='search_product']")
    WebElement productSearchBar;

    @FindBy(css ="a[class*='add-to-cart']")
    WebElement productSearchBar1;

    @FindBy(css ="#quantity")
    WebElement quantityField;

    @FindBy(css ="div[class='productinfo text-center'] p")
     List<WebElement> viewProductBtn2;

    @FindBy(css ="div[class='productinfo text-center'] p")
    List<WebElement> viewProductBtn5;


    String itemsNeeded[]={"Blue Top","Men Tshirt","Sleeveless Dress","Stylish Dress","Winter Top"};

    //addItems();
    public   void addItems(WebDriver driver, String []itemsNeeded){

        int j=0;

        List<WebElement> products = driver.findElements(By.cssSelector("div[class='productinfo text-center'] p"));

        for(int i = 0;i < products.size();i++){
       List itemNeededList=  Arrays.asList(itemsNeeded);
       if(itemNeededList.contains(products)){
         j++;
           driver.findElements(By.cssSelector("")).get(i).click();
       }

if (j == itemsNeeded.length){
    break;
}

        }

    }

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
public void increaseQuantityToFour(){
   // quantityField.clear();
    //   quantityField.sendKeys("4");
    for(int i = 1;i<4;i++){
      //  quantityField.getAttribute("value");
        quantityField.sendKeys(Keys.ARROW_UP);
    }
}

    public  void selectFirstProduct(){

        List<WebElement> allMenus = driver.findElements(By.cssSelector("a[href*='product_details']"));
        allMenus.get(0).click();
       }

    public  void clickViewProductButton(){
       // List<WebElement> allViewProductButton = driver.findElements(By.cssSelector(" .product-image-wrapper > .choose > .nav.nav-justified.nav-pills  a"));
        List<WebElement> allViewProductButton = viewProductButton;
        allViewProductButton.get(0).click();
    }

    public  void selectFirstAddtToCartButton(){

        List<WebElement> addToCartButton = driver.findElements(By.cssSelector("a[class*='btn-default add-to-cart']"));
        addToCartButton.get(0).click();
    }
    public  void selectFirstContinueShopping(){

        List<WebElement> allContinueButton = driver.findElements(By.xpath("//button[contains(.,'Continue Shopping')]"));
        allContinueButton.get(0).click();
       // for(int i=0;i<allContinueButton.size();i++){
        //    allContinueButton.get(0).click();
       // }
    }
    public  void selectSecondAddtToCartButton(){

        //List<WebElement> addToCartButton1 = driver.findElements(By.cssSelector("a[class*='btn-default add-to-cart']"));
       // addToCartButton1.get(1).click();
        secondAddToCartButton.click();
    }
public void clickAnyxxxxx(){
       // int j =0;
    List<WebElement> allProductName=driver.findElements(By.cssSelector("div[class='productinfo text-center'] p"));
    //List<WebElement> allProductName =new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='productinfo text-center'] p")));
    for(int i=0;i<allProductName.size();i++){
     String name=   allProductName.get(i).getText();
     if(name.contains("Men Tshirt")){

        // driver.findElement(By.cssSelector(".choose > .nav.nav-justified.nav-pills  a")).click();
         driver.findElements(By.cssSelector(".choose > .nav.nav-justified.nav-pills  a")).get(i).click();
     }
     //j++;
        break;
    }
}
    public void clickParticularClothing(){
        List<WebElement> allViewProductButtons = viewProductButton;
        for(WebElement any: allViewProductButtons){
            if(any.getText().equalsIgnoreCase("Blue Top")){
                any.click();
                break;
            }
        }

    }
    //note
public void clickViewProductForAnyProductOnHomePage(String ele){
    List<WebElement> allViewProductButton = viewProductButton;
    //allViewProductButton.get(0).click();
  /*  if(allViewProductButton.contains(ele)){
        allViewProductButton.
        //driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-justified']/li")).get(i).click();
    }*
     */
   /* for(WebElement prod: allViewProductButton){
        if(allViewProductButton.contains(ele)){
            prod.click();
        }
    }*/

}
   /* public void clickViewProductForAnyProductOnHomePage5(String ele){
        List<WebElement> allViewProductButton = viewProductBtn5;
        driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-justified']/li")).get(i).click();
        //allViewProductButton.get(0).click();
  /*  if(allViewProductButton.contains(ele)){
        allViewProductButton.
    }*
     */
       /* for(WebElement prod: allViewProductButton){
            if(allViewProductButton.contains(ele)){
                prod.click();
            }
        }*/
   // }

/*public void ClickViewProductForAnyProductOnHomePage2(){
        for(int i =0;i< viewProductBtn2.size();i++){
            viewProductBtn2.get(i).getText();

        }

}*/
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

    public  void addProductToCart(){

        List<WebElement> addProductToCartButton = driver.findElements(By.cssSelector("a[class*='add-to-cart']"));
        addProductToCartButton.get(0).click();
    }
    public void addProductsToCart(){
        List<WebElement> product =new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[qa='product_name']>a")));
        System.out.println("prdoduct=" + product.size());
  for(int i =0;i<product.size();i++){
      String name = product.get(i).getText();
      System.out.println("NAME is" + name);
      if(name.contains("Cauliflower"))
      {
          driver.findElement(By.xpath("//div[@qa='product_name']//a[text()='" + name + "']/following::button[1]")).click();
      }

  }

    }

    }

