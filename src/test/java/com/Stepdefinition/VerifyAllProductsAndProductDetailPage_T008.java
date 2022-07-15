package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyAllProductsAndProductDetailPage_T008 extends BaseClass {

    @Test
    public void verifyAllProductsAndProductDetailPage() {
        HomePage homePage = new HomePage(driver);
        CommonPage common = new CommonPage(driver);
        ProductPage product = new ProductPage(driver);
        ProductDetailsPage productDetails= new ProductDetailsPage(driver);

        //1  Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //2  Verify that home page is visible successfully
        System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //3  Click on 'Products' button
        NavigationPage navigation = new NavigationPage(driver);

        //4 Verify user is navigated to ALL PRODUCTS page successfully
        navigation.NavigateTo("Products");
        common.validateURL("products");
        //verify products
       product.getAllProductNames();


        //6 Click on 'View Product' of first product
        product.selectFirstProduct();

//7Verify that  detail is visible: product name, category, price, availability, condition, brand
        productDetails.isProductDetailsVisible();


    }

}