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


        //4  . Click on 'Products' button
        navigation.NavigateTo("Products");

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        common.validatePageURL("products");


        //verify products
       product.getAllProductNames();


        //7 Click on 'View Product' of first product
        product.selectFirstProduct();

        //8. User is landed to product detail page
      common.validatePageURL("product_details/1");

//9 Verify that  detail is visible: product name, category, price, availability, condition, brand
        productDetails.verifyThatProductDetailIsVisibleProductNameCategoryPriceAvailabilityConditionBrand();

    }

}