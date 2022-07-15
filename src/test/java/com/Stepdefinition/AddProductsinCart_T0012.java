package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductsinCart_T0012 extends BaseClass{

  @Test
    public void addProductsinCart() throws InterruptedException {
      HomePage homePage = new HomePage(driver);
      NavigationPage navigation = new NavigationPage(driver);
      ContactUsPage contactUs = new ContactUsPage(driver);
      ProductPage product = new ProductPage(driver);



      //1  Navigate to url 'http://automationexercise.com'
      driver.get(baseURL);

      //2  Verify that home page is visible successfully
      System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
      Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

      //4 Verify user is navigated to ALL PRODUCTS page successfully
      navigation.NavigateTo("Products");

     // Hover over first product and click 'Add to cart'
    product.selectFirstAddtToCartButton();
    //6  Click 'Continue Shopping' button
    Thread.sleep(5000);
    product.selectFirstContinueShopping();

    //7 Hover over second product and click 'Add to cart'
  Thread.sleep(5000);
    product.selectSecondAddtToCartButton();
    product.clickViewCart();
   // product.selectSecondContinueShoppingButton();
    }
}
