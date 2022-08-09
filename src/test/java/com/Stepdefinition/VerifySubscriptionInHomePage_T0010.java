package com.Stepdefinition;

import com.pages.HomePage;
import com.pages.NavigationPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifySubscriptionInHomePage_T0010 extends BaseClass{

    @Test
    public void verifySubscriptionInHomePage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        NavigationPage navigation = new NavigationPage(driver);


        //1 &2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //3  Verify that home page is visible successfully
        System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //4. Scroll down to footer
        homePage.ScrollDownToFooter();

  //5 Verify text 'SUBSCRIPTION'
        System.out.println(homePage.verifyTextSUBSCRIPTION());
    String  actualText= homePage.verifyTextSUBSCRIPTION();
    String expectedText= "SUBSCRIPTION";
    Assert.assertEquals(actualText,expectedText,"wrong text");

    //6  Enter email address in input and click arrow button

        homePage.enterEmailAndNavigateToNextPage("abc@gmail.com");

        //7. Verify success message 'You have been successfully subscribed!' is visible
        homePage.confirmMessageSent(driver);







    }
}
