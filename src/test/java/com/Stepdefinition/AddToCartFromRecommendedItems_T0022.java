package com.Stepdefinition;

import com.pages.*;
import org.apache.commons.compress.utils.OsgiUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartFromRecommendedItems_T0022 extends BaseClass{

    @Test
    public void addToCartFromRecommendedItems(){
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

        //4. Scroll down to footer
        homePage.ScrollDownToFooter();
      productDetails.validateRECOMMENDEDITEMSAreVisible("recommended items");
        System.out.println(productDetails.validateRECOMMENDEDITEMSAreVisible("recommended items"));


    }
}
