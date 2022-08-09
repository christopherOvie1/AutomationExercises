package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderRegisterBeforeCheckout_T0015 extends BaseClass{


    @Test
    public void placeOrderRegisterBeforeCheckout(){

        String day= "23",month="May",year="2020";
        String firstName= "chris", lastName="john",company = "abc ltd",addressLn1="4",addressLn2= "abc st",country = "Canada",state= "ottawa",city="test",zipcode="23432",mobileNumber="123455";
        HomePage homePage = new HomePage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CommonPage common = new CommonPage(driver);
        CartPage cart =new CartPage(driver);
        AccountCreatedPage accountCreated= new AccountCreatedPage(driver);
        RegistrationPage register = new RegistrationPage(driver);
        ProductDetailsPage productDetails= new ProductDetailsPage(driver);

        //2
        driver.get(baseURL);
        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //4 .Click on 'Signup / Login' button  //Signup / Login
        /// homePage.goToLoginPage();
        navigation.NavigateTo("Signup / Login");

        //5. Fill all details in Signup and create account
        loginPage.enterRandomString();
        loginPage.enterRandomEmailField();
        //7 click sign up button
        loginPage.loginIntoRegistrationPage();


        //6 AND 7 Verify 'ACCOUNT CREATED!' and click 'Continue' button

        register.getRadioButtons();
        register.enterPassword("ahh65bgfd");

        register.selectDateOfBirth(day,month,year);
        register.enterAddressInfo(firstName,lastName, company,addressLn1,addressLn2,country,state,city,zipcode,mobileNumber);

        String actualAccCreatedText=  accountCreated.verifyThatACCOUNTCREATEDIsVisible();
        String expectedAccCreatedText = "ACCOUNT CREATED!";
        Assert.assertEquals(actualAccCreatedText,expectedAccCreatedText);

        accountCreated.clickContinueButton();

// 7. Verify ' Logged in as username' at top
        loginPage.verifyThatLoggedusernameIsVisible();
        // 8. Add products to cart

        product.clickAnyxxxxx();

        //9. Click 'Cart' button
        productDetails.clickAddToCartButton();
        product.clickViewCart();

        //10. Verify that cart page is displayed
        common.validatePageURL("cart");

        //11. Click Proceed To Checkout
        cart.clickProceedToCheckoutButton();

        //12. Verify Address Details and Review Your Order
        String add= cart.confirmsBillingAddressSameAsDeliveryAddress();
        System.out.println(add);

        String v=  cart.validateReviewYourOrder();
        System.out.println(v);

        //13. Enter description in comment text area and click 'Place Order'
        cart.EnterDescriptionInCommentTextAreaAndClickPlaceOrder("no comment");
//14. & 15 Enter payment details: Name on Card, Card Number, CVC, Expiration date
        cart.enterEnterPaymentDetailsNameOnCardAndCardNumberCVCExpirationDate("john","123","34","Jan", "2020");

//16. Verify success message 'Your order has been placed successfully!'
        String succMessage=  cart.verifySuccessMessage();
        System.out.println(succMessage);
        //17. Click 'Delete Account' button
        navigation.NavigateTo("Delete Account");
    }
}
