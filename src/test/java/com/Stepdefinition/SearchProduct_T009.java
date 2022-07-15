package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProduct_T009 extends BaseClass{

    @Test
    public void verifySearchProduct(){

        String nameOfProduct="Blue Top";

        HomePage homePage = new HomePage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        ContactUsPage contactUs = new ContactUsPage(driver);
        ProductPage product = new ProductPage(driver);
        ProductDetailsPage productDetails= new ProductDetailsPage(driver);

        //1 &2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);


        //3  Verify that home page is visible successfully
        System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //4 & 5Verify user is navigated to ALL PRODUCTS page successfully
        navigation.NavigateTo("Products");

        //6 Enter product name in search input and click search button
        product.typeProductNameInSearchBar(nameOfProduct);

        //7  Verify 'SEARCHED PRODUCTS' is visible
        System.out.println(productDetails.VerifySEARCHEDPRODUCTSisVisible());
        Assert.assertTrue(productDetails.VerifySEARCHEDPRODUCTSisVisible());



    }
}
