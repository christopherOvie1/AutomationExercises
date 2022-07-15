package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

    public static WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);}


    @FindBy(css="div[class='single-products']")
    WebElement searchedProduct;

    @FindBy(css="div[class='product-information']>h2")
    WebElement productName;

    @FindBy(css="div[class='product-information']>p")
    WebElement productCategory;

    @FindBy(css="span > span")
    WebElement productPrice;

    @FindBy(xpath="//p[contains(.,'Availability: In Stock')]")
    WebElement productAvailability;
////*[contains(text(),'(New)')]
   // @FindBy(xpath="//div[2]/div/p[3]/text()")

     @FindBy(xpath="//p[contains(.,'Condition: New')]")
    WebElement productCondition;

    @FindBy(xpath="//p[contains(.,'Brand: Polo')]")
    WebElement productBrand;


    public void isProductDetailsVisible(){
        productName.isDisplayed();
       // String productNam =  productName.getText();
        //System.out.println(productNam);
        System.out.println(productName.getText());

        productCategory.isDisplayed();
        System.out.println(productCategory.getText());

      productPrice.isDisplayed();
        System.out.println(productPrice.getText());

       productAvailability.isDisplayed();
        System.out.println(productAvailability.getText());

         productCondition.isDisplayed();
        System.out.println(productCondition.getText());

        productBrand.isDisplayed();
        System.out.println(productBrand.getText());
    }

public boolean VerifySEARCHEDPRODUCTSisVisible(){
      return   searchedProduct.isDisplayed();
}


}
