package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderRegisterWhileCheckout_T0014 extends BaseClass{



    @Test
    public void placeOrderRegisterWhileCheckout() throws InterruptedException {

        String day= "23",month="May",year="2020";
        String firstName= "chris", lastName="john",company = "abc ltd",addressLn1="4",addressLn2= "abc st",country = "Canada",state= "ottawa",city="test",zipcode="23432",mobileNumber="123455";
        HomePage homePage = new HomePage(driver);
        NavigationPage navigation = new NavigationPage(driver);

        ProductPage product = new ProductPage(driver);
        CommonPage common = new CommonPage(driver);
        CartPage cart =new CartPage(driver);
        AccountCreatedPage accountCreated= new AccountCreatedPage(driver);
        RegistrationPage register = new RegistrationPage(driver);
        ProductDetailsPage productDetails= new ProductDetailsPage(driver);

        LoginPage loginPage = new LoginPage(driver);
        //1 &2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //3  Verify that home page is visible successfully
        System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

//4. &5 Add products to cart
        //product.clickAnyxxxxx();
       /// common.getDifferentProducts();

       common.AddtoCartJourneys();
       // CommonPage.AddtoCartJourneys();

        //6. Verify that cart page is displayed
        productDetails.clickAddToCartButton();


        product.clickViewCart();

        //7 Verify that cart page is displayed
        common.validateURL("view_cart");

        //7. Click Proceed To Checkout
        cart.clickProceedToCheckoutButton();

        //8. Click 'Register / Login' button
        cart.clickLoginAndRegisterLink();

        //9. Fill all details in Signup and create account
        loginPage.enterRandomString();
        loginPage.enterRandomEmailField();

        //7 click sign up button
        loginPage.loginIntoRegistrationPage();

        //8
        // boolean d =   register.VerifyThatENTERACCOUNTINFORMATIONisVisible();
        //   System.out.println(d);
        //choose radio button

        register.getRadioButtons();
        register.enterPassword("ahh65bgfd");

        register.selectDateOfBirth(day,month,year);
        register.enterAddressInfo(firstName,lastName, company,addressLn1,addressLn2,country,state,city,zipcode,mobileNumber);

//14. Verify that 'ACCOUNT CREATED!' is visible

        String actualAccCreatedText=  accountCreated.verifyThatACCOUNTCREATEDIsVisible();
        String expectedAccCreatedText = "ACCOUNT CREATED!";
        Assert.assertEquals(actualAccCreatedText,expectedAccCreatedText);
//12.Click 'Cart' button
        navigation.NavigateTo("Cart");
        //13. Click 'Proceed To Checkout' button
        cart.clickProceedToCheckoutButton();
        //14   14. Verify Address Details and Review Your Ordercart.verifyAddressIsSame("addressType");
       String add= cart.confirmsBillingAddressSameAsDeliveryAddress();
        System.out.println(add);

      String v=  cart.validateReviewYourOrder();
        System.out.println(v);
        //System.out.println("xxxxxxxxxx");
        System.out.println(cart.verifyDeliveryAddress2("Mr. odibo ovie","manchester manchester m3 6de"));
        //15. Enter description in comment text area and click 'Place Order'
      //  System.out.println("yyyyyyyy");
       cart.EnterDescriptionInCommentTextAreaAndClickPlaceOrder("no comment");
        //16&17 Enter payment details: Name on Card, Card Number, CVC, Expiration date
        cart.enterEnterPaymentDetailsNameOnCardAndCardNumberCVCExpirationDate("john","123","34","Jan", "2020");


        //18. Verify success message 'Your order has been placed successfully!'
      String succMessage=  cart.verifySuccessMessage();
        System.out.println(succMessage);

//19. Click 'Delete Account' button
        navigation.NavigateTo("Delete Account");
    }


}
