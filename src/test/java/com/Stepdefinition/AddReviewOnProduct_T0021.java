package com.Stepdefinition;

import com.pages.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddReviewOnProduct_T0021 extends BaseClass {

    @Test
    public void searchProductsAndVerifyCartAfterLogin_T0020() throws InterruptedException {

        //Test data
        String name ="test",email="test@test.com",review="i am ready";



        NavigationPage navigation = new NavigationPage(driver);
        CommonPage common = new CommonPage(driver);
        ProductPage product = new ProductPage(driver);
        ProductDetailsPage productDetails = new ProductDetailsPage(driver);
        CartPage cart = new CartPage(driver);


        //1 &2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //3. Click on 'Products' button
        navigation.NavigateTo("Products");

        //4. Verify user is navigated to ALL PRODUCTS page successfully
        common.validatePageurl("products");

        //5. Click on 'View Product' button
        product.clickViewProductButton();

        //6. Verify 'Write Your Review' is visible
        String actualText = productDetails.verifyWriteYourReviewText();
        String expectedText = "WRITE YOUR REVIEW";
        Assert.assertEquals(actualText, expectedText, "actual text does not match expected text");
        System.out.println(productDetails.verifyWriteYourReviewText());
        //or
        String message = productDetails.verifyWriteYourReviewText();
        Assert.assertTrue(message.equalsIgnoreCase(expectedText));

        //7. Enter name, email and review
        productDetails.EnterNameEmailAndReview(name, email, review);

        //8. Click 'Submit' button
        productDetails.clickSubmitButton();

        //9. Verify success message 'Thank you for your review.'
        System.out.println(cart.verifySuccessMessageThankYouForYourReview());
        String actualMessage = cart.verifySuccessMessageThankYouForYourReview();
        String expectedMessage = "Thank you for your review.";
        Assert.assertEquals(actualMessage, expectedMessage,"actualMessage does not match expectedMessage");


    }
}
