package com.Stepdefinition;

import com.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProduct_T009 extends BaseClass{

    private Object itemsNeeded;

    @Test
    public void verifySearchProduct(){

        String nameOfProduct="Blue Top";
        String nameOfItem= "Winter Top";


        HomePage homePage = new HomePage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        ProductPage product = new ProductPage(driver);
        CommonPage common = new CommonPage(driver);
        ProductDetailsPage productDetails= new ProductDetailsPage(driver);

        //1 & 2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //3  Verify that home page is visible successfully
        System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //4  Click on 'Products' button
        navigation.NavigateTo("Products");

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        common.validatePageURL("products");

        //6 Enter product name in search input and click search button
       product.typeProductNameInSearchBar(nameOfProduct);

       //7  Verify 'SEARCHED PRODUCTS' is visible
        System.out.println(productDetails.VerifySEARCHEDPRODUCTSisVisible());
       Assert.assertTrue(productDetails.VerifySEARCHEDPRODUCTSisVisible());

       //8. Verify all the products related to search are visible
        productDetails.getAllSimilarProductNames();







    }
}
