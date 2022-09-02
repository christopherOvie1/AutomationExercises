package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductsAndVerifyCartAfterLogin_T0020 extends BaseClass{

    @Test
    public void searchProductsAndVerifyCartAfterLogin_T0020(){

        String nameOfProduct="Blue Top";
        String brand1  = "Polo", brand2 = "H&M";

        HomePage homePage = new HomePage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        ProductPage product = new ProductPage(driver);
        ProductDetailsPage productDetails= new ProductDetailsPage(driver);
        CommonPage common = new CommonPage(driver);


        //1 & 2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //3. Click on 'Products' button
        navigation.NavigateTo("Products");

        //4. Verify user is navigated to ALL PRODUCTS page successfully
        boolean b=common.validatePageURL("products");
        System.out.println(b);
        Assert.assertTrue(common.validatePageURL("products"));

        //5. Enter product name in search input and click search button
        product.typeProductNameInSearchBar(nameOfProduct);

        //6. Verify that user is navigated to brand page and brand products are displayed
       /* common.validatePageURL("Top");

        //7. On left side bar, click on any other brand link

        homePage.clickOnAnyBrandName(brand1);

        //8. Verify that user is navigated to that brand page and can see products
        Assert.assertTrue(common.validatePageURL(brand1));*/



    }
}
