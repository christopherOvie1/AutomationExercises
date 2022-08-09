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
    LoginPage loginPage = new LoginPage(driver);
    CartPage cart =new CartPage(driver);


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

    product.selectFirstContinueShopping();

    //7 Hover over second product and click 'Add to cart'
    product.selectSecondAddtToCartButton();

    //8. Click 'View Cart' button
    product.clickViewCart();
   // product.selectSecondContinueShoppingButton();


    //9. Verify both products are added to Cart

     Assert.assertTrue(cart.verifyBothProductsAreAddedToCart(),"product added is not found");

     //10. Verify their prices, quantity and total price

    //product price   td[class='cart_price']

    //product quantity  td[class='cart_quantity']
    //product total price  p[class='cart_total_price']
    }
}
