package com.Stepdefinition;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.NavigationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyScropUsingArrowButtonAndScrollDownFunctionality_T0025 extends BaseClass{

    @Test
    public void VerifyScropUsingArrowButtonAndScrollDownFunctionality(){
        String text = "SUBSCRIPTION";
        HomePage homePage = new HomePage(driver);
        //  CommonPage common = new CommonPage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        // ContactUsPage contactUs = new ContactUsPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        // ProductPage product = new ProductPage(driver);
        //  ProductDetailsPage productDetails= new ProductDetailsPage(driver);


        //1 &2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //4. Scroll down to footer
        homePage.ScrollDownToFooter();

        //5 Verify text 'SUBSCRIPTION'
        System.out.println(homePage.verifyTextSUBSCRIPTION());
        String  actualText= homePage.verifyTextSUBSCRIPTION();
        String expectedText= text;
        Assert.assertEquals(actualText,expectedText,"wrong text");

//6. Click on arrow at bottom right side to move upward
        homePage.clickMovingArrow();

        //7Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
     String actualTxt=  homePage.confirmVisibleTextOnScreen();
     String expectedTxt= "Full-Fledged practice website for Automation Engineers";
        Assert.assertEquals(actualTxt,expectedTxt,"actualTxt does not match expectedTxt");



    }
}
