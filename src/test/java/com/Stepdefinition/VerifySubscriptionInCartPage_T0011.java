package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifySubscriptionInCartPage_T0011 extends BaseClass {

    @Test
    public void verifySubscriptionInCartPage() {

        //Test data
        String text = "SUBSCRIPTION";
        String email= "abc@test.com";

        HomePage homePage = new HomePage(driver);
        NavigationPage navigation = new NavigationPage(driver);

        //1 & 2  Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //3. Verify that home page is visible successfully
        System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //4 & 5Verify user is navigated to ALL PRODUCTS page successfully
        navigation.NavigateTo("Cart");

        //4. Scroll down to footer
        homePage.ScrollDownToFooter();

        //5 Verify text 'SUBSCRIPTION'
        System.out.println(homePage.verifyTextSUBSCRIPTION());
        String actualText = homePage.verifyTextSUBSCRIPTION();
        String expectedText = text;
        Assert.assertEquals(actualText, expectedText, "wrong text");

        //6 & 7 Enter email address in input and click arrow button
        homePage.enterEmailAndNavigateToNextPage(email);

        //8. Verify success message 'You have been successfully subscribed!' is visible
        //homePage.confirmMessageSent(driver);
       String c= homePage.subsribedVerifidMessage();
        System.out.println(c);
        String expectedVerifiedMessage= "You have been successfully subscribed!";

        String actualVerifiedMessage=homePage.subsribedVerifidMessage();
        Assert.assertEquals(actualVerifiedMessage,expectedVerifiedMessage,"no match found");



    }

}
