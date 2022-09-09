package com.Stepdefinition;

import com.pages.HomePage;
import com.pages.NavigationPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifySubscriptionInHomePage_T0010 extends BaseClass {



    @Test
    public void verifySubscriptionInHomePage() throws InterruptedException {

        String test = "test123@gmail.com";

        HomePage homePage = new HomePage(driver);
        


        //1 & 2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //3  Verify that home page is visible successfully
        System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //4. Scroll down to footer
        homePage.ScrollDownToFooter();

        //5 Verify text 'SUBSCRIPTION'
        String actualText = homePage.verifyTextSUBSCRIPTION();
        String expectedText = "SUBSCRIPTION";
        Assert.assertEquals(actualText, expectedText, "wrong text");
        System.out.println(homePage.verifyTextSUBSCRIPTION());

        //6  Enter email address in input and click arrow button
        homePage.enterEmailAndNavigateToNextPage(test);

        //7. Verify success message 'You have been successfully subscribed!' is visible
        String c= homePage.subsribedVerifidMessage();
        System.out.println(c);
        String expectedVerifiedMessage= "You have been successfully subscribed!";

        String actualVerifiedMessage=homePage.subsribedVerifidMessage();
        Assert.assertEquals(actualVerifiedMessage,expectedVerifiedMessage,"no match found");



    }
}
