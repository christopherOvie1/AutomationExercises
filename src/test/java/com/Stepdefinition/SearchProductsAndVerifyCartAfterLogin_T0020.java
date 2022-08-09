package com.Stepdefinition;

import com.pages.HomePage;
import com.pages.NavigationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductsAndVerifyCartAfterLogin_T0020 extends BaseClass{

    @Test
    public void searchProductsAndVerifyCartAfterLogin_T0020(){

        HomePage homePage = new HomePage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        //1 &2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);


        //3  Verify that home page is visible successfully
        System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

//4 & 5Verify user is navigated to ALL PRODUCTS page successfully

        navigation.NavigateTo("Products");

    }
}
