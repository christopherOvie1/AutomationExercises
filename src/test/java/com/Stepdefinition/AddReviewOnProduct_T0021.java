package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddReviewOnProduct_T0021 extends BaseClass{

    @Test
    public void searchProductsAndVerifyCartAfterLogin_T0020(){

        HomePage homePage = new HomePage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        CommonPage common = new CommonPage(driver);
        ProductPage product = new ProductPage(driver);
        ProductDetailsPage productDetails= new ProductDetailsPage(driver);


        //1 &2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);


        //3  Verify that home page is visible successfully
        System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

//4 & 5Verify user is navigated to ALL PRODUCTS page successfully

        navigation.NavigateTo("Products");

        //4. Verify user is navigated to ALL PRODUCTS page successfully
        common.validateURL("products");

        product.clickViewProductButton();
     String actualText=   productDetails.verifyWriteYourReviewText();
        String expectedText="WRITE YOUR REVIEW";
        Assert.assertEquals(actualText,expectedText,"actual text does not match expected text");
        System.out.println(productDetails.verifyWriteYourReviewText());

        productDetails.EnterNameEmailAndReview("chris","abc@test.com","ready");



    }
}
