package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyProductQuantityInCart_T0013 extends BaseClass {

    @Test
    public void verifyProductQuantityInCart_T0013() {

        String items = "Stylish Dress";

        HomePage homePage = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        ProductDetailsPage productDetails = new ProductDetailsPage(driver);
        CommonPage common = new CommonPage(driver);
        CartPage cart = new CartPage(driver);

        //1 & 2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //3  Verify that home page is visible successfully
        System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());


        //4. Click 'View Product' for any product on home page
       common.selectAnyProductAndLogIntoProductDetails();

        //5. Verify product detail is opened
        common.validatePageurl("product_details");

        //6. Increase quantity to 4
        product.increaseQuantityToFour();

        //7. Click 'Add to cart' button
        productDetails.clickAddToCartButton();

        //8. Click 'View Cart' button
        product.clickViewCart();

        //9. Verify that product is displayed in cart page with exact quantity
        System.out.println(cart.verifythatproductisdisplayedincartpagewithexactquantity());
        String actualMatchedQuanity = cart.verifythatproductisdisplayedincartpagewithexactquantity();
        String expectedMatchedQuanity = "4";
        Assert.assertEquals(actualMatchedQuanity, expectedMatchedQuanity, actualMatchedQuanity + " does not match " + expectedMatchedQuanity);

    }


}
