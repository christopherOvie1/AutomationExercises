package com.Stepdefinition;

import com.pages.HomePage;
import com.pages.NavigationPage;
import com.pages.ProductDetailsPage;
import com.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ViewCartBrandProducts_T0019 extends BaseClass{


   @Test
    public void viewCartBrandProducts() {

       HomePage homePage = new HomePage(driver);
       NavigationPage navigation = new NavigationPage(driver);
       ProductPage product = new ProductPage(driver);
       ProductDetailsPage productDetails= new ProductDetailsPage(driver);

       //1  Navigate to url 'http://automationexercise.com'
       driver.get(baseURL);

       //2  Verify that home page is visible successfully
       System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
       Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());




   }
}
