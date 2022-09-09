package com.Stepdefinition;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.NavigationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyScropWithoutArrowButtonAndScrollDownFunctionality_T0026 extends BaseClass{

    @Test
    public void VerifyScropUsingArrowButtonAndScrollDownFunctionality(){

        //Test data
        String text = "SUBSCRIPTION";

        HomePage homePage = new HomePage(driver);


        //1 &2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //4. Scroll down to footer
        homePage.ScrollDownToFooter();

        //5 Verify text 'SUBSCRIPTION'
        System.out.println(homePage.verifyTextSUBSCRIPTION());
        String  actualText= homePage.verifyTextSUBSCRIPTION();
        String expectedText= text;
        Assert.assertEquals(actualText,expectedText,"actualText does not match expected text");

         //6. Scroll up page to top
        homePage.scrollUpPageToTop();


        //7 Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        String actualTxt=  homePage.confirmVisibleTextOnScreen();
        String expectedTxt= "Full-Fledged practice website for Automation Engineers";
        Assert.assertEquals(actualTxt,expectedTxt,"actualTxt does not match expectedTxt");

    }
}
