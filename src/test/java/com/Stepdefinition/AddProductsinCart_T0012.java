package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductsinCart_T0012 extends BaseClass {

    @Test
    public void addProductsinCart() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);


        //1 & 2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //3 Verify that home page is visible successfully
        System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //4 Verify user is navigated to ALL PRODUCTS page successfully
        navigation.NavigateTo("Products");

        // 5 Hover over first product and click 'Add to cart'
        product.HoverOverFirstProductAndClickAddToCart();

        //6  Click 'Continue Shopping' button
        product.clickContinueShoppingButton();

        //7 Hover over second product and click 'Add to cart'
        product.HoverOverSecondProductAndClickAddToCart();

        //8. Click 'View Cart' button
        product.clickViewCart();



        //9. Verify both products are added to Cart
        Assert.assertTrue(cart.verifyBothProductsAreAddedToCart(), "product added is not found");

        //10. Verify their prices, quantity and total price

        //product price   td[class='cart_price']

        //product quantity  td[class='cart_quantity']
        //product total price  p[class='cart_total_price']
    }
}
